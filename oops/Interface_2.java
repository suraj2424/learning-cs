package oops;

/* Multiple Inheritance with the help of Interface */

interface Printer {
    void print(String s);
    void switchOn();
}

interface Scanner {
    void scan(String s);
    void switchOn(String s);
}

class MultifunctionMachine implements Printer, Scanner {

    @Override
    public void print(String s) {
        System.out.println("Printing: " + s);
    }

    public void scan(String s) {
        System.out.println("Scanning: " + s);
    }

    public void switchOn() {
        System.out.println("Switching On");
    }
    public void switchOn(String s) {
        System.out.println("Switching On: " + s);
    }
}

public class Interface_2 {
    public static void main(String[] args) {
        MultifunctionMachine mcm1 = new MultifunctionMachine();
        mcm1.print("How are you");
        mcm1.scan("Record.pdf");
    }

}
