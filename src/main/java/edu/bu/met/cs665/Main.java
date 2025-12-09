/**
 * Name: SRUJANA NIRANJANKUMAR
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/09/2025
 * File Name: Main.java
 *
 * Description: This file contains the entry point for the application. It demonstrates the
 * usage of 3 design patterns and scheduling mechanisms, including:
 *  - A cron-based scheduling system
 *  - The Flyweight pattern for reusing task configuration objects
 *  - Thread pool executor pattern for thread reuse of cron job execution
 *  - Simple factory pattern for object creation on need basis
 *  - A properties-based runner for externalized cron configurations
 *
 * The Main class orchestrates the creation of cron tasks, their scheduling,
 * and execution using both pattern-based and properties-based approaches.
 */

package edu.bu.met.cs665;

import edu.bu.met.cs665.app.AppPropertiesCronRunner;
import edu.bu.met.cs665.factory.CronTaskFactory;
import edu.bu.met.cs665.flyweight.TaskFlyweight;
import edu.bu.met.cs665.flyweight.TaskFlyweightFactory;
import edu.bu.met.cs665.task.CronTask;
import edu.bu.met.cs665.thread.scheduler.CronScheduler;

/**
 * This is the Main class.
 */
public class Main {

  /**
   * The Main class method serves as the entry point of the application. It demonstrates
   * how cron-like tasks can be scheduled using different design patterns such as
   * Flyweight, Simple Factory, and Thread-pool executor. It also showcases the use of
   * a properties-driven configuration mechanism for task execution.
   */
  public static void main(String[] args) throws Exception {
    System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "warn");    // hiding quartz warning
    System.out.println("=== PATTERN-BASED CRON ===");
    CronScheduler scheduler = new CronScheduler();

    // Flyweights
    TaskFlyweight emailConfig =
            TaskFlyweightFactory.getConfig("* * * * *", "Send weekly email");

    TaskFlyweight backupConfig =
            TaskFlyweightFactory.getConfig("* * * * *", "Run system backup");

    // Use simple factory (With ENUM)
    CronTask emailTask = CronTaskFactory.create(TaskType.EMAIL, emailConfig);
    CronTask backupTask = CronTaskFactory.create(TaskType.BACKUP, backupConfig);

    // Thread pool executor
    scheduler.scheduleRecurring(emailTask, 5, 3);
    scheduler.scheduleRecurring(backupTask, 5, 3);

    Thread.sleep(16_000);

    System.out.println("\n=== PROPERTIES-BASED CRON ===");
    new AppPropertiesCronRunner().runFromProperties();

    // Exit system after 5 minutes
    Thread.sleep(300_000);
    System.exit(0);
  }
}
