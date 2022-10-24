package Radio.CallSign.RadioNumber;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class RadioNumber {
    private final char[] numberDic = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public boolean isUsed(String number) {
        ArrayList<String> callSignNumber = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/Radio/CallSign" +
                "/RadioNumber/StationNumbers.txt"))) {
            while ((reader.readLine()) != null) {
                if (!reader.readLine().isEmpty()) {
                    callSignNumber.add(reader.readLine());
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            for (String s : callSignNumber) {
                if (s.equalsIgnoreCase(number)) {
                    return true;
                }
            }
        } catch (NullPointerException ex) {
            System.out.println("NPE ex");
        }

        return false;
    }

    private String genNumber() {
        StringBuilder num;
        int numLength = 0;
        do {
            num = new StringBuilder();
            while (numLength < 3) {
                num.append(numberDic[new Random().nextInt(10)]);
                numLength++;
            }
        } while (isUsed(num.toString()));
        return num.toString();
    }

    public String getNum() {
        String returnable = "";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/Radio/CallSign" +
                "/RadioNumber/StationNumbers.txt", true))) {
            {
                returnable = genNumber();
                writer.write(returnable);
                writer.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return returnable;
    }
}
