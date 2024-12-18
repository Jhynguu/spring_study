package com.example.modelmapper.service;

import com.example.modelmapper.domain.User;
import com.example.modelmapper.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final ModelMapper modelMapper;

    public UserService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // 필드명이 다를 경우 커스터마이징 매핑 규칙 설정
    public UserDTO convertToDTO(User user) {
        modelMapper.typeMap(User.class, UserDTO.class)
                .addMapping(User::getFullName, UserDTO::setName);
        return modelMapper.map(user, UserDTO.class);
    }

    public User convertToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public List<UserDTO> convertToDTOList(List<User> users) {
        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}