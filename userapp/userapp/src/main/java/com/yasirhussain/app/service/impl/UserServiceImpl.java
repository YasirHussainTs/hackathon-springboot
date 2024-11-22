package com.yasirhussain.app.service.impl;

import com.yasirhussain.app.dto.UserDTO;
import com.yasirhussain.app.entity.User;
import com.yasirhussain.app.repository.UserRepository;
import com.yasirhussain.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> getUserById(Long id) {
        return userRepository.findById(id).map(this::convertToDTO);    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        User savedUser = userRepository.save(user);
        return convertToDTO(savedUser);    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            User userToUpdate = existingUser.get();
            userToUpdate.setId(userDTO.getId());
            userToUpdate.setName(userDTO.getName());
            userToUpdate.setPassword(userDTO.getPassword());
            userToUpdate.setContact(userDTO.getContact());

            User updatedUser = userRepository.save(userToUpdate);
            return convertToDTO(updatedUser);
        } else {
            throw new RuntimeException("User with ID " + id + " not found");
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private UserDTO convertToDTO(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getPassword(), user.getContact());
    }

    private User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setContact(userDTO.getContact());
        return user;
    }
}
