package input_output;

import static input_output.UserDataReader.readUserData;
import static input_output.UserDataSaver.saveUserData;

public class Main {

    static String path = "src/main/resources/testdata/user.dat";

    public static void main(String[] args) {

        System.out.println("Input your data. To finish type \"exit\"");
        saveUserData(path);

        readUserData(path);
    }

}
