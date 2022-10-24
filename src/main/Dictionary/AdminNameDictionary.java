package Dictionary;

import java.util.Random;

public class AdminNameDictionary {
    private final String[] adminNames = {"admin", "root", "super", "author"};
    public String getAdminLogin(){
        return adminNames[new Random().nextInt(4)];
    }
}
