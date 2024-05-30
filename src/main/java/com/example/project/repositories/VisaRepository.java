package com.example.project.repositories;

import com.example.project.databases.Visa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisaRepository extends JpaRepository<Visa, Long> {
}
