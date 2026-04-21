package oops;

/* COMPILE TIME POLYMORPHISM */

class Addition {
    
    // method 1: (int, int) - Overloaded with (int,int)
    int add(int a, int b) {
        System.out.println("int int");
        return a + b;
    }

    // method 2: Overloaded with (double, double)
    double add(double a, double b) {
        System.out.println("double double");
        return a + b;
    }

    // method 3: Overloaded with (int, int, int)
    int add(int a, int b, int c) {
        System.out.println("int int int");
        return a + b + c;
    }

}


/* RUNTIME POLYMORPHISM */

class Animal {
    void sound() {
        System.out.println("My name is Animal.");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("My name is Dog.");
    }
}

public class Polymorphism_1 {
    public static void main(String[] args) {
        // This is just simple method signature
        // Addition add1 = new Addition();
        // add1.add(12.5, 11.0);
        // add1.add(12, 11);
        // add1.add(12, 11, 13);   


        Dog dg1 = new Dog();
        dg1.sound(); // This will override Parent Class method sound()

        Animal dg2 = new Dog();
        dg2.sound(); // This will also overrid Parent class method sound()



    }
}
