package com.inspire11.etrak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inspire11.etrak.domain.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
