package oops;

class Demo {
    String name; // instance field
    private int speed;

    void accelerate(int delta) {  // behaviour methods/functions
        speed += delta;
    }

    int getSpeed() {
        return speed;
    }
}

public class Class {
    public static void main(String[] args) {
        Demo dm1 = new Demo(); // Default constructor
        // Here dm1 is a object

        System.out.println("initial model: " + dm1.name + "\ninitial speed: " + dm1.getSpeed());
        // above will print null & 0 due to Default constructor


        dm1.accelerate(50);
        System.out.println(dm1.getSpeed()); // will return 50.
    }
}