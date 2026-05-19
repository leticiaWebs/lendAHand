package com.project.lendAHand.userBusiness.mapper;

import com.project.lendAHand.model.UserRequest;
import com.project.lendAHand.model.UserResponse;
import com.project.lendAHand.userBusiness.domain.UserBusiness;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public UserBusiness toEntity(UserRequest request) {
        UserBusiness user = new UserBusiness();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhone(request.getPhone());
        user.setUserType(request.getUserType());
        user.setCity(request.getCity());
        return user;
    }

    public UserResponse toResponse(UserBusiness user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setPhone(user.getPhone());
        response.setUserType(user.getUserType());
        response.setCity(user.getCity());
        return response;
    }

    public void updateEntity(UserBusiness user, UserRequest request) {
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhone(request.getPhone());
        user.setUserType(request.getUserType());
        user.setCity(request.getCity());
    }
}
