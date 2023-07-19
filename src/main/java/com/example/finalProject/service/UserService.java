package com.example.finalProject.service;

import com.example.finalProject.dto.UserDTO;
import com.example.finalProject.mapper.PermissionMapper;
import com.example.finalProject.mapper.UserMapper;
import com.example.finalProject.model.Comment;
import com.example.finalProject.model.Permission;
import com.example.finalProject.model.User;
import com.example.finalProject.repository.CommentRepository;
import com.example.finalProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;


public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    private static final String ROLE_USER="ROLE_USER";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("User Not Found!!!");
        }

    }

    public User addUser(User user) {
        User checkExistUser = userRepository.findByEmail(user.getEmail());
        if (checkExistUser == null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setIsBlocked(false);
            Permission permission = new Permission();
            permission.setId(3L);
            permission.setRole(ROLE_USER);
            List<Permission> permissionList = new ArrayList<>();
            permissionList.add(permission);
            user.setPermissions(permissionList);
            return userRepository.save(user);
        }
        return null;
    }

    public User updatePassword(String newPassword, String oldPassword) {
        User currentSessionUser = getCurrentSessionUser();
        if (passwordEncoder.matches(oldPassword, currentSessionUser.getPassword())) {
            currentSessionUser.setPassword(passwordEncoder.encode(newPassword));
            return userRepository.save(currentSessionUser);
        }
        return null;
    }

    public User updateFullNameAndEmail(String fullName, String email) {
        User currentSessionUser = getCurrentSessionUser();
        if (email.equals(currentSessionUser.getEmail())) {
            currentSessionUser.setFullName(fullName);
        } else if (userRepository.findByEmail(email) == null) {
            currentSessionUser.setFullName(fullName);
            currentSessionUser.setEmail(email);
        } else {
            return null;
        }

        return userRepository.save(currentSessionUser);
    }


    public User getCurrentSessionUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User user = (User) authentication.getPrincipal();
            if (user != null) {
                return user;
            }
        }
        return null;
    }

    public void deleteUser() {
        User user = getCurrentSessionUser();
        List<Comment> userComment=commentRepository.findByUser(user);
        commentRepository.deleteAll(userComment);
        userRepository.deleteById(user.getId());
    }

    public List<UserDTO> getUserList() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    public UserDTO getUserById(Long id) {
        return userMapper.toDto(userRepository.findById(id).orElse(new User()));
    }

    public UserDTO editUserStatus(UserDTO userDTO) {
        User user = (User) loadUserByUsername(userDTO.getEmail());
        if (user != null) {
            user.setPermissions(permissionMapper.toModelList(userDTO.getUserPermissionList()));
            if (userDTO.getIsBlocked()) {
                user.setIsBlocked(true);
            } else {
                user.setIsBlocked(false);
            }
            return userMapper.toDto(userRepository.save(user));
        } else {
            return null;
        }
    }


}
