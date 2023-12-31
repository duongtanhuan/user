package com.supportportal.service;

import com.supportportal.domain.User;
import com.supportportal.exception.domain.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface UserService {

    User register(String firstName, String lastName, String username, String email) throws EmailExistException, UserNameExistException, MessagingException;

    List<User> getUsers();

    User findUserByUserName(String username);

    User findUserByEmail(String email);

    User addNewUser(String firstName, String lastName, String username, String email, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage) throws UserNotFoundException, UserNameExistException, EmailExistException, IOException, NotAnImageFileException;

    User updateUser(String currentUsername, String newFirstName, String newLastName, String newUsername, String newEmail, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage) throws UserNotFoundException, UserNameExistException, EmailExistException, IOException, NotAnImageFileException, UserNameExistException;

    void deleteUser(String username) throws IOException;

    void resetPassword(String email) throws EmailNotFoundException;

    User updateProfileImage(String username, MultipartFile profileImage) throws EmailExistException, UserNameExistException, IOException, NotAnImageFileException;

}
