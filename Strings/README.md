# 🔤 Strings in Java

<div align="center">

![Java](https://img.shields.io/badge/Language-Java-orange)
![DSA](https://img.shields.io/badge/Topic-Strings-blue)
![Level](https://img.shields.io/badge/Difficulty-Beginner_to_Intermediate-green)

</div>

---

# 📖 Introduction

Strings are one of the most fundamental and frequently used data structures in programming.

A **String** is a sequence of characters stored together to represent text.

Examples:

```java
String name = "Guruvesh";
String city = "Pune";
String language = "Java";
```

Almost every software application deals with strings:

- User names
- Passwords
- Search engines
- Chat applications
- Text editors
- URLs
- Databases
- File names

Because of their importance, string problems are among the most frequently asked questions in:

- Technical Interviews
- Placement Exams
- Coding Assessments
- Competitive Programming

---

# 🧠 Important String Concepts

## 1. String Declaration

```java
String str = "Hello";
```

---

## 2. String Length

```java
str.length();
```

Returns total number of characters.

---

## 3. Character Access

```java
str.charAt(i);
```

Accesses character at index `i`.

---

## 4. String Comparison

### Wrong

```java
str1 ==str2
```

Compares references.

### Correct

```java
str1.equals(str2)
```

Compares actual contents.

---

## 5. String Concatenation

```java
String result = str1 + str2;
```

---

## 6. Substring

```java
str.substring(start, end);
```

---

## 7. StringBuilder

Used when frequent modifications are required.

```java
StringBuilder sb = new StringBuilder();
```

Advantages:

- Faster
- Mutable
- Memory efficient

---

# 🎯 Interview Tricks

## Trick 1

Convert String → Character Array

```java
char arr[] = str.toCharArray();
```

Useful for:

- Anagrams
- Frequency Count
- Sorting Characters

---

## Trick 2

Convert Character to Lowercase

```java
Character.toLowerCase(ch);
```

---

## Trick 3

Convert Character to Uppercase

```java
Character.toUpperCase(ch);
```

---

## Trick 4

Use StringBuilder for String Compression

Avoid:

```java
ans =ans +ch;
```

Prefer:

```java
StringBuilder sb = new StringBuilder();
```

---

## Trick 5

Reverse String Efficiently

```java
StringBuilder sb = new StringBuilder(str);
sb.

reverse();
```

---

# 📂 Problems Solved

---

# 1️⃣ Anagrams

## Problem

Determine whether two strings contain the same characters with the same frequencies.

Example:

```text
listen
silent
```

Output:

```text
True
```

---

## Intuition

Two strings are anagrams if:

- Lengths are equal
- Every character appears the same number of times

Think of it as rearranging letters.

```
listen
↓
silent
```

Same characters, different order.

---

## Approach

1. Convert both strings to lowercase.
2. Convert to character arrays.
3. Sort both arrays.
4. Compare arrays.

---

## Time Complexity

```text
O(n log n)
```

Sorting dominates.

---

## Why Interviewers Ask This

Tests:

- Character manipulation
- Sorting
- String handling
- Frequency logic

---

# 2️⃣ Direction Problem

## Problem

Given directions:

```text
N
S
E
W
```

Find the shortest distance from the origin.

---

## Example

```text
WNEENESENNN
```

---

## Intuition

Imagine a person walking on a graph.

```
North  -> y++
South  -> y--
East   -> x++
West   -> x--
```

After processing all directions, we get final coordinates.

Distance is then calculated using the Pythagorean Theorem.

---

## Mathematical Formula

::contentReference[oaicite:0]{index=0}


---

## Approach

1. Track x and y coordinates.
2. Update according to direction.
3. Calculate shortest distance.

---

## Time Complexity

```text
O(n)
```

---

## Why Interviewers Ask This

Checks:

- Traversal logic
- Coordinate systems
- Mathematical reasoning

---

# 3️⃣ Largest String

## Problem

Find the lexicographically largest string from an array.

Example:

```java
{"apple","banana","mango","zebra"}
```

Output:

```java
zebra
```

---

## What Does Lexicographical Mean?

Dictionary order.

Example:

```text
Apple < Banana < Mango < Zebra
```

---

## Intuition

Compare every string with the current largest string.

Whenever a larger string is found, update the answer.

Think of it like finding the tallest student in a classroom.

---

## Approach

```text
largest = first string

Compare all remaining strings

If current > largest
    update largest
```

---

## Time Complexity

```text
O(n)
```

---

## Important Method

```java
str1.compareTo(str2);
```

Returns:

```text
Positive  -> str1 > str2
Negative  -> str1 < str2
Zero      -> equal
```

---

# 4️⃣ Lowercase Vowels in String

## Problem

Count total lowercase vowels in a string.

Example:

```text
apnacollege
```

Output:

```text
5
```

---

## Vowels

```text
a
e
i
o
u
```

---

## Intuition

Traverse the string character by character.

For each character:

```text
Is it a vowel?
```

If yes:

```text
count++
```

---

## Approach

```java
for every character
check vowel
increase count
```

---

## Time Complexity

```text
O(n)
```

---

## Why Interviewers Ask This

Tests:

- String traversal
- Conditional logic
- Character handling

---

# 5️⃣ String Compression

## Problem

Compress consecutive repeating characters.

Example:

```text
aaabbcccdd
```

Output:

```text
a3b2c3d2
```

---

## Real World Example

Compression techniques help reduce:

- File size
- Memory usage
- Data transfer cost

---

## Intuition

Count consecutive occurrences.

Instead of storing:

```text
aaa
```

Store:

```text
a3
```

---

## Approach

1. Traverse string.
2. Count repeated characters.
3. Append character.
4. Append frequency if greater than 1.

---

## Example Dry Run

Input:

```text
aaabbcccdd
```

Process:

```text
a → 3 times → a3
b → 2 times → b2
c → 3 times → c3
d → 2 times → d2
```

Output:

```text
a3b2c3d2
```

---

## Time Complexity

```text
O(n)
```

---

## Important Learning

Use:

```java
StringBuilder
```

instead of:

```java
ans =ans +ch;
```

because StringBuilder is significantly faster.

---

# 6️⃣ String Palindrome

## Problem

Check whether a string reads the same forward and backward.

---

## Example

```text
racecar
```

Forward:

```text
racecar
```

Backward:

```text
racecar
```

Output:

```text
True
```

---

## Intuition

Compare characters from both ends.

```
r == r
a == a
c == c
```

Continue until the middle.

---

## Approach

Use two pointers.

```text
left = 0
right = n-1
```

Move inward.

---

## Time Complexity

```text
O(n)
```

---

## Why Interviewers Love This Question

Tests:

- Two Pointer Technique
- Index Handling
- Logical Thinking

---

# 7️⃣ To Uppercase

## Problem

Capitalize the first letter of every word.

---

## Example

Input:

```text
hi, i am learning java
```

Output:

```text
Hi, I Am Learning Java
```

---

## Intuition

Whenever:

```text
space encountered
```

the next character should become uppercase.

---

## Approach

1. Convert first character to uppercase.
2. Traverse string.
3. Whenever space occurs:
    - Add space.
    - Capitalize next character.

---

## Example

```text
hello world
```

Process:

```text
hello → Hello
world → World
```

Output:

```text
Hello World
```

---

## Time Complexity

```text
O(n)
```

---

# 📊 Complexity Summary

| Problem            | Time Complexity | Space Complexity |
|--------------------|-----------------|------------------|
| Anagrams           | O(n log n)      | O(n)             |
| Direction Problem  | O(n)            | O(1)             |
| Largest String     | O(n)            | O(1)             |
| Lowercase Vowels   | O(n)            | O(1)             |
| String Compression | O(n)            | O(n)             |
| String Palindrome  | O(n)            | O(1)             |
| To Uppercase       | O(n)            | O(n)             |

---

# 🏆 Key Takeaways

✔ Strings are immutable in Java.

✔ StringBuilder is preferred for frequent modifications.

✔ compareTo() is heavily used in interviews.

✔ Two-pointer technique is common in palindrome problems.

✔ Character manipulation forms the foundation of many advanced DSA questions.

✔ String questions frequently appear in coding interviews and placement assessments.

✔ Mastering Strings improves problem-solving skills for Arrays, Hashing, Sliding Window, and Dynamic Programming.

---

# 🚀 Progress

✅ Anagrams

✅ Direction Problem

✅ Largest String

✅ Lowercase Vowels in String

✅ String Compression

✅ String Palindrome

✅ To Uppercase

---

> "Strings look simple, but they quietly power search engines, compilers, databases, chat applications, and countless
> interview questions."
