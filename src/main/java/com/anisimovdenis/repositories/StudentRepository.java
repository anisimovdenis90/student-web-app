package com.anisimovdenis.repositories;

import com.anisimovdenis.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
