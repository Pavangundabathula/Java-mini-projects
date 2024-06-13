import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.*;

class todo implements Serializable {
    String task;
    LocalDate date;
    LocalTime time;

    todo(String task, LocalDate date, LocalTime time) {
        this.task = task;
        this.date = date;
        this.time = time;
    }

    public void display() {
        System.out.println("Task: " + task + "\nDate: " + date + "\nTime: " + time);
    }
}

public class todolist {
    public static List<todo> Object = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("To-Do List");
        Scanner sc = new Scanner(System.in);
        loadtodo();
        while (true) {
            System.out.println("Menu\n"+"1.Add a task\n"+"2.Delete a task\n"+"3.View all tasks\n"+"4.Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    toadd(sc);
                    break;
                case 2:
                    toremove(sc);
                    break;
                case 3:
                    view();
                    break;
                case 4:
                    savetodo();
                    System.out.println("Exiting the application");
                    sc.close();
                    return;
                default:
                    System.out.println("Enter the right choice");
                    break;
            }
        }
    }

    public static void toadd(Scanner sc) {
        try{
        System.out.print("Enter the task: ");
        sc.nextLine();
        String task = sc.nextLine();
        System.out.print("Enter date (dd-MM-yyyy): ");
        String d = sc.nextLine();
        LocalDate date = LocalDate.parse(d, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.print("Enter time (HH:mm): ");
        String t = sc.nextLine();
        LocalTime time = LocalTime.parse(t, DateTimeFormatter.ofPattern("HH:mm"));
        Object.add(new todo(task, date, time));
        System.out.println("Task Added Successfully");
        savetodo();
        }
        catch(DateTimeParseException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public static void toremove(Scanner sc) {
        if (!Object.isEmpty()) {
            System.out.print("Enter task to delete: ");
            sc.nextLine();
            String remstr = sc.nextLine();
            boolean found = false;
            try {
                Iterator<todo> iterator = Object.iterator();
                while (iterator.hasNext()) {
                    todo ob = iterator.next();
                    if (ob.task.equals(remstr)) {
                        iterator.remove();
                        found = true;
                        System.out.println("Task deleted successfully");
                        System.out.println("-------------------");
                    }
                }
                if (!found) {
                    System.out.println("Task not found");
                }
                savetodo();
            } catch (Exception e) {
                System.out.println("Error");
            }
        } else {
            System.out.println("There is no task saved to delete");
        }
    }

    public static void view() {
        if (Object.isEmpty()) {
            System.out.println("No task to display");
        } else {
            for (todo ob : Object) {
                ob.display();
                System.out.println("-------------------");
            }
        }
    }

    public static void loadtodo() {
        try (FileInputStream fin = new FileInputStream("todo.txt");
             ObjectInputStream ois = new ObjectInputStream(fin)) {
            Object = (List<todo>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Error: o " + e.getMessage());
        }
    }

    public static void savetodo() {
        try (FileOutputStream fout = new FileOutputStream("todo.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fout)) {
            oos.writeObject(Object);
        } catch (Exception e) {
            System.out.println("Error: now " + e.getMessage());
        }
    }
}
