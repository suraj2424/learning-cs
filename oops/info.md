# OOPS (OBJECT ORIENTED PROGRAMMING SYSTEM/STRUCTURE)

***Definition:*** OOPS is a programming paradigm based on `objects` that contain *variables* and *methods*. 

**Paradigm** can be termed as method to solve some problem or do some task.
- Object oriented
- Procedural
- Functional
- Structural
- Logical etc, paradigms

---

# 6 Main Pillars of OOPS
1. Class
2. Object & Methods
3. Inheritance
4. Abstraction
5. Polymorphism
6. Encapsulation

--- 

## 1. Class
- A class is `Blueprint`.
- Intangible (It exist but, we cannot touch it)

Demo: [Here](Class_Demo.java)

## 2. Object
- An object is a `instance of a class`.
- Objects get initialized in a **HEAP MEMORY**.
- & variables get initialized in a **STACK MEMORY**.

---

### Constructor
- Default Constructor
- Parameterised Constructor
- Copy Constructor
Demo: [Here](Constructor.java)

### this method
- it calls constructor
- you can specify constructor based on parameters
*⚠️Note*: only can be called from inside a constructor

### Static
- In java, static can be of:
1. Variables
2. Methods
3. Blocks
4. Class

- A static can be mentioned as Anything which can be updated at a `Class Level`.
- Belongs to the class, not individual objects.
- All objects of the class share the same memory reference for this variable.
- Can be accessed directly using the class name (e.g., ClassName.variableName) without creating an object.
- Also we cannot call static stuff through objects
- You cannot call **non static** variables/functions inside static method.
- But, You can call static variables/functions in non-static method/function.

Demo: [Here](Static.java)

#### Static Block
- Executes automatically exactly once when the class is first loaded, even before the main() method.
- Primarily used to initialize static variables or perform one-time setup tasks.

#### Static Methods
- Can be called without creating an instance of the class.
- **Limitation:** Static methods and blocks cannot access non-static (instance) fields or methods directly, as those require an object context.

---

## 3. Encapsulation
- It involves wrapping data (variables) and methods (behaviors) into a single unit—the class—while restricting direct access to the internal data to ensure security and control.
Demo: [Here](Encapsulation.java)

### Key features
- Data Security
- Getter and Setter methods
- Validation before updating in setters

---

## 4. Inheritance
- Base class (Parent Class)
- Derived class (Child Class)
    - This class inherits `parent class's properties`.
- To generate a `child class` from `parent class`, we need to use `extends` keyword.
- `parent class` can restrict the properties to share with *child class*.
- private variables can be inherited. (restricted to share with child class)
- `parent class` cannot access child methods


### Types of Inheritance
**refer:** ![Inheritance](./inheritance%20image.webp)

1. Single Inheritance (parent -> child)

2. Multi-Level Inheritance (parent -> child -> child -> child)

3. Hierarchical Inheritance (parent having multiple childs)

4. Hybrid Inheritance (Combination of single, multilevel and hierarchical)

5. Multiple inheritance
Parent A and Parent B both of them will form a child C.

Here comes a problem, 
- Diamond problem (if parent A has method `m` & parent B has method `m` as well, so the problem which `m` method will get transferred to child.)
 - Multiple inheritance is not allowed due to ambiguity


## 5. Abstraction

**Demo:** [Code](Abstraction.java) 

- Process of hiding implementation details and exposing only the essential features of an object.
- **Example:** TV Remote

This can be achieved by using-
**Abstract Classes** (0-100% abstraction)
- Can have its constructor
**Instance Classes**

### Abstract Classes
- Can contain normal methods & abstract methods
- **normal methods** (which has their implementation)
- **abstract methods** (which do not have the implementation/behaviour)

#### Rules: 
Cannot be instantiated directly. Subclasses must override all abstract methods to be non-abstract themselves.

### Interfaces

**Demo:** [Code](Interface.java) 

**Definition:** A blueprint used to achieve 100% abstraction.

**Implementation:** Use the implements keyword. All methods in an interface are implicitly abstract (pre-Java 8).

**Rules:** Cannot have constructors and cannot be instantiated.

**Key Logic:** "Parent (Interface/Abstract class) can point to Child (Implementation), but Child cannot point to Parent."

We need to `implement` them (methods).

### MULTIPLE INHERITANCE IS POSSIBLE IN JAVA THROUGH INTERFACES

## 6. Polymorphism
- Polymorphism means "many forms." It allows an entity (like a method) to behave differently depending on the context.
### 1. Compile-time Polymorphism (Method Overloading)

**Refer:** [Here](Polymorphism_1.java)

- Also known as <u>Early Binding</u>, this is handled by the compiler.
- **How it works:** Multiple methods in the same class share the same name but have different method signatures (number, type, or order of parameters)
- **Example:** A Calculator class with multiple add methods to handle different data types.

#### Rules for Method Overloading
To successfully overload a method, you must change at least one of the following:
- **Number of parameters:** e.g., add(int a) vs add(int a, int b).
- **Data type of parameters:** e.g., add(int a) vs add(double a).
- **Sequence of data types:** e.g., display(int a, String b) vs display(String b, int a).

### 2. Runtime Polymorphism (Method Overriding)
- Also known as Late Binding, this is handled by the **JVM**.
**Concept:** Occurs in a parent-child class relationship where a child class provides a specific implementation for a method already defined in the parent class.

**Key Rules:**
- **Method Signature:** Must match exactly.
- **Return Type:** Must be the same or a covariant (child) type
- **Access Modifiers:** Cannot reduce visibility. If the parent method is public, the child method must also be public.
- **Restrictions:** You cannot override static, private, or final methods, nor can you override constructors


## Keywords
| Modifier | Same Class | Same Package | Subclass (Other Package) | Other Package (No Subclass) |
| :--- | :---: | :---: | :---: | :---: |
| **private** | ✅ | ❌ | ❌ | ❌ |
| **default** | ✅ | ✅ | ❌ | ❌ |
| **protected** | ✅ | ✅ | ✅ | ❌ |
| **public** | ✅ | ✅ | ✅ | ✅ |


### 'Final' Keyword

**DEMO**: [Here](Final.java)

- **Variable**: Cannot be changed.
- **Method**: Can not be overridden.
- **Class**: Cannot be inherited.

### 'Super' Keyword

**DEMO:** [Here](Super.java)

- reference variable used to refer to immediate parent class objects.
- acts as bridge between subclass and its superclass, allowing you to access shadowed variables, overridden methods, or hidden constructors.

**USE**:
- To Invoke Parent Class Constructor.
- To Invoke Parent Class Variables.
- To Invoke Parent Class Methods.


**RESTRICTIONS**
- Inside `static method` or `static block`.
- **Single Level:** `super` only refers to the <u>immediate parent</u>. You cannot use *super.super* to reach a grandparent class.

---

## Nested Class

**DEMO**: [Here](NestedClass.java)

### 1. Static Nested Class

**Access:** 
- It cannot access non-static (instance) members of the outer class directly.

### 2. Inner Classes (Non-Static)

**Access:**
- Have access to all variables and methods of the outer class, including private ones.

**Types**

1. Member Inner Class
- Inside Outer Class and Outside of Function

2. Local Inner Class
- Inside Outer Class and Inside Function

3. Anonymous Class
- A class having no name

