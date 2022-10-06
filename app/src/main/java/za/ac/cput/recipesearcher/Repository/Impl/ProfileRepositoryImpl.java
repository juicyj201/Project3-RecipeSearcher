package za.ac.cput.recipesearcher.Repository.Impl;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import za.ac.cput.recipesearcher.Entities.Profile;
import za.ac.cput.recipesearcher.Repository.ProfileRepository;

public class ProfileRepositoryImpl implements ProfileRepository {
    private FirebaseDatabase db;
    private DatabaseReference profilerepo;
    private Task<DataSnapshot> task;

    public ProfileRepositoryImpl(){
        db = FirebaseDatabase.getInstance();
        profilerepo = db.getReference("user");
    }

    @Override
    public Profile save(Profile profile) {
        if(!profile.equals(null)){
            profilerepo.child(profile.getName()).setValue(profile);
        }

        return profile;
    }

    @Override
    public Profile read(Profile profile) {
        Task<DataSnapshot> task = profilerepo.get();
        Profile dbProfile = null;
        while(task.getResult().exists()) {
            if (task.getResult().getValue(Profile.class).equals(profile)) {
                dbProfile = task.getResult().getValue(Profile.class);
            }
        }

        return dbProfile;
    }

    @Override
    public List<Profile> readAll() {
        Task<DataSnapshot> task = profilerepo.get();
        List<Profile> profileList = new ArrayList<>();
        while(task.getResult().exists()) {
            profileList.add(task.getResult().getValue(Profile.class));
        }

        return profileList;
    }
}
