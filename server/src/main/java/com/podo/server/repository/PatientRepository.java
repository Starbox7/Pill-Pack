package com.podo.server.repository;

import com.podo.server.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<PatientEntity, UUID> {
}