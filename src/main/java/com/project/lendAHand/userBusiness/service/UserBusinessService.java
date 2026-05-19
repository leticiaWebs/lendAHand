package com.project.lendAHand.userBusiness.service;

import com.project.lendAHand.model.UserRequest;
import com.project.lendAHand.model.UserResponse;
import com.project.lendAHand.userBusiness.domain.UserBusiness;
import com.project.lendAHand.userBusiness.mapper.UserMapper;
import com.project.lendAHand.userBusiness.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBusinessService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserBusinessService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public UserResponse create(UserRequest request) {
        UserBusiness user = mapper.toEntity(request);
        user = repository.save(user);
        return mapper.toResponse(user);
    }

    public List<UserResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public UserResponse findById(Long id) {
        UserBusiness user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return mapper.toResponse(user);
    }

    public UserResponse update(Long id, UserRequest request) {
        UserBusiness user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        mapper.updateEntity(user, request);
        user = repository.save(user);

        return mapper.toResponse(user);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        repository.deleteById(id);
    }

}
