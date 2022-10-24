package Users;

import MyProject.Dictionary.PasswordGenerator;
import MyProject.Dictionary.UserNameDictionary;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class UserCreator {
    String username;
    String password;
    String object;
    String ip;
    String serialNumber;


    public UserCreator() {
        System.out.println("Creating USER");
        object();
        serial();
        ip();
        userName();
        password();

        System.out.println("username: " + this.username + "\npassword: " + this.password);
    }

    public void writeUserToFile() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("\ndd/MM/yyyy HH:mm:ss\n");
        LocalDateTime now = LocalDateTime.now();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.dat", true))) {
            oos.write(dateTimeFormatter.format(now).getBytes());
            oos.write(getInfo());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void password() {
        Scanner scanner = new Scanner(System.in);
        String[] passArray;
        String password;
        System.out.println("Choice option for password: press \"Enter\" to generate common password, " +
                "1 - complex password. 2 - my own password" +
                " (common password by default)");
        int passOption = scanner.nextInt();

        switch (passOption) {
            case 1:
                passArray = new PasswordGenerator().strongPassword(10);
                password = passArray[new Random().nextInt(10)];
                this.password = password;
                break;
            case 2:
                this.password = scanner.nextLine();
                break;
            default: {
                System.out.println("You choice the wrong option, password will be created by default");
                passArray = new PasswordGenerator().commonPassword(10);
                password = passArray[new Random().nextInt(10)];
                this.password = password;
            }
        }
    }

    private void userName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username (enter gen to generate name): ");
        String user = scanner.nextLine();
        if (user.equals("gen")) {
            this.username = new UserNameDictionary().getUserNames();
        } else {
            this.username = user;
        }
    }

    private void ip() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ip: ");
        this.ip = scanner.nextLine();
    }

    private void object() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter objects existence: ");
        this.object = scanner.nextLine();
    }

    private void serial(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter serial number: ");
        this.serialNumber = scanner.nextLine();
    }

    private byte[] getInfo() {
        return ("\nObject: " + this.object + "\nSerial number: " + serialNumber +  "\nip: " + this.ip + "\nusername: " +
                this.username + "\npassword: " + this.password + "\n").getBytes();
    }
}
