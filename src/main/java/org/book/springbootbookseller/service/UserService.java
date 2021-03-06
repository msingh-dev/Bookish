package org.book.springbootbookseller.service;

import org.book.springbootbookseller.model.Role;
import org.book.springbootbookseller.model.User;
import org.book.springbootbookseller.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());

        return userRepository.save(user);

    }

    @Override
    public Optional<User> findByUsername(String username){

        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional //Transactional Required when we are doing any update/delete operation
    public void makeAdmin(String username){
         userRepository.updateUserRole(username, Role.ADMIN);
    }


}
