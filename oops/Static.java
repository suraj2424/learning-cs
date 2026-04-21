package oops;

class Student {

    // Static initializations
    static String name;
    static String university;

    // Static Block -> Only runs once when program starts
    static {
        System.out.println("Static block invoked.");
        name = "Suraj Suryawanshi";
        university = "IIIT Vadodara";
        // getUniversityGreet();
    }

    // Default Constructor
    String subject;
    int rollNumber;
    Student(String subject, int rollNumber) {
        this.subject = subject;
        this.rollNumber = rollNumber;
    }

    static void getUniversityGreet(){
        System.out.println("Hello and welcome to university: " + university);
    }

    void printSubject(){
        // getUniversityGreet(); // you can call this inside non-static method
        // above method call is static
        // Non static methods can call static methods
        // But static methods can not call non-static variables/functions
        System.out.println("Subject is: " + subject);
    }
}

public class Static {
    public static void main(String[] args) {

        // call & get any static variable/method value directly without need of object instance
        System.out.println();
        // System.out.println("University: " + Student.university);


        // also get any method output
        // Student.getUniversityGreet();


        Student std1 = new Student("Maths", 48);
        std1.printSubject();

    }
}