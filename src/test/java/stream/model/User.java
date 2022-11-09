package stream.model;

import com.github.javafaker.Faker;
import stream.constans.Gender;

import static stream.constans.RandomGender.randomGender;

public class User {
    private String name;
    private int age;
    private String email;
    private Gender gender;

    public User() {
        Faker faker = new Faker();
        this.name = faker.name().firstName();
        this.age = faker.random().nextInt(1, 99);
        this.email = faker.internet().emailAddress();
        this.gender = randomGender();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                '}';
    }
}

