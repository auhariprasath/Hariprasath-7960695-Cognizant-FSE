# Understanding Recursive Algorithms

## Introduction to Recursion

### Definition

Recursion is a programming technique in which a method or function calls itself repeatedly to solve a problem. Instead of solving the entire problem at once, recursion breaks the problem into smaller subproblems of the same type and solves them until a simple condition, known as the **base case**, is reached.

A recursive algorithm consists of two essential parts:

1. **Base Case** – The condition that stops the recursion.
2. **Recursive Case** – The part where the function calls itself with a smaller or simpler input.

---

## How Recursion Works

When a recursive function is called, the system stores the current function call in memory (the call stack). The function continues calling itself until the base case is reached. Once the base case is satisfied, the stored function calls are resolved one by one in reverse order.

---

## Example: Factorial Using Recursion

The factorial of a number is defined as:

```text
5! = 5 × 4 × 3 × 2 × 1 = 120
```

### Recursive Formula

```text
n! = n × (n - 1)!
0! = 1
```

### Java Implementation

```java
public class Main {

    public static int factorial(int n) {

        if(n == 0) { // Base Case
            return 1;
        }

        return n * factorial(n - 1); // Recursive Call
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
```

### Output

```text
120
```

### Execution Flow

```text
factorial(5)
= 5 * factorial(4)
= 5 * 4 * factorial(3)
= 5 * 4 * 3 * factorial(2)
= 5 * 4 * 3 * 2 * factorial(1)
= 5 * 4 * 3 * 2 * 1 * factorial(0)
= 5 * 4 * 3 * 2 * 1 * 1
= 120
```

---

## Advantages of Recursion

### 1. Simplifies Complex Problems

Recursion breaks large problems into smaller, manageable subproblems, making the solution easier to understand.

### 2. Produces Cleaner Code

Many problems can be implemented with fewer lines of code using recursion compared to iterative approaches.

### 3. Natural Fit for Hierarchical Structures

Recursion is particularly useful for problems involving:

* Trees
* Graphs
* Directory structures
* Divide-and-conquer algorithms

---

## Applications of Recursion

### Factorial Calculation

```java
factorial(n)
```

### Fibonacci Series

```java
fibonacci(n)
```

### Binary Search

Recursively divides the search space into smaller halves.

### Tree Traversal

Used to visit all nodes in a tree structure.

### Tower of Hanoi

A classic recursive problem involving moving disks between rods.

---

## Advantages and Disadvantages

| Advantages                                       | Disadvantages                               |
| ------------------------------------------------ | ------------------------------------------- |
| Simple and readable code                         | Higher memory usage due to function calls   |
| Suitable for divide-and-conquer problems         | Can cause stack overflow for deep recursion |
| Easy implementation of tree and graph algorithms | Often slower than iterative solutions       |

---

## Conclusion

Recursion is a powerful problem-solving technique where a function calls itself to solve smaller instances of the same problem. It simplifies complex tasks by breaking them into smaller subproblems and is widely used in algorithms involving trees, graphs, searching, and mathematical computations. Every recursive algorithm must include a base case to prevent infinite recursion and ensure proper termination.
