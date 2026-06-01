# 🧩 2D Arrays (Matrices) in Java

> A complete collection of fundamental 2D Array concepts, tricks, patterns, and interview-oriented problems solved in
> Java.

---

# 📖 What is a 2D Array?

A **2D Array** is an array of arrays.

Instead of storing elements in a single line, data is stored in the form of **rows and columns**, similar to a table or
spreadsheet.

Example:

```

1 2 3
4 5 6
7 8 9

```

Visual Representation:

```

matrix\[3]\[3]

| 1 | 2 | 3 |
|---|---|---|
| 4 | 5 | 6 |
| 7 | 8 | 9 |

```

Rows = 3

Columns = 3

Total Elements = Rows × Columns

---

# 🎯 Why Learn 2D Arrays?

2D Arrays are widely used in:

- Image Processing
- Computer Graphics
- Game Development
- Dynamic Programming
- Machine Learning
- Graph Algorithms
- Database Tables
- Sudoku Solvers

They form the foundation for advanced topics like:

- Matrix Exponentiation
- Dynamic Programming Grids
- Graph Representations
- BFS & DFS on Grids

---

# 🧠 Important Terminology

## Row

Horizontal arrangement.

```

1 2 3

```

---

## Column

Vertical arrangement.

```

1
4
7

```

---

## Cell

Individual position.

Example:

```

matrix\[1]\[2]

```

Row = 1

Column = 2

Value = 6

---

# 📦 Declaration & Initialization

```java
int matrix[][] = new int[3][3];
```

Creates:

```

0 0 0
0 0 0
0 0 0

```

---

# 📥 Taking Input

```java
Scanner sc = new Scanner(System.in);

for(
int i = 0;
i<matrix.length;i++){
        for(
int j = 0;
j<matrix[0].length;j++){
matrix[i][j]=sc.

nextInt();
    }
            }
```

---

# 📤 Printing Matrix

```java
for(int i = 0;
i<matrix.length;i++){
        for(
int j = 0;
j<matrix[0].length;j++){
        System.out.

print(matrix[i][j]+" ");
    }
            System.out.

println();
}
```

---

# 🔥 Essential Interview Tricks

## Trick 1: Number of Rows

```java
matrix.length
```

---

## Trick 2: Number of Columns

```java
matrix[0].length
```

---

## Trick 3: Total Elements

```java
matrix.length *matrix[0].length
```

---

## Trick 4: Main Diagonal

Condition:

```java
i ==j
```

Example:

```

1 2 3
4 5 6
7 8 9

```

Main Diagonal:

```

1 5 9

```

---

## Trick 5: Secondary Diagonal

Condition:

```java
i +j ==n -1
```

Example:

```

1 2 3
4 5 6
7 8 9

```

Secondary Diagonal:

```

3 5 7

```

---

# 🎯 Solved Problems

---

# 1️⃣ Count of Numbers

## Problem

Count how many times a target number appears inside the matrix.

Example:

```

4 7 8
8 8 7

```

Target = 8

Output:

```

3

```

---

## Intuition

Visit every element.

Whenever target is found:

```

count++

```

---

## Logic

```java
for(each row){
        for(
each column){

        if(matrix[i][j]==key){
count++;
        }

        }
        }
```

---

## Pattern Used

✅ Complete Matrix Traversal

---

## Time Complexity

```text
O(rows × columns)
```

---

## Space Complexity

```text
O(1)
```

---

# 2️⃣ Sum of Rows

## Problem

Find the sum of all elements of a specific row.

Example:

```

1 4 9
11 4 3
2 2 3

```

Second Row:

```

11 + 4 + 3 = 18

```

---

## Intuition

Fix the row.

Move only through columns.

---

## Logic

```java
for(int j = 0;
j<matrix[0].length;j++){
sum +=matrix[row][j];
        }
```

---

## Pattern Used

✅ Row Traversal

---

## Time Complexity

```text
O(columns)
```

---

## Space Complexity

```text
O(1)
```

---

# 3️⃣ Diagonal Sum

## Problem

Find sum of both diagonals.

Example:

```

1 2 3
4 5 6
7 8 9

```

Primary Diagonal:

```

1 + 5 + 9
```

Secondary Diagonal:

```

3 + 5 + 7
```

Total:

```

25

```

---

## Brute Force Approach

Check every cell.

```java
if(i==j)
```

or

```java
if(i+j==n-1)
```

---

## Optimized Observation

Only diagonal elements are needed.

No need to visit every cell.

---

## Optimized Logic

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

## Why this Condition?

```java
if(i !=n-i-1)
```

Prevents double counting of center element.

Example:

```

1 2 3
4 5 6
7 8 9

```

Center:

```

5

```

Belongs to both diagonals.

Without condition:

```

5 counted twice
```

---

## Pattern Used

✅ Diagonal Traversal

---

## Time Complexity

```text
O(n)
```

---

## Space Complexity

```text
O(1)
```

---

# 4️⃣ Sorted Matrix Search

## Problem

Search an element in a matrix where:

- Rows are sorted
- Columns are sorted

Example:

```

10 20 30 40
15 25 35 45
27 29 37 48
32 33 39 50

```

Search = 33

---

## Most Important Observation

Start from:

```

Top Right Corner
```

Why?

Because:

Left → Smaller

Down → Larger

Both decisions become available.

---

## Search Strategy

### If target < current

Move Left

```java
j--
```

---

### If target > current

Move Down

```java
i++
```

---

### If target == current

Found

---

## Visualization

```

10 20 30 40
15 25 35 45
27 29 37 48
32 33 39 50

```

Search = 33

```

40 → left
30 → down
35 → left
25 → down
29 → down
33 ✓

```

---

## Pattern Used

✅ Staircase Search

---

## Why Better Than Linear Search?

Linear Search:

```text
O(n²)
```

Staircase Search:

```text
O(n+m)
```

---

## Time Complexity

```text
O(rows + columns)
```

---

## Space Complexity

```text
O(1)
```

---

# 5️⃣ Transpose Matrix

## Problem

Convert rows into columns.

Example:

Original:

```

1 2 3
4 5 6

```

Transpose:

```

1 4
2 5
3 6

```

---

## Concept

```

matrix\[i]\[j]

becomes

matrix\[j]\[i]

```

---

## Visual Understanding

Original:

```

1 2 3
4 5 6

```

Transpose:

```

1 4
2 5
3 6

```

---

## Logic

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

## Pattern Used

✅ Coordinate Swapping

---

## Time Complexity

```text
O(rows × columns)
```

---

## Space Complexity

```text
O(rows × columns)
```

---

# 🚨 Common Mistakes

### Mistake 1

Using

```java
matrix.length
```

for columns.

Correct:

```java
matrix[0].length
```

---

### Mistake 2

Double-counting center element in diagonal sum.

---

### Mistake 3

Using linear search in a sorted matrix.

Use Staircase Search instead.

---

### Mistake 4

Confusing row and column indices.

Remember:

```java
matrix[row][column]
```

---

# 🏆 Interview Takeaways

If interviewer says:

### Matrix Traversal

Think:

```text
Nested Loops
```

---

### Diagonal Problem

Think:

```text
i == j
i + j == n - 1
```

---

### Sorted Matrix Search

Think:

```text
Top Right Corner
Staircase Search
```

---

### Transpose Matrix

Think:

```text
(i,j) → (j,i)
```

---

# 📚 Problems Covered

✅ Count of Numbers

✅ Sum of Rows

✅ Diagonal Sum

✅ Sorted Matrix Search

✅ Transpose Matrix

---

# 🚀 Key Learning

2D Arrays are not about memorizing loops.

They are about recognizing patterns:

- Matrix Traversal
- Row Traversal
- Column Traversal
- Diagonal Traversal
- Staircase Search
- Coordinate Transformation

Master these patterns and most beginner-to-intermediate matrix problems become significantly easier.

## 🗺️ Pattern Map

| Problem              | Pattern                   |
|----------------------|---------------------------|
| Count of Numbers     | Complete Traversal        |
| Sum of Rows          | Row Traversal             |
| Diagonal Sum         | Diagonal Traversal        |
| Sorted Matrix Search | Staircase Search          |
| Transpose Matrix     | Coordinate Transformation |