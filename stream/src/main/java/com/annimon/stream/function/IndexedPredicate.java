package com.annimon.stream.function;

/**
 * Represents a predicate (function with boolean type result) with additional index argument.
 *
 * @param <T> the type of the input to the function
 * @since 1.1.6
 */
@FunctionalInterface
public interface IndexedPredicate<T> {

    /**
     * Tests the value for satisfying predicate.
     *
     * @param index  the index
     * @param value  the value to be tests
     * @return {@code true} if the value matches the predicate, otherwise {@code false}
     */
    boolean test(int index, T value);
}
