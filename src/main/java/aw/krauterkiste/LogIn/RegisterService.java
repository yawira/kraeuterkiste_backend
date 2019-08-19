package aw.krauterkiste.LogIn;


import aw.krauterkiste.Model.UserDto;
import aw.krauterkiste.Model.UserEntity;
import aw.krauterkiste.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RegisterService {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterService(IUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean userCanBeRegistered(UserDto userDto){
        Optional<UserEntity> userModel = Optional.ofNullable(userRepository.findByUsername(userDto.getUsername()));
        // Überprüft, dass der User nicht schon existiert und Passwörter gleich sind
        return userDto.passwordsMatch() && !userModel.isPresent();
    }

    public UserDetails registerUser(UserDto userDto){
        String encodedPass = passwordEncoder.encode(userDto.getPassword());
        userRepository.save(new UserEntity(userDto.getUsername(), encodedPass));
        return new User(userDto.getUsername(), encodedPass, new ArrayList<>());
    }
}