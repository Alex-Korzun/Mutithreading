package multithreading.practice;

import org.apache.log4j.Logger;

public class ThreadExample extends Thread {
    private static final int COUNTING_LIMIT = 100;
    private static final Logger logger = Logger.getLogger(ThreadExample.class);
    private final Counter counter;

    public ThreadExample(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        logger.info("Thread example started working...");
        while (counter.getCounter() < COUNTING_LIMIT) {
            logger.info(Thread.currentThread().getName() + " = " + counter.increment());
        }
        logger.info("Thread example finished working...");
    }
}
