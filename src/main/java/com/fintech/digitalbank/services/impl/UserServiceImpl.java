package com.fintech.digitalbank.services.impl;

import com.fintech.digitalbank.dto.request.UserRequest;
import com.fintech.digitalbank.dto.response.BankResponse;
import com.fintech.digitalbank.entities.User;
import com.fintech.digitalbank.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public BankResponse createAccount(UserRequest userRequest) {
        User newUser = User.builder()
                .firstName(userRequest.firstName())
                .lastName(userRequest.lastName())
                .otherName(userRequest.otherName())
                .gender(userRequest.gender())
                .address(userRequest.address())
                .stateOfOrigin(userRequest.stateOfOrigin())
                .status(userRequest.status())
                .accountNumber(user.)
                .build()
        return null;
    }
}
