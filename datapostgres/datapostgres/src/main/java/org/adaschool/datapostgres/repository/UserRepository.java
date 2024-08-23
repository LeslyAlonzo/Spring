package org.adaschool.datapostgres.repository;

import org.adaschool.datapostgres.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
