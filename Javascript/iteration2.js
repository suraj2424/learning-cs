/* ( Var, Let and Const ) - Hoisting, Scoping, Shadowing and more */

/* var existed from the start */
/* `let` and `const` introduced in es6 */ 

/* 

es - ECMAScript - scripting specification that powers javascript

es5 - 2009
es6 - 2016


*/



/* Function scope */
function name(params) {

}


/* Block Scope */
{

}




/* 

var
- functional/global scope



let and const
- block scope

*/



/* Lets test 

var a = 5

{
    console.log(a); // return 5
}

*/


/*

{

    var a = 5

}

console.log(a) // return 5

*/






/*


now for let and const



{
    let a = 5
}

console.log(a) // ReferenceError: a is not defined

*/






/* similarly

{
    const b = 25
}

console.log(b) // ReferenceError: b is not defined
*/




/* But if i move let and const inside block */
/*
{
    let a = 5
    console.log(a) // return 5
}


// similarly
{
    const a = 5
    console.log(a)
}
*/