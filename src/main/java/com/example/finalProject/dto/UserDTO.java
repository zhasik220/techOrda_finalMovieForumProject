package com.example.finalProject.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String email;
    private String fullName;
    private Boolean isBlocked;
    private List<PermissionDTO> userPermissionList;
}
