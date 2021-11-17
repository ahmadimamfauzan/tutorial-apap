package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.repository.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDB userDB;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDB.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassWord = passwordEncoder.encode(password);
        return hashedPassWord;
    }

    @Override
    public List<UserModel> getUserList() {
        return userDB.findAll();
    }

    @Override
    public UserModel getUserByUsername(String username) {
        Optional<UserModel> user = userDB.findByUsername(username);
        if(user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @Override
    public void deleteUser(UserModel user) {
        userDB.delete(user);
    }

    @Override
    public boolean isMatch(String newPassword, String oldPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(newPassword, oldPassword);
    }

    @Override
    public void setPassword(UserModel myUser, String newPassword) {
        myUser.setPassword(newPassword);
    }
}
