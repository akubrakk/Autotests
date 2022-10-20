package serialization;

import java.io.*;

public class Serializator {
   public final File FILE = new File("src/main/resources/testdata/person.dat");

    public void serialize(Person person){

        try(FileOutputStream fos = new FileOutputStream(FILE);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){

            oos.writeObject(person);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Person deSerialize() throws  IOException, ClassNotFoundException{
        Person person = null;

       FileInputStream fis = new FileInputStream(FILE);
       ObjectInputStream ois = new ObjectInputStream(fis);

       person = (Person) ois.readObject();

       return person;
    }

}
