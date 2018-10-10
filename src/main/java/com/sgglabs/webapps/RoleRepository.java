package com.sgglabs.webapps;

import com.sgglabs.webapps.model.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends CrudRepository<Role, Integer> {
}