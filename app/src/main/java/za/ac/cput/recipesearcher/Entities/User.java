package za.ac.cput.recipesearcher.Entities;

import java.util.Objects;

public class User {
    //id consists of first name letter and last name
    private final String id;
    private final String username;
    private final String firstname;
    private final String surname;
    private final String email;
    private final String condition;

    public User(UserBuilder userBuilder){
        this.id = userBuilder.id;
        this.username = userBuilder.username;
        this.firstname = userBuilder.firstname;
        this.surname = userBuilder.surname;
        this.email = userBuilder.email;
        this.condition = userBuilder.condition;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getCondition() {
        return condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id.equals(user.id) && Objects.equals(username, user.username) && Objects.equals(firstname, user.firstname) && Objects.equals(surname, user.surname) && Objects.equals(email, user.email) && Objects.equals(condition, user.condition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, firstname, surname, email, condition);
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }



    public static class UserBuilder{
        private static String id;
        private static String username;
        private static String firstname;
        private static String surname;
        private static String email;
        private static String condition;

        public UserBuilder(){
            this.id = id;
            this.username = username;
            this.firstname = firstname;
            this.surname = surname;
            this.email = email;
            this.condition = condition;
        }

        public UserBuilder createID(){
            this.id = firstname.substring(1, 1) + surname;
            return this;
        }

        public UserBuilder createUsername(String username){
            this.username = username;
            return this;
        }

        public UserBuilder createFullName(String firstname, String surname){
            this.firstname = firstname;
            this.surname = surname;
            return this;
        }

        public UserBuilder createEmail(String email){
            this.email = email;
            return this;
        }

        public UserBuilder createCondition(String condition){
            this.condition = condition;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
