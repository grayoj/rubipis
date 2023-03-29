package com.boardend.boardend.repository;

import java.util.List;

import com.boardend.boardend.models.Rider;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RiderRepository extends JpaRepository<Rider, Long> {
    List<Rider> findByAvailable(boolean available);
    List<Rider> findByFirstName(String packageName);
}