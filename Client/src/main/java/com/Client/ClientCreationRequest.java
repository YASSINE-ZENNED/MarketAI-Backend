package com.Client;

import lombok.Builder;

@Builder
public record ClientCreationRequest(
        String name,
        String email,
        String password,
        String address,
        String phone,
        String photo



        ) {
}
