package stream.constans;

import java.util.Random;

public class RandomGender {
    public static Gender randomGender(){
        Gender[]values = Gender.values();
        return values[new Random().nextInt(values.length)];
    }
}
