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

## Question 4

- Difficulty: Medium+
- Topic: Hashing + Strings
- Pattern: Sliding Window + Frequency

### Problem Statement
Given a string `s`, find the length of the longest substring without repeating characters.

### Expectations
- Brute force (briefly)
- Optimal sliding window (O(n))
- Handle duplicates correctly
- Explain why shrinking works here but not in previous problems


**BRUTE FORCE**

Idea:

- Try every substring
- Check if it has all unique characters

🧠 How?

- For each starting index i:
- Expand j from i → n-1
- Keep a set to track characters
- If duplicate found → break

refer (Code): [longestSubstring | longestSubstring_1 method](Question_4.java)  

- **TC:** O(N^2)  

- **SC:** O(N)  


**OPTIMAL APPROACH**

refer (Code): [longestSubstring_2 method](Question_4.java)  

### Follow-Up

#### Can you solve this using a Set instead of Map? What changes?

--> once a duplicate char appears we will shrink from left until duplicate is removed from set.
and rest same logic

#### What’s the difference between:
- “shrink step-by-step” vs
- “jump using lastSeen index”

--> shrink step-by-step will a set strategy of solving and jump using lastseen index will be solved using map.
since strategy will be followed by what will be our data structure for handling duplicate char.

#### Walk me through your logic step-by-step (this is a classic trap)
Edge case:
`s = "abba"`

```text
initially, map contains 0 k,v pairs.
and len = 0
keep left index = i
at j=0, c = 'a'
not seen so add in map
map will be [(a,0)]
len = max(0,j-i+1) = 1


at j=1
not seen
map = [(a,0)(b,1)]
len = max(1, j-i+1) = 2

at j=2
seen
we will shrink just after that char gets out of window 
so, i = map.get(b) + 1
i = 2
now len = max(2,j-i+1) = max(1,1) = 2
also map will get updated which will be = [(a,0)(b,2)]

at j = 3
seen
shrink
so, map.contains('a') and check map.get('a') >= i 
0 >= 2 NO, false
so no change
and len = max(2, j-i+1) = 2
```

### Mistakes 

#### Mistake 1
- I was explaining what happens when a duplicate characters appears,
**I said we will shrink our window until the duplicate is gone**

But, **crucial** detail is that we will only remove duplicate when the duplicate character is present in the current window.


### Question 5

- Difficulty: Medium
- Topic: Stack / Monotonic Stack
- Pattern: Next Greater Element

#### Problem Statement
Given an array nums, return an array res where:
- res[i] = next greater element to the right of nums[i]
- If none exists → -1

Example:

input: 
nums = [2,1,2,4,3] 


output: [4,2,4,-1,-1]

#### Expectations

- Brute force first
- Optimal using monotonic stack (O(n))
- Explain WHY stack works

**BRUTE FORCE**

- first get curr with index `i`.
- next we will loop `(j=i+1 to n-1)`
- and apply condition nums[j] > curr if true -> then update ans[i] with nums[j]

refer (Code): [findNextGreater method](Question_5.java)  

**Optimal Approach**

- we will keep a decreasing monotonic stack

**what does above mean then?**

stack stores indices such that 
```java
nums[stack[0]] > nums[stack[1]] > nums[stack[2]] ...
```
**Why?**
Because:

- When a new element comes in (nums[i])
- It resolves all smaller elements before it

refer (Code): [findNextGreater_1 method](Question_5.java)  


#### Optimal Intuition

> We use a monotonic decreasing stack to keep track of elements whose next greater element hasn’t been found yet. When we encounter a new element, we resolve all smaller elements in the stack by assigning their next greater element.

#### Walkthrough
example: 
nums = [2,1,2,4,3]

```text
stack will hold indices
i=0 (2) → push → [0]

i=1 (1) → push → [0,1]

i=2 (2)
  nums[2] > nums[1] → pop 1 → ans[1]=2
  push 2 → [0,2]

i=3 (4)
  pop 2 → ans[2]=4
  pop 0 → ans[0]=4
  push 3 → [3]

i=4 (3)
  push → [3,4]

```

#### 🔥 Follow-up (important)

1. How would you solve this if the array is circular?
(e.g., next greater can wrap around)

2. What changes if we want next greater to the left?

3. Can you solve this without storing indices (only values)? Why or why not?

#### 1. How would you solve this if the array is circular?
(e.g., next greater can wrap around)

> "After reaching the end, you can wrap around to the beginning."

**Trick**
Simulate 2 passes over the array:
```text
for (i = 0 → 2*n-1)
```
Use:
```text
i % n
```

refer (Code): [findNextGreater_2 method](Question_5.java)  

#### 2. What changes if we want next greater to the left?
Just reverse the direction.

#### 3. Can you solve this without storing indices (only values)? Why or why not?
`Sometimes yes or Sometimes No`

**💡 When values-only works**
If you only need:
- next greater value
- You can store values.

**❌ When indices are required**

If you need:

- position
- distance
- circular handling
👉 You MUST store indices

**🔥 Interview-ready answer:**
> We store indices because we need to map results back to original positions. Using only values loses positional information, especially when duplicates exist.


## Question 6

- Difficulty: Medium+
- Topic: Stack / Histogram
- Pattern: Monotonic Stack (advanced)

### Problem Statement

Given an array `heights[]` representing histogram bars, return the largest rectangle area.

---

**Example 1:**

input:
heights: [2,1,5,6,2,3] 

output:
10

---

### Expectations

Brute force idea

Optimal using stack

Explain:
- Why we calculate width the way we do
- Left boundary & right boundary logic

**BRUTE FORCE**

refer (Code): [findMaxArea method](Question_6.java)  

TC: O(N<sup>3</sup>) ❌ TLE (Complexity is too high)

**Optimized Brute Force**

refer (Code): [findMaxArea_bruteFixed method](Question_6.java)


### Reframe Problem:

For each index i:

- height = heights[i]
- find:
  - left boundary → first smaller element on left
  - right boundary → first smaller element on right
- Then:
  - width = right - left - 1
  - area = heights[i] * width

#### Why this works?
We are treating each bar as:
> “What is the largest rectangle where I am the smallest bar?”


### Intuition (Crucial)

"We maintain a monotonic increasing stack of indices.
When we encounter a smaller height, it means the bar at the top can no longer extend further right.
So we pop it and calculate the area using:"
- current index as right boundary
- new stack top as left boundary

### Walkthrough
```text

heights = [2,1,5,6,2,3]
stack = []

i = 0 → 2
stack empty → push
stack = [0]



i = 1 → 1
1 < 2 → pop 0

Now:

height = 2
right = 1
left = -1 (stack empty)
width = 1 - (-1) - 1 = 1
area = 2 × 1 = 2

push 1
stack = [1]


i = 2 → 5
5 > 1 → push
stack = [1,2]


i = 3 → 6
6 > 5 → push
stack = [1,2,3]



i = 4 → 2
2 < 6 → pop 3

height = 6
right = 4
left = 2

width = 4 - 2 - 1 = 1
area = 6

still 2 < 5 → pop 2

height = 5
right = 4
left = 1

width = 4 - 1 - 1 = 2
area = 10 ✅

push 4
stack = [1,4]



i = 5 → 3
3 > 2 → push
stack = [1,4,5]

i = 6 → 0 (fake)
force pop everything

```

### Why do we calculate width as:
> right - left - 1 ?

**Because:**
- right = first smaller element on right ❌ (not included)
- left = first smaller element on left ❌ (not included)

**So valid region is:**
- (left + 1) → (right - 1)

**Evaluate:**
```text
(right-1) - (left+1) + 1
= right - left - 1
```

### Why do we pop when current height < stack top height?

#### My Answer (Half right but failed to explain why?)
- what this means is that what we are storing is all the indices where the peek of stack than curr num,
whenever we encounter a num which breaks the flow where the currheight is st.peek() we will pop until that currheight will be greater than the peek element of stack, so this is the logic behind monotonic increasing stack.

**Answer Validations:**
- I recognized this is a monotonic increasing stack ✅
- I understand that we pop when the “order breaks” ✅

#### ❌ What needs fixing

My  explanation says:
- “we pop until currheight will be greater than peek”
- That’s describing what happens, not why it happens.

#### 💡 The real reason (this is the key insight)
> "We pop because the current element becomes the right boundary for the popped element."


### Why do we push indices instead of heights in this problem?

### My Answer (Short Answer Not recommended in Interviews)
- for boundaries computation i guess.

### Complete Answer
- We store indices instead of heights because we need to calculate the width of the rectangle.
To compute width, we need left and right boundaries (indices), not just values.
Heights alone don’t tell us how far we can extend.
