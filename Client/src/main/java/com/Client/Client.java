package com.Client;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Client {

    public Client(Long id, String email, String photo) {
        this.id = id;
        this.email = email;
        this.photo = photo;
    }


    @Id
    @GeneratedValue
    private Long id;

    public String name;
    public String email;
    public String password;
    public String phone;
    public String address;
    public String photo;



}
