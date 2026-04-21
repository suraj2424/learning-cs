package oops;

class Food {
    void eat() {
        System.out.println("eat delicious food.");
    }
}

class Roti extends Food {
    void eat() {
        super.eat();
    }
}

class X {
    int speed = 50;
    X() {
        System.out.println("X is called");
    }
    X(String s) {
        System.out.println("Hey! " + s);
    }
}

class Y extends X {
    Y() {
        super("Suraj");
    }
}

public class Super {
    public static void main(String[] args) {
        Roti rt1 = new Roti();
        rt1.eat();


        Y y1 = new Y();

    }
}
