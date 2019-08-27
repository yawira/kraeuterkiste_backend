package aw.krauterkiste.logIn.service;



import aw.krauterkiste.logIn.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LoginService implements UserDetailsService {

    final IUserRepository iUserRepository;
    final PasswordEncoder passwordEncoder;

    @Autowired
    public LoginService(IUserRepository iUserRepository, PasswordEncoder passwordEncoder) {
        this.iUserRepository = iUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        aw.krauterkiste.logIn.model.UserEntity userEntity = iUserRepository.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("Username '" + username + "' not found!");
        }
        UserDetails user = new User(userEntity.getUsername(), userEntity.getPassword(), new ArrayList<>());
        return user;
    }
}