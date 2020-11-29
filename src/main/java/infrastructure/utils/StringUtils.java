package infrastructure.utils;

import java.util.Random;

public class StringUtils {
    public String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public String nums = "0123456789";

    public enum utilMode {
        ALPHA,
        ALPHANUMERIC,
        NUMERIC;
    }


    public String stringGenerator(utilMode mode, int length){
        String tempString = "";

        if (mode.equals(utilMode.ALPHA)){
            tempString = alphabet;
        }
        else if (mode.equals(utilMode.ALPHANUMERIC)){
            tempString = alphabet+nums;
        }
        else if (mode.equals(utilMode.NUMERIC)) {
            tempString = nums;
        }

        StringBuilder result = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            result.append(tempString.charAt(random.nextInt(tempString.length())));
        }
        return result.toString();
    }
}
