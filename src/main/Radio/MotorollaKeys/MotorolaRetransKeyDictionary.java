package Radio.MotorollaKeys;


import Dictionary.passGen;
import java.util.Random;

public class MotorolaRetransKeyDictionary implements passGen {
    private final char[] dictionary = {'A', 'a', 'B', 'b', 'C', 'c', 'D', 'd', 'E', 'e'
            , 'F', 'f', 'G', 'g', 'H', 'h', 'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', 'M', 'm', 'N', 'n'
            , 'O', 'o', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't', 'U', 'u', 'V', 'v', 'W', 'w'
            , 'X', 'x', 'Y', 'y', 'Z', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '#', '$', '_'}; // 65 chars

    public String[] password(int count) {
        String[] passwords = new String[count];
        StringBuilder sb = new StringBuilder();
        int arrayPosition = 0;

        while (count > 0) {
            int keyLength = randomKeyLength();
            while (keyLength != 0) {
                sb.append(dictionary[new Random().nextInt(65)]);
                keyLength--;
            }
            passwords[arrayPosition] = sb.toString();
            sb.delete(0, sb.length());
            arrayPosition++;
            count--;
        }
        return passwords;
    }


    private int randomKeyLength() {
        Random random = new Random();
        int minValue = 16;
        int maxValue = 24;
        int diff = maxValue - minValue;
        int i = random.nextInt(diff + 1);
        i += minValue;
        return i;
    }
}
