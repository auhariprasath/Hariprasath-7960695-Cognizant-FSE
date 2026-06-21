# SOLID Principles – Complete Explanation with Examples

## What are SOLID Principles?

SOLID is a set of five fundamental design principles in Object-Oriented Programming (OOP). They help developers write code that is:

- Easy to understand
- Easy to maintain
- Flexible for future changes
- Less prone to bugs

| Letter | Principle |
|--------|-----------|
| **S** | Single Responsibility Principle |
| **O** | Open/Closed Principle |
| **L** | Liskov Substitution Principle |
| **I** | Interface Segregation Principle |
| **D** | Dependency Inversion Principle |

---

## 1. Single Responsibility Principle (SRP)

**Definition:** A class should have only one reason to change — meaning it should have only one responsibility.

**Simple Explanation:** One class = One job. Don't mix unrelated tasks in the same class.

**Violation Example (Bad Design):**

```java
class Employee {
    String name;
    double salary;

    void calculateSalary() { ... }     // Salary logic
    void generateReport() { ... }      // Report generation
}
```

**Problem:** If the report format changes, you modify the `Employee` class. If salary calculation changes, you also modify the same class. This class has multiple reasons to change.

**Correct Example (Good Design):**

```java
class Employee {
    String name;
    double salary;
    // Only data + getters/setters
}

class SalaryCalculator {
    double calculateSalary(Employee emp) { ... }
}

class ReportGenerator {
    void generateReport(Employee emp) { ... }
}
```

**Benefit:** Each class has only one responsibility. Changing the report format only affects `ReportGenerator`.

---

## 2. Open/Closed Principle (OCP)

**Definition:** Software entities (classes, modules, functions) should be open for extension but closed for modification.

**Simple Explanation:** You should add new features by writing new code, not by changing old code.

**Violation Example (Bad Design):**

```java
class AreaCalculator {
    double calculateArea(String shape, double radius, double length, double width) {
        if (shape.equals("circle")) {
            return Math.PI * radius * radius;
        } else if (shape.equals("rectangle")) {
            return length * width;
        }
        // Adding new shape (triangle) requires modifying this method
    }
}
```

**Problem:** Every new shape forces you to modify this class — risky and violates OCP.

**Correct Example (Good Design):**

```java
interface Shape {
    double calculateArea();
}

class Circle implements Shape {
    double radius;
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    double length, width;
    public double calculateArea() {
        return length * width;
    }
}

class AreaCalculator {
    double calculateArea(Shape shape) {
        return shape.calculateArea();   // No modification needed
    }
}
```

**Benefit:** To add Triangle, Pentagon, etc., just create new classes. No change needed in `AreaCalculator`.

---

## 3. Liskov Substitution Principle (LSP)

**Definition:** Objects of a subclass should be replaceable with objects of the superclass without affecting the correctness of the program.

**Simple Explanation:** A child class must be usable wherever the parent class is expected, without breaking anything.

**Violation Example (Bad Design):**

```java
class Bird {
    void fly() { ... }
}

class Sparrow extends Bird { ... }     // OK

class Penguin extends Bird {
    void fly() {
        throw new UnsupportedOperationException("Penguins can't fly!");
    }
}
```

**Problem:** You cannot safely replace `Bird` with `Penguin`. Code expecting a `Bird` to fly will crash.

**Correct Example (Good Design):**

```java
abstract class Bird {
    abstract void makeSound();
}

interface FlyingBird {
    void fly();
}

class Sparrow extends Bird implements FlyingBird {
    public void makeSound() { ... }
    public void fly() { ... }
}

class Penguin extends Bird {
    public void makeSound() { ... }
    // No fly() method
}
```

**Benefit:** Subclasses are truly substitutable without unexpected errors.

---

## 4. Interface Segregation Principle (ISP)

**Definition:** Clients should not be forced to depend on interfaces they do not use.

**Simple Explanation:** Create small, specific interfaces instead of one large "fat" interface.

**Violation Example (Bad Design):**

```java
interface Worker {
    void work();
    void eat();
}

class Human implements Worker {
    public void work() { ... }
    public void eat() { ... }      // Makes sense
}

class Robot implements Worker {
    public void work() { ... }
    public void eat() {
        throw new UnsupportedOperationException("Robot doesn't eat");
    }
}
```

**Problem:** `Robot` is forced to implement `eat()`, which it doesn't need.

**Correct Example (Good Design):**

```java
interface Workable {
    void work();
}

interface Feedable {
    void eat();
}

class Human implements Workable, Feedable {
    public void work() { ... }
    public void eat() { ... }
}

class Robot implements Workable {
    public void work() { ... }
    // No eat() method
}
```

**Benefit:** Classes only implement what they actually need.

---

## 5. Dependency Inversion Principle (DIP)

**Definition:** High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details.

**Simple Explanation:** Don't hardcode dependencies on concrete classes. Depend on interfaces/abstract classes instead.

**Violation Example (Bad Design):**

```java
class WiredKeyboard { ... }

class Computer {
    private WiredKeyboard keyboard = new WiredKeyboard();  // Tight coupling

    void start() {
        keyboard.connect();
    }
}
```

**Problem:** You cannot easily switch to `WirelessKeyboard` without changing the `Computer` class.

**Correct Example (Good Design):**

```java
interface Keyboard {
    void connect();
}

class WiredKeyboard implements Keyboard { ... }
class WirelessKeyboard implements Keyboard { ... }

class Computer {
    private Keyboard keyboard;

    public Computer(Keyboard keyboard) {   // Dependency Injection
        this.keyboard = keyboard;
    }

    void start() {
        keyboard.connect();
    }
}
```

**Usage:**

```java
Computer pc1 = new Computer(new WiredKeyboard());
Computer pc2 = new Computer(new WirelessKeyboard());
```

**Benefit:** Easy to swap implementations without changing the `Computer` class.

---

## Summary Table

| Principle | Main Idea | Key Benefit |
|-----------|-----------|--------------|
| **SRP** | One class → One responsibility | Easier maintenance |
| **OCP** | Open for extension, closed for modification | Safe to add features |
| **LSP** | Subclasses must be substitutable | Reliable inheritance |
| **ISP** | Small, focused interfaces | No unnecessary dependencies |
| **DIP** | Depend on abstractions | Flexible & decoupled code |