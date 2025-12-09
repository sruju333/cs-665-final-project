/**
 * Name: SRUJANA NIRANJANKUMAR
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/09/2025
 * File Name: CronTask.java
 *
 * Description:
 * Interface for cron tasks. Defines a single method to execute the task.
 */

package edu.bu.met.cs665.task;

/**
 * Represents a cron task that can be executed.
 * Concrete tasks implement the runTask() method.
 */

public interface CronTask {
    /**
     * Executes the cron task.
     */
    void runTask();
}
