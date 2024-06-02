import java.util.*;
public class BMI{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("BMI - Body Mass Index");
        System.out.print("Enter Your Weight in kilograms: ");
        double w=sc.nextDouble();
        System.out.print("Enter your height in meters: ");
        double h=sc.nextDouble();
        double b=w/(h*h);
        System.out.printf("Your BMI is: %.2f",b);
    }
}