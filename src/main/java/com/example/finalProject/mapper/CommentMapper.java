package com.example.finalProject.mapper;

import com.example.finalProject.dto.CommentDTO;
import com.example.finalProject.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(source = "text", target = "commentText")
    @Mapping(source = "time", target = "postedTime")
    @Mapping(source = "user.id",target = "userId")
    @Mapping(source = "user.fullName",target = "userFullName")
    @Mapping(source = "movie.id",target = "movieId")
    CommentDTO toDTO(Comment comment);

    @Mapping(source = "commentText", target = "text")
    @Mapping(source = "postedTime", target = "time")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "userFullName", target = "user.fullName")
    @Mapping(source = "movieId",target = "movie.id")
    Comment toModel(CommentDTO commentDTO);

    List<CommentDTO> toDtoList(List<Comment> commentList);
    List<Comment> toModelList(List<CommentDTO> commentDTOList);
}
