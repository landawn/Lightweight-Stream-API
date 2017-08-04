package com.annimon.stream.streamtests;

import static com.annimon.stream.test.hamcrest.IntStreamMatcher.assertElements;
import static org.hamcrest.Matchers.arrayContaining;

import org.junit.Test;

import com.annimon.stream.IntStream;
import com.annimon.stream.function.Function;
import com.annimon.stream.function.IntUnaryOperator;

public final class FlatMapToIntTest {

    @Test
    public void testFlatMapToInt() {
        IntStream.rangeClosed(2, 4).boxed().flatMapToInt(new Function<Integer, IntStream>() {

            @Override
            public IntStream apply(Integer t) {
                return IntStream.iterate(t, IntUnaryOperator.Util.identity()).limit(t);
            }
        }).chain(assertElements(arrayContaining(2, 2, 3, 3, 3, 4, 4, 4, 4)));
    }
}
