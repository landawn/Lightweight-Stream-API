package com.annimon.stream.streamtests;

public final class FilterIndexedTest {

    //    @Test
    //    public void testFilterIndexed() {
    //        Stream.rangeClosed(4, 8)
    //                .filterIndexed(new IndexedPredicate<Integer>() {
    //                    @Override
    //                    public boolean test(int index, Integer value) {
    //                        return (index * value) % 2 == 0;
    //                    }
    //                })
    //                .__(assertElements(contains(
    //                       4, // (0 * 4)
    //                          // (1 * 5)
    //                       6, // (2 * 6)
    //                          // (3 * 7)
    //                       8  // (4 * 8)
    //                )));
    //    }
    //
    //    @Test
    //    public void testFilterIndexedWithStartAndStep() {
    //        Stream.rangeClosed(4, 8)
    //                .filterIndexed(20, -5, new IndexedPredicate<Integer>() {
    //                    @Override
    //                    public boolean test(int index, Integer value) {
    //                        return (index * value) % 2 == 0;
    //                    }
    //                })
    //                .__(assertElements(contains(
    //                       4, // (20 * 4)
    //                          // (15 * 5)
    //                       6, // (10 * 6)
    //                          // (5  * 7)
    //                       8  // (0  * 8)
    //                )));
    //    }
    //
    //    @Test(expected = NoSuchElementException.class)
    //    public void testFilterIndexedIteratorNextOnEmpty() {
    //        Stream.<Integer>empty()
    //                .filterIndexed(IndexedPredicate.Util.wrap(Functions.remainder(2)))
    //                .iterator()
    //                .next();
    //    }
    //
    //    @Test(expected = UnsupportedOperationException.class)
    //    public void testFilterIndexedIteratorRemove() {
    //        IntStream.range(0, 10).boxed()
    //                .filterIndexed(IndexedPredicate.Util.wrap(Functions.remainder(2)))
    //                .iterator()
    //                .remove();
    //    }
}
