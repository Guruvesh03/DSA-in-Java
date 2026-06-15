# 🧠 Bit Manipulation in Java

> A structured interview-focused Bit Manipulation handbook containing core concepts, important tricks, intuition, dry
> runs, pattern recognition, and optimized solutions for revision and placements.

---

# 📚 Table of Contents

1. Introduction
2. Why Bit Manipulation Matters
3. Binary Fundamentals
4. Bitwise Operators Cheatsheet
5. Important Bit Tricks
6. Core Problems & Solutions
7. XOR Mastery
8. Pattern Recognition Guide
9. Common Mistakes
10. Complexity Cheatsheet
11. Real World Applications
12. Rapid Revision Section

---

# 🚀 Introduction

Bit Manipulation is the process of directly operating on the binary representation of numbers using bitwise operators.

Since computers internally store data in binary format, bit manipulation allows extremely fast and optimized
computations.

It is widely used in:

* Competitive Programming
* Technical Interviews
* Cryptography
* Compression Algorithms
* Operating Systems
* Networking
* Game Engines
* Embedded Systems

---

# ⚡ Why Bit Manipulation Matters

## Advantages

* Faster than many arithmetic operations
* Reduces time complexity in many problems
* Helps optimize memory and computation
* Frequently asked in coding interviews
* Builds strong low-level problem-solving intuition

---

# 🔢 Binary Fundamentals

## Decimal to Binary

| Decimal | Binary |
|---------|--------|
| 1       | 0001   |
| 2       | 0010   |
| 3       | 0011   |
| 4       | 0100   |
| 5       | 0101   |
| 6       | 0110   |
| 7       | 0111   |
| 8       | 1000   |

---

# 📌 Important Terms

## LSB (Least Significant Bit)

The rightmost bit.

Example:

```text
1011
   ↑
  LSB
```

---

## MSB (Most Significant Bit)

The leftmost bit.

Example:

```text
1011
↑
MSB
```

---

# 🧮 Powers of 2 Table

| Power | Value |
|-------|-------|
| 2⁰    | 1     |
| 2¹    | 2     |
| 2²    | 4     |
| 2³    | 8     |
| 2⁴    | 16    |
| 2⁵    | 32    |
| 2⁶    | 64    |
| 2⁷    | 128   |

---

# ⚙️ Bitwise Operators Cheatsheet

| Operator | Name        | Purpose                 |
|----------|-------------|-------------------------|
| `&`      | AND         | Checking bits           |
| `\|`     | OR          | Setting bits            |
| `^`      | XOR         | Toggling / Cancellation |
| `~`      | NOT         | Inverting bits          |
| `<<`     | Left Shift  | Multiply by 2           |
| `>>`     | Right Shift | Divide by 2             |

# 🔍 Understanding Operators

## AND Operator `&`

Returns 1 only when both bits are 1.

```text
1 & 1 = 1
1 & 0 = 0
0 & 1 = 0
0 & 0 = 0
```

### Example

```text
5 = 0101
1 = 0001
------------
    0001
```

Mainly used for:

* checking bits
* odd/even checks
* masking

---

## OR Operator `|`

Returns 1 if any bit is 1.

### Example

```text
5 = 0101
1 = 0001
------------
    0101
```

Mainly used for:

* setting bits

---

## XOR Operator `^`

Returns 1 when bits are different.

```text
1 ^ 1 = 0
1 ^ 0 = 1
0 ^ 1 = 1
0 ^ 0 = 0
```

### Example

```text
5 = 0101
3 = 0011
------------
    0110
```

Mainly used for:

* toggling
* unique element problems
* swapping
* cancellation logic

---

## NOT Operator `~`

Flips all bits.

```text
~1010 = 0101
```

---

## Left Shift `<<`

Shifts bits to the left.

### Formula

```text
x << 1 = x * 2
```

### Example

```text
5 = 0101
5 << 1 = 1010 = 10
```

---

## Right Shift `>>`

Shifts bits to the right.

### Formula

```text
x >> 1 = x / 2
```

### Example

```text
8 = 1000
8 >> 1 = 0100 = 4
```

---

# 🧠 Important Bit Tricks

| Trick              | Purpose             |             |
|--------------------|---------------------|-------------|
| `n & 1`            | Odd / Even          |             |
| `1 << i`           | Create mask         |             |
| `n                 | mask`               | Set ith bit |
| `n & ~mask`        | Clear ith bit       |             |
| `n ^ mask`         | Toggle ith bit      |             |
| `n & (n - 1)`      | Remove last set bit |             |
| `n & (n - 1) == 0` | Power of 2          |             |

---

# 🧩 Core Problems & Solutions

---

# 1️⃣ Check Odd or Even

## 📌 Problem

Determine whether a number is odd or even.

---

## 💡 Intuition

The last bit determines parity.

* Odd numbers end with `1`
* Even numbers end with `0`

---

## ⚡ Trick Used

```java
(n &1)
```

---

## 🧠 Logic

AND with 1 isolates the last bit.

---

## 🪄 Binary Dry Run

```text
7 = 111
1 = 001
-----------
    001
```

Result = 1 → Odd

---

## ⏱ Complexity

* Time: O(1)
* Space: O(1)

---

# 2️⃣ Get ith Bit

## 📌 Problem

Find whether the ith bit is set or not.

---

## ⚡ Trick Used

```java
(n &(1<<i))
```

---

## 💡 Intuition

Create a mask with only the ith bit set.

---

## 🧠 Logic

If AND result is non-zero, ith bit is set.

---

## 🪄 Example

```text
n = 10 = 1010
i = 1

Mask = 0010

1010
0010
------
0010
```

Bit is set.

---

# 3️⃣ Set ith Bit

## 📌 Problem

Set the ith bit to 1.

---

## ⚡ Trick Used

```java
n |(1<<i)
```

---

## 💡 Intuition

OR with 1 always sets the bit.

---

## 🧠 Logic

The mask contains 1 only at the required position.

---

# 4️⃣ Clear ith Bit

## 📌 Problem

Clear the ith bit.

---

## ⚡ Trick Used

```java
n &~(1<<i)
```

---

## 💡 Intuition

Create a mask having 0 only at the ith position.

---

## 🧠 Logic

AND with 0 clears the bit.

---

# 5️⃣ Update ith Bit

## 📌 Problem

Update ith bit according to given value.

---

## 💡 Intuition

First clear the bit, then set according to requirement.

---

## ⚡ Logic

### Step 1: Clear Bit

```java
n &~(1<<i)
```

### Step 2: Set Bit

```java
n |(newBit <<i)
```

---

# 6️⃣ Toggle ith Bit

## 📌 Problem

Toggle the ith bit.

---

## ⚡ Trick Used

```java
n ^(1<<i)
```

---

## 💡 Intuition

XOR with 1 flips the bit.

---

# 7️⃣ Clear Last i Bits

## 📌 Problem

Clear last i bits.

---

## ⚡ Trick Used

```java
n &(~0<<i)
```

---

## 💡 Intuition

Shift creates trailing zeroes.

---

# 8️⃣ Clear Range of Bits

## 📌 Problem

Clear bits in a given range.

---

## 💡 Intuition

Combine left and right masks.

---

## ⚡ Logic

```java
int a = (~0) << (j + 1);
int b = (1 << i) - 1;
int mask = a | b;
```

---

# 9️⃣ Check if Number is Power of 2

## 📌 Problem

Determine whether a number is power of 2.

---

## ⚡ Golden Trick

```java
n &(n -1)
```

---

## 💡 Intuition

Power of 2 has only one set bit.

---

## 🧠 Logic

Subtracting 1 removes the only set bit.

---

## 🪄 Example

```text
8  = 1000
7  = 0111
-------------
     0000
```

---

# 🔟 Count Set Bits

## 📌 Problem

Count number of set bits.

---

## Method 1: Basic Shifting

### Logic

Check last bit repeatedly.

---

## Method 2: Brian Kernighan Algorithm

### ⚡ Trick

```java
n =n &(n -1)
```

---

## 💡 Intuition

Each operation removes one set bit.

---

## 🧠 Advantage

Runs only for number of set bits.

---

# 1️⃣1️⃣ XOR Properties

## Important Rules

```text
a ^ a = 0

a ^ 0 = a

0 ^ a = a

XOR is commutative
```

---

# 1️⃣2️⃣ Swap Two Numbers Using XOR

## ⚡ Logic

```java
a =a ^b;
b =a ^b;
a =a ^b;
```

---

## 💡 Intuition

XOR has a magical cancelation property:

```java
x ^x =0
x ^0=x
```

Using this, we temporarily hide both values inside XOR operations and then recover them in reverse order without using
any extra variable.

Think of XOR like a reversible binary locker 🔐

---

## 🧠 How It Works

### Initial Values

```text
a = 5
b = 3
```

---

### Step 1️⃣

```java
a =a ^b;
```

Now:

```text
a = 6
b = 3
```

`a` stores the XOR combination of both numbers.

---

### Step 2️⃣

```java
b =a ^b;
```

Now:

```text
a = 6
b = 5
```

Original value of `a` is restored into `b`.

---

### Step 3️⃣

```java
a =a ^b;
```

Now:

```text
a = 3
b = 5
```

Original value of `b` is restored into `a`.

✅ Numbers swapped successfully.

---

## ❌ Mistake I Made Initially

### Wrong Logic

```java
a =a ^a ^b;
b =b ^b ^a;
```

---

## 🚫 Why It Failed

Since:

```java
x ^x =0
```

The first statement becomes:

```java
a =0^b;
a =b;
```

The original value of `a` gets destroyed immediately.

Then the second statement also fails because both variables start becoming the same value.

### Example

```text
Initial:
a = 5
b = 3
```

After wrong logic:

```text
a = 3
b = 3
```

❌ Swapping does not happen.

---

## ⏱️ Complexity

| Complexity       | Value  |
|------------------|--------|
| Time Complexity  | `O(1)` |
| Space Complexity | `O(1)` |

---

## 📌 Important Note

Although XOR swap is a famous bit manipulation trick, real-world code usually prefers using a temporary variable because
it is easier to read and debug.

```java
int temp = a;
a =b;
b =temp;
```

---

# 1️⃣3️⃣ Find Unique Element Using XOR

## 📌 Problem

Every element appears twice except one.

---

## ⚡ Trick

Use XOR on all elements.

---

## 💡 Intuition

Duplicate elements cancel each other.

---

## 🧠 Logic

```text
x ^ x = 0
```

Only unique element remains.

---

# 1️⃣4️⃣ Remove Last Set Bit

## ⚡ Trick

```java
n &(n -1)
```

---

## 💡 Intuition

Subtracting 1 flips bits after the last set bit.

---

# 1️⃣5️⃣ Check kth Bit Set or Not

## ⚡ Logic

```java
(n &(1<<k))!=0
```

---

# 1️⃣6️⃣ Fast Exponentiation

## 📌 Problem

Calculate aⁿ efficiently.

---

## 💡 Intuition

Use binary representation of exponent.

---

## ⚡ Optimized Logic

```java
while(n >0){
        if((n &1)!=0){
ans *=a;
    }

a *=a;
n =n >>1;
        }
```

---

## 🧠 Why It Works

Each bit contributes power of 2.

---

## ⏱ Complexity

* Time: O(log n)
* Space: O(1)

---

# 🧨 XOR Mastery

XOR is one of the most important tools in Bit Manipulation.

## Why XOR is Powerful

* Cancels duplicates
* Helps in toggling
* Enables optimized solutions
* Useful in encryption
* Excellent for state manipulation

---

# 🎯 Pattern Recognition Guide

| Observation          | Think About         |
|----------------------|---------------------|
| unique element       | XOR                 |
| powers of 2          | `n & (n-1)`         |
| subsets              | bitmasking          |
| state toggling       | XOR                 |
| fast multiply/divide | shifts              |
| counting bits        | Kernighan Algorithm |
| masking required     | AND / OR            |

---

# ❌ Common Mistakes

## 1. Forgetting Parentheses

Wrong:

```java
n &1<<i
```

Correct:

```java
n &(1<<i)
```

---

## 2. Confusing 0-Based Indexing

Bits are usually counted from right to left starting from 0.

---

## 3. Signed Right Shift Confusion

Negative numbers behave differently.

---

## 4. Overflow During Left Shift

Large shifts may overflow integer range.

---

## 5. Using XOR Without Understanding Cancellation

Always verify XOR behavior carefully.

---

# 📊 Complexity Cheatsheet

| Operation           | Time Complexity |
|---------------------|-----------------|
| Get Bit             | O(1)            |
| Set Bit             | O(1)            |
| Clear Bit           | O(1)            |
| Toggle Bit          | O(1)            |
| Power of 2 Check    | O(1)            |
| Count Set Bits      | O(log n)        |
| Fast Exponentiation | O(log n)        |

---

# 🌍 Real World Applications

## Bit Manipulation is used in:

* Cryptography
* Networking
* Image Processing
* Compression Algorithms
* Operating Systems
* Databases
* Embedded Systems
* Competitive Programming
* Game Engines
* Permission Systems

---

# 🚀 Rapid Revision Section

```text
n & 1                -> Odd / Even
1 << i               -> Create mask
n | (1 << i)         -> Set ith bit
n & ~(1 << i)        -> Clear ith bit
n ^ (1 << i)         -> Toggle ith bit
n & (n - 1)          -> Remove last set bit
n & (n - 1) == 0     -> Power of 2
x << 1               -> Multiply by 2
x >> 1               -> Divide by 2
```

---

# 🏁 Final Notes

Bit Manipulation is less about memorizing tricks and more about understanding how binary behaves.

Once the intuition becomes clear:

* many problems become shorter,
* optimized solutions become natural,
* and interview pattern recognition improves significantly.

Mastering Bit Manipulation builds strong low-level problem-solving intuition and improves coding efficiency across
multiple domains.

---

# ⭐ Recommended Practice Order

1. Odd / Even
2. Get ith Bit
3. Set ith Bit
4. Clear ith Bit
5. Toggle ith Bit
6. Update ith Bit
7. Clear Last i Bits
8. Clear Range of Bits
9. Power of 2
10. Count Set Bits
11. XOR Problems
12. Unique Element
13. Fast Exponentiation

---

# 💻 Language Used

* Java

---

# 📌 Author

DSA practice repository focused on:

* Interview Preparation
* Placement Readiness
* Problem Solving
* Pattern Recognition
* Clean Documentation
