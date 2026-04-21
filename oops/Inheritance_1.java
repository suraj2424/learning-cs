package oops;

/* Single Level Inheritance */

class Animal {
    private void hear() {
        System.out.println("Animal hears a sound");
    }
    void eat() {
        System.out.println("Animal eats food.");
    }
}

class Dog extends Animal { // Single Inheritance
    void bark() {
        System.out.println("Dog barked!");
    }
} // Here 'Dog' class is Child Class

public class Inheritance_1 {
    public static void main(String[] args) {
        Dog dg1 = new Dog();
        dg1.eat(); // From Animal
        dg1.bark(); // From Dog
//❌    dg1.hear(); // cannot call

    }
}