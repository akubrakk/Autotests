package file_classes;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws IOException {

        String path = "src/main/resources/testdata/";
        String fileName = "test_data.yaml";


        createFile(path,fileName);
        getLastModifiedTime(path,fileName);

    }


    public static void createFile(String path, String fileName) throws IOException {
        File dir = new File(path);


        if (!dir.exists()) {
            dir.mkdirs();
        }

        File file = new File(dir, fileName);

        if(!file.exists()){
            file.createNewFile();
        }

    }

    public static void getLastModifiedTime(String path, String fileName){

        File file = new File(path,fileName);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        System.out.println("Last modified: " + sdf.format(file.lastModified()));
    }
}
