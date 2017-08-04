package com.annimon.stream;

import java.util.NoSuchElementException;

import com.annimon.stream.function.IntConsumer;
import com.annimon.stream.function.IntSupplier;
import com.annimon.stream.function.Supplier;

/**
 * A container object which may or may not contain a {@code int} value.
 * If a value is present, {@code isPresent()} will return {@code true} and
 * {@code getAsInt()} will return the value.
 */
public final class OptionalInt {
    /**
     * Common instance for {@code empty()}.
     */
    private static final OptionalInt EMPTY = new OptionalInt();

    /**
     * If true then the value is present, otherwise indicates no value is present
     */
    private final boolean isPresent;
    private final int value;

    /**
     * Construct an empty instance.
     */
    private OptionalInt() {
        this.isPresent = false;
        this.value = 0;
    }

    /**
     * Returns an empty {@code OptionalInt} instance.  No value is present for this
     * OptionalInt.
     *
     * @return an empty {@code OptionalInt}
     */
    public static OptionalInt empty() {
        return EMPTY;
    }

    /**
     * Construct an instance with the value present.
     *
     * @param value the int value to be present
     */
    private OptionalInt(int value) {
        this.isPresent = true;
        this.value = value;
    }

    /**
     * Return an {@code OptionalInt} with the specified value present.
     *
     * @param value the value to be present
     * @return an {@code OptionalInt} with the value present
     */
    public static OptionalInt of(int value) {
        return new OptionalInt(value);
    }

    /**
     * If a value is present in this {@code OptionalInt}, returns the value,
     * otherwise throws {@code NoSuchElementException}.
     *
     * @return the value held by this {@code OptionalInt}
     * @throws NoSuchElementException if there is no value present
     *
     * @see OptionalInt#isPresent()
     */
    public int get() {
        if (!isPresent) {
            throw new NoSuchElementException("No value present");
        }
        return value;
    }

    /**
     * Return {@code true} if there is a value present, otherwise {@code false}.
     *
     * @return {@code true} if there is a value present, otherwise {@code false}
     */
    public boolean isPresent() {
        return isPresent;
    }

    /**
     * Invokes consumer function with value if present, otherwise does nothing.
     *
     * @param consumer block to be executed if a value is present
     * @throws NullPointerException if value is present and {@code consumer} is
     *         null
     */
    public void ifPresent(IntConsumer consumer) {
        if (isPresent)
            consumer.accept(value);
    }

    /**
     * If a value is present, performs the given action with the value,
     * otherwise performs the empty-based action.
     *
     * @param consumer  the consumer function to be executed, if a value is present
     * @param emptyAction  the empty-based action to be performed, if no value is present
     * @throws NullPointerException if a value is present and the given consumer function is null,
     *         or no value is present and the given empty-based action is null.
     * @since 1.1.4
     */
    public void ifPresentOrElse(IntConsumer consumer, Runnable emptyAction) {
        if (isPresent) {
            consumer.accept(value);
        } else {
            emptyAction.run();
        }
    }

    /**
     * Wraps a value into {@code IntStream} if present, otherwise returns an empty {@code IntStream}.
     *
     * @return the optional value as an {@code IntStream}
     */
    public IntStream stream() {
        if (!isPresent())
            return IntStream.empty();
        return IntStream.of(value);
    }

    /**
     * Returns the value if present, otherwise returns {@code other}.
     *
     * @param other  the value to be returned if there is no value present
     * @return the value, if present, otherwise {@code other}
     */
    public int or(int other) {
        return isPresent ? value : other;
    }

    /**
     * Returns the value if present, otherwise invokes {@code other} and returns
     * the result of that invocation.
     *
     * @param other a {@code IntSupplier} whose result is returned if no value
     *              is present
     * @return the value if present otherwise the result of {@code other.getAsInt()}
     * @throws NullPointerException if value is not present and {@code other} is
     *         null
     */
    public int orGet(IntSupplier other) {
        return isPresent ? value : other.getAsInt();
    }

    /**
     * Returns the value if present, otherwise throws an exception provided by supplier function.
     *
     * @param <X> the type of exception to be thrown
     * @param exceptionSupplier  supplier function that produces an exception to be thrown
     * @return inner value if present
     * @throws X if inner value is not present
     */
    public <X extends Throwable> int orThrow(Supplier<X> exceptionSupplier) throws X {
        if (isPresent) {
            return value;
        } else {
            throw exceptionSupplier.get();
        }
    }

    /**
     * Indicates whether some other object is "equal to" this OptionalInt. The
     * other object is considered equal if:
     * <ul>
     *    <li> it is also an {@code OptionalInt} and;
     *    <li> both instances have no value present or;
     *    <li> the present values are "equal to" each other via {@code ==}.
     * </ul>
     *
     * @param obj an object to be tested for equality
     * @return {@code true} if the other object is "equal to" this object
     *         otherwise {@code false}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof OptionalInt)) {
            return false;
        }

        OptionalInt other = (OptionalInt) obj;
        return (isPresent && other.isPresent) ? value == other.value : isPresent == other.isPresent;
    }

    /**
     * Returns the hash code value of the present value, if any, or 0 (zero) if
     * no value is present.
     *
     * @return hash code value of the present value or 0 if no value is present
     */
    @Override
    public int hashCode() {
        return isPresent ? value : 0;
    }

    /**
     * Returns a non-empty string representation of this object suitable for
     * debugging.
     *
     * @return the string representation of this instance
     */
    @Override
    public String toString() {
        return isPresent ? String.format("OptionalInt[%s]", value) : "OptionalInt.empty";
    }
}
