
# "PATTERN FIRST" STUDY

**1. The Restatement (2 min)**
- Do not write code immediately. Write down (or speak out loud) exactly what the input is, what the output should be, and what the constraints are.

**2: Pattern Identification (3-5 mins)**
- Ask yourself: Does this look like something I've seen before? (e.g., Is this a search problem? A sliding window? A graph traversal?)
- If you are stuck for more than 15 minutes, look at the hint or the discussion tab, but do not copy the code. Look only for the name of the technique used.

**3: The "Whiteboard" Logic**
- Once you know the technique, draft the logic on paper or a doc. Define the variables, the loop conditions, and the edge cases. Only after this, write the actual code.

**4: Post-Solve Reflection (Crucial)**
- After the problem is "Accepted," ask: Why did this pattern work here? What was the specific trigger in the problem description that hinted at this approach?

---

# Build Your "Pattern Library"
- Create a personal notebook or a simple document. For every major pattern (like Two Pointers, Sliding Window, DFS/BFS, or Dynamic Programming), create a "template" entry:

---

# The Rules of Engagement for Retention
- To stop "forgetting" the problems you've already solved:

### Spaced Repetition: 
- If you solved a problem today, try to solve it again from scratch 3 days later. If you struggle, you didn't learn the pattern; you memorized the implementation.

### The "One-Variation" Rule: 
- After solving a problem, try to change the constraints. What if the array wasn't sorted? What if I needed all occurrences instead of just one? This forces your brain to understand the logic rather than the syntax.

### Simulate the Interview: 
- Spend time explaining your solution out loud as if you were speaking to an interviewer. If you can't explain the "Why" behind your approach (the time/space complexity trade-offs), you are not ready for a real interview.

---

# The 4-Step Whiteboard Process

---

## 1. Define the State
Before writing a single line of code, identify what data you need to track to reach the answer.

- **What are my variables?**
  (e.g., `max_sum`, `left_pointer`, `visited_set`, `current_path`).
- **What is the initial state?**
  (e.g., Do I start `left` at 0? Do I need a dummy head for the Linked List?)

---

## 2. Walk Through the "Happy Path"
Pick a simple, representative example from the problem description. Trace it step-by-step on paper or in a comment block.

- **Do not simulate in your head.** Write:
  > "Step 1: `i=0`, `value=5`, so I add 5 to my hashmap.
  > Step 2: `i=1`, `value=2`, check hashmap for target..."
- **Outcome:** You will often discover that your initial approach misses a detail (e.g., *"Oh, if I add it to the hashmap before checking the condition, I'll count the same element twice"*).

---

## 3. Stress Test the Edge Cases
Before coding, define how your logic handles the "weird" inputs. Ask:
- What happens if the input is **empty or null**?
- What if the input has **only one element**?
- What if **all elements are identical**?
- What if the answer is **negative** or requires **integer overflow handling**?

---

## 4. The Complexity Check
Look at your planned steps.
- How many times does your loop run?
- Are you doing redundant work inside the loop (like re-scanning an array)?
- **Outcome:** You should be able to state your time and space complexity (`O(N)`, `O(log N)`, etc.) before you type the code.

---

## Expected Outcomes
You have successfully executed **"Whiteboard Logic"** if, at the end of this phase, you can answer **"Yes"** to these three questions:

1. **The "Blind Coding" Test:**
   Can I write the entire solution based only on my notes, without having to stop and think about the logic again?
   *If you have to stop to "figure it out" while typing, you didn't finish the whiteboard phase.*

2. **The Debug-in-Head Test:**
   If I look at my planned steps, can I trace a dry run (mentally or on paper) and find the exact point where a bug would occur?

3. **The Language-Agnostic Test:**
   Is my logic clear enough that I could explain it to someone who doesn't know the programming language I'm using?
   *(Logic is language-independent; syntax is just the vessel.)*