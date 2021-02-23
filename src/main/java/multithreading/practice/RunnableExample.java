package multithreading.practice;

import org.apache.log4j.Logger;

public class RunnableExample implements Runnable {
    private static final int COUNTING_LIMIT = 100;
    private static final Logger logger = Logger.getLogger(RunnableExample.class);
    private final Counter counter;

    public RunnableExample(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        logger.info("Runnable example started working...");
        while (counter.getCounter() < COUNTING_LIMIT) {
            int count = counter.increment();
            logger.info(Thread.currentThread().getName() + " = " + count);
        }
        logger.info("Runnable example finished working...");
    }
}
