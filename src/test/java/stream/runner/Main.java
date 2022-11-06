package stream.runner;


import stream.constans.Gender;
import stream.model.User;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Map<Gender, List<String>> users = Stream.generate(User::new)
                .limit(20)
                .filter(user -> user.getAge() > 18)
                .sorted(Comparator.comparing(User::getName))
                .filter(user -> user.getEmail() != null)
                .collect(Collectors.groupingBy(User::getGender, Collectors.mapping(User::getName,Collectors.toList())));
        System.out.println(users.toString());

    }


}
