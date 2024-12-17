package com.fintech.digitalbank.services;

import com.fintech.digitalbank.dto.request.UserRequest;
import com.fintech.digitalbank.dto.response.BankResponse;

public interface UserService {

    BankResponse createAccount(UserRequest userRequest);

}
