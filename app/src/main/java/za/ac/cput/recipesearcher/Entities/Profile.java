package za.ac.cput.recipesearcher.Entities;

import java.util.Objects;

public class Profile {
    private String name;
    private String surname;
    private String email;

    public Profile(ProfileBuilder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.email = builder.email;
    }

    public Profile(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile)) return false;
        Profile profile = (Profile) o;
        return name.equals(profile.name) && surname.equals(profile.surname) && email.equals(profile.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, email);
    }

    @Override
    public String toString() {
        return "ProfileRepository{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static class ProfileBuilder{
        public static String name;
        public static String surname;
        public static String email;

        public ProfileBuilder(){
            this.name = name;
            this.surname = surname;
            this.email = email;
        }

        public ProfileBuilder createName(String name){
            this.name = name;
            return this;
        }

        public ProfileBuilder createSurname(String surname){
            this.surname = surname;
            return this;
        }

        public ProfileBuilder createEmail(String email){
            this.email = email;
            return this;
        }

        public Profile build(){
            return new Profile(this);
        }
    }
}