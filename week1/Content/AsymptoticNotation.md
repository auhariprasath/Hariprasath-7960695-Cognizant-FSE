# Understanding Asymptotic Notation

## Big O Notation

### Definition

Big O notation is a mathematical representation used to describe the time and space complexity of an algorithm. It indicates how the execution time or memory usage of an algorithm grows as the size of the input increases.

### Importance of Big O Notation

Big O notation helps developers:

* Analyze the efficiency of algorithms.
* Compare different algorithms based on their performance.
* Predict how algorithms will behave with large datasets.
* Choose the most suitable algorithm for a given problem.

### Common Time Complexities

| Big O Notation | Complexity        | Example                          |
| -------------- | ----------------- | -------------------------------- |
| O(1)           | Constant Time     | Accessing an array element       |
| O(log n)       | Logarithmic Time  | Binary Search                    |
| O(n)           | Linear Time       | Linear Search                    |
| O(n log n)     | Linearithmic Time | Merge Sort                       |
| O(n²)          | Quadratic Time    | Bubble Sort                      |
| O(2ⁿ)          | Exponential Time  | Recursive Fibonacci              |
| O(n!)          | Factorial Time    | Traveling Salesman (Brute Force) |

### Example

#### Linear Search

```java
public static int linearSearch(int[] arr, int target) {
    for(int i = 0; i < arr.length; i++) {
        if(arr[i] == target) {
            return i;
        }
    }
    return -1;
}
```

In the worst case, the algorithm checks every element in the array. Therefore, its time complexity is **O(n)**.

#### Binary Search

```java
public static int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while(left <= right) {
        int mid = left + (right - left) / 2;

        if(arr[mid] == target)
            return mid;
        else if(arr[mid] < target)
            left = mid + 1;
        else
            right = mid - 1;
    }

    return -1;
}
```

Binary Search repeatedly divides the search space into halves, resulting in a time complexity of **O(log n)**.

---

# Best, Average, and Worst-Case Scenarios for Search Operations

When analyzing search algorithms, performance is often measured in three cases:

## 1. Best Case

### Definition

The best case occurs when the target element is found immediately with the minimum number of operations.

### Example: Linear Search

```java
int[] arr = {10, 20, 30, 40, 50};
target = 10;
```

The target is found at the first position.

**Time Complexity:** O(1)

---

## 2. Average Case

### Definition

The average case represents the expected performance when the target element may be located anywhere in the dataset.

### Example: Linear Search

```java
int[] arr = {10, 20, 30, 40, 50};
target = 30;
```

The algorithm checks approximately half of the elements before finding the target.

**Time Complexity:** O(n)

---

## 3. Worst Case

### Definition

The worst case occurs when the target element is located at the last position or is not present in the dataset.

### Example: Linear Search

```java
int[] arr = {10, 20, 30, 40, 50};
target = 60;
```

The algorithm checks every element before determining that the target is absent.

**Time Complexity:** O(n)

---

# Complexity Comparison of Search Algorithms

| Search Algorithm | Best Case | Average Case | Worst Case |
| ---------------- | --------- | ------------ | ---------- |
| Linear Search    | O(1)      | O(n)         | O(n)       |
| Binary Search    | O(1)      | O(log n)     | O(log n)   |

---

# Conclusion

Big O notation is a fundamental tool for analyzing algorithm efficiency. It helps developers understand how an algorithm's performance changes as the input size grows. For search operations, performance is typically evaluated using best-case, average-case, and worst-case scenarios. Linear Search has a worst-case complexity of O(n), while Binary Search offers significantly better performance with a complexity of O(log n) when applied to sorted data.
