/* variable shadowing */
/** var can shadowed */
var a = 5;
let flag = true
while(flag) {
    let a = 7;
    console.log(a) // output 7
    flag = false
}
console.log(a);




/* but for let */
let b = 10;
let flag2 = true
while(flag2) {
    var b = 16;
    console.log(b); // output: 
    flag2 = false
}
console.log(b) // output: 