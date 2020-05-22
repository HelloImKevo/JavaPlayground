package com.kevo.concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author kevo
 */
public final class ConcurrentTimer {

    private ConcurrentTimer() {
        // No instance.
    }

    /**
     *
     * @param executor An executor with a variable thread pool size.
     * @param concurrency How much concurrency to leverage.
     * @param action A lengthy operation to perform.
     * @return Duration in milliseconds.
     * @throws InterruptedException If something goes horribly wrong.
     */
    public static long time(Executor executor, int concurrency,
            final Runnable action) throws InterruptedException {

        final CountDownLatch ready = new CountDownLatch(concurrency);
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch done = new CountDownLatch(concurrency);

        for (int i = 0; i < concurrency; i++) {
            System.out.println("Submitting Runnable with: " + action);
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Runnable is ready.");
                    ready.countDown();
                    try {
                        start.await();
                        action.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    } finally {
                        done.countDown();
                    }
                }

            });
        }

        // Wait for all workers to be ready
        ready.await();

        long startMillis = System.currentTimeMillis();
        start.countDown();
        done.await();

        return System.currentTimeMillis() - startMillis;
    }

    public static final void main(String[] args) throws Exception {
        // This demonstration will not work with a fixed thread pool.
        Executor executor = Executors.newCachedThreadPool();
        Runnable action = new Runnable() {
            @Override
            public void run() {
                final List<String> junkStrings = new ArrayList<>();
                for (int i = 0; i < 50; i++) {
                    char[] junk = new char[512];
                    Arrays.fill(junk, 'a');
                    junkStrings.add(Arrays.toString(junk));
                }
                System.out.println("Finished creating a bunch of junk.");
            }

        };

        long duration = ConcurrentTimer.time(executor, 10, action);
        System.out.println("Duration (millis): " + duration);
    }
}
