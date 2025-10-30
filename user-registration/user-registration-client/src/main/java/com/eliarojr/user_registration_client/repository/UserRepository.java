package com.eliarojr.user_registration_client.repository;

import com.eliarojr.user_registration_client.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
