/* Q1 What is difference between process.nextTick(), setImmediate(), and setTimeout()  */
// tests understanding of the event loop.

// event loop is used in js for Asynchronous Programming.

// one cycle of event loop is called tick

// event loop has multiple phases idle, check, cold, close

/* process.nextTick() adds a callback to the microtask queue. giving it the highest priority. 
It executes immediately after the current operation finishes, before moving to the next phase of the event loop  */

/* setImmediate() scheduled to run in the check phase of event loop */

/* setTimeout() scheduled to run in timers phase */

/* Key Exception: In an I/O cycle 
(e.g., inside an fs.readFile callback), setImmediate() is guaranteed to execute before setTimeout(). */




// Event loop order of execution
// process.nextTick()
// setImmediate()
// setTimeout()






/* Q2 What is difference between `cluster` and `worker_threads` in NodeJS  */
// for cluster lets say we have a single module index.js and its running a heavy code which is processing over 10000 lines.

/*

Cluster: Creates multiple instances of the Node.js application (multiple processes) to utilize 
multiple CPU cores, helping with concurrency and handling blocked main threads.


Worker Threads: Allows a single Node.js process to run heavy calculations in separate threads, 
preventing the main event loop thread from becoming blocked.

*/




/* Q3 What happens when you call require() multiple times for the same module */

/*

ex.
// counter.js
module.exports = { count: 0 };



// fileA.js
const counter = require("./counter");
counter.count++;


// fileB.js
const counter = require("./counter");
counter.count++; // Output: 1


// ANSWER
When you require a module for the first time, Node.js loads, executes, and caches it in 
require.cache. Subsequent require calls for the same module return the cached instance, 
making modules singletons by default.

*/





/* Q4 How does NodeJS handle asynchronous errors inside async callbacks or promises? */

/*

Callbacks: Use the error-first callback pattern, where the first parameter is reserved for the error object.
Promises/Async-Await: Use try/catch blocks. If an asynchronous rejection is not caught, 
it triggers an unhandledRejection event.

*/


/* Q5 Explain event loop in NodeJS and how its different from the browsers event loop  */

/*

if the call stack is empty we have two queues.
one is MICROTASK QUEUE (Has Higher priority) (Promises, Mutations, Observer related callbacks are added)
and another one is MACROTASK QUEUE (Any asychronous operations are added)


While both manage asynchronous tasks, the Node.js event loop is more complex, 
featuring six distinct phases (Timer, Pending Callbacks, Idle, Poll, Check, and Close) to handle I/O and system operations.
The browser loop is primarily focused on rendering and user interaction events, which Node.js lacks.


6 PHASES REMEMBER ABBREVIATION: (TPI PCC)

*/