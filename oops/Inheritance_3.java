package oops;

/* Hierarchical Inheritance  */
/*

        A
        |
      __|__    
      |   |
      B   C

      B,C are child of A

*/
class Machine {
    void process() {
        System.out.println("I do processing");
    }
}

class Mobile extends Machine {
    void location() {
        System.out.println("I can support person location using my sensor.");
    }
}

class Laptop extends Machine {
    void compute() {
        System.out.println("I can do heavy computation");
    }
}

public class Inheritance_3 {
    public static void main(String[] args) {
        Mobile mb1 = new Mobile();
        mb1.process(); // from Machine class (parent)
        mb1.location(); // from Mobile class (self class)

        Laptop lp1 = new Laptop();
        lp1.process(); // from Machine class (parent)
        lp1.compute(); // from Mobile class (self class functions/methods)
    }
}
