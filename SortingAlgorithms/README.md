# 🔄 Sorting Algorithms in Java

> *“Sorting is the silent librarian of Computer Science.”* 📚
> Before searching, optimizing, or analyzing data, we usually sort it first.

This folder contains the basic sorting algorithms implemented in **Java** along with:

* Core theory
* Intuition behind each algorithm
* Important tricks
* Dry logic understanding
* Time & Space complexities
* Stability and adaptiveness
* Interview insights

---

# 📌 What is Sorting?

Sorting is the process of arranging data in a particular order.

Usually:

* Ascending Order → `1, 2, 3, 4`
* Descending Order → `4, 3, 2, 1`

Sorting helps in:

* Faster searching 🔍
* Better data organization 📂
* Efficient algorithms ⚡
* Easier duplicate handling
* Binary Search implementation

---

# 🧠 Core Intuition of Sorting

Every sorting algorithm follows one main philosophy:

| Algorithm      | Core Idea                                  |
|----------------|--------------------------------------------|
| Bubble Sort    | Push largest element to the end repeatedly |
| Selection Sort | Select minimum element and place correctly |
| Insertion Sort | Build sorted array one element at a time   |
| Counting Sort  | Count frequency instead of comparing       |

---

# ⚡ Important Sorting Terminologies

## 1. Stable Sorting

A sorting algorithm is **stable** if equal elements maintain their original order.

Example:

```text
Input:
(2,A) (1,X) (2,B)

Stable Sorted:
(1,X) (2,A) (2,B)
```

`2A` stays before `2B`.

### Stable Algorithms Here:

* Bubble Sort ✅
* Insertion Sort ✅
* Counting Sort ✅

### Not Stable:

* Selection Sort ❌

---

## 2. In-Place Sorting

Algorithm that uses very little extra memory.

### In-place Algorithms:

* Bubble Sort ✅
* Selection Sort ✅
* Insertion Sort ✅

### Not In-place:

* Counting Sort ❌

---

## 3. Adaptive Sorting

Algorithm becomes faster if array is partially sorted.

### Adaptive:

* Bubble Sort (optimized version) ✅
* Insertion Sort ✅

### Non-Adaptive:

* Selection Sort ❌

---

# 🫧 Bubble Sort

## 📖 Theory

Bubble Sort repeatedly compares adjacent elements and swaps them if they are in the wrong order.

After every pass:

* The largest element “bubbles” to the end.

---

## 🧠 Intuition

Imagine soap bubbles rising in water 🫧

Larger elements slowly move upward (towards the end of the array).

Example:

```text
5 3 4 1
```

Pass 1:

```text
3 4 1 5
```

Largest element `5` reached its correct position.

---

## ⚙️ Working Logic

### Outer Loop

Controls number of passes.

### Inner Loop

Compares adjacent elements.

```java
if(arr[j]>arr[j+1])
```

Then swap.

---

## 🎯 Important Trick

### Optimization Trick

Use a boolean variable:

```java
boolean swapped = false;
```

If no swapping happens in one pass:

* Array is already sorted
* Stop early

This reduces unnecessary iterations.

---

## ⏱ Complexity

| Case    | Time Complexity |
|---------|-----------------|
| Best    | O(n)            |
| Average | O(n²)           |
| Worst   | O(n²)           |

### Space Complexity

```text
O(1)
```

---

## ✅ Properties

| Property | Value                   |
|----------|-------------------------|
| Stable   | Yes                     |
| In-place | Yes                     |
| Adaptive | Yes (optimized version) |

---

## 🧩 Interview Insight

Bubble Sort is rarely used in real-world systems because it is inefficient for large datasets.

But:

* Excellent for learning swapping logic
* Helps understand nested loops
* Builds sorting intuition

---

# 🎯 Selection Sort

## 📖 Theory

Selection Sort repeatedly selects the minimum element from the unsorted part and places it at the correct position.

---

## 🧠 Intuition

Imagine arranging playing cards 🃏

You scan all cards:

* Find the smallest card
* Put it at the front
* Repeat for remaining cards

---

## ⚙️ Working Logic

### Step 1

Assume current index contains minimum.

```java
int minIndex = i;
```

### Step 2

Search entire unsorted portion.

### Step 3

Swap minimum element with current position.

---

## 🎯 Important Trick

Selection Sort performs:

```text
Only one swap per pass
```

This makes it useful when:

* Swapping cost is expensive
* Memory writes are costly

---

## ❌ Important Observation

Even if the array is already sorted:

* Selection Sort still checks all elements.

So:

```text
Best Case = Worst Case
```

---

## ⏱ Complexity

| Case    | Time Complexity |
|---------|-----------------|
| Best    | O(n²)           |
| Average | O(n²)           |
| Worst   | O(n²)           |

### Space Complexity

```text
O(1)
```

---

## ✅ Properties

| Property | Value |
|----------|-------|
| Stable   | No    |
| In-place | Yes   |
| Adaptive | No    |

---

## 🧩 Interview Insight

Selection Sort is not efficient for large data.

But interviewers sometimes ask it because it tests:

* Minimum tracking logic
* Nested loop understanding
* Index manipulation

---

# 🃏 Insertion Sort

## 📖 Theory

Insertion Sort builds the sorted array one element at a time by inserting each element into its correct position.

---

## 🧠 Intuition

Imagine sorting cards in your hand 🃏

You pick one card at a time and insert it into the correct position among already sorted cards.

That is exactly how Insertion Sort works.

---

## ⚙️ Working Logic

### Step 1

Take current element:

```java
int current = arr[i];
```

### Step 2

Shift larger elements to the right.

### Step 3

Insert current element into correct position.

---

## 🔥 Most Important Logic

### WHY shifting instead of swapping?

Swapping requires:

* 3 operations

Shifting requires:

* 1 movement

Therefore insertion sort becomes efficient for:

* Small datasets
* Nearly sorted arrays

---

## 🎯 Important Trick

Insertion Sort is extremely fast for:

```text
Nearly Sorted Arrays
```

Because very few shifts are needed.

That is why many advanced sorting algorithms use insertion sort internally for small partitions.

---

## ⏱ Complexity

| Case    | Time Complexity |
|---------|-----------------|
| Best    | O(n)            |
| Average | O(n²)           |
| Worst   | O(n²)           |

### Space Complexity

```text
O(1)
```

---

## ✅ Properties

| Property | Value |
|----------|-------|
| Stable   | Yes   |
| In-place | Yes   |
| Adaptive | Yes   |

---

## 🧩 Interview Insight

Insertion Sort is actually useful in real systems for:

* Small arrays
* Hybrid sorting algorithms
* Nearly sorted data

It is far more practical than Bubble Sort.

---

# 🔢 Counting Sort

## 📖 Theory

Counting Sort does not compare elements.

Instead:

* It counts frequency of elements.
* Then reconstructs the sorted array.

---

## 🧠 Intuition

Imagine exam marks from 0 to 100.

Instead of comparing students repeatedly:

* Count how many students got each mark.
* Rebuild the sorted order.

This becomes extremely fast.

---

## ⚙️ Working Logic

### Step 1

Find maximum element.

### Step 2

Create count array.

```java
int[] count = new int[max + 1];
```

### Step 3

Store frequencies.

### Step 4

Traverse count array and rebuild sorted array.

---

## 🎯 Important Trick

Counting Sort is useful only when:

```text
Range of numbers is small
```

Example:

* Marks
* Ages
* Small integers

Not suitable for:

```text
1 to 10^9
```

because count array becomes huge.

---

## 🚫 Important Limitation

Classic Counting Sort works mainly for:

* Non-negative integers

Negative numbers require modifications.

---

## ⏱ Complexity

| Case    | Time Complexity |
|---------|-----------------|
| Best    | O(n + k)        |
| Average | O(n + k)        |
| Worst   | O(n + k)        |

Where:

```text
k = range of elements
```

### Space Complexity

```text
O(k)
```

---

## ✅ Properties

| Property         | Value |
|------------------|-------|
| Stable           | Yes   |
| In-place         | No    |
| Comparison Based | No    |

---

## 🧩 Interview Insight

Counting Sort is powerful when:

* Input range is limited
* Huge amount of data exists
* Linear sorting is needed

It introduces the idea that:

```text
Not every sorting algorithm needs comparisons.
```

---

# 📊 Overall Comparison Table

| Algorithm      | Best   | Average | Worst  | Stable | Adaptive | In-place |
|----------------|--------|---------|--------|--------|----------|----------|
| Bubble Sort    | O(n)   | O(n²)   | O(n²)  | ✅      | ✅        | ✅        |
| Selection Sort | O(n²)  | O(n²)   | O(n²)  | ❌      | ❌        | ✅        |
| Insertion Sort | O(n)   | O(n²)   | O(n²)  | ✅      | ✅        | ✅        |
| Counting Sort  | O(n+k) | O(n+k)  | O(n+k) | ✅      | ❌        | ❌        |

---

# 🧠 Important Patterns & Observations

## 1. Bubble Sort and Insertion Sort improve on nearly sorted arrays.

Reason:

* Less swapping/shifting needed.

---

## 2. Selection Sort always performs same comparisons.

Reason:

* It always searches for minimum.

---

## 3. Counting Sort avoids comparisons completely.

This breaks the limitation of:

```text
O(n log n)
```

for comparison-based sorting.

---

# 🚀 When to Use Which?

| Situation            | Preferred Algorithm |
|----------------------|---------------------|
| Learning basics      | Bubble Sort         |
| Less swaps needed    | Selection Sort      |
| Nearly sorted arrays | Insertion Sort      |
| Small integer range  | Counting Sort       |

---

# 📚 Key Takeaways

✅ Sorting is foundational for DSA
✅ Different algorithms optimize different things
✅ Time complexity alone is not everything
✅ Stability and adaptiveness matter in real systems
✅ Understanding intuition is more important than memorizing code

---

# 🛠 Implemented Algorithms

* Bubble Sort
* Selection Sort
* Insertion Sort
* Counting Sort

All implementations are written in **Java** ☕

---

# 🌱 Future Algorithms to Learn

* Merge Sort
* Quick Sort
* Heap Sort
* Radix Sort
* Bucket Sort
* Shell Sort

---

# ✨ Final Thought

Sorting algorithms are not just about arranging numbers.

They teach:

* Problem decomposition
* Optimization thinking
* Trade-offs
* Memory vs speed decisions
* Algorithmic intuition

Learning sorting properly is like learning movement in chess ♟️
Every advanced algorithm later starts feeling less chaotic.
