package ui.model;


import com.github.javafaker.Faker;

public class User {

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    public User(String username, String firstname, String lastname, String email, String password) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

     public static Builder builder(){
        return new Builder();
     }

    public static class Builder{
        private String username;
        private String firstname;
        private String lastname;
        private String email;
        private String password;

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public User buildRandomUser(){
            Faker faker = new Faker();

           return new User(faker.name().username(),faker.name().firstName(),faker.name().lastName() , faker.internet().emailAddress(), faker.friends().character());
      }

    }
}
