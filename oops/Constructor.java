package oops;

class Vehicle {
    String model;
    private int speed; // instance fields

    // custom default constructor
    Vehicle() {
        model = "NISSAN";
        speed = 40;

        System.out.println("This is called.");
    }

    // parameterised constructor
    Vehicle(String model, int speed) {
        this(); // if we change the parameters to (model,speed) in this method it will execute recursive constructor invocation
        this.model = model;
        this.speed = speed;
    }


    // behoviour methods
    void accelerate(int delta) { 
        speed += delta;
    }

    String getModel() {
        return model;
    }

    int getSpeed() {
        return speed;
    }


    // copy constructor
    Vehicle(Vehicle that) {
        this.model = that.model;
        this.speed = that.speed;
    }
}

public class Constructor {

    static void print(int topGap, int bottomGap) {
        for(int i=0; i<topGap; i++) {
            System.out.println();
        }

        System.out.println(">-------------------------------------------------<");

        for(int i=0; i<bottomGap; i++) {
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Vehicle vh1 = new Vehicle(); // Default Constructor

        // or we can siply construct our own custom constructor
        // refer line 7
        print(1,0);
        System.out.println("      DEFAULT CONSTRUCTOR   ");
        print(0, 1);
        System.out.println("Default values: \nmodel name: " + vh1.getModel() + "\nmodel speed: " + vh1.getSpeed());
        print(1,0);



        // Parameterised Constructor
        System.out.println("      PARAMETERISED CONSTRUCTOR          ");
        print(0,1);
        Vehicle vh2 = new Vehicle("TATA", 45);

        System.out.println("Parameterised values: \nmodel name: " + vh2.getModel() + "\nmodel speed: " + vh2.getSpeed());
        print(1, 0);
        

        // copy constructor
        System.out.println("      COPY CONSTRUCTOR");
        print(0, 1);
        Vehicle vh3 = new Vehicle(vh2);
        System.out.println("Copy Constructor values: \nmodel name: " + vh3.getModel() + "\nmodel speed: " + vh3.getSpeed());
        print(1, 1);




        // Dont copy like this
        Vehicle vh4 = vh2;
        // above will just point to vh2 rather than having its separate values


        // this() method is a constructor
        // will call only inside another constructor




    }
}
