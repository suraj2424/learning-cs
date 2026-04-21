package oops;

/*

Multi Level Inheritance

B
|
C
|
D
|
E
|
... so on

*/

class LivingBeing {
    void breathe() {
        System.out.println("A living being can breathe.");
    }
}

class Human extends LivingBeing {
    void eat() {
        System.out.println("A Human can eat.");
    }
}

class Employee extends Human {
    void work() {
        System.out.println("A employee works in a office.");
    }
}

public class Inheritance_2 {
    public static void main(String[] args) {
        Employee emp1 = new Employee();
        emp1.breathe(); // From LivingBeing
        emp1.eat(); // From Human
        emp1.work(); // From Employee
    }
}
