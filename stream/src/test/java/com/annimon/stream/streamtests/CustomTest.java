package com.annimon.stream.streamtests;

import static com.annimon.stream.test.hamcrest.StreamMatcher.assertElements;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.annimon.stream.CustomOperators;
import com.annimon.stream.IntStream;
import com.annimon.stream.Stream;
import com.annimon.stream.function.Consumer;
import com.annimon.stream.function.Function;

public final class CustomTest {

    @Test(expected = NullPointerException.class)
    public void testCustomNull() {
        Stream.empty().__(null);
    }

    @Test
    public void testCustomIntermediateOperator_Reverse() {
        IntStream.range(0, 10).boxed().__(new CustomOperators.Reverse<Integer>()).__(assertElements(contains(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)));
    }

    @Test
    public void testCustomIntermediateOperator_SkipAndLimit() {
        IntStream.range(0, 10).boxed().__(new CustomOperators.SkipAndLimit<Integer>(5, 2)).__(assertElements(contains(5, 6)));
    }

    @Test
    public void testCustomIntermediateOperator_FlatMapAndCast() {
        List<List> lists = new ArrayList<>();
        for (char ch = 'a'; ch <= 'f'; ch++) {
            lists.add(new ArrayList<>(Arrays.asList(ch)));
        }
        Stream.of(lists).__(new CustomOperators.FlatMap<>(new Function<List, Stream<Object>>() {
            @SuppressWarnings("unchecked")
            @Override
            public Stream<Object> apply(List value) {
                return Stream.of(value);
            }
        })).__(new CustomOperators.Cast<>(Character.class)).__(assertElements(contains('a', 'b', 'c', 'd', 'e', 'f')));
    }

    @Test
    public void testCustomTerminalOperator_Sum() {
        int sum = Stream.of(1, 2, 3, 4, 5).__(new CustomOperators.Sum());
        assertEquals(15, sum);
    }

    @Test
    public void testCustomTerminalOperator_ForEach() {
        final List<Integer> list = new ArrayList<>();
        IntStream.range(0, 10).boxed().__(new CustomOperators.ForEach<>(new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                list.add(t);
            }
        }));

        assertThat(list, contains(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    }
}
