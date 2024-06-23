import java.util.*;
import java.io.*;

public class Password_generator {
    public static String Uppercase_alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String Lowercase_alpha="abcdefghijklmnopqrstuvwxyz";
    public static String numbers="1234567890";
    public static String Symbols="!@#$%^&*-()_+=<>?";
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Random Password generator");
        System.out.print("Enter numbers of Letters in password:");
        int letters_no=sc.nextInt();
        System.out.print("Enter numbers of Symbols in password:");
        int symbols_no=sc.nextInt();
        System.out.print("Enter numbers of numbers in password:");
        int numbers_no=sc.nextInt();
        String str=generator(1, letters_no)+generator(2, symbols_no)+generator(3, numbers_no);
        System.out.print("The Password is: ");
        System.out.println(str);
    }
    public static String generator(int choice,int letters){
        String str="";
        switch (choice) {
            case 1:
                for(int i=0;i<letters;i++){
                    int r=(int)(Math.random()*26);
                    if(i==0){
                        str=str+Uppercase_alpha.charAt(r);
                    }
                    else{
                        str=str+Lowercase_alpha.charAt(r);
                    }
                    
                }
                break;
                case 2:
                    for(int i=0;i<letters;i++){
                        int r=(int)(Math.random()*17);
                        str=str+Symbols.charAt(r);
                    }
                    break;
                case 3:
                    for(int i=0;i<letters;i++){
                        int r=(int)(Math.random()*10);
                        str=str+numbers.charAt(r);
                    }
                    break;
            default:
                break;
        }
        return str;
    }
}
