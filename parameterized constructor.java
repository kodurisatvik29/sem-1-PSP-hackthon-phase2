import java.util.Scanner;

class Student {
    String studentName, courseName;
    int rollNumber, courseCredits;
    double marks;

    public Student(String studentName, int rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    public boolean checkEligibility() {
        return marks >= 50;
    }

    public double calculateFee() {
        return courseCredits * 1500;
    }

    public double calculateScholarship() {
        double fee = calculateFee();
        if (marks >= 85) return fee * 0.20;
        if (marks >= 70) return fee * 0.10;
        return 0;
    }

    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    public void displayDetails() {
        System.out.println("Name: " + studentName + "\nRoll No: " + rollNumber + "\nMarks: " + marks);
        System.out.println("Course: " + courseName + "\nCredits: " + courseCredits);
        System.out.println("Eligible: " + checkEligibility());
        System.out.println("Fee: Rs. " + calculateFee());
        System.out.println("Scholarship: Rs. " + calculateScholarship());
        System.out.println("Final Fee: Rs. " + calculateFinalFee());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name, Roll No, Marks, Course Name, Credits: ");
        Student s = new Student(sc.next(), sc.nextInt(), sc.nextDouble(), sc.next(), sc.nextInt());

        if (s.checkEligibility()) {
            s.displayDetails();
        } else {
            System.out.println("Student is not eligible for registration.");
        }
        sc.close();
    }
}