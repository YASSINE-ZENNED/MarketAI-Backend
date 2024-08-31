package com.Client;

import jakarta.persistence.*;

import lombok.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity {

    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(unique = true)
    private String phone;
    private String address;
    private String photo;
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private ClientRole clientRole;

//  @Override
//  public Collection<? extends GrantedAuthority> getAuthorities() {
//    return List.of(new SimpleGrantedAuthority(clientRole.name()));
//  }

    //  @Override
    public String getUsername() {
        return name;
    }

    //  @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //  @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //  @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //  @Override
    public boolean isEnabled() {
        return true;
    }
}
