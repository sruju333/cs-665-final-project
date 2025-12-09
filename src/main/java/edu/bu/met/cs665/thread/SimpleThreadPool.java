/**
 * Name: SRUJANA NIRANJANKUMAR
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/09/2025
 * File Name: SimpleThreadPool.java
 *
 * Description:
 * A simple thread pool implementation that manages a fixed number of worker threads
 * and executes submitted tasks concurrently using a queue.
 */

package edu.bu.met.cs665.thread;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * SimpleThreadPool manages a pool of worker threads to execute Runnable tasks.
 */
public class SimpleThreadPool {
    private final Worker[] workers;
    private final LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    /**
     * Creates a thread pool with the specified number of workers.
     *
     * @param size number of worker threads in the pool
     */
    public SimpleThreadPool(int size) {
        workers = new Worker[size];

        for (int i = 0; i < size; i++) {
            workers[i] = new Worker("Worker-" + i);
            workers[i].start();
        }
    }

    /**
     * Submits a task to the thread pool for execution.
     *
     * @param task the Runnable task to execute
     */
    public void submit(Runnable task) {
        queue.add(task);
    }

    /**
     * Worker thread that continuously takes tasks from the queue and runs them.
     */
    class Worker extends Thread {
        public Worker(String name) { super(name); }

        public void run() {
            try {
                while (true) {
                    Runnable task = queue.take();
                    task.run();
                }
            } catch (InterruptedException e) {
                System.out.println(getName() + " stopped.");
            }
        }
    }
}
