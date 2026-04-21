package oops;

/* RUNTIME POLYMORPHISM */

class Battery {
    Battery() {
        System.out.println("Device Battery");
    }
}

class LithiumIon extends Battery {
    LithiumIon() {
        System.out.println("LithiumIon Battery");
    }
}

class Device {
    void charge() {
        System.out.println("Device is charging...");
    }
    Battery battery() {
        return new Battery();
    }
}

class Laptop extends Device {
    void charge() {
        System.out.println("Laptop is charging.");
    }
    LithiumIon battery() {
        return new LithiumIon();
    }
}

class Phone extends Device {
    void charge() {
        System.out.println("Phone is charging.");
    }
    LithiumIon battery() {
        return new LithiumIon();
    }
}

public class Polymorphism_2 {
    public static void main(String[] args) {
        Device D;
        D = new Device();
        D.charge(); // Device is charging...
        D.battery(); // Device Battery.
        System.out.println("--------------");
        D = new Laptop();
        D.charge(); // Laptop is charging.
        D.battery(); // LithiumIon Battery
        System.out.println("--------------");
        D = new Phone();
        D.charge(); // Phone is charging.
        D.battery(); // LithiumIon Battery
    }
}
