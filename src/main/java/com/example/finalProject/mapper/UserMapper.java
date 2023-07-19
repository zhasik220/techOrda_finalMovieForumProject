package com.example.finalProject.mapper;

import com.example.finalProject.dto.UserDTO;
import com.example.finalProject.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PermissionMapper.class})
public interface UserMapper {

    @Mapping(source = "permissions", target = "userPermissionList")
    UserDTO toDto(User user);


    @Mapping(source = "userPermissionList", target = "permissions")
    User toModel(UserDTO userDTO);

    List<UserDTO> toDtoList(List<User> userList);

    List<User> toModelList(List<UserDTO> userDTOList);


}
