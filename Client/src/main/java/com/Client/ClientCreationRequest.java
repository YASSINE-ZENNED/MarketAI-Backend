package com.Client;

public record ClientCreationRequest(
        String name,
        String email,
        String password,
        String address,
        String phone,
        String photo



        ) {
}
