package oops;

class Outer {
    private static String staticMsg = "Hello";
    private String instanceMsg = "World";

    // 1. Static Nested Class
    static class StaticNested {
        void display() {
            System.out.println(staticMsg); // OK
            // System.out.println(instanceMsg); // Error: Cannot access non-static
        }
    }

    // 2. Member Inner Class
    class Inner {
        void display() {
            System.out.println(staticMsg + " " + instanceMsg); // OK: Accesses both
        }
    }
}

// public class NestedClass {
    
// }
