package ui.model;


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

        public User build(){
            return new User(username, firstname, lastname, email, password);
        }
    }
}
