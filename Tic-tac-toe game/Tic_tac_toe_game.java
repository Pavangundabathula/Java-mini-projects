import java.io.*;
import java.util.*;

class Score implements Serializable{
    int wins;
    int loses;
    public void todisplay(){
        System.out.println("Wins: "+wins+" - Loses: "+loses);
    }
}
public class Tic_tac_toe_game {
    public static String[][] arr=new String[3][3];
    public static Score score=new Score();
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        loadscore();
        System.out.println("Choices:\n1.Play the Game\n2.Score\n3.Quit");
        System.out.print("Enter ur choice: ");
        int choice=sc.nextInt();
        while(true){
            if(choice==1){
                int count=1;
                for(int i=0;i<arr.length;i++){
                    for(int j=0;j<arr[i].length;j++){
                        arr[i][j]="-";
                        System.out.print(count+" | ");
                        count++;
                    }
                    System.out.println("\n-----------");
                }
                while(true){
                    System.out.print("Enter where u want to select: ");
                    int ur_choice=sc.nextInt();
                    int computer_choice;
                    if(allot(ur_choice, "X")){
                        boolean is_avail=false;
                        if(is_empty()){
                            while(!is_avail){
                                computer_choice=(int)(Math.random()*9);
                                is_avail=allot(computer_choice,"O");
                            }
                        }
                        for(int i=0;i<arr.length;i++){
                            for(int j=0;j<arr[i].length;j++){
                                if(!arr[i][j].equals("-")){
                                    System.out.print(arr[i][j]+" | ");
                                }
                                else{
                                    System.out.print("- | ");
                                }
                            }
                            System.out.println("");
                            System.out.println("-----------");
                        }
                        if(result("X")){
                            score.wins++;
                            System.out.println("You won");
                            score.todisplay();
                            System.out.println("-----------");
                            break;
                        }
                        else if(result("O")){
                            score.loses++;
                            System.out.println("Computer Won");
                            score.todisplay();
                            System.out.println("-----------");
                            break;
                        }
                        savescore();
                    }
                    else if(ur_choice==0 || ur_choice>9){
                        System.out.println("Enter Only 1 to 9");
                    }
                    else{
                        System.out.println("Enter values which are Empty blocks");
                    }
                }
                System.out.println("Choices:\n1.Re-Play the Game\n2.Score\n3.Quit");
                System.out.print("Enter ur choice: ");
                choice=sc.nextInt();
            }
            else if(choice==2){
                System.out.println("------------------");
                score.todisplay();
                System.out.println("------------------");
                System.out.println("Choices:\n1.Play the Game\n2.Score\n3.Quit");
                System.out.print("Enter ur choice: ");
                choice=sc.nextInt();
            }
            else{
                savescore();
                break;
            }
        }
    }
    public static boolean allot(int ur_choice,String value){
        boolean is_avail=false;
        switch (ur_choice) {
            case 1:
                if(arr[0][0].equals("-")){
                    arr[0][0]=value;
                    is_avail=true;
                }
                break;
            case 2:
                if(arr[0][1].equals("-")){
                    arr[0][1]=value;
                    is_avail=true;
                }
                break; 
            case 3:
                if(arr[0][2].equals("-")){
                    arr[0][2]=value;
                    is_avail=true;
                }
                break;
            case 4:
                if(arr[1][0].equals("-")){
                    arr[1][0]=value;
                    is_avail=true;
                }
                break; 
            case 5:
                if(arr[1][1].equals("-")){
                    arr[1][1]=value;
                    is_avail=true;
                }
                break;   
            case 6:
                if(arr[1][2].equals("-")){
                    arr[1][2]=value;
                    is_avail=true;
                }
                break;
            case 7:
                if(arr[2][0].equals("-")){
                    arr[2][0]=value;
                    is_avail=true;
                }
                break;
            case 8:
                if(arr[2][1].equals("-")){
                    arr[2][1]=value;
                    is_avail=true;
                }
                break;
            case 9:
                if(arr[2][2].equals("-")){
                    arr[2][2]=value;
                    is_avail=true;
                }
                break;
            default:
                break;
        }
        return is_avail;
    }
    public static boolean result(String value){
        boolean win=false;
        if(arr[0][0].equals(value) && arr[1][1].equals(value) && arr[2][2].equals(value)){
            win=true;
        }
        else if(arr[0][2].equals(value) && arr[1][1].equals(value) && arr[2][0].equals(value)){
            win=true;
        }
        for(int i=0;i<3;i++){
            if(arr[i][0].equals(value) && arr[i][1].equals(value) && arr[i][2].equals(value)){
                win=true;
            }
        }
        for(int i=0;i<3;i++){
            int a=0;
            if(arr[0][i].equals(value) && arr[1][i].equals(value) && arr[2][i].equals(value)){
                win=true;
            }
        }
        return win; 
    }
    public static boolean is_empty(){
        boolean empty=false;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j].equals("-")){
                    empty=true;
                    break;
                }
            }
            if(empty){
                break;
            }
        }
        return empty;
    }
    public static void savescore(){
        try(FileOutputStream fout=new FileOutputStream("score.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fout)){
            oos.writeObject(score);
        }
        catch(Exception e){
            System.out.println("Error: "+e);
        }
    }
    public static void loadscore(){
        try(FileInputStream fin=new FileInputStream("score.txt");
        ObjectInputStream ois=new ObjectInputStream(fin)){
            score=(Score)ois.readObject();
        }
        catch(Exception e){
            System.out.println("Error: "+e);
        }
    }
}
