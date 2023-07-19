package com.example.finalProject.service;

import com.example.finalProject.dto.PermissionDTO;
import com.example.finalProject.mapper.PermissionMapper;
import com.example.finalProject.model.User;
import com.example.finalProject.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionService {
    private final PermissionRepository permissionRepository;
    private final UserService userService;
    private final PermissionMapper permissionMapper;

    public List<PermissionDTO> getPermissionList() {
        return permissionMapper.toDtoList(permissionRepository.findAll());
    }
    public List<PermissionDTO> getRoleCurrentUser(){
        User user=userService.getCurrentSessionUser();
        return permissionMapper.toDtoList(user.getPermissions());
    }
}
