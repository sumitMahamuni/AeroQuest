package com.aeroQuest.ars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aeroQuest.ars.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

}
