package input_output;

import java.io.*;
import java.util.Scanner;

public class UserDataSaver {

    public static void saveUserData(String path) {

        Scanner scanner = new Scanner(System.in);
        String data = "";

        while (!data.equals("exit")) {
            data = scanner.nextLine();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {

                writer.write(data);
                writer.newLine();

                if (data.equals("write")){
                    writer.flush();
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        scanner.close();
    }
}
