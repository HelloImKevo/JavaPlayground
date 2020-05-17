package com.kevo.junk;

/**
 * @author kevo
 */
public class PerformanceTest {

    private static class Dummy {

        private String mName;

        public String getName() {
            return mName;
        }

        public void setName(String name) {
            mName = name;
        }
    }

    public static void testNullCheckPerformance(int iterations) {
        String str1 = "";
        Dummy dummy = new Dummy();
        dummy.setName("Bob");

        long start, end;

        double duration, average1, average2;

        average1 = 0;
        average2 = 0;

        for (int i = 0; i < iterations; i++) {
            start = System.nanoTime();
            if (dummy.getName() != null
                    && dummy.getName().equals(str1)) {
                // Do nothing
            }
            end = System.nanoTime();
            duration = getDuration(start, end);
            average1 += duration;

            if (i % 10000 == 0) {
                log("1. Duration:", duration);
            }

            start = System.nanoTime();
            if (str1.equals(dummy.getName())) {
                // Do nothing
            }
            end = System.nanoTime();
            duration = getDuration(start, end);
            average2 += duration;

            if (i % 10000 == 0) {
                log("2. Duration:", duration);
            }
        }

        average1 /= iterations;
        average2 /= iterations;

        System.out.println("---------------------------------");

        log("1. Duration Average:", average1);
        log("2. Duration Average:", average2);
    }

    public static void log(String tag, double value) {
        System.out.println(String.format(tag + " %.6f", value));
    }

    public static double getDuration(long start, long end) {
        return (end - start) / 10D;
    }

    public static void main(String[] args) {
        testNullCheckPerformance(10000);
        testNullCheckPerformance(10000);
        testNullCheckPerformance(10000);
        testNullCheckPerformance(10000);
        testNullCheckPerformance(10000);
        testNullCheckPerformance(10000);
    }
}
