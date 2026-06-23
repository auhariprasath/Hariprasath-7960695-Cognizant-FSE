# Singleton Pattern

## Definition

The Singleton Pattern is a creational design pattern that ensures a class has only one instance throughout the application and provides a global access point to that instance.

## Purpose

The main purpose of the Singleton Pattern is to control object creation and ensure that only one object of a class exists. This helps in managing shared resources efficiently.

## Features

* Only one instance of the class is created.
* The constructor is made private to prevent direct object creation.
* A static method provides access to the single instance.
* The same object is returned whenever requested.

## Example

```java
class Database {
    private static Database instance;

    private Database() {
        System.out.println("Database Connected");
    }

    public static Database getInstance() {
        if(instance == null) {
            instance = new Database();
        }
        return instance;
    }
}

public class Main {
    public static void main(String[] args) {
        Database d1 = Database.getInstance();
        Database d2 = Database.getInstance();

        System.out.println(d1 == d2);
    }
}
```

## Output

```
Database Connected
true
```

## Applications

* Database Connections
* Logging Systems
* Configuration Managers
* Cache Management Systems

---

# Factory Method Pattern

## Definition

The Factory Method Pattern is a creational design pattern that provides an interface for creating objects while allowing subclasses or factory classes to decide which object to create.

## Purpose

The Factory Method Pattern simplifies object creation by hiding the instantiation logic from the client. The client requests an object from the factory without knowing the exact class being instantiated.

## Features

* Encapsulates object creation logic.
* Reduces dependency between client code and concrete classes.
* Improves code maintainability and flexibility.
* Supports the Open/Closed Principle.

## Example

### Interface

```java
interface Food {
    void prepare();
}
```

### Concrete Classes

```java
class Pizza implements Food {
    public void prepare() {
        System.out.println("Preparing Pizza");
    }
}

class Burger implements Food {
    public void prepare() {
        System.out.println("Preparing Burger");
    }
}
```

### Factory Class

```java
class FoodFactory {

    public static Food getFood(String type) {

        if(type.equalsIgnoreCase("Pizza")) {
            return new Pizza();
        }

        if(type.equalsIgnoreCase("Burger")) {
            return new Burger();
        }

        return null;
    }
}
```

### Client Code

```java
public class Main {
    public static void main(String[] args) {

        Food food1 = FoodFactory.getFood("Pizza");
        food1.prepare();

        Food food2 = FoodFactory.getFood("Burger");
        food2.prepare();
    }
}
```

## Output

```
Preparing Pizza
Preparing Burger
```

## Applications

* Vehicle Manufacturing Systems
* Notification Systems (Email, SMS, Push Notifications)
* Payment Gateway Integration
* User Interface Component Creation

---

# Difference Between Singleton and Factory Method

| Singleton Pattern                                 | Factory Method Pattern                 |
| ------------------------------------------------- | -------------------------------------- |
| Ensures only one object exists.                   | Creates objects based on requirements. |
| Controls the number of instances.                 | Controls the object creation process.  |
| Uses a private constructor and a static instance. | Uses a factory class or method.        |
| Returns the same object every time.               | Can return different objects.          |
| Example: Database Connection Manager.             | Example: Vehicle or Food Factory.      |

## Conclusion

The Singleton Pattern is used when exactly one instance of a class is required throughout the application, whereas the Factory Method Pattern is used to create objects without exposing the creation logic to the client. Both patterns improve code organization, reusability, and maintainability.
