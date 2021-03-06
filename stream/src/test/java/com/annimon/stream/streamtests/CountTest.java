package com.annimon.stream.streamtests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.annimon.stream.IntStream;
import com.annimon.stream.LongStream;

public final class CountTest {

    @Test
    public void testCount() {
        long count = LongStream.range(10000000000L, 10000002000L).count();
        assertEquals(2000, count);
    }

    @Test
    public void testCountMinValue() {
        long count = IntStream.range(Integer.MIN_VALUE, Integer.MIN_VALUE + 100).count();
        assertEquals(100, count);
    }

    @Test
    public void testCountMaxValue() {
        long count = LongStream.range(Long.MAX_VALUE - 100, Long.MAX_VALUE).count();
        assertEquals(100, count);
    }
}
