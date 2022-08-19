package za.ac.cput.recipesearcher.Factory;

import za.ac.cput.recipesearcher.Entities.User;

public class UserFactory {
    public User createUser(String username, String firstname, String surname, String email, String condition){
        return new User.UserBuilder()
                .createUsername(username)
                .createFullName(firstname, surname)
                .createEmail(email)
                .createCondition(condition)
                .build();
    }

    /**
     new UserRepository.UserBuilder()
     .createUsername("AlexKing")
     .createFullName("Nexus", "Alexander")
     .createEmail("kingA@mail.com")
     .createCondition("High-blood pressure")
     .build()
     */
}
