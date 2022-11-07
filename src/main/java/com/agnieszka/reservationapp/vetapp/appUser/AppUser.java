package com.agnieszka.reservationapp.vetapp.appUser;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;

    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    private Boolean locked = true;

    private Boolean enabled = true;

    public AppUser(
            final String firstName,
            final String lastName,
            final String email,
            final String password,
            final UserRole userRole
           ) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singleton(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
