package com.annimon.stream.function;

/**
 * Represents a function which produces result from index and two input arguments.
 *
 * @param <T> the type of the first argument
 * @param <U> the type of the second argument
 * @param <R> the type of the result of the function
 * @since 1.1.6
 */
@FunctionalInterface
public interface IndexedBiFunction<T, U, R> {

    /**
     * Applies this function to the given arguments.
     *
     * @param index  the index
     * @param value1  the first argument
     * @param value2  the second argument
     * @return the function result
     */
    R apply(int index, T value1, U value2);
}
