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