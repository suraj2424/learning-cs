# JavaScript Questions & Answers

## Index
- [Q1: What is difference between `process.nextTick()`, `setImmediate()`, and `setTimeout()`](#q1)
- [Q2: What is difference between `cluster` and `worker_threads` in NodeJS](#q2)
- [Q3: What happens when you call `require()` multiple times for the same module](#q3)
- [Q4: How does NodeJS handle asynchronous errors inside async callbacks or promises?](#q4)
- [Q5: Explain event loop in NodeJS and how it is different from the browser's event loop](#q5)

<details>
<summary id="q1"><strong>Q1: What is difference between `process.nextTick()`, `setImmediate()`, and `setTimeout()`</strong></summary>

**Answer:**

- `process.nextTick()` queues a **micro‑task** that runs **immediately after the current call stack** finishes, **before the event‑loop proceeds to the next phase**. It has the highest priority among the three and can starve I/O if overused.
- `setImmediate()` schedules a **callback** to be executed in the **`check` phase** of the event loop, **after I/O callbacks** have been processed. It is useful for deferring work that should run **after the current poll phase**.
- `setTimeout(callback, delay)` schedules a **timer** that fires in the **`timers` phase**. The delay is a minimum; the callback will run **after at least `delay` ms** and after the timers phase has been processed.

**Typical ordering** (when all are scheduled from the same turn of the event loop):
```
process.nextTick()
Promise.then()   // also a micro‑task
setImmediate()
setTimeout(..., 0)
```

**Key exception:** In an I/O callback (e.g., inside `fs.readFile`), `setImmediate()` is guaranteed to execute **before** a `setTimeout(..., 0)` because the `check` phase runs right after the poll phase, whereas the timers phase runs on the next loop iteration.

---
</details>

<details>
<summary id="q2"><strong>Q2: What is difference between `cluster` and `worker_threads` in NodeJS</strong></summary>

**Answer:**

- **`cluster`**
  - Spawns **separate Node.js processes** (each with its own V8 instance, memory heap, and event loop).
  - Useful for **scaling across CPU cores** and providing fault isolation—if one worker crashes, others keep running.
  - Communication happens via **inter‑process messaging (IPC)** using `process.send`/`process.on('message')`.
  - Higher overhead than threads because of separate process start‑up costs and memory duplication.
- **`worker_threads`**
  - Creates **lightweight threads** within a single Node.js process; all workers share the **same memory heap**.
  - Suitable for **CPU‑bound work** where you need to off‑load heavy calculations but still want fast data sharing via `SharedArrayBuffer` or `MessageChannel`.
  - Lower overhead compared to `cluster` but requires careful synchronization to avoid race conditions.
  - Workers can be terminated independently, but a crash in a worker can affect the main process unless properly caught.

**When to use which:**
- Use **`cluster`** for **network‑bound servers** that benefit from process isolation and want to leverage multiple cores without sharing state.
- Use **`worker_threads`** for **CPU‑intensive tasks** where sharing data (e.g., large buffers) is advantageous and you can manage concurrency.

---
</details>

<details>
<summary id="q3"><strong>Q3: What happens when you call `require()` multiple times for the same module</strong></summary>

**Answer:**

1. On the **first `require`**, Node.js **loads the file**, **executes it**, and **caches the exported object** in `require.cache` using the module’s resolved filename as the key.
2. Subsequent `require` calls for the **same resolved path** return the **cached `module.exports` object**, so the module behaves like a **singleton**.
3. Because the same object reference is returned, **state mutations persist** across files (as shown in the example with `counter.count`).
4. The cache can be **invalidated** manually (`delete require.cache[require.resolve('./module')]`) which forces a fresh load on the next `require`.
5. Circular dependencies are handled by providing a **partial export** during the loading phase, which can lead to `undefined` values if not careful.

---
</details>

<details>
<summary id="q4"><strong>Q4: How does NodeJS handle asynchronous errors inside async callbacks or promises?</strong></summary>

**Answer:**

- **Callbacks** – Follow the **error‑first pattern**: the first argument is an `Error` object (or `null` if no error). You must check this argument before proceeding.
- **Promises / `async`‑`await`** – Errors are captured as **rejections**. They can be handled with:
  - `.catch()` on the promise chain.
  - `try`/`catch` blocks surrounding `await` calls.
- **Uncaught rejections** – If a promise rejection is not handled, Node emits a **`'unhandledRejection'`** event on the `process` object. You can listen to it (`process.on('unhandledRejection', handler)`) to log or clean up resources.
- **Uncaught exceptions** – Errors thrown inside callbacks that are not caught propagate to the **`'uncaughtException'`** event. Using this as a safety net is discouraged; prefer proper error handling.
- **Domains** – The deprecated **`domain`** module was an earlier way to catch async errors across multiple callbacks, but modern code should rely on the above mechanisms.

---
</details>

<details>
<summary id="q5"><strong>Q5: Explain event loop in NodeJS and how it is different from the browser's event loop</strong></summary>

**Answer:**

- **Node.js Event Loop Phases** (in order for each iteration):
  1. **`timers`** – Executes callbacks scheduled by `setTimeout` and `setInterval` whose timers have expired.
  2. **`pending callbacks`** – Executes I/O callbacks deferred to the next loop iteration.
  3. **`idle, prepare`** – Internal use only.
  4. **`poll`** – Retrieves new I/O events; executes I/O callbacks (except close callbacks). If the poll queue is empty, the loop will either wait for callbacks or proceed.
  5. **`check`** – Executes `setImmediate` callbacks.
  6. **`close callbacks`** – Executes `close` events like `socket.on('close')`.
- **Micro‑tasks** (`process.nextTick` and Promises) are processed **after each phase** before the loop continues to the next phase.
- **Browser Event Loop**
  - Consists of **tasks** (macrotasks) and **microtasks**. After a task runs, the browser processes **all microtasks** (`Promise.then`, `MutationObserver`, etc.) before rendering and moving to the next task.
  - The browser has a **rendering phase** that updates the UI, which does not exist in Node.
- **Key differences**:
  - Node has **multiple distinct phases** to handle I/O, timers, and checks, giving finer‑grained control over when callbacks run.
  - Browsers have a **single task queue** and a dedicated **render** step; they do not expose the same low‑level phases.
  - Node’s loop runs **continuously** on the server side, processing I/O without a UI, whereas the browser loop is tied to the frame rate and UI rendering.

---
</details>

*Content hidden by default – click each question to expand the answer.*
