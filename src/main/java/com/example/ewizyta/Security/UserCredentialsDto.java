package com.example.ewizyta.Security;

import com.example.ewizyta.role.Role;

import java.util.Objects;

public class UserCredentialsDto {
    private final String email;
    private final String password;
    private final Role role;

    public UserCredentialsDto(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCredentialsDto that = (UserCredentialsDto) o;
        return email.equals(that.email) && password.equals(that.password) && role.equals(that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, role);
    }
}
