/**
 * Name: SRUJANA NIRANJANKUMAR
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/09/2025
 * File Name: BackupTask.java
 *
 * Description:
 * Concrete cron task that performs a backup operation.
 * Uses a TaskFlyweight for shared configuration.
 */

package edu.bu.met.cs665.task;

import edu.bu.met.cs665.flyweight.TaskFlyweight;

/**
 * Represents a backup task in the cron system.
 * Extends BaseTask and executes backup-specific behavior.
 */
public class BackupTask extends BaseTask {

    // Constructor
    public BackupTask(TaskFlyweight flyweight) {
        super(flyweight);
    }

    /**
     * Executes the backup task using the flyweight configuration.
     * Prints the task description when running.
     */
    @Override
    public void runTask() {
        System.out.println("Running BACKUP task → " + flyweight.getDescription());
    }
}
