package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    List<UserModel> getUserList();
    UserModel getUserByUsername(String username);
    void deleteUser(UserModel user);
    boolean isMatch(String newPassword, String oldPassword);
    void setPassword(UserModel myUser, String newPassword);
}
