package serialization;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Serializator serializator = new Serializator();

        Pet owl = new Pet();
        Person person = new Person("Harry", 14, owl);

        serializator.serialize(person);

        Person newPerson = serializator.deSerialize();

        System.out.println("Persons: ");
        System.out.println(person.getName() + " " + person.getAge() + " " + person.getPet());
        System.out.println(newPerson.getName() + " " + newPerson.getAge() + " " + newPerson.getPet());
    }
}
