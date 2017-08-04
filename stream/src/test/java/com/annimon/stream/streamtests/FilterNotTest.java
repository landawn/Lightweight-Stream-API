package com.annimon.stream.streamtests;

import static com.annimon.stream.test.hamcrest.StreamMatcher.assertElements;
import static org.hamcrest.Matchers.contains;

import org.junit.Test;

import com.annimon.stream.Functions;
import com.annimon.stream.IntStream;

public final class FilterNotTest {

    @Test
    public void testFilterNot() {
        IntStream.range(0, 10).boxed().removeIf(Functions.remainder(2)).chain(assertElements(contains(1, 3, 5, 7, 9)));
    }
}
