package com.ttn.reap.repository;

import com.ttn.reap.entity.Recognition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecognitionRepository extends JpaRepository<Recognition, Integer> {

    public List<Recognition> findAll();

    public Optional<Recognition> findByMessage(String message);
}
