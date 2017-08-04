package com.annimon.stream.function;

/**
 * Represents an operation on index and input argument.
 *
 * @param <T> the type of the input to the operation
 * @since 1.1.6
 */
@FunctionalInterface
public interface IndexedConsumer<T> {

    /**
     * Performs operation on argument.
     *
     * @param index  the index
     * @param t  the input argument
     */
    void accept(int index, T t);
}
