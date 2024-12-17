package com.fintech.digitalbank.dto.request;

import com.fintech.digitalbank.enums.Gender;
import lombok.Builder;

@Builder
public record UserRequest(
         Long id,
         String firstName,
         String lastName,
         String otherName,
         Gender gender,
         String address,
         String stateOfOrigin,
         String email,
         String phoneNumber,
         String alterNativePhoneNumber,
         String status
) {

}
