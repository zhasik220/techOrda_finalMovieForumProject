package com.example.finalProject.mapper;

import com.example.finalProject.dto.PermissionDTO;
import com.example.finalProject.model.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    @Mapping(source = "role", target = "permissionRole")
    PermissionDTO toDTO(Permission permission);

    @Mapping(source = "permissionRole", target = "role")
    Permission toModel(PermissionDTO permissionDTO);

    List<PermissionDTO> toDtoList(List<Permission> permissions);

    List<Permission> toModelList(List<PermissionDTO> permissionDTOList);

}
