package com.annimon.stream.streamtests;

import static com.annimon.stream.test.hamcrest.StreamMatcher.assertElements;
import static org.hamcrest.Matchers.contains;

import java.util.NoSuchElementException;

import org.junit.Test;

import com.annimon.stream.Functions;
import com.annimon.stream.IntStream;
import com.annimon.stream.Stream;
import com.annimon.stream.function.Predicate;

public final class FilterTest {

    @Test
    public void testFilter() {
        IntStream.range(0, 10).boxed().filter(Functions.remainder(2)).chain(assertElements(contains(0, 2, 4, 6, 8)));
    }

    @Test(expected = NoSuchElementException.class)
    public void testFilterIteratorNextOnEmpty() {
        Stream.<Integer> empty().filter(Functions.remainder(2)).iterator().next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testFilterIteratorRemove() {
        IntStream.range(0, 10).boxed().filter(Functions.remainder(2)).iterator().remove();
    }

    @Test
    public void testFilterWithOrPredicate() {
        Predicate<Integer> predicate = Predicate.Util.or(Functions.remainder(2), Functions.remainder(3));
        IntStream.range(0, 10).boxed().filter(predicate).chain(assertElements(contains(0, 2, 3, 4, 6, 8, 9)));
    }

    @Test
    public void testFilterWithAndPredicate() {
        Predicate<Integer> predicate = Predicate.Util.and(Functions.remainder(2), Functions.remainder(3));
        IntStream.range(0, 10).boxed().filter(predicate).chain(assertElements(contains(0, 6)));
    }

    @Test
    public void testFilterWithXorPredicate() {
        Predicate<Integer> predicate = Predicate.Util.xor(Functions.remainder(2), Functions.remainder(3));
        IntStream.range(0, 10).boxed().filter(predicate).chain(assertElements(contains(2, 3, 4, 8, 9)));
    }
}
