import java.util.*;

public class tempcon {
    public static void main(String[] args) {
        System.out.println("Tmeperature Conevntor");
        System.out.println("1.Celsius(°C) to Fahrenheit(°F) "+"\n"+"2.Celsius(°C) to Kelvin(K) "+"\n"+"3.Fahrenheit (°F) to Celsius (°C)"+"\n"+"4.Fahrenheit (°F) to Kelvin(K)"+"\n"+"5.Kelvin(K) to Celsius (°C)"+"\n"+"6.Kelvin(K) to Fahrenheit (°F)");
        System.out.print("Enter your choice: ");
        Scanner sc=new Scanner(System.in);
        int choice=sc.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter the Temperature in Celius: ");
                double celius=sc.nextDouble();
                double fahrenheit=(celius*(9.0/5.0))+32.0;
                System.out.println(celius+"°C in Fahrenheit "+fahrenheit+"°F");
                break;
            case 2:
                System.out.print("Enter the Temperature in Celius: ");
                celius=sc.nextInt();
                double kelvin=celius+273.15;
                System.out.println(celius+"°C in Kelvin "+kelvin+"K");
                break;
            case 3:
                System.out.print("Enter the Temperature in Fahreheit: ");
                fahrenheit=sc.nextDouble();
                celius=((fahrenheit -32.0)*(5.0/9.0));
                System.out.println(fahrenheit+" °F in Celius is: "+celius+"°C");
                break;
            case 4:
                System.out.println("Enter the Temperature in Fahrenheit: ");
                fahrenheit=sc.nextDouble();
                kelvin=((fahrenheit -32.0)*(5.0/9.0))+273.15;
                System.out.println(fahrenheit+" °F in Kelvin K is:"+kelvin+"K");
                break;
            case 5:
                System.out.print("Enter the Temperature in Kelvin: ");
                kelvin=sc.nextDouble();
                celius=(kelvin-273.15);
                System.out.println(kelvin+" K in Celius is: "+celius+"°C");
                break;
            case 6:
                System.out.print("Enter the Temperature In Kelvin: ");
                kelvin=sc.nextDouble();
                fahrenheit=((kelvin - 273.15)*(9.0/5.0))+32.0;
                System.out.println(kelvin+"K in Fahrenhiet is: "+fahrenheit+"°F");
                break;
            default:
                System.out.println("Enter the right choice");
                break;
        }
    }
}
