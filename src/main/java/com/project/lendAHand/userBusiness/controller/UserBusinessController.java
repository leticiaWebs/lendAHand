package com.project.lendAHand.userBusiness.controller;



import com.project.lendAHand.model.UserRequest;
import com.project.lendAHand.model.UserResponse;
import com.project.lendAHand.userBusiness.domain.UserBusiness;
import com.project.lendAHand.userBusiness.mapper.UserMapper;
import com.project.lendAHand.userBusiness.repository.UserRepository;
import com.project.lendAHand.userBusiness.service.UserBusinessService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserBusinessController {

    private final UserBusinessService service;

    public UserBusinessController(UserBusinessService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAllAccounts() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(
            @PathVariable Long id,
            @RequestBody UserRequest request) {

        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}