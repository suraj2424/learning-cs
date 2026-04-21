package oops;

class A {
    final int SPEED_LIMIT = 45;
    void updatedSpeed() {
        // SPEED_LIMIT = 60; // error
    }

    final void display() {
        System.out.println("Parent Display");
    }
}

class B extends A {
    // void display(); // cannot override
}

final class C {

}

// class D extends C {

// }


public class Final {
    // public static void main(String[] args) {
        
    // }
}
