package input_output;

import java.io.*;

public class UserDataReader {

    public static void readUserData(String path){
      try(BufferedReader reader = new BufferedReader(new FileReader(path));) {
          while (reader.ready()){
              String s = reader.readLine();
              System.out.println(s);
          }

      }catch (FileNotFoundException e) {
          throw new RuntimeException(e);
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
    }
}
