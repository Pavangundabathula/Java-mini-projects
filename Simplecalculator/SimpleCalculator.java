import java.util.*;

public class SimpleCalculator {
    public static void main(String[] args) {
        int choice;
        Scanner sc=new Scanner(System.in);
        System.out.println("This is Simple Calculator"+"\n"+"Here are the list of choices to perform some functions"+"\n"+"1.Add('+')"+"\n"+"2.Subtraction('-')"+"\n"+"3.Multiplication('*')"+"\n"+"4.Division('/')");
        System.out.print("Enter your choice: ");
        choice=sc.nextInt();
        System.out.print("Enter the first number: ");
        int number1 =sc.nextInt();
        System.out.print("Enter the Second number: ");
        int number2=sc.nextInt();
        int result=0;
        int count=0;
        int number;
        try{
        while(choice<6 && choice>0){
            switch(choice){
                case 1:
                if(count==0){
                    result=number1+number2;
                    count++;
                }
                else{
                    System.out.print("Enter the number to add to the result: ");
                    number=sc.nextInt();
                    result=result+number;
                }
                break;
                case 2:
                if(count==0){
                    result=number1-number2;
                    count++;
                }
                else{
                    System.out.print("Enter the number to Subtract the result: ");
                    number=sc.nextInt();
                    result=result-number;
                }
                break;
                case 3:
                if(count==0){
                    result=number1*number2;
                    count++;
                }
                else{
                    System.out.print("Enter the number to multiply with result: ");
                    number=sc.nextInt();
                    result=result*number;
                }
                break;
                case 4:
                if(count==0){
                    result=number1/number2;
                    count++;
                }
                else{
                    System.out.print("Enter the number to divide the result: ");
                    number=sc.nextInt();
                    result=result/number;
                }
                break;
                default:
                System.out.println("Please enter the correct choice");
                break;
            }
            System.out.println("Result is: "+result);
            System.out.print("Do u want to do any other function ? yes(y)/no(n) : ");
            sc.nextLine();
            String c=sc.nextLine();
            if(c.equals("y") || c.equals("Y")){
                System.out.print("Enter the choice: ");
                choice=sc.nextInt();
            }
            else{
                break;
            }
        }
    }
    catch(Exception e){
        System.out.println("Dont divide with Zero");
    }
    }
    
}