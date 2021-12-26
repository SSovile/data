package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.company.models.converter.UserConverter;
import com.company.models.domain.User;
import com.company.models.dto.UserDto;
import com.company.service.UserService;
import com.company.service.NumberOfPhoneService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    NumberOfPhoneService numberOfPhoneService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getUserList() {
        List<UserDto> responseUserDtoList = new ArrayList<>();
        for (User user: userService.getAll()) {
            responseUserDtoList.add(UserConverter.toDTO(user));
        }
        return new ResponseEntity<>(responseUserDtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer id) {
        try {
            User searchedUser = userService.getById(id);
            return new ResponseEntity<>(UserConverter.toDTO(searchedUser), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<UserDto> postUser(@RequestBody UserDto userDto) {
        User createdUser = User.builder()
                .nickname(userDto.getNickname)
                .number(numberOfPhoneService.getByNumber(userDto.getNumber()))
                .build();
        User responseUser = userService.create(createdUser);
        return new ResponseEntity<>(UserConverter.toDTO(responseUser), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UserDto> putUser(@RequestBody UserDto userDto, @PathVariable Integer id) {
        try {
            User updatedUserValues = User.builder()
                    .nickname(userDto.getNickname())
                    .number(numberOfPhoneService.getByNumber(userDto.getNumber()))
                    .build();
            userService.updateById(updatedUserValues, id);
            userDto.setId(id);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable Integer id) {
        try {
            userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
