/**
 * Name: SRUJANA NIRANJANKUMAR
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/09/2025
 * File Name: BaseTask.java
 *
 * Description:
 * Abstract base class for cron tasks. Holds a shared TaskFlyweight
 * for task configuration and provides a common structure for concrete tasks.
 */

package edu.bu.met.cs665.task;

import edu.bu.met.cs665.flyweight.TaskFlyweight;
/**
 * Base class for all cron tasks.
 * Stores a TaskFlyweight and provides a constructor for concrete tasks.
 */

public abstract class BaseTask implements CronTask {
    protected TaskFlyweight flyweight;

    /**
     * Initializes the task with the given flyweight configuration.
     *
     * @param flyweight shared task configuration
     */
    protected BaseTask(TaskFlyweight flyweight) {
        this.flyweight = flyweight;
    }
}
