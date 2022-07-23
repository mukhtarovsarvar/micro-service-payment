package com.click.repository;

import com.click.model.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<ProfileEntity, String> {

    Optional<ProfileEntity> findByUsername(String username);
    Optional<ProfileEntity> findByPhone(String phone);
}