package MyProject.Dictionary;

import java.util.Random;

public class PasswordGenerator{
    private final char[] dictionaryStrong = {'A', 'a', 'B', 'b', 'C', 'c', 'D', 'd', 'E', 'e'
            , 'F', 'f', 'G', 'g', 'H', 'h', 'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', 'M', 'm', 'N', 'n'
            , 'O', 'o', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't', 'U', 'u', 'V', 'v', 'W', 'w'
            , 'X', 'x', 'Y', 'y', 'Z', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '#', '$', '_'
            , '!', '@', '%', '^', '&', '*', '(', ')', '+', '=', '/', '~', '[', ']', '{', '}'}; // 81 chars

    private final char[] dictionaryCommon = {'A', 'a', 'B', 'b', 'C', 'c', 'D', 'd', 'E', 'e', 'F', 'f', 'G', 'g', 'H', 'h',
            'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', 'M', 'm', 'N', 'n', 'O', 'o', 'P', 'p', 'Q', 'q', 'R',
            'r', 'S', 's', 'T', 't', 'U', 'u', 'V', 'v', 'W', 'w', 'X', 'x', 'Y', 'y', 'Z', 'z', '0', '1',
            '2', '3', '4', '5', '6', '7', '8', '9'}; //62 chars



    public String[] strongPassword(int count) {
        String[] password = new String[count];
        StringBuilder sb = new StringBuilder();
        int arrayIndex = 0;
        while (count > 0){
            int keyLength = keyLength();
            while (keyLength > 0){
                sb.append(dictionaryStrong[new Random().nextInt(81)]);
                keyLength--;
            }
            password[arrayIndex] = sb.toString();
            sb.delete(0, sb.length());
            arrayIndex++;
            count--;
        }
        return password;
    }

    public String[] commonPassword(int count){
        String[] password = new String[count];
        StringBuilder sb = new StringBuilder();
        int arrayIndex = 0;
        while (count > 0){
            int keyLength = commonKeyLength();
            while (keyLength > 0){
                sb.append(dictionaryCommon[new Random().nextInt(62)]);
                keyLength--;
            }
            password[arrayIndex] = sb.toString();
            sb.delete(0, sb.length());
            arrayIndex++;
            count--;
        }
        return password;
    }

    private int keyLength(){
        Random random = new Random();
        int minValue = 8;
        int maxValue = 20;
        int diff = maxValue - minValue;
        int i = random.nextInt(diff + 1);
        i += minValue;
        return i;
    }

    private int commonKeyLength(){
        Random random = new Random();
        int minValue = 8;
        int maxValue = 16;
        int diff = maxValue - minValue;
        int i = random.nextInt(diff + 1);
        i += minValue;
        return i;
    }
}
