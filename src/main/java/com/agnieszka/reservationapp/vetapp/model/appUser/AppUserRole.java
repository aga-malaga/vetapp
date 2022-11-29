package com.agnieszka.reservationapp.vetapp.model.appUser;

import org.springframework.security.core.GrantedAuthority;

public enum AppUserRole implements GrantedAuthority {
    CLIENT("CLIENT"),
    ADMIN("ADMIN"),
    DOCTOR("DOCTOR"),
    ;

    private final String authority;

    AppUserRole(final String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
