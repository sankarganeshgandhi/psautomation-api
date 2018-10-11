package com.sgglabs.webapps;

import com.sgglabs.webapps.model.entity.Script;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScriptRepository extends CrudRepository<Script, Integer> {
}
