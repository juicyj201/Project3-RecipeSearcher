//package za.ac.cput.recipesearcher.Repository.Impl;
//
//import android.util.Log;
//
//import androidx.annotation.NonNull;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.Logger;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import za.ac.cput.recipesearcher.Entities.User;
//import za.ac.cput.recipesearcher.Repository.UserRepository;
//
//public class UserRepositoryImpl implements UserRepository {
//    private FirebaseDatabase db;
//    private DatabaseReference userrepo;
//
//    public UserRepositoryImpl(){
//        db = FirebaseDatabase.getInstance();
//        userrepo = db.getReference("users");
//    }
//
//    @Override
//    public User save(User user) {
//        if(!user.equals(null)){
//            userrepo.child(user.getId()).setValue(user);
//        }
//
//        return user;
//    }
//
//
//    @Override
//    public List<User> readAll() {
//        return null;
//    }
//
//    @Override
//    public Optional<User> update(User user) {
//        return null;
//        //return Optional.empty();
//    }
//}
