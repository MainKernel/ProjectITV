package MyProject.Dictionary;

import java.util.Random;

public class UserNameDictionary {
    private final String[] userNames = {"user", "default", "common", "guest"};

    public String getUserNames() {
        return userNames[new Random().nextInt(4)];
    }
}
