package Dictionary;

import java.util.Random;

public class BiosPasswordDictionary implements passGen {
    private final char[] dictionary = {'A', 'a', 'B', 'b', 'C', 'c', 'D', 'd', 'E', 'e', 'F', 'f', 'G', 'g', 'H', 'h',
            'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', 'M', 'm', 'N', 'n', 'O', 'o', 'P', 'p', 'Q', 'q', 'R',
            'r', 'S', 's', 'T', 't', 'U', 'u', 'V', 'v', 'W', 'w', 'X', 'x', 'Y', 'y', 'Z', 'z', '0', '1',
            '2', '3', '4', '5', '6', '7', '8', '9'}; //62 chars


    public String[] password(int count){
        String[] dictionarys = new String[count];
        StringBuilder sb = new StringBuilder();
        int arrayIndex = 0;

        while (count > 0){
            int keyLength = keyLength();
            while (keyLength > 0){
                sb.append(dictionary[new Random().nextInt(62)]);
                keyLength--;
            }
            dictionarys[arrayIndex] = sb.toString();
            sb.delete(0, sb.length());
            arrayIndex++;
            count--;
        }
        return dictionarys;
    }

    private int keyLength(){
        Random random = new Random();
        int minValue = 5;
        int maxValue = 8;
        int diff = maxValue - minValue;
        int i = random.nextInt(diff + 1);
        i += minValue;
        return i;
    }
}
