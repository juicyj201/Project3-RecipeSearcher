package za.ac.cput.recipesearcher.Repository;

import java.util.List;

import za.ac.cput.recipesearcher.Entities.Profile;

public interface ProfileRepository extends IRepository<Profile, String>{
    public Profile save(Profile profile);
    public Profile read(Profile profile);
    public List<Profile> readAll();
}
