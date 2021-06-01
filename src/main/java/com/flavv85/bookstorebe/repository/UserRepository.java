package com.flavv85.bookstorebe.repository;

import com.flavv85.bookstorebe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
