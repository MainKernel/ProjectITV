import Users.AdminCreator;
import Users.UserCreator;

import java.util.Scanner;

public class Creator {
    public void Creator(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choice the option you need: \n1.Create admin account. \n2.Create user account.");
        String option = scanner.nextLine();
        if(option.equals("1")){
            new AdminCreator().writeUserToFile();
        } else if(option.equals("2")){
            new UserCreator().writeUserToFile();
        } else {
            System.out.println("Wrong option");
        }
    }
}
