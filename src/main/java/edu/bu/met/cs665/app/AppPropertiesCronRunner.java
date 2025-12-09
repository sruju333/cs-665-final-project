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

package edu.bu.met.cs665.app;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Loads cron settings from app.properties and schedules a Quartz job using them.
 */
public class AppPropertiesCronRunner {
    /**
     * Reads cron expression and message from properties, builds a Quartz job,
     * and schedules it with the configured trigger.
     *
     * @throws Exception if properties cannot be loaded or scheduling fails
     */
    public void runFromProperties() throws Exception {

        // Load properties file
        Properties props = new Properties();
        InputStream is = getClass().getClassLoader().getResourceAsStream("app.properties");

        if (is == null) {
            throw new FileNotFoundException("app.properties not found in classpath");
        }

        props.load(is);

        // Start scheduler
        String cronExpr = props.getProperty("cron.expression");
        String msg = props.getProperty("cron.message");

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();

        // Create job
        JobDetail job = JobBuilder.newJob(PrintMessageJob.class)
                .withIdentity("propertiesCronJob")
                .usingJobData("message", msg)
                .build();

        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("propertiesCronTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpr))
                .build();

        scheduler.scheduleJob(job, trigger);
    }

    /**
     * Simple Quartz job that prints a configured message when triggered.
     */
    public static class PrintMessageJob implements Job {
        /**
         * Executes the job and prints the configured message.
         *
         * @param context job execution context
         */
        @Override
        public void execute(JobExecutionContext context) {
            String message = context.getJobDetail().getJobDataMap().getString("message");
            System.out.println("[PROPERTIES CRON] " + message + " → " + new java.util.Date());
        }
    }

}
