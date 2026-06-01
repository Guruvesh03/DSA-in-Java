# 🧩 2D Arrays (Matrices) in Java

> A collection of fundamental 2D Array concepts, patterns, tricks, and interview-oriented problems solved in Java.

---

## 📂 Problems Covered

- ✅ Count of Numbers
- ✅ Sum of Rows
- ✅ Diagonal Sum
- ✅ Sorted Matrix Search
- ✅ Transpose Matrix

**Total Problems Solved:** 5

---

# 📖 Table of Contents

- What is a 2D Array?
- Why Learn 2D Arrays?
- Important Terminology
- Matrix Cheat Sheet
- Pattern Map
- Solved Problems
- Common Mistakes
- Interview Revision Sheet
- Key Takeaways

---

# 🎯 What is a 2D Array?

A **2D Array (Matrix)** stores data in the form of rows and columns.

Think of it as a table or spreadsheet.

### Visual Representation

```text
        Column
          ↓

      0   1   2

0   | 1 | 2 | 3 |
1   | 4 | 5 | 6 |
2   | 7 | 8 | 9 |

↑
Row
```

Accessing:

```java
matrix[1][2]
```

Output:

```text
6
```

---

# 🚀 Why Learn 2D Arrays?

2D Arrays are widely used in:

| Domain                 | Usage               |
|------------------------|---------------------|
| 🎮 Game Development    | Maps & Boards       |
| 🖼️ Image Processing   | Pixels              |
| 🤖 Machine Learning    | Data Representation |
| 📊 Data Analysis       | Tables              |
| 🌐 Graph Problems      | Grid Traversal      |
| 🧮 Dynamic Programming | State Storage       |

---

# 🧠 Important Terminology

## Row

Horizontal arrangement.

```text
1 2 3
```

---

## Column

Vertical arrangement.

```text
1
4
7
```

---

## Cell

Individual position inside the matrix.

```java
matrix[row][column]
```

Example:

```java
matrix[1][2]
```

Value = 6

---

# ⚡ Matrix Cheat Sheet

| Operation          | Formula            |
|--------------------|--------------------|
| Number of Rows     | `matrix.length`    |
| Number of Columns  | `matrix[0].length` |
| Total Elements     | `rows × columns`   |
| Main Diagonal      | `i == j`           |
| Secondary Diagonal | `i + j == n - 1`   |

---

# 🗺️ Pattern Map

Understanding patterns is more important than memorizing code.

```text
2D ARRAYS
│
├── Complete Traversal
│   └── Count of Numbers
│
├── Row Traversal
│   └── Sum of Rows
│
├── Diagonal Traversal
│   └── Diagonal Sum
│
├── Staircase Search
│   └── Sorted Matrix Search
│
└── Coordinate Transformation
    └── Transpose Matrix
```

---

# 📚 Solved Problems

---

# 1️⃣ Count of Numbers

## Problem

Count how many times a target number appears inside a matrix.

### Example

```text
4 7 8
8 8 7
```

Target:

```text
8
```

Output:

```text
3
```

---

## 🧠 Intuition

Imagine checking every seat in a classroom looking for a specific student.

You cannot skip any seat.

Similarly, every element must be checked.

---

## 💡 Logic

```java
for(each row){
        for(
each column){

        if(matrix[i][j]==target){
count++;
        }

        }
        }
```

---

## 🔍 Pattern Used

✅ Complete Matrix Traversal

---

## ⏱ Complexity

| Metric           | Value             |
|------------------|-------------------|
| Time Complexity  | O(rows × columns) |
| Space Complexity | O(1)              |

---

# 2️⃣ Sum of Rows

## Problem

Find the sum of all elements of a particular row.

### Example

```text
1 4 9
11 4 3
2 2 3
```

Second Row:

```text
11 + 4 + 3 = 18
```

Output:

```text
18
```

---

## 🧠 Intuition

Fix one row and move horizontally through its columns.

```text
11 → 4 → 3
```

---

## 💡 Logic

```java
for(int j = 0;
j<matrix[0].length;j++){
sum +=matrix[row][j];
        }
```

---

## 🔍 Pattern Used

✅ Row Traversal

---

## ⏱ Complexity

| Metric           | Value      |
|------------------|------------|
| Time Complexity  | O(columns) |
| Space Complexity | O(1)       |

---

# 3️⃣ Diagonal Sum

## Problem

Find the sum of both diagonals of a square matrix.

### Example

```text
1 2 3
4 5 6
7 8 9
```

Primary Diagonal:

```text
1 + 5 + 9
```

Secondary Diagonal:

```text
3 + 5 + 7
```

Total:

```text
25
```

---

## 🎯 Key Observations

### Main Diagonal

```java
i ==j
```

```text
1
  5
    9
```

---

### Secondary Diagonal

```java
i +j ==n -1
```

```text
    3
  5
7
```

---

## ⚡ Most Important Trick

```java
if(i !=n -i -1)
```

Why?

Because the center element belongs to both diagonals.

Without this condition:

```text
5 gets counted twice
```

---

## 💡 Optimized Logic

```java
for(int i = 0;
i<n;i++){

sum +=matrix[i][i];

        if(i !=n-i-1){
sum +=matrix[i][n-i-1];
        }

        }
```

---

## 🔍 Pattern Used

✅ Diagonal Traversal

---

## ⏱ Complexity

| Metric           | Value |
|------------------|-------|
| Time Complexity  | O(n)  |
| Space Complexity | O(1)  |

---

# 4️⃣ Sorted Matrix Search

## Problem

Search an element in a matrix where rows and columns are sorted.

### Example

```text
10 20 30 40
15 25 35 45
27 29 37 48
32 33 39 50
```

Target:

```text
33
```

---

## 🧠 Golden Observation

Start from the:

```text
Top Right Corner
```

```text
10 20 30 [40]
15 25 35 45
27 29 37 48
32 33 39 50
```

Why?

```text
← Smaller Values
↓ Larger Values
```

This gives us two useful choices.

---

## 🚶 Staircase Search

```text
40
←

30
↓

35
←

25
↓

29
↓

33 ✅
```

---

## 💡 Logic

If target is smaller:

```java
j--;
```

Move left.

If target is larger:

```java
i++;
```

Move down.

---

## 🔍 Pattern Used

✅ Staircase Search

---

## ⏱ Complexity

| Method           | Complexity        |
|------------------|-------------------|
| Linear Search    | O(n²)             |
| Staircase Search | O(rows + columns) |

---

# 5️⃣ Transpose Matrix

## Problem

Convert rows into columns.

### Example

Original Matrix:

```text
1 2 3
4 5 6
```

Transpose:

```text
1 4
2 5
3 6
```

---

## 🧠 Core Idea

```text
(i, j)

becomes

(j, i)
```

---

## 🔄 Visual Transformation

```text
Original

1 2 3
4 5 6

      ↓

Transpose

1 4
2 5
3 6
```

---

## 💡 Logic

```java
for(int i = 0;
i<rows;i++){
        for(
int j = 0;
j<cols;j++){

transpose[j][i]=matrix[i][j];

        }
        }
```

---

## 🔍 Pattern Used

✅ Coordinate Transformation

---

## ⏱ Complexity

| Metric           | Value             |
|------------------|-------------------|
| Time Complexity  | O(rows × columns) |
| Space Complexity | O(rows × columns) |

---

# 🚨 Common Mistakes

### ❌ Mistake 1

Using:

```java
matrix.length
```

for columns.

### ✅ Correct

```java
matrix[0].length
```

---

### ❌ Mistake 2

Double-counting the center element in Diagonal Sum.

---

### ❌ Mistake 3

Using Linear Search in a Sorted Matrix.

Use Staircase Search.

---

### ❌ Mistake 4

Mixing row and column indices.

Remember:

```java
matrix[row][column]
```

---

# 🎤 Interview Revision Sheet

| If Interviewer Says... | Think...           |
|------------------------|--------------------|
| Traverse Matrix        | Nested Loops       |
| Count Occurrences      | Complete Traversal |
| Sum of Row             | Row Traversal      |
| Diagonal Problem       | `i == j`           |
| Secondary Diagonal     | `i + j == n - 1`   |
| Sorted Matrix Search   | Staircase Search   |
| Transpose Matrix       | `(i,j) → (j,i)`    |

---

# 🏆 Key Takeaways

Matrices are not about memorizing nested loops.

They are about recognizing patterns.

```text
Matrix Traversal
        ↓
Row Traversal
        ↓
Column Traversal
        ↓
Diagonal Traversal
        ↓
Staircase Search
        ↓
Coordinate Transformation
```

Master these patterns and most beginner-to-intermediate matrix problems become significantly easier.

---

## 🎯 Learning Outcome

After completing this section, you should be able to:

- ✅ Traverse a matrix efficiently
- ✅ Work with rows and columns
- ✅ Solve diagonal-based problems
- ✅ Apply Staircase Search
- ✅ Understand matrix transformations
- ✅ Recognize common matrix patterns in interviews