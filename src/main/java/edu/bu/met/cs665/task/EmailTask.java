/**
 * Name: SRUJANA NIRANJANKUMAR
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/09/2025
 * File Name: EmailTask.java
 *
 * Description:
 * Concrete cron task that performs an email operation.
 * Uses a TaskFlyweight for shared configuration.
 */

package edu.bu.met.cs665.task;

import edu.bu.met.cs665.flyweight.TaskFlyweight;

/**
 * Represents an email task in the cron system.
 * Extends BaseTask and executes email-specific behavior.
 */
public class EmailTask extends BaseTask {

    // public constructor
    public EmailTask(TaskFlyweight flyweight) {
        super(flyweight);
    }

    /**
     * Executes the email task using the flyweight configuration.
     * Prints the task description when running.
     */
    @Override
    public void runTask() {
        System.out.println("Running EMAIL task → " + flyweight.getDescription());
    }
}
