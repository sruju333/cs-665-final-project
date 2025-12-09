
| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | SRUJANA NIRANJANKUMAR      |
| Date         | 12/08/2025                 |
| Course       | Fall                       |
| Assignment # | FINAL PROJECT              |

# Final Project Overview
The objective of this assignment is to design and implement a simplified Cron Job Simulator that demonstrates the use of compound design patterns-specifically the Thread Pool pattern and the Flyweight pattern-within an object-oriented architecture. 
The goal is to simulate scheduled task execution while showing how these two patterns work together to improve efficiency. 
In addition, the assignment includes a properties-based cron job loader, allowing the program to load cron configurations from an external .properties file and compare it with a pattern-based cron scheduler implemented in code.
A key requirement of this assignment is to keep the design simple and easy to understand while clearly demonstrating important OOP concepts such as inheritance, abstraction, and polymorphism and use of interfaces.
The project also highlights design decisions that improve flexibility, reduce duplication, and make the system easy to extend with new types of tasks, schedulers, and configurations.

# GitHub Repository Link:
https://github.com/sruju333/cs-665-final-project.git

# Implementation Description 

## Flexibility of the Implementation

The system is designed with flexibility in mind. New cron-based tasks can be added easily by simply creating a new class that extends a base Task class and overrides the execute() method. Similarly, new cron patterns or configuration types can be introduced without modifying the existing core logic. The use of a Flyweight factory (TaskConfigFactory) allows the reuse of cron configuration objects, enabling the addition of new configurations without rewriting or duplicating code. Because the scheduler interacts with tasks through a common interface, the underlying task behavior can evolve independently of the scheduler.
The implementation also includes two different scheduling approaches-pattern-based cron scheduling and properties-file scheduling-allowing the program to be extended with more scheduling strategies in the future without modifying the existing schedulers.

## Simplicity and Understandability
The class structure is intentionally kept lightweight and readable. Responsibilities are clearly separated:
- The CronScheduler manages task scheduling and delegates work to a ThreadPool.
- The ThreadPool isolates concurrency concerns.
- The Task hierarchy defines the behavior of individual jobs.
- The FlyweightTaskConfig encapsulates reusable configuration data.
- The TaskConfigFactory manages shared configuration instances.
- The result is an intuitive design where each class has one clear purpose. Anyone reviewing the code can easily understand where tasks are created, how they are configured, and how the scheduler triggers them.

## Avoiding Code Duplication

Duplicate code was avoided by centralizing common logic:
- Shared cron configuration objects are handled by the Flyweight factory, preventing repeated creation of identical configuration data.
- All tasks inherit from a single Task superclass, ensuring shared behavior lives in one place.
- Reusable scheduling logic (parsing patterns, reading properties, submitting tasks to the pool) is cleanly separated into different classes rather than repeated inside tasks or schedulers.

Avoiding duplication improves maintainability, prevents inconsistencies, and makes the system easier to update or extend later.

## Design Patterns Used

1. Thread Pool Pattern
   The Thread Pool pattern is used in the ThreadPool class to efficiently manage worker threads. Instead of creating a new thread for every task, a pool of reusable threads handles incoming jobs. This improves performance and demonstrates concurrency control in a clean and simple way.

2. Flyweight Pattern
   Cron configurations (pattern + message) are implemented as Flyweight objects. The TaskConfigFactory ensures that identical configurations reuse the same object. This reduces memory usage and demonstrates how Flyweight improves efficiency for repeated, similar data.

3. OOP Principles (Inheritance & Polymorphism)
   Different task types extend a common Task base class, allowing the scheduler to treat all tasks uniformly. Polymorphism ensures that the scheduler does not need to know which type of task it is executing; it simply calls task.execute().


# Maven Commands

```bash
mvn clean compile
```


## JUnit Tests

To run, use the following command:
```bash
mvn clean test
```


## Spotbugs

Use the following command:

```bash
mvn spotbugs:gui 
```


## Checkstyle

```bash
mvn checkstyle:checkstyle
```




