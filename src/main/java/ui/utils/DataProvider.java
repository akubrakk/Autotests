package ui.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataProvider {

    private static final List<String> userNames = Arrays.asList("Bob","Tina", "Fatima");

    public static String getUserName(){

        Random random = new Random();
        return userNames.get(random.nextInt(userNames.size()));
    }

}
