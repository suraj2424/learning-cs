public class GCD {
    static int gcd(int a, int b) {
        while(b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
    public static void main(String[] args) {
        int a = 28;
        int b = 18;
        System.out.println("Answer of GCD(" + a + ", " + b + "): " + gcd(a, b));
    }    
}
