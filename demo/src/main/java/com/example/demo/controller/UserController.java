package com.example.demo.controller;

import com.example.demo.dtos.UserDTO;
import com.example.demo.models.Client;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import static com.example.demo.controller.UserApi.USER;
import static com.example.demo.controller.UserApi.USER_ID;

@Controller
public class UserController {
    private final UserService userService;
    private final UserConverter userConverter;

    public UserController(UserService userService,
                          UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }
    @Operation(summary = "Get user by id")
    @ApiResponse(
            responseCode = "200",
            description = "Found the user",
            content = {
                    @io.swagger.v3.oas.annotations.media.Content(
                            mediaType = "application/json",
                            schema = @io.swagger.v3.oas.annotations.media.Schema(
                                    implementation = UserDTO.class
                            )
                    )
            }
    )
    @GetMapping(USER_ID)
    public ResponseEntity<?> getById(@PathVariable Integer id){
        return ResponseEntity.ok(userConverter.convert(userService.findById(id)));
    }

    @Operation(summary = "Create user")
    @ApiResponse(
            responseCode = "201",
            description = "User created"
    )
    @PostMapping(USER)
    public ResponseEntity<?> create(@RequestBody UserDTO userDTO){
        Client user = userConverter.convert(userDTO);
        return ResponseEntity.ok(userConverter.convert(userService.create(user)));
    }

    @Operation(summary = "Update user")
    @ApiResponse(
            responseCode = "200",
            description = "User updated"
    )
    @PutMapping(USER_ID)
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO){
        Client user = userConverter.convert(userDTO);
        return ResponseEntity.ok(userConverter.convertUser(userService.update(user)));
    }

    @Operation(summary = "Delete user")
    @ApiResponse(
            responseCode = "204",
            description = "User deleted"
    )
    @DeleteMapping(USER_ID)
    public boolean delete(@RequestParam Integer id){
        return userService.delete(id);
    }

}
