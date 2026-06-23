# ⚡ Bit Manipulation — Detailed Revision Sheet

> 🎯 Brush-up notes: short intuition + formula + example for every concept. Built for re-reading before interviews/contests, not for learning from scratch.

---

## 🧠 Core Concepts

### 🔹 What is a Bit?
Smallest unit of data → `0` (OFF) / `1` (ON). Computers store everything internally in binary.

### 🔹 MSB & LSB
| Term | Meaning | Why it matters |
|---|---|---|
| **MSB** (Most Significant Bit) | Leftmost bit | Acts as **sign bit** in signed numbers; represents highest power of 2 |
| **LSB** (Least Significant Bit) | Rightmost bit | Decides **Odd/Even** → `(n & 1)` |

```
13 = 1101
     ↑   ↑
    MSB  LSB
```

### 🔹 Signed vs Unsigned
| Type | Rule | 8-bit Range |
|---|---|---|
| Unsigned | All bits = magnitude | `0 to 255` |
| Signed | MSB = sign (0→+, 1→−) | `-128 to +127` |

### 🔹 Two's Complement (how negatives are stored)
**Steps:** Write positive binary → Invert all bits → Add 1.
```
5      = 00000101
Invert = 11111010
+1     = 11111011   →  this represents -5
```
✅ Why use it? Because `5 + (-5)` using two's complement directly gives `00000000` — no special subtraction circuitry needed.

🧩 **Memory Trick:** `Invert → +1 → Negative` ("Flip & Bump")

### 🔹 Decimal ↔ Binary Conversion
| Direction | Method | Trick |
|---|---|---|
| Decimal → Binary | Divide by 2 repeatedly, collect remainders, read **bottom→top** | 📦 "Division → Remainders → Reverse" |
| Binary → Decimal | Multiply each bit by its power of 2 and sum | 📦 "Multiply → Add → Decimal" |

```
13 → Binary                      1101₂ → Decimal
13÷2=6 R1                        1×2³ + 1×2² + 0×2¹ + 1×2⁰
6÷2=3  R0                        = 8 + 4 + 0 + 1
3÷2=1  R1                        = 13
1÷2=0  R1   → read up: 1101
```
⚠️ **Common mistakes:** reading remainders top-to-bottom (wrong); starting powers from 2¹ instead of 2⁰ (LSB is always `2⁰`).

**Key Identity:** `1 << k  =  2^k` — appears in almost every bit manipulation problem.

| Operation | Complexity |
|---|---|
| Decimal → Binary | O(log N) |
| Binary → Decimal | O(number of bits) |

---

## ⚙️ Important Bitwise Operators

| Operator | Name | Purpose | Example |
|:---:|---|---|---|
| `&` | AND | 1 only if **both** bits are 1 — used to *check/clear* bits | `1010 & 0010 = 0010` |
| `\|` | OR | 1 if **either** bit is 1 — used to *set* bits | `1010 \| 0001 = 1011` |
| `^` | XOR | 1 if bits **differ** — used to *toggle/cancel* | `1010 ^ 0011 = 1001` |
| `~` | NOT | Flips every bit | `~1010 = 0101` (within bit-width) |
| `<<` | Left Shift | Shifts bits left, fills 0 on right → multiplies | `0101 << 1 = 1010` (5→10) |
| `>>` | Right Shift | Shifts bits right, discards rightmost → divides | `1000 >> 1 = 0100` (8→4) |

🚀 **Golden Memory Rule**
```
Check  → AND
Set    → OR
Clear  → AND + NOT
Toggle → XOR
```
Master these four formulas and most beginner bit problems become straightforward.

---

## 🔄 Binary Tricks

### Shift Operators
Shifting bits left/right efficiently performs multiplication/division since binary positions are powers of 2.

| Operation | Formula | Example |
|---|---|---|
| Left Shift | `x << n  =  x × 2ⁿ` | `7 << 1 = 14`, `7 << 2 = 28` |
| Right Shift | `x >> n  =  x ÷ 2ⁿ` | `20 >> 1 = 10`, `20 >> 2 = 5` |

⚠️ Right shift performs **integer division** — `13 >> 1 = 6`, not `6.5` (decimal part is lost).

### Creating a Mask
```
1 << i   → sets ONLY the iᵗʰ bit to 1
1<<0 = 0001    1<<1 = 0010    1<<2 = 0100    1<<3 = 1000
```

### The Four Core Bit Operations (with dry runs)

| Goal | Formula | Dry Run (n=10=1010, i=1) |
|---|---|---|
| **Get** iᵗʰ bit | `(n & (1 << i)) != 0` | `1010 & 0010 = 0010` → bit is **set** |
| **Set** iᵗʰ bit | `n \| (1 << i)` | `1010 \| 0010 = 1010` (already set) |
| **Clear** iᵗʰ bit | `n & ~(1 << i)` | `1010 & 1101 = 1000` |
| **Toggle** iᵗʰ bit | `n ^ (1 << i)` | `1010 ^ 0010 = 1000` |
| **Update** iᵗʰ bit | `n = (n & ~(1<<i)) \| (newBit<<i)` | clear then write — two-step |

### Remove Last Set Bit
```
n & (n - 1)
12 = 1100
11 = 1011
-------- AND -------
     1000   →  last set bit removed
```
💡 **Why it works:** subtracting 1 flips the rightmost set bit to 0 and all bits after it to 1 — AND then wipes that bit.

### Check Power of 2
```
(n & (n - 1)) == 0   &&   n > 0
```
A power of 2 has **exactly one set bit**, so removing it gives 0.

🧠 **Memory Trick**
```
Left Shift (<<)  ⬅️ ⬆️ ×2ⁿ
Right Shift (>>) ➡️ ⬇️ ÷2ⁿ
```

---

## 📐 Formulas & Identities

### Bit Ops Quick Reference
```text
Check Kth Bit        : (n & (1 << k)) != 0
Set Kth Bit          : n | (1 << k)
Clear Kth Bit        : n & ~(1 << k)
Toggle Kth Bit       : n ^ (1 << k)
Update Kth Bit       : n = (n & ~(1 << i)) | (newBit << i)
Remove Last Set Bit  : n & (n - 1)
Check Power of 2     : (n & (n - 1)) == 0   &&  n > 0
Clear Last i Bits    : n & ((-1) << i)
Set Rightmost 0 Bit  : n | (n + 1)
Count Set Bits (BK)  : while(n) { n &= (n-1); count++; }
```

**Clear Last i Bits** — create a mask with 1s on the left, 0s on the last i positions via `(-1) << i`, then AND:
```
n = 29 = 11101 ,  i = 3
mask = (-1)<<3 = ...11111000
29 & mask  →  last 3 bits cleared
```

**Set Rightmost Unset Bit** — `n | (n + 1)` flips the rightmost 0 to 1 while keeping all 1s intact (adding 1 carries exactly up to that bit, OR-ing then preserves it).

### 🧨 XOR Mastery — Full Property List
XOR is special because it's the only operator that's reversible — making it perfect for cancellation tricks.

| Property | Formula | Why |
|---|---|---|
| Self-cancel | `a ^ a = 0` | every bit identical → all 0 |
| Identity | `a ^ 0 = a` | 0 doesn't affect value |
| Reversible | `(a ^ b) ^ b = a` | second XOR undoes the first |
| Commutative | `a ^ b = b ^ a` | order doesn't matter |
| Associative | `(a^b)^c = a^(b^c)` | grouping doesn't matter |
| Toggle a bit | `n ^ (1 << i)` | flips that bit, leaves rest untouched |

**Finding the unique element** (everyone else appears twice):
```
2 ^ 3 ^ 4 ^ 3 ^ 2 = (2^2) ^ (3^3) ^ 4 = 0 ^ 0 ^ 4 = 4
```

**XOR Swap** (no temp variable):
```
a = a ^ b;
b = a ^ b;   // now b = original a
a = a ^ b;   // now a = original b
```

🧠 **Memory Trick**
```
XOR = Difference Detector → Same bits → 0, Different bits → 1
XOR Cancels Duplicates
```

---

## 🧩 Common Patterns

| Observation | Think About |
|---|---|
| Unique element | XOR |
| Powers of 2 | `n & (n-1)` |
| Subsets | Bitmasking |
| State toggling | XOR |
| Fast multiply/divide | Shifts |
| Counting bits | Brian Kernighan |
| Masking required | AND / OR |

🧠 **Memory Trick**
```
XOR        = Difference Detector  (same→0, diff→1)
AND(n,n-1) = Removes Last Set Bit
```

**Unique element (all others appear twice):**
```text
2 ^ 3 ^ 4 ^ 3 ^ 2  =  4
```

**XOR Swap:**
```text
a = a ^ b;
b = a ^ b;
a = a ^ b;
```

---

## 🎭 Frequently Used Bitmasks

| Goal | Mask Expression | Why it Works |
|---|---|---|
| Set only iᵗʰ bit | `1 << i` | shifts the single `1` into position |
| All 1s except iᵗʰ bit | `~(1 << i)` | inverted mask → ANDing clears that bit |
| Clear last i bits | `(-1) << i` | `-1` is all 1s; shifting pushes 0s into low bits |
| Isolate lowest set bit | `n & (-n)` | `-n` (two's complement) keeps only the lowest 1 |
| Remove lowest set bit | `n & (n - 1)` | `n-1` flips lowest set bit + everything after it |
| Set lowest unset bit | `n \| (n + 1)` | `+1` carries up to the first 0, OR keeps rest intact |
| Check if odd/even | `n & 1` | isolates LSB |
| All bits set (n-bit) | `(1 << n) - 1` | shift past range then subtract 1 → fills with 1s |

💡 **Brian Kernighan's Algorithm** (count set bits): repeatedly do `n = n & (n-1)` until `n` becomes 0, incrementing a counter each time — runs in **O(set bits)**, much faster than checking every bit individually (O(total bits)).

---

## 🚀 Fast Exponentiation (Binary Exponentiation)

**Golden Trick:** decompose exponent into powers of 2 → square base, multiply on set bits.

```text
3¹³  →  13 = 1101₂ = 8+4+1
     →  3¹³ = 3⁸ × 3⁴ × 3¹
```

**Standard logic:**
```text
ans = 1
while (power > 0) {
    if (power & 1) ans *= number;
    number *= number;
    power >>= 1;
}
```

| Approach | Time |
|---|---|
| Brute Force | O(n) |
| Binary Exponentiation | **O(log n)** |

🧩 **Memory Trick:** *"Square & Select"* — square the base every step, select it only when the bit is `1`.

---

## 🔤 ASCII Tricks

| Goal | Trick |
|---|---|
| Uppercase → Lowercase | `ch \| ' '`  (i.e. `ch \| 32`) |
| Lowercase → Uppercase | `ch & '_'`  (i.e. `ch & ~32`) |
| Check alphabet case | Compare 5th bit (`ch & 32`) |

```text
'A' = 01000001
' ' = 00100000
-----------------
'a' = 01100001
```

🧩 **Memory Trick:** Space char `' ' = 00100000` is the **"Lowercase Switch"** → OR turns it ON.
⚠️ Works only for **alphabets**, not digits/symbols.

---

## 🎓 Interview Tricks

```text
n & 1                 → Odd / Even
1 << i                → Create mask
n | (1 << i)          → Set ith bit
n & ~(1 << i)         → Clear ith bit
n ^ (1 << i)          → Toggle ith bit
n & (n - 1)           → Remove last set bit
(n & (n-1)) == 0      → Power of 2 check
x << 1 / x >> 1       → ×2 / ÷2
a^a=0, a^0=a          → XOR cancellation
```

⚠️ **Common Mistakes**
- Forgetting parentheses → `n & 1<<i` ❌ vs `n & (1<<i)` ✅
- Bit index counted **0-based from right**
- Signed right shift on negatives behaves differently
- Large left shifts can overflow
- Misusing XOR cancellation without verifying

⭐ **Recommended Practice Order**
```
Odd/Even → Get Bit → Set Bit → Clear Bit → Toggle Bit →
Update Bit → Clear Last i Bits → Power of 2 →
Count Set Bits → XOR Problems → Unique Element → Fast Exponentiation
```

---

## ⏱ Complexity Cheat Sheet

| Operation | Complexity |
|---|---|
| Get / Set / Clear / Toggle Bit | O(1) |
| Power of 2 Check | O(1) |
| Count Set Bits (Kernighan) | O(log n) |
| Fast Exponentiation | O(log n) |
| Binary ↔ Decimal Conversion | O(log n) |

---

## 🌍 Real-World Applications
`Cryptography` · `Networking` · `Image Processing` · `Compression` · `OS` · `Databases` · `Embedded Systems` · `Game Engines` · `Permission Systems (flags via bitmasks)`

---

### 🧠 One-Glance Recall Block
```
&  → AND  → Check
|  → OR   → Set
^  → XOR  → Toggle / Unique / Swap
~  → NOT  → Invert
<< → ×2ⁿ
>> → ÷2ⁿ
n & (n-1)     → remove last set bit / power of 2 check
n & -n        → isolate last set bit
n | (n+1)     → set rightmost 0 bit
ch | ' '      → upper → lower
```

💡 *Revise this page 10 mins before every contest/interview.*
