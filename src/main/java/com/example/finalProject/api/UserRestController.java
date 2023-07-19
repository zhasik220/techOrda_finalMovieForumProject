package com.example.finalProject.api;

import com.example.finalProject.dto.UserDTO;
import com.example.finalProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/user")
public class UserRestController {
    private final UserService userService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/get-user-list")
    public List<UserDTO> userDTOList() {
        return userService.getUserList();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "{id}")
    public UserDTO userDTO(@PathVariable(name = "id") Long id) {
        return userService.getUserById(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping
    public UserDTO editUserStatus(@RequestBody UserDTO userDTO) {
        return userService.editUserStatus(userDTO);
    }


}
