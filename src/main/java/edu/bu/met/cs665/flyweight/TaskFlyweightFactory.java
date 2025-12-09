/**
 * Name: SRUJANA NIRANJANKUMAR
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/09/2025
 * File Name: TaskFlyweightFactory.java
 *
 * Description:
 * Factory class that creates and reuses TaskFlyweight objects.
 * Uses a cache to ensure shared configurations are not recreated.
 */
package edu.bu.met.cs665.flyweight;

import java.util.HashMap;

/**
 * Provides flyweight instances for task configurations by caching and
 * returning shared TaskFlyweight objects based on frequency and description.
 */
public class TaskFlyweightFactory {
    private static final HashMap<String, TaskFlyweight> cache = new HashMap<>();

    /**
     * Returns a shared TaskFlyweight based on the given frequency and description.
     * If none exists, it creates and stores a new one in the cache.
     *
     * @param frequency   cron-style frequency value
     * @param description task description
     * @return a cached or newly created TaskFlyweight
     */
    public static TaskFlyweight getConfig(String frequency, String description) {
        String key = frequency + "-" + description;

        cache.putIfAbsent(key, new TaskFlyweight(frequency, description));
        return cache.get(key);
    }
}
