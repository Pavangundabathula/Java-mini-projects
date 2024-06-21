import java.util.*;
import java.io.*;

class Contact implements Serializable, Comparable<Contact> {
    private static final long serialVersionUID = 1L;
    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public void display() {
        System.out.println("Name: " + name + "\nPhone: " + phone);
        System.out.println("------------------------------");
    }

}

public class contactbook {
    private static final String FILE_NAME = "contacts.txt";
    private static List<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        loadContacts();

        while (true) {
            System.out.println("\nContact Book Application");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. View Contacts");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addContact(sc);
                    saveContacts();
                    break;
                case 2:
                    deleteContact(sc);
                    saveContacts();
                    break;
                case 3:
                    viewContacts();
                    break;
                case 4:
                    saveContacts();
                    System.out.println("Exiting the application.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void addContact(Scanner sc) {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter phone: ");
        String phone = sc.nextLine();
        contacts.add(new Contact(name, phone));
        System.out.println("Contact added successfully.");
    }

    public static void deleteContact(Scanner sc) {
        System.out.print("Enter the name of the contact to delete: ");
        String name = sc.nextLine();
        Iterator<Contact> iterator = contacts.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.name.equals(name)) {
                iterator.remove();
                found = true;
                System.out.println("Contact deleted successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            Collections.sort(contacts); 
            System.out.println("Contacts List:");
            for (Contact contact : contacts) {
                contact.display();
            }
        }
    }

    public static void loadContacts() {
        try (FileInputStream fin = new FileInputStream(FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fin)) {
            contacts = (List<Contact>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous contacts found. Starting a new list.");
        }
    }

    public static void saveContacts() {
        try (FileOutputStream fout = new FileOutputStream(FILE_NAME);
             ObjectOutputStream oos = new ObjectOutputStream(fout)) {
            oos.writeObject(contacts);
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }
}
