/**
 * Name: SRUJANA NIRANJANKUMAR
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/09/2025
 * File Name: AppPropertiesCronRunner.java
 *
 * Description:
 * Loads cron settings from app.properties and schedules a Quartz job using the
 * configured expression and message.
 */

package edu.bu.met.cs665.factory;

import edu.bu.met.cs665.TaskType;
import edu.bu.met.cs665.flyweight.TaskFlyweight;
import edu.bu.met.cs665.task.BackupTask;
import edu.bu.met.cs665.task.CronTask;
import edu.bu.met.cs665.task.EmailTask;

/**
 * A simple factory for creating CronTask objects based on task type and shared flyweight config.
 */
public class CronTaskFactory {

    /**
     * Creates a CronTask using the given task type and flyweight configuration.
     *
     * @param type the type of task to create
     * @param fw   the shared flyweight configuration
     * @return a new CronTask instance
     */
    public static CronTask create(TaskType type, TaskFlyweight fw) {
        switch (type) {
            case EMAIL:
                return new EmailTask(fw);

            case BACKUP:
                return new BackupTask(fw);

            default:
                throw new IllegalArgumentException("Unknown task type: " + type);
        }
    }
}
