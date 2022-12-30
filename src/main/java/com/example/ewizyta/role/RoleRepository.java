package com.example.ewizyta.role;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role getRoleByName(String name);
}
