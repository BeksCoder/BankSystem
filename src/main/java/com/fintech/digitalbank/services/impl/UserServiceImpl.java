package com.fintech.digitalbank.services.impl;

import com.fintech.digitalbank.dto.AccountInfo;
import com.fintech.digitalbank.dto.request.UserRequest;
import com.fintech.digitalbank.dto.response.BankResponse;
import com.fintech.digitalbank.entities.User;
import com.fintech.digitalbank.repositories.UserRepository;
import com.fintech.digitalbank.services.UserService;
import com.fintech.digitalbank.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public BankResponse createAccount(UserRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.email())) {
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                    .accountInfo(null)
                    .build();
        }
        User newUser = User.builder()
                .firstName(userRequest.firstName())
                .lastName(userRequest.lastName())
                .otherName(userRequest.otherName())
                .gender(userRequest.gender())
                .address(userRequest.address())
                .stateOfOrigin(userRequest.stateOfOrigin())
                .status("ACTIVE")
                .accountNumber(AccountUtils.generateAccountNumber())
                .email(userRequest.email())
                .accountBalance(BigDecimal.ZERO)
                .phoneNumber(userRequest.phoneNumber())
                .alterNativePhoneNumber(userRequest.alterNativePhoneNumber())
                .build();
User savedUser = userRepository.save(newUser);
        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS)
                .responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .accountBalance(savedUser.getAccountBalance())
                        .accountNumber(savedUser.getAccountNumber())
                        .accountName(String.join(" ", savedUser.getFirstName(), savedUser.getLastName()))
                        .build())
                .build();
    }
}
