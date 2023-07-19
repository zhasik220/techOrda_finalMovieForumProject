package com.example.finalProject.api;

import com.example.finalProject.dto.PermissionDTO;
import com.example.finalProject.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/permission")
public class PermissionRestController {
    private final PermissionService permissionService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/get-permission-list")
    public List<PermissionDTO> permissionDTOList() {
        return permissionService.getPermissionList();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/get-permission-current-user")
    public List<PermissionDTO> getRoleCurrentUser(){
        return permissionService.getRoleCurrentUser();
    }
}
