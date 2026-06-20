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

---

# Integer Overflow and Wrap Around using Bits

## 📌 Problem

Why does storing a value outside the range of a data type produce unexpected results?

Example:

```java
byte x = (byte) 129;
System.out.

println(x);
```

Output:

```text
-127
```

Why does `129` become `-127`?

---

## ⚡ Golden Trick

A computer stores numbers using a **fixed number of bits**.

For an 8-bit signed byte:

```text
Range = -128 to 127
```

Only **256 unique bit patterns** are possible:

```text
2^8 = 256
```

When a value exceeds the maximum range, the extra carry bit is discarded and the value **wraps around**.

Think of it like a clock:

```text
11 + 1 = 12
12 + 1 = 1
```

Similarly:

```text
127 + 1 = -128
```

---

## 💻 Code

```java
public class Main {
    public static void main(String[] args) {

        byte a = 127;
        a++;

        System.out.println(a);

        byte b = (byte) 129;
        System.out.println(b);
    }
}
```

Output:

```text
-128
-127
```

---

## 🧠 Intuition

Computers do not store numbers directly.

They store only **bits**.

For example:

```text
127 = 01111111
```

When we add 1:

```text
01111111
+       1
---------
10000000
```

The result becomes:

```text
10000000
```

In Two's Complement representation:

```text
10000000 = -128
```

Therefore:

```text
127 + 1 = -128
```

The number wraps around because there is no ninth bit available.

---

## 🪄 Dry Run

### Example 1: 127 + 1

Step 1:

```text
127 = 01111111
```

Step 2:

```text
01111111
+00000001
---------
10000000
```

Step 3:

Interpret result as signed byte:

```text
10000000 = -128
```

Final Answer:

```text
127 + 1 = -128
```

---

### Example 2: Storing 129

Binary representation:

```text
129 = 10000001
```

Stored bits:

```text
10000001
```

Since the first bit is 1, it is interpreted as a negative number.

Using Two's Complement:

Invert bits:

```text
01111110
```

Add 1:

```text
01111111
```

Value:

```text
127
```

Therefore:

```text
10000001 = -127
```

Final Answer:

```text
129 becomes -127
```

---

## ❌ Counter Example

### Unsigned Byte

If the byte were unsigned:

```text
10000001
```

would be:

```text
128 + 1 = 129
```

Result:

```text
129
```

No negative value appears.

The same bits can represent different values depending on how they are interpreted.

---

## 🔥 Why It Works

### Fixed Bit Storage

An 8-bit number can store only:

```text
00000000
to
11111111
```

Total combinations:

```text
256
```

The CPU cannot magically create extra bits.

When overflow occurs:

```text
11111111 + 1
```

becomes:

```text
1 00000000
```

The extra carry:

```text
1
```

is discarded.

Only:

```text
00000000
```

remains.

This causes the value to wrap around.

---

### Two's Complement Representation

Signed integers use Two's Complement.

Positive numbers:

```text
00000000 = 0
00000001 = 1
...
01111111 = 127
```

Negative numbers:

```text
11111111 = -1
11111110 = -2
...
10000000 = -128
```

This allows addition and subtraction to work using the same hardware circuitry.

---

## ⚠️ Edge Cases

### Maximum Positive Value

```text
127 + 1 = -128
```

---

### Minimum Negative Value

```text
-128 - 1 = 127
```

Binary:

```text
10000000
-       1
---------
01111111
```

Result:

```text
127
```

---

### Large Positive Numbers

```text
(byte)130 = -126
(byte)131 = -125
(byte)132 = -124
```

---

### Large Negative Numbers

```text
(byte)-129 = 127
(byte)-130 = 126
```

---

## ⏱️ Complexity

Time Complexity:

```text
O(1)
```

Space Complexity:

```text
O(1)
```

Since overflow handling is performed directly by hardware.

---

## 🎓 Interview Takeaway

Interview Question:

> Why does 127 + 1 become -128 in Java byte?

Answer:

```text
A byte uses 8 bits and follows Two's Complement representation.

127 is stored as:

01111111

Adding 1 produces:

10000000

which represents -128.

The overflow occurs because the carry bit is discarded due to the fixed 8-bit storage.
```

---

## 🧩 Memory Trick

Imagine an 8-bit signed integer as a circular wheel:

```text
... -3
... -2
... -1
0
1
2
...
126
127
↓
-128
↓
-127
...
```

After reaching the maximum value:

```text
127
```

the next value becomes:

```text
-128
```

because the bit pattern wraps around.

### One-Line Rule

```text
Integer Overflow = Fixed Number of Bits + Extra Carry Bit Discarded
```

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

## XOR `^`

XOR (Exclusive OR) compares two bits and returns `1` only when the bits are different.

---

## XOR Truth Table

| A | B | A ^ B |
|---|---|-------|
| 0 | 0 | 0     |
| 0 | 1 | 1     |
| 1 | 0 | 1     |
| 1 | 1 | 0     |

### Rule

```text
Same Bits      → 0
Different Bits → 1
```

---

## Example

```text
5 = 0101
3 = 0011

5 ^ 3

0101
0011
----
0110

= 6
```

---

## Why XOR is Special

Unlike AND and OR, XOR has several unique properties that make it extremely useful in DSA, Competitive Programming, and
Bit Manipulation.

---

## Property 1: Same Numbers Cancel Out

```text
a ^ a = 0
```

### Example

```text
5 ^ 5

0101
0101
----
0000

= 0
```

Since every bit is identical, all bits become `0`.

---

## Property 2: XOR with 0 Returns the Same Number

```text
a ^ 0 = a
```

### Example

```text
5 ^ 0

0101
0000
----
0101

= 5
```

Zero does not affect the value.

---

## Property 3: Reversible Operation

```text
(a ^ b) ^ b = a
```

### Example

```text
5 ^ 3 = 6

6 ^ 3 = 5
```

The second XOR cancels the first one.

This property is the foundation of XOR-based swapping and many advanced algorithms.

---

## Property 4: Order Doesn't Matter

```text
a ^ b = b ^ a
```

### Example

```text
5 ^ 3 = 6
3 ^ 5 = 6
```

This property is called **Commutativity**.

---

## Property 5: Grouping Doesn't Matter

```text
(a ^ b) ^ c = a ^ (b ^ c)
```

### Example

```text
(2 ^ 3) ^ 4
=
2 ^ (3 ^ 4)
```

This property is called **Associativity**.

---

## XOR for Toggling Bits

XOR can flip a bit.

### Example

```text
Bit = 1

1 ^ 1 = 0
```

```text
Bit = 0

0 ^ 1 = 1
```

A bit XORed with `1` always changes its state.

---

## Toggle ith Bit

### Formula

```java
n ^(1<<i)
```

### Example

```text
n = 10

1010

Toggle bit at index 1

Mask = 0010

1010
0010
----
1000

= 8
```

---

## Finding a Unique Element

When every element appears twice except one:

```text
2 3 4 3 2
```

Using XOR:

```text
2 ^ 3 ^ 4 ^ 3 ^ 2

= (2 ^ 2) ^ (3 ^ 3) ^ 4

= 0 ^ 0 ^ 4

= 4
```

### Result

```text
Unique Element = 4
```

This is one of the most common interview questions.

---

## Swapping Two Numbers Using XOR

### Logic

```java
a =a ^b;
b =a ^b;
a =a ^b;
```

### Example

```text
a = 5
b = 3

After swapping:

a = 3
b = 5
```

---

## Quick Comparison

| Expression     | Result                     |
|----------------|----------------------------|
| `a ^ a`        | `0`                        |
| `a ^ 0`        | `a`                        |
| `(a ^ b) ^ b`  | `a`                        |
| `a ^ b`        | Set bits where bits differ |
| `n ^ (1 << i)` | Toggle ith bit             |

---

## 🧠 Memory Trick

```text
XOR = Difference Detector

Same Bits      → 0
Different Bits → 1

a ^ a = 0
a ^ 0 = a

XOR Cancels Duplicates
```

### One-Line Summary

```text
XOR returns 1 for different bits and 0 for same bits, making it perfect for toggling bits, finding unique elements, and cancelling duplicate values.
```

## NOT Operator `~`

Flips all bits.

```text
~1010 = 0101
```

---

## 🔄 Shift Operators

Shift operators move the bits of a number left or right. Since binary positions represent powers of 2, shifting bits can
efficiently perform multiplication and division.

---

## Left Shift `<<`

Moves all bits to the left by a specified number of positions.

### Formula

```text
x << n = x × 2ⁿ
```

### Example

```text
5 = 00000101

5 << 1

00000101
↓
00001010

= 10
```

### More Examples

```text
7 << 1 = 14
7 << 2 = 28
7 << 3 = 56
```

### Key Points

- Bits move towards the left.
- Empty positions on the right are filled with `0`.
- Leftmost bits that go beyond the available space are discarded.
- Each left shift doubles the value.

```text
x << 1 = x × 2
x << 2 = x × 4
x << 3 = x × 8
```

---

## Right Shift `>>`

Moves all bits to the right by a specified number of positions.

### Formula

```text
x >> n = x ÷ 2ⁿ
```

### Example

```text
8 = 00001000

8 >> 1

00001000
↓
00000100

= 4
```

### More Examples

```text
20 >> 1 = 10
20 >> 2 = 5
```

### Key Points

- Bits move towards the right.
- Rightmost bits are discarded.
- Each right shift halves the value.
- Performs integer division, so decimal values are lost.

```text
13 >> 1 = 6

13 / 2 = 6.5
```

The `.5` is discarded because bits cannot store fractional parts in integer representation.

---

## Creating Bit Masks

A very common use of left shift is creating masks.

### Formula

```java
1<<i
```

### Examples

```text
1 << 0 = 0001
1 << 1 = 0010
1 << 2 = 0100
1 << 3 = 1000
```

Only the `iᵗʰ` bit is set to `1`.

---

## Quick Comparison

| Operator | Meaning         | Formula          |
|----------|-----------------|------------------|
| `x << n` | Move bits left  | `x × 2ⁿ`         |
| `x >> n` | Move bits right | `x ÷ 2ⁿ`         |
| `1 << i` | Create mask     | Set only ith bit |

---

## 🧠 Memory Trick

```text
Left Shift  (<<)
⬅ Move Left
⬆ Value Increases
× 2ⁿ

Right Shift (>>)
➡ Move Right
⬇ Value Decreases
÷ 2ⁿ
```

# 🧠 Important Bit Tricks

| Trick                | Purpose             |
|----------------------|---------------------|
| `n & 1`              | Check Odd / Even    |
| `1 << i`             | Create bit mask     |
| `n \| mask`          | Set ith bit         |
| `n & ~mask`          | Clear ith bit       |
| `n ^ mask`           | Toggle ith bit      |
| `n & (n - 1)`        | Remove last set bit |
| `(n & (n - 1)) == 0` | Check Power of 2    |

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

# 3️⃣ Set Kth Bit

# 📌 Problem: Set the K-th Bit

Given an integer `n` and a bit position `k`, set the K-th bit of the number and return the resulting value.

---

# ⚡ Golden Trick

Use the bitwise OR operator with a mask containing only the K-th bit set.

```java
n |(1<<k)
```

The OR operation guarantees that the K-th bit becomes `1`, regardless of its previous value.

---

# 🧠 Intuition

To set a specific bit, we first create a mask:

```java
1<<k
```

This shifts `1` to the K-th position.

For example:

```text
k = 3

0001 << 3 = 1000
```

Now perform OR:

```text
n | mask
```

Since:

```text
0 | 1 = 1
1 | 1 = 1
```

the K-th bit is guaranteed to become `1`.

---

# 🪄 Dry Run

### Input

```text
n = 10
k = 0
```

Binary representation:

```text
10 = 1010
```

### Step 1: Create Mask

```text
1 << 0 = 0001
```

### Step 2: Apply OR

```text
1010
0001
----
1011
```

### Result

```text
11
```

---

# ❌ Counter Example

Suppose the bit is already set.

### Input

```text
n = 13
k = 2
```

Binary:

```text
13 = 1101
```

Mask:

```text
0100
```

Apply OR:

```text
1101
0100
----
1101
```

Result:

```text
13
```

The number remains unchanged because the bit was already set.

---

# 🔥 Why It Works

The mask contains exactly one bit set:

```text
0001 << k
```

When OR is applied:

```text
n | mask
```

only the K-th position is affected.

For the target bit:

```text
0 | 1 = 1
1 | 1 = 1
```

Therefore, the K-th bit always becomes `1`.

All other bits remain unchanged.

---

# ⚠️ Edge Cases

### 1. Bit Already Set

```text
n = 13
k = 2
```

Result remains:

```text
13
```

---

### 2. Number is Zero

```text
n = 0
k = 3
```

```text
0000 | 1000 = 1000
```

Result:

```text
8
```

---

### 3. Setting the 0th Bit

```text
n = 10
k = 0
```

```text
1010 | 0001 = 1011
```

Result:

```text
11
```

---

# ⏱️ Complexity

| Operation | Complexity |
|-----------|------------|
| Time      | O(1)       |
| Space     | O(1)       |

---

# 🎓 Interview Takeaway

Whenever you need to force a bit to become `1`, use:

```java
n |(1<<k)
```

This is the standard and most efficient approach used in bit manipulation problems.

---

# 🧩 Memory Trick

Think of OR as a permanent marker 🖊️.

If you draw a `1` over a bit:

```text
0 → 1
1 → 1
```

it always stays `1`.

So remember:

```text
Set Bit
=
OR with Shifted 1
```

```java
n |(1<<k)
```

Whenever you hear **"set the K-th bit"**, your brain should immediately think:

👉 **OR + Shifted 1**
---

# 4️⃣ Clear kth Bit

# 📌 Problem: Clear the K-th Bit

Given an integer `n` and a bit position `k`, clear the K-th bit of the number and return the resulting value.

Clearing a bit means forcing it to become `0` regardless of its current value.

---

# ⚡ Golden Trick

Create a mask with only the K-th bit set:

```java
1<<k
```

Invert the mask:

```java
~(1<<k)
```

Then perform AND with the original number:

```java
n &~(1<<k)
```

This clears the K-th bit while leaving all other bits unchanged.

---

# 🧠 Intuition

To clear a bit, we need a mask that contains:

```text
1 everywhere
0 at the K-th position
```

Example:

```text
k = 2

1 << 2 = 0100
```

Invert it:

```text
1011
```

Now perform AND:

```text
1101
1011
----
1001
```

The K-th bit becomes `0`.

---

# 🪄 Dry Run

### Input

```text
n = 13
k = 2
```

Binary representation:

```text
13 = 1101
```

### Step 1: Create Mask

```text
1 << 2 = 0100
```

### Step 2: Invert Mask

```text
~0100 = 1011
```

### Step 3: Apply AND

```text
1101
1011
----
1001
```

### Result

```text
9
```

---

# ❌ Common Mistake I Made

Initially, I used:

```java
n |~(1<<k)
```

instead of:

```java
n &~(1<<k)
```

### Why This Is Wrong

The inverted mask contains many leading `1`s because Java stores integers using **32-bit Two's Complement representation
**.

Example:

```text
1 << 2 = 00000000 00000000 00000000 00000100
```

After inversion:

```text
~(1 << 2)

11111111 11111111 11111111 11111011
```

Notice that almost every bit becomes `1`.

Now if we use OR:

```text
n | ~(1 << k)
```

Example:

```text
1101
11111111111111111111111111111011
--------------------------------
11111111111111111111111111111111
```

Result:

```text
-1
```

or another negative number depending on the input.

---

# 🤯 Why Was I Getting Negative Numbers?

Java stores integers using **Two's Complement**.

In a 32-bit integer:

```text
Most Significant Bit (MSB)
```

acts as the **sign bit**.

```text
0 → Positive
1 → Negative
```

When we applied:

```java
n |~(1<<k)
```

the inverted mask already had:

```text
11111111 11111111 11111111 xxxxxxxx
```

The sign bit became:

```text
1
```

which tells Java:

```text
"This number is negative."
```

Therefore the result often became:

```text
-1
-5
-9
...
```

instead of the expected positive value.

---

# 🔥 Why AND Works

The inverted mask contains:

```text
1 everywhere
0 at the K-th bit
```

AND has the property:

```text
1 & x = x
0 & x = 0
```

Therefore:

- The K-th bit becomes `0`
- All other bits remain unchanged

Exactly what we want.

---

# ⚠️ Edge Cases

### 1. Bit Already Clear

```text
n = 9
1001
```

Clear bit 2:

```text
1001
1011
----
1001
```

Result remains:

```text
9
```

---

### 2. Clearing the 0th Bit

```text
n = 5
```

```text
0101
1110
----
0100
```

Result:

```text
4
```

---

### 3. Number is Zero

```text
n = 0
```

Any bit cleared:

```text
0
```

Result remains:

```text
0
```

---

# ⏱️ Complexity

| Operation | Complexity |
|-----------|------------|
| Time      | O(1)       |
| Space     | O(1)       |

---

# 🎓 Interview Takeaway

Remember the four most important bit manipulation formulas:

| Operation  | Formula         |
|------------|-----------------|
| Check Bit  | `n & (1 << k)`  |
| Set Bit    | `n \| (1 << k)` |
| Clear Bit  | `n & ~(1 << k)` |
| Toggle Bit | `n ^ (1 << k)`  |

A very common beginner mistake is:

```java
n |~(1<<k)
```

because OR does **not clear** bits.

To clear a bit, always think:

```text
Clear
=
AND
+
NOT Mask
```

---

# 🧩 Memory Trick

Imagine the mask as a stencil 🎭.

```text
1 → Keep the bit
0 → Erase the bit
```

After inversion:

```text
11101111
```

the target bit position contains a hole (`0`).

When AND is applied:

```java
n &~(1<<k)
```

that bit gets erased while everything else survives.

Remember:

```text
Clear Bit
=
AND with Inverted Mask
```

```java
n &~(1<<k)
```

🚀 **Golden Memory Rule**

```text
Check  → AND
Set    → OR
Clear  → AND + NOT
Toggle → XOR
```

Master these four formulas, and nearly every beginner bit manipulation problem becomes straightforward.

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

# 📌 Problem: Toggle the K-th Bit

Given an integer `n` and a bit position `k`, toggle the K-th bit of the number and return the resulting value.

Toggling means:

```text
0 → 1
1 → 0
```

---

# ⚡ Golden Trick

Use the XOR operator with a mask containing only the K-th bit set.

```java
n ^(1<<k)
```

XOR automatically flips the target bit while leaving all other bits unchanged.

---

# 🧠 Intuition

To toggle a bit, we need something that can:

```text
Turn 0 into 1
Turn 1 into 0
```

The XOR operator has exactly this property:

```text
0 ^ 1 = 1
1 ^ 1 = 0
```

So we create a mask having only the K-th bit set:

```java
1<<k
```

and XOR it with the number.

---

# 🪄 Dry Run

### Input

```text
n = 13
k = 2
```

Binary representation:

```text
13 = 1101
```

### Step 1: Create Mask

```text
1 << 2 = 0100
```

### Step 2: Apply XOR

```text
1101
0100
----
1001
```

### Result

```text
9
```

The 2nd bit changed from:

```text
1 → 0
```

---

# ❌ Counter Example

Toggle the same bit twice.

### First Toggle

```text
13 = 1101
```

```text
1101
0100
----
1001
```

Result:

```text
9
```

### Second Toggle

```text
1001
0100
----
1101
```

Result:

```text
13
```

Notice that toggling the same bit twice restores the original number.

---

# 🔥 Why It Works

XOR has a special property:

```text
0 ^ 1 = 1
1 ^ 1 = 0
```

and

```text
0 ^ 0 = 0
1 ^ 0 = 1
```

The mask contains:

```text
0 everywhere
1 only at the K-th bit
```

Therefore:

- The K-th bit gets flipped.
- All other bits remain unchanged.

---

# ⚠️ Common Mistake

Many beginners confuse XOR with OR.

### Wrong

```java
n |(1<<k)
```

This only sets the bit.

```text
0 → 1
1 → 1
```

The bit never changes from `1` back to `0`.

---

### Correct

```java
n ^(1<<k)
```

This truly toggles the bit.

```text
0 → 1
1 → 0
```

---

# ⚠️ Edge Cases

### 1. Toggle a Set Bit

```text
n = 13
1101
```

Toggle bit 2:

```text
1101
0100
----
1001
```

Result:

```text
9
```

---

### 2. Toggle an Unset Bit

```text
n = 9
1001
```

Toggle bit 2:

```text
1001
0100
----
1101
```

Result:

```text
13
```

---

### 3. Toggle the 0th Bit

```text
n = 10
1010
```

Toggle bit 0:

```text
1010
0001
----
1011
```

Result:

```text
11
```

---

### 4. Number is Zero

```text
n = 0
k = 3
```

```text
0000
1000
----
1000
```

Result:

```text
8
```

---

# ⏱️ Complexity

| Operation | Complexity |
|-----------|------------|
| Time      | O(1)       |
| Space     | O(1)       |

---

# 🎓 Interview Takeaway

The four most important bit manipulation formulas are:

| Operation  | Formula         |
|------------|-----------------|
| Check Bit  | `n & (1 << k)`  |
| Set Bit    | `n \| (1 << k)` |
| Clear Bit  | `n & ~(1 << k)` |
| Toggle Bit | `n ^ (1 << k)`  |

Among these, XOR is the only operation that flips a bit.

---

# 🧩 Memory Trick

Think of XOR as a switch 🔘.

Every time you press it:

```text
OFF → ON
ON → OFF
```

Press it once:

```text
0 → 1
1 → 0
```

Press it again:

```text
1 → 0
0 → 1
```

That's why:

```text
Toggle Bit
=
XOR with Shifted 1
```

```java
n ^(1<<k)
```

🚀 **Golden Memory Rule**

```text
Check  → AND
Set    → OR
Clear  → AND + NOT
Toggle → XOR
```

If OR is a marker 🖊️ that permanently writes a `1`,
then XOR is a switch 🎛️ that flips the bit every time you touch it.

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

Determine whether a given number is a Power of 2.

---

## ⚡ Golden Trick

```java
(n &(n -1))==0
```

---

## 💻 Java Function

```java
public static boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
}
```

---

## 🧠 Key Observation

A Power of 2 always contains **exactly one Set Bit**.

### Examples

```text
1  = 0001
2  = 0010
4  = 0100
8  = 1000
16 = 10000
32 = 100000
```

Notice that every number has only **one `1`** in its binary representation.

---

## 🔍 What is a Set Bit?

A bit whose value is **1** is called a **Set Bit**.

### Example

```text
13 = 1101
```

```text
1 1 0 1
↑ ↑   ↑
```

Number of Set Bits = **3**

---

## 💡 Intuition

When we subtract `1` from a number:

- The rightmost Set Bit becomes `0`
- All bits to its right become `1`

For a Power of 2, there is only one Set Bit.

So subtracting `1` completely removes that Set Bit.

---

## 🪄 Dry Run

### Example: n = 8

Binary Representation:

```text
8 = 1000
```

Subtract 1:

```text
7 = 0111
```

Perform AND Operation:

```text
1000
0111
----
0000
```

Result = **0** ✅

Therefore, **8 is a Power of 2**.

---

## 🎯 Another Example

### Example: n = 16

```text
16 = 10000
15 = 01111
```

```text
10000
01111
-----
00000
```

Result = **0** ✅

Therefore, **16 is a Power of 2**.

---

## ❌ Non-Power of 2 Example

### Example: n = 10

```text
10 = 1010
 9 = 1001
```

```text
1010
1001
----
1000
```

Result ≠ **0**

Therefore, **10 is NOT a Power of 2**.

---

## 🔥 Why Does This Work?

The expression:

```java
n &(n -1)
```

always removes the **rightmost Set Bit** from a number.

### Example

```text
12 = 1100
11 = 1011
```

```text
1100
1011
----
1000
```

The rightmost Set Bit is removed.

For a Power of 2, there is only one Set Bit.

Removing it leaves:

```text
0000
```

Hence:

```java
(n &(n -1))==0
```

---

## ⚠️ Important Edge Case

### What about 0?

```java
0&(-1)=0
```

But:

```text
0 is NOT a Power of 2
```

That's why we add:

```java
n >0
```

Final Condition:

```java
n >0&&(n &(n -1))==0
```

---

## ⏱️ Complexity Analysis

### Time Complexity

```text
O(1)
```

Only one bitwise operation is performed.

### Space Complexity

```text
O(1)
```

No extra memory is used.

---

## 🎓 Interview Takeaway

```text
Power of 2 → Exactly One Set Bit

n & (n - 1) = 0
```

### Quick Examples

```text
1   ✅
2   ✅
4   ✅
8   ✅
16  ✅
32  ✅

3   ❌
5   ❌
10  ❌
12  ❌
18  ❌
```

---

## 🧩 Memory Trick

Imagine a Power of 2 as a room with only **one light turned on**.

```text
1000
```

Subtracting `1` turns that light off and switches all lower lights on.

```text
0111
```

Now there is no position where both numbers have a `1`.

```text
1000
0111
----
0000
```

Result = **0**

Therefore, the number is a Power of 2. 🚀

---

# 🔟 Count Set Bits

## 📌 Problem

Given a non-negative integer `N`, count the number of **set bits (1s)** present in its binary representation.

A set bit is a bit whose value is `1`.

### Example

```text
N = 13

Binary = 1101

Set Bits = 3
```

---

## ⚡ Golden Trick

```java
n =n &(n -1);
```

This operation removes the **rightmost set bit** from a number.

Each iteration removes exactly one `1`.

Therefore:

```text
Number of iterations = Number of set bits
```

---

## 💻 Important Logic

### Approach 1: Check Every Bit

```java
for(int i = 0;
i< 31;i++){
        if((n &(1<<i))!=0){
count++;
        }
        }
```

---

### Approach 2: Check Last Bit Repeatedly

```java
while(n >0){
count +=(n &1);
n >>=1;
        }
```

---

### Approach 3: Brian Kernighan's Algorithm ⭐

```java
while(n >0){
n =n &(n -1);
count++;
        }
```

---

## 🧠 Intuition

Every set bit contributes `1` to the final count.

Instead of checking every position individually, we can repeatedly remove set bits until the number becomes zero.

Consider:

```text
1101
```

If we remove one set bit at a time:

```text
1101
↓
1100
↓
1000
↓
0000
```

We removed:

```text
3 set bits
```

Hence the answer is:

```text
3
```

---

## 🪄 Dry Run

### Example: N = 13

```text
Binary = 1101
```

### Iteration 1

```text
n       = 1101
n - 1   = 1100

1101
1100
----
1100
```

Count = 1

---

### Iteration 2

```text
n       = 1100
n - 1   = 1011

1100
1011
----
1000
```

Count = 2

---

### Iteration 3

```text
n       = 1000
n - 1   = 0111

1000
0111
----
0000
```

Count = 3

---

Number becomes:

```text
0000
```

Stop.

✅ Answer = 3

---

## ❌ Why Not Check Every Bit?

A common solution is:

```java
for(int i = 0;
i< 31;i++)
```

This works perfectly.

However, it always performs:

```text
31 iterations
```

even when only a few bits are set.

Example:

```text
1000000000000000000000000000000
```

contains only:

```text
1 set bit
```

Yet the loop still checks all 31 positions.

---

## 🔥 Why Brian Kernighan's Algorithm Is Better

Observe:

```text
n & (n - 1)
```

always removes exactly one set bit.

Example:

```text
1101 → 1100
1100 → 1000
1000 → 0000
```

One set bit disappears in every iteration.

Therefore:

```text
Iterations = Number of Set Bits
```

Not:

```text
Iterations = Total Number of Bits
```

This makes it extremely efficient when the number contains only a few set bits.

---

## ⚠️ Edge Cases

### 1. Number is Zero

```text
N = 0

Binary = 0

Set Bits = 0
```

---

### 2. Number is One

```text
N = 1

Binary = 1

Set Bits = 1
```

---

### 3. All Bits Set

```text
N = 15

Binary = 1111

Set Bits = 4
```

---

### 4. Large Power of Two

```text
N = 1024

Binary = 10000000000

Set Bits = 1
```

---

### 5. Maximum Integer Value

```text
N = 2147483647

Binary = 31 ones

Set Bits = 31
```

---

## ⏱️ Complexity

| Approach        | Time Complexity       | Space Complexity |
|-----------------|-----------------------|------------------|
| Check Every Bit | O(31)                 | O(1)             |
| Shift and Check | O(Number of Bits)     | O(1)             |
| Brian Kernighan | O(Number of Set Bits) | O(1)             |

---

## 🎓 Interview Takeaway

Whenever you hear:

```text
Count Set Bits
```

Think:

```java
n &(n -1)
```

because it removes the rightmost set bit in one operation.

This is one of the most frequently asked bit manipulation tricks in coding interviews and competitive programming.

---

## 🧩 Memory Trick

Imagine every set bit is a glowing bulb 💡:

```text
11010100
```

### Normal Approach

```text
🔍 Check every position
```

You inspect every bulb, whether it's ON or OFF.

---

### Brian Kernighan

```text
🎯 Remove one glowing bulb at a time
```

```text
11010100
↓
11010000
↓
11000000
↓
10000000
↓
00000000
```

Each removal increases the count by `1`.

### Golden Formula

```java
n =n &(n -1);
```

💡 **One operation = One set bit removed**

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

# 1️⃣4️⃣ Set the Rightmost Unset Bit

# 📌 Problem: Set the Rightmost Unset Bit

Given a non-negative integer `N`, set its **rightmost unset (0) bit** and return the resulting number.

---

## 🧾 Examples

### Example 1

```text
Input:  N = 10

Binary:
1010

Rightmost unset bit:
1010
   ↑

After setting:
1011

Output: 11
```

### Example 2

```text
Input:  N = 7

Binary:
111

After setting the rightmost unset bit:
1111

Output: 15
```

---

# ⚡ Golden Trick

```java
n |(n +1)
```

This single expression sets the **rightmost unset bit** of a number.
---

# 🧠 Intuition

To understand the trick, let's first see what happens when we add `1`.

Consider:

```text
N = 10

Binary:
1010
```

Adding `1`:

```text
1010
+   1
----
1011
```

Notice something interesting:

```text
1010
1011
   ↑
```

The rightmost unset bit became `1`.

Now perform OR:

```text
1010
1011
----
1011
```

The OR operation preserves all existing `1`s and ensures that the rightmost unset bit becomes `1`.

---

# 🪄 Dry Run

## Example: N = 10

### Step 1

```text
N = 10

Binary:
1010
```

### Step 2

```text
N + 1

1010
+   1
----
1011
```

### Step 3

Apply OR:

```text
1010
1011
----
1011
```

### Step 4

Convert back to decimal:

```text
1011 = 11
```

✅ Answer = 11

---

# ❌ Why Can't We Just Use `n + 1`?

Many beginners think:

```java
return n +1;
```

should work.

It works for some cases, but completely fails for others.

---

## Case 1: Works Accidentally

```text
N = 10

1010
```

```text
N + 1 = 1011
```

Output:

```text
11
```

Looks correct.

---

## Case 2: Fails

```text
N = 11

Binary:
1011
```

Adding 1:

```text
1011
+   1
----
1100
```

Result:

```text
12
```

But the expected answer is:

```text
1011

Rightmost unset bit:
1011
  ↑

Set it:

1111 = 15
```

---

### Comparison

```text
Using n + 1      → 1100 (12) ❌
Using n|(n+1)    → 1111 (15) ✅
```

Why?

Because `n + 1` may change multiple bits due to carry propagation.

```text
1011 + 1

1 + 1 = 0 (carry)
1 + carry = 0 (carry)
0 + carry = 1
```

Result:

```text
1100
```

Several bits changed.

But our goal is only:

```text
Set the first 0 bit from the right.
```

The OR operation guarantees exactly that.

---

# 🔍 Why Does `n | (n + 1)` Always Work?

Suppose:

```text
N = xxxx01111
```

The rightmost unset bit is:

```text
xxxx0 1111
    ↑
```

Adding 1:

```text
xxxx10000
```

Observe:

1. The rightmost unset bit becomes `1`.
2. All bits to its right become `0`.

Now OR them:

```text
xxxx01111
xxxx10000
----------
xxxx11111
```

Result:

```text
The rightmost unset bit is set.
All existing 1s remain unchanged.
```

Exactly what we need.

---

# 🔥 Why It Works

When we compute:

```java
n |(n +1)
```

- `n + 1` turns the first `0` bit (from the right) into `1`.
- OR keeps every existing `1`.
- OR also keeps the newly created `1`.

Therefore:

```text
The rightmost unset bit becomes set.
```

This works in a single operation.

---

# ⚠️ Edge Cases

### 1. Number is 0

```text
0  -> 1
```

---

### 2. Single Bit Number

```text
1 -> 3
```

```text
1
↓

11
```

---

### 3. Multiple Trailing Ones

```text
11

1011
```

Result:

```text
1111 = 15
```

---

### 4. All Bits Are Set

```text
7

111
```

Result:

```text
1111 = 15
```

---

### 5. Large Power of Two

```text
1024

10000000000
```

Result:

```text
10000000001
```

---

### 6. Integer Overflow Case

```text
Integer.MAX_VALUE
```

```text
2147483647

01111111111111111111111111111111
```

The next bit lies outside the positive `int` range.

Be careful if the platform includes this case.

---

# ⏱️ Complexity

| Operation | Complexity |
|-----------|------------|
| Time      | O(1)       |
| Space     | O(1)       |

---

# 🎓 Interview Takeaway

Whenever you hear:

```text
Set the rightmost unset bit
```

Immediately think:

```java
n |(n +1)
```

Key observation:

```text
n + 1
```

finds the first zero from the right and turns it into one.

Then:

```text
OR
```

preserves all existing set bits while keeping that newly set bit.

This produces the desired answer in constant time.

---

# 🧩 Memory Trick

Imagine a binary number as a row of switches:

```text
1011
```

You want to turn ON the first OFF switch from the right.

```text
1011
  ↑
```

`n + 1` locates that switch and flips it ON.

```text
1100
```

Then OR merges the old and new states:

```text
1011
1100
----
1111
```

🎯 **Memory Formula**

```java
Set Rightmost
Unset Bit
        =
        n | (n + 1)
```

Whenever you see:

```text
Rightmost 0 → Make it 1
```

Think:

```text
ADD 1 ➜ OR
```

🚀

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

# 📌 Problem: Check Whether the K-th Bit is Set

Given an integer `n` and a bit position `k`, determine whether the K-th bit of the number is set (`1`) or not set (`0`).

---

# ⚡ Golden Trick

Create a mask having only the K-th bit set.

```java
1<<k
```

Then perform a bitwise AND operation:

```java
n &(1<<k)
```

- Result = `0` → K-th bit is NOT set
- Result ≠ `0` → K-th bit IS set

---

# 🧠 Intuition

Imagine each bit of a number is a switch.

For example:

```text
13 = 1101
```

```text
Position: 3 2 1 0
Bits:     1 1 0 1
```

To check a specific switch, we create a mask that turns ON only that position.

For K = 2:

```text
0001 << 2 = 0100
```

Now perform AND:

```text
1101
0100
----
0100
```

Since the result is not zero, the bit exists and is set.

---

# 🪄 Dry Run

### Input

```text
n = 13
k = 2
```

### Step 1

Create mask:

```text
1 << 2 = 0100
```

### Step 2

Perform AND:

```text
1101
0100
----
0100
```

### Step 3

Result ≠ 0

```text
Answer = Set
```

---

# ❌ Counter Example

### Input

```text
n = 13
k = 1
```

Binary:

```text
13 = 1101
```

Mask:

```text
0010
```

AND:

```text
1101
0010
----
0000
```

Result = 0

```text
Answer = Not Set
```

---

# 🔥 Why It Works

The mask contains exactly one bit set:

```text
0001 << k
```

When AND is performed:

```text
n & mask
```

all bits become zero except the K-th bit.

Therefore:

- If K-th bit was 1 → result is non-zero.
- If K-th bit was 0 → result is zero.

This directly tells us whether the bit is set.

---

# ⚠️ Edge Cases

### 1. Checking 0th Bit

```text
n = 5 (0101)
k = 0
```

Result:

```text
Set
```

---

### 2. Number is Zero

```text
n = 0
```

Every bit is unset.

Result:

```text
Not Set
```

---

### 3. Large Bit Position

```text
k >= 31
```

For Java `int`, valid positions are typically:

```text
0 to 31
```

---

# ⏱️ Complexity

| Operation | Complexity |
|-----------|------------|
| Time      | O(1)       |
| Space     | O(1)       |

---

# 🎓 Interview Takeaway

Whenever you need to inspect a specific bit:

```java
(n &(1<<k))!=0
```

This is the most common and efficient technique used in bit manipulation problems.

---

# 🧩 Memory Trick

Think of the mask as a spotlight 🔦.

```java
1<<k
```

moves the spotlight to the K-th position.

```java
n &mask
```

illuminates only that bit.

- Light visible → Bit is Set ✅
- No light → Bit is Not Set ❌

Remember:

```java
Check Bit
        =
        AND
with Shifted 1
```

```java
(n &(1<<k))
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