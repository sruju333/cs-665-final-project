/**
 * Name: SRUJANA NIRANJANKUMAR
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/09/2025
 * File Name: CronScheduler.java
 *
 * Description:
 * Schedules cron tasks for recurring execution using a simple thread pool.
 * Allows tasks to run repeatedly with a fixed interval.
 */

package edu.bu.met.cs665.thread.scheduler;

import edu.bu.met.cs665.thread.SimpleThreadPool;
import edu.bu.met.cs665.task.CronTask;

/**
 * CronScheduler uses a thread pool to execute CronTask instances on a recurring schedule.
 */
public class CronScheduler {
    // Create thread pool of size 2
    private final SimpleThreadPool pool = new SimpleThreadPool(2);

    /**
     * Schedules a CronTask to run repeatedly at a fixed interval.
     *
     * @param task        the CronTask to execute
     * @param seconds     interval between executions in seconds
     * @param repeatCount number of times to repeat the task
     */
    public void scheduleRecurring(CronTask task, int seconds, int repeatCount) {
        new Thread(() -> {
            for (int i = 0; i < repeatCount; i++) {
                pool.submit(() -> task.runTask());    // submit pool
                try {
                    Thread.sleep(seconds * 1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }).start();
    }
}
