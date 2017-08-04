package com.annimon.stream.streamtests;

import static com.annimon.stream.test.hamcrest.LongStreamMatcher.assertElements;
import static org.hamcrest.Matchers.arrayContaining;

import org.junit.Test;

import com.annimon.stream.LongStream;
import com.annimon.stream.function.Function;
import com.annimon.stream.function.LongUnaryOperator;

public final class FlatMapToLongTest {

    @Test
    public void testFlatMapToLong() {
        LongStream.rangeClosed(2L, 4L).boxed().flatMapToLong(new Function<Long, LongStream>() {
            @Override
            public LongStream apply(Long t) {
                return LongStream.iterate(t, LongUnaryOperator.Util.identity()).limit(t);
            }
        }).chain(assertElements(arrayContaining(2L, 2L, 3L, 3L, 3L, 4L, 4L, 4L, 4L)));
    }
}
