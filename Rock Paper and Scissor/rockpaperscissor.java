import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

class Score implements Serializable{
    int wins=0;
    int loses=0;
    int ties=0;
    public void update(String result){
        if(result.equals("Tie")){
            ties++;
        }
        else if(result.equals("Win")){
            wins++;
        }
        else if(result.equals("Lose")){
            loses++;
        }
    }
    public void display(){
        System.out.println("Wins: "+wins+"\nLoses: "+loses+"\nTies: "+ties);
    }
}
public class rockpaperscissor {
    public static Score obj=new Score();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            while(true){
                System.out.println("Choices: \n"+"1.Play Game\n2.Score\n3.Quit Game");
                System.out.print("Enter ur choice: ");
                int choice=sc.nextInt();
                loadscore();
                switch (choice) {
                    case 1:
                        System.out.print("Enter r(Rock) or p(Paper) or s(Scissor): ");
                        sc.nextLine();
                        String ur_choice=sc.nextLine();
                        ur_choice=ur_choice.toLowerCase();
                        if(!ur_choice.equals("r") && !ur_choice.equals("p") && !ur_choice.equals("s")){
                            System.out.println("--------------------------------------------");
                            System.out.println("Only enter r(Rock) or p(Paper) or s(Scissor)");
                            System.out.println("--------------------------------------------");
                            break;
                        }
                        String computer_choice=choice();
                        String result=tocompare(ur_choice, computer_choice);
                        System.out.println("--------------------------------------");
                        toprint(ur_choice, computer_choice);
                        System.out.println("You "+result);
                        obj.update(result);
                        obj.display();
                        System.out.println("--------------------------------------");
                        savescore();
                        break;
                    case 2:
                        System.out.println("--------------------------------------");
                        obj.display();
                        System.out.println("--------------------------------------");
                        break;
                    case 3:
                        savescore();
                        return;
                    default:
                        System.out.println("Enter right choice");
                        break;
                }
            }
        }
        catch(Exception e){
            System.out.println("Error: "+e);
        }
        
    }
    public static String choice(){
        String[] arr={"r","p","s"};
        int comp=(int)(Math.random()*3);
        return arr[comp];
    }
    public static String tocompare(String ur_choice,String computer_choice){
        if(ur_choice.equals(computer_choice)){
            return "Tie";
        }
        else if(ur_choice.equals("r") && computer_choice.equals("s") || ur_choice.equals("p") && computer_choice.equals("r") || ur_choice.equals("s") && computer_choice.equals("p")){
            return "Win";
        }
        else{
            return "Lose";
        }
    }
    public static void toprint(String ur,String com){
        if(ur.equals("r")){
            ur="Rock";
        }
        else if(ur.equals("p")){
            ur="Paper";
        }
        else{
            ur="Scissor";
        }
        if(com.equals("r")){
            com="Rock";
        }
        else if(com.equals("p")){
            com="Paper";
        }
        else{
            com="Scissor";
        }
        System.out.println("Your move: "+ur+" - Computer move: "+com);
    }
    public static void savescore(){
        try(FileOutputStream fout=new FileOutputStream("score.txt");
            ObjectOutputStream oos=new ObjectOutputStream(fout)){
                oos.writeObject(obj);
        }
        catch(Exception e){
            System.out.println("Error: 1"+e);
        }
    }
    public static void loadscore(){
        try(FileInputStream fin=new FileInputStream("score.txt");
        ObjectInputStream ois=new ObjectInputStream(fin)){
            obj=(Score)ois.readObject();
        }
        catch(Exception e){
            System.out.println("Error: 1"+e);
        }
    }
}
