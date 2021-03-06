package com.annimon.stream.streamtests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.annimon.stream.Functions;
import com.annimon.stream.IntStream;
import com.annimon.stream.Stream;

public final class AnyMatchTest {

    @Test
    public void testAnyMatchWithTrueResult() {
        boolean match = IntStream.range(0, 10).boxed().anyMatch(Functions.remainder(2));
        assertTrue(match);
    }

    @Test
    public void testAnyMatchWithFalseResult() {
        boolean match = Stream.of(2, 3, 5, 8, 13).anyMatch(Functions.remainder(10));
        assertFalse(match);
    }
}
