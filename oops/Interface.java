package oops;

// Interface
interface Payment {
    void pay(int amount); // we will only show the method not implementation
}

class UPI_Payment implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("Paid amount: " + amount + " using UPI Payment");
    }
    // You need public before 'void'
    // you have to implement 'pay method' and override it for UPI Payment
}

class CREDIT_Payment implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("Paid amount: " + amount + " using Credit Card Payment.");
    }
}



public class Interface {
    public static void main(String[] args) {
        // Payment py1 = new Payment();
        // ❌ Compile Time Error: Cannot Instantiate it.

        Payment py2 = new UPI_Payment();
        py2.pay(50);

        Payment py3 = new CREDIT_Payment();
        py3.pay(100);
    }
}
