package com.annimon.stream.function;

/**
 * Represents a function which produces result from index and input argument.
 *
 * @param <T> the type of the input of the function
 * @param <R> the type of the result of the function
 * @since 1.1.6
 */
@FunctionalInterface
public interface IndexedFunction<T, R> {

    /**
     * Applies this function to the given argument.
     *
     * @param index  the index
     * @param t  an argument
     * @return the function result
     */
    R apply(int index, T t);
}
