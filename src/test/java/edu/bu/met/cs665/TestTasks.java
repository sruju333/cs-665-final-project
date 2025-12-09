/**
 * Name: SRUJANA NIRANJANKUMAR
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/09/2025
 * File Name: TestTasks.java
 * Description: This file defines the test cases for TestTasks class to verify implementation
 */
package edu.bu.met.cs665;

import edu.bu.met.cs665.factory.CronTaskFactory;
import edu.bu.met.cs665.flyweight.TaskFlyweight;
import edu.bu.met.cs665.flyweight.TaskFlyweightFactory;
import edu.bu.met.cs665.task.BackupTask;
import edu.bu.met.cs665.task.CronTask;
import edu.bu.met.cs665.task.EmailTask;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Written unit test cases for testing Cron Job Simulator
 */
public class TestTasks {
    @Test
    public void testFlyweightCreation() {
        TaskFlyweight config = TaskFlyweightFactory.getConfig("* * * * *", "Send email");
        assertNotNull(config);
        assertEquals("* * * * *", config.getFrequency());
        assertEquals("Send email", config.getDescription());
    }

    @Test
    public void testEmailTaskCreation() {
        TaskFlyweight config = TaskFlyweightFactory.getConfig("* * * * *", "Send email");
        CronTask task = CronTaskFactory.create(TaskType.EMAIL, config);
        assertNotNull(task);
        assertEquals(EmailTask.class, task.getClass());
    }

    @Test
    public void testBackupTaskCreation() {
        TaskFlyweight config = TaskFlyweightFactory.getConfig("* * * * *", "System backup");
        CronTask task = CronTaskFactory.create(TaskType.BACKUP, config);
        assertNotNull(task);
        assertEquals(BackupTask.class, task.getClass());
    }

    @Test
    public void testFlyweightSharedInstance() {
        TaskFlyweight config1 = TaskFlyweightFactory.getConfig("* * * * *", "Send email");
        TaskFlyweight config2 = TaskFlyweightFactory.getConfig("* * * * *", "Send email");
        assertEquals(config1, config2); // should return the same instance from cache
    }

    @Test
    public void testTaskRunOutput() {
        TaskFlyweight config = TaskFlyweightFactory.getConfig("* * * * *", "Send email");
        CronTask task = CronTaskFactory.create(TaskType.EMAIL, config);

        // We can test that runTask executes without throwing exceptions
        task.runTask();
        assertNotNull(task); // basic check to ensure task exists
    }
}
