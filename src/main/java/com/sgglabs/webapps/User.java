package com.sgglabs.webapps;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User extends CrudRepository<User, Integer> {
}