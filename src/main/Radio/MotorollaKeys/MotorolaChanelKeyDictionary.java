package Radio.MotorollaKeys;


import Dictionary.passGen;
import java.util.Random;

public class MotorolaChanelKeyDictionary implements passGen {
    private final char[] dictionary = {'A', 'B', 'C', 'D', 'E', 'F', '1'
            , '2', '3', '4', '5', '6', '7', '8', '9', '0'}; // 16 chars

    @Override
    public String[] password(int count) {
        String[] passwords = new String[count];
        StringBuilder sb = new StringBuilder();
        int arrayPosition = 0;

        while (count > 0) {
            int keyLength = randomKeyLength();
            while (keyLength > 0) {
                sb.append(dictionary[new Random().nextInt(16)]);
                keyLength--;
            }
            passwords[arrayPosition] = sb.toString();
            sb.delete(0, sb.length());
            arrayPosition++;
            count--;
        }
        return passwords;
    }

    public int randomKeyLength() {
        Random random = new Random();
        int minValue = 7;
        int maxValue = 9;
        int diff = maxValue - minValue;
        int i = random.nextInt(diff + 1);
        i += minValue;
        return i;
    }
}
