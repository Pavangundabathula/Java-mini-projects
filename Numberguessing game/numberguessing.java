import java.util.*;

public class numberguessing {
    public static void main(String[] args) {
        System.out.println("Number-Guessing Game : ");
        System.out.println("--------------------");
        System.out.println("Enter the number betwwen 0 to 10");
        Scanner sc=new Scanner(System.in);
        int user=sc.nextInt();
        double b=Math.random()*10;
        int computer=(int) b;
        if(user==computer){
            System.out.println("You won , your guess is right");
        }
        else{
            System.out.println("You Lose,Better luck next Time");
            System.out.println("Answer is "+computer);
        }
    }
}
