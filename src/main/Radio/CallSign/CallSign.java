package Radio.CallSign;

import Radio.CallSign.RadioNumber.RadioNumber;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;


public class CallSign {
    private File notUsedCallSigns = new File("src/main/Radio/CallSign/callSigns.txt");
    private final File usedCallSigns = new File("src/main/Radio/CallSign/usedCallSigns.txt");
    private ArrayList<String> SignList = new ArrayList<>();


    public boolean isUsed(String callSigne){
        ArrayList<String> used = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("src/main/Radio/CallSign/usedCallSigns.txt"))){
            used.add(reader.readLine());
        }catch (IOException ex){
            ex.printStackTrace();
        }
        for (String callSign:used) {
            if(callSign.equalsIgnoreCase(callSigne)){
                return true;
            }
        }
        return false;
    }

    private void readCallSign() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/Radio/CallSign/callSigns.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String tmp = reader.readLine();
                if(tmp != null){
                    SignList.add(tmp.toUpperCase());
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String createCallSigne(){
        readCallSign();
        String result = "";
        int rand = new Random().nextInt(SignList.size());
        result = SignList.get(rand);
        SignList.remove(rand);
        result += "-" + new RadioNumber().getNum();

        System.out.println("sign = " + result);
        return result;
    }

}
