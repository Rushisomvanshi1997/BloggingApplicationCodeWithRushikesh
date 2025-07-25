package com.codeWithRushikesh.repositories;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeWithRushikesh.entities.Role;

@Repository
public interface RoleRepo  extends JpaRepository<Role, Integer>{


    Role findByName(String name);
	

}
