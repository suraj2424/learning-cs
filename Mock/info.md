# Mock 1

## Question 1

### Problem Statement
Given an integer array `nums` and an integer `k`, return the total number of continuous subarrays whose sum equals to `k`.

**Difficulty:** Medium

### Example:
**Input:** nums = [1, 1, 1], k = 2
**Output:** 2
**Explaination:** ([1,1] at index 0–1 and 1–2)

**refer:** [Here](Question_1.java) 


## Question 2

Difficulty: Medium+
Topic: Arrays / Prefix Sum Variation
Pattern: Subarray + Modulo

### Problem Statement
- Given an integer array `nums` and an integer `k`, return the number of subarrays whose `sum` is divisible by `k`.

### Example:
nums = [4,5,0,-2,-3,1], k = 5 → Output: 7


### Expectations
Q1. Convert problem using prefix sums + modulo  

Q2. Handle negative modulo properly (very important)  

Q3. Use hashmap for frequency  

Q4. Explain why (sum % k) works  

**Dry run:**

```text
sum = 0
count = 0
i=0
sum = 4
map: [(0,1),(4,1)]

i=1
sum = 9
count = 1
map: [(0,1),(4,2)]

i=2
sum = 9
count = 3
map: [(0,1),(4,3)]

i=3
sum = 7
count = 3
map: [(0,1),(2,1),(4,3)]

i=4
sum = 4
count = 6
map: [(0,1),(2,1),(4,4)]

i=5
sum = 5
count = 7 
map: [(0,2),(2,1),(4,4)]
```

**Q1. my answer:**
refer: [Here](Question_2.java)

**Q2. answer:**
- if we store key as sum % k, then i think we can actually consider all the remainders of k.

**Q3. answer:**
- used map in the solution

**Q4. answer:**
- because sum % k -> here the value of sum % k will be between 0 - (k-1), so this logic helps the sum % k to find frequencies.

### Question Progress Review

#### **❌ What I missed / mistakes**

**1. Negative modulo bug ⚠️ (important)**  

In Java: 
```java
-1 % 5 = -1   // not 4
```

So my code can break for negative sums.

**FIX**
```java
int rem = sum % k;
if (rem < 0) rem += k;
```

**2. Explanation lacks the key insight**
This is the most important gap.

I said:
> "we can consider all remainders"

That’s not enough. The real insight is:

**Key Insight**
I want:
```java
(subarray sum) % k == 0
```
Which means:
```java
(prefixSum[j] - prefixSum[i]) % k == 0
```

Rearrange:  
```java
prefixSum[j] % k == prefixSum[i] % k
```

`👉 So we just need same remainder pairs`


### Edge Cases

1. What happens if `k = 0`?

- current logic: **sum % k**  

**→ division by zero which is division by zero → crash**

If `k = 0`, the question becomes:

> “Count subarrays whose sum == 0”

✅ That’s the previous problem you already solved

So:

- Use prefix sum + hashmap (sum, frequency)
- NOT modulo

refer (Code): [divisibleSubarrays_1 method](Question_2.java)

---

2. Can we reduce space complexity from O(n) to O(k)? When?

- since remainder of `sum % k` will be between [0-(k-1)].
- we can use freq array of size `k`
- ✅ Space becomes O(k) instead of O(n)

refer (Code): [divisibleSubarrays_2 method](Question_2.java)


3. How would you adapt this to return the longest subarray divisible by k instead of count?

- Now instead of counting, we want max length.

Key idea:
- Store first occurrence of each remainder


**Logic**

If same remainder appears at:
- index i and j

Then:
```java
subarray (i+1 → j) is divisible by k
length = j - i
```
refer (Code): [divisibleSubarrays_3 method](Question_2.java)


## 🔁 Pattern Summary (very important)
- Count subarrays → store frequency
- Longest subarray → store first index
- Handle negatives → normalize modulo
- `k = 0` → switch to sum == 0 problem

## Question 3 
- (Main area Im struggling with)

- Difficulty: Medium
- Topic: Prefix Sum / Hashing
- Twist: Concept clarity

### Problem Statement
- Given a binary array (only 0s and 1s), find the maximum length of a contiguous subarray with equal number of 0s and 1s.
### Expectations
- Convert problem cleverly (key trick)
- Use prefix sum + hashmap
- Explain WHY it works (this is the main test)

### Walkthrough
```text
example: 
nums = [0, 1, 0]

complete pref sum: [-1,0,-1]

map state & initial len:
- map before: [(0,-1)]
- len = 0


at i = 0
sum = -1
add in map: [(0,-1), (-1,0)]

at i = 1
sum = 0
key exists
len = max(0,i-map.get(0)) = max(0,i-(-1)) = max(0,2) = 2

at i = 2
sum = -1
key exists
len = max(2, i-map.get(-1)) = max(2, i-0) = max(2,2) = 2

hence final answer: 2
```


### CODE
refer (Code): [findMaxLength method](Question_3.java)

### Edge Cases

#### Why map.put(0,-1) ?
This handles subarrays that start from index 0.

**❌ What if we DON'T add it?**
Then:

- map doesn't contain 0 initially
- We miss subarrays starting at index 0

`Result` → wrong answer

#### What if we stored latest index instead of first index — would it still work? Why or why not?

- Storing latest index would lose longer subarrays, since earlier index gives bigger length.

#### How would you modify this to find the count of subarrays with equal 0s and 1s?

- Switch above problem with: `prefix sum + frequency map`
> “Now the problem reduces to counting subarrays with sum = 0”

refer (Code): [countMaxLength method](Question_3.java)

