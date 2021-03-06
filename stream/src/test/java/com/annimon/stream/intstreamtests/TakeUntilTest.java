package com.annimon.stream.intstreamtests;

import static com.annimon.stream.test.hamcrest.IntStreamMatcher.assertElements;
import static org.hamcrest.Matchers.arrayContaining;

import org.junit.Test;

import com.annimon.stream.Functions;
import com.annimon.stream.IntStream;

public final class TakeUntilTest {

    //    @Test
    //    public void testTakeUntil() {
    //        IntStream.of(2, 4, 6, 7, 8, 10, 11)
    //                .takeUntil(IntPredicate.Util.negate(Functions.remainderInt(2)))
    //                .__(assertElements(arrayContaining(
    //                        2, 4, 6, 7
    //                )));
    //    }

    @Test
    public void testTakeUntilFirstMatch() {
        IntStream.of(2, 4, 6, 7, 8, 10, 11).takeUntil(Functions.remainderInt(2)).__(assertElements(arrayContaining(2)));
    }

    @Test
    public void testTakeUntilNoneMatch() {
        IntStream.of(2, 4, 6, 7, 8, 10, 11).takeUntil(Functions.remainderInt(128)).__(assertElements(arrayContaining(2, 4, 6, 7, 8, 10, 11)));
    }
}
