package Radio.CallSign;

import Radio.CallSign.RadioNumber.RadioNumber;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;


public class CallSign {
    private ArrayList<String> signList = new ArrayList<>();


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
                    signList.add(tmp.toUpperCase());
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String createCallSigne(){
        readCallSign();
        String result = "";
        int rand = new Random().nextInt(signList.size());
        result = signList.get(rand);
        signList.remove(rand);
        result += "-" + new RadioNumber().getNum();

        return result;
    }

}
