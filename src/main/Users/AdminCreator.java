package Users;


import Dictionary.AdminNameDictionary;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class AdminCreator {
    String object;
    String ip;
    String login;
    String password;
    String serialNumber;

    public AdminCreator() {
        System.out.println("Creating ADMIN");
        object();
        serial();
        ip();
        login();
        password();

        System.out.println("login: " + this.login + "\npassword: " + this.password);
    }

    public void writeUserToFile() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("\ndd/MM/yyyy HH:mm:ss\n");
        LocalDateTime now = LocalDateTime.now();
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("admin.dat",true))) {
            oos.write(dateTimeFormatter.format(now).getBytes());
            oos.write(getInfo());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void serial() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter serial number: ");
        this.serialNumber = scanner.nextLine();
    }

    private void ip() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ip: ");
        this.ip = scanner.nextLine();
    }

    private void object() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter object existence: ");
        this.object = scanner.nextLine();
    }

    private void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter login (press enter to generate it automatically): ");
        String option = scanner.nextLine();
        if (option.equals("")) {
            this.login = new AdminNameDictionary().getAdminLogin();
        } else {
            this.login = option;
        }

    }

    private void password() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choice option for password: 0 - to generate common password, " +
                "1 - complex password. 2 - my own password" +
                " (complex password by default)");
        int passOption = scanner.nextInt();
        String[] passwordArray;
        String password;
            switch (passOption) {
                case 1:
                    passwordArray = new Dictionary.PassGen.PasswordGenerator().strongPassword(10);
                    password = passwordArray[new Random().nextInt(10 + 1)];
                    this.password = password;
                    break;
                case 2:
                    this.password = scanner.nextLine();
                    break;
                default:
                    System.out.println("You choice the wrong option, password will be created by default");
                    passwordArray = new Dictionary.PassGen.PasswordGenerator().commonPassword(10);
                    password = passwordArray[new Random().nextInt(10 + 1)];
                    this.password = password;
                    break;
            }
    }

    private byte[] getInfo() {
        return ("\nObject: " + this.object + "\nSerial number: " + serialNumber + "\nip: " + this.ip + "\nusername: " +
                this.login + "\npassword: " + this.password + "\n").getBytes();
    }
}
