# Design Patterns: When to Use Which

---

## **Basic Patterns**
   **Pattern**               | **When to Use**                                                                                     |
 |---------------------------|---------------------------------------------------------------------------------------------------|
 | Interface                | When multiple classes share common methods but each has a different implementation.             |
 | Abstract Parent Class     | When some common behavior is shared but subclasses need to implement specific methods.          |
 | Private Methods           | To break complex logic into smaller helper methods not accessible outside the class.           |
 | Accessor Methods          | To provide controlled access (get/set) to object data (encapsulation).                          |
 | Constant Data Manager     | To store constants in a class for global access without instantiation.                          |
 | Immutable Object          | When object state should not change after creation; ensure thread-safety and consistency.       |
 | Monitor                   | When multiple threads access shared data, use synchronized methods to make it thread-safe.     |

---

## **Creational Patterns**
 | **Pattern**               | **When to Use**                                                                                     |
 |---------------------------|---------------------------------------------------------------------------------------------------|
 | Singleton                 | When only one instance of a class is needed globally.                                             |
 | Factory Method            | When a class wants to delegate object creation to subclasses.                                    |
 | Abstract Factory          | When creating families of related objects without specifying concrete classes.                 |
 | Prototype                 | When creating multiple similar objects efficiently by cloning an existing one.                  |
 | Builder                   | When constructing complex objects step-by-step, possibly with optional parameters.               |

---

## **Collectional / Structural Patterns**
 | **Pattern**               | **When to Use**                                                                                     |
 |---------------------------|---------------------------------------------------------------------------------------------------|
 | Composite                 | When you want to treat individual and composite objects uniformly.                               |
 | Flyweight                 | When you need to reduce memory usage by sharing common objects.                                  |
 | Visitor                   | When you want to add operations to classes without changing them.                               |
 | Iterator                  | When you want to traverse a collection without exposing its underlying representation.           |

---
## **Structural Patterns**
 | **Pattern**               | **When to Use**                                                                                     |
 |---------------------------|---------------------------------------------------------------------------------------------------|
 | Decorator                 | When you want to add functionality to objects dynamically without modifying them.               |
 | Adapter                   | When you want to make incompatible interfaces compatible.                                        |
 | Facade                    | When you want to provide a simple interface to a complex system.                                  |
 | Object Release            | When you need to release expensive resources after use.                                          |
 | Object Cache              | When you want to reuse already created objects to improve performance.                           |
 | Proxy                     | When you want to delay object creation until it is needed or control access.                     |
 | Bridge                    | When you want to separate abstraction from implementation to vary them independently.           |
 | Chain of Responsibility  | When multiple objects can handle a request and you want to pass it along a chain.               |
 | Aggregator Enforcer       | When all modifications must go through a single root object for consistency.                   |

---
## **Behavioral Patterns**
 | **Pattern**               | **When to Use**                                                                                     |
 |---------------------------|---------------------------------------------------------------------------------------------------|
 | Command                   | When requests should be treated as objects to allow queuing, logging, or undoing.                |
 | Mediator                  | When multiple objects interact frequently and you want to centralize communication.             |
 | State                     | When object behavior changes based on its internal state.                                       |
 | Memento                   | When you need to capture and restore an object's previous state.                                  |
 | Observer                  | When objects need to be notified automatically of state changes in another object.                |
 | Interpreter               | When you need to interpret sentences/expressions in a language or grammar.                       |
 | Strategy                  | When multiple algorithms or behaviors can be swapped interchangeably.                            |
 | Null Object               | When you want to avoid null checks by providing a default no-op object.                           |
 | Common Attribute Registry | When you need a centralized repository for configuration or shared data.                       |
 | Template                  | When you want to define the skeleton of an algorithm with some steps implemented by subclasses.   |
 | Object Authenticator      | When you need a gatekeeper to control access to an object or its data.                            |