/**
 * Name: SRUJANA NIRANJANKUMAR
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/09/2025
 * File Name: TaskFlyweight.java
 *
 * Description:
 * A flyweight class that stores reusable task configuration, including
 * the cron frequency and description shared across multiple cron tasks.
 */

package edu.bu.met.cs665.flyweight;

/**
 * Flyweight object that stores shared task configuration such as frequency and description.
 */
public class TaskFlyweight {
    private final String frequency;
    private final String description;

    // Getters and Setters (Parameterized constructor)
    public TaskFlyweight(String frequency, String description) {
        this.frequency = frequency;
        this.description = description;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getDescription() {
        return description;
    }
}
