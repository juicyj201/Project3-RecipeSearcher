package za.ac.cput.recipesearcher.Entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProfileTest {
    private Profile profile;

    @BeforeEach
    void setUp() {
        profile = new Profile.ProfileBuilder().createName("Light").createSurname("Yagami").createEmail("light@deathnotetingz.com").build();
    }

    @Test
    void testProfile() {
        Assertions.assertNotNull(profile);
    }
}
