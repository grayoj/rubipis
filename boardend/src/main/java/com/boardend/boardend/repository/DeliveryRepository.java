package com.boardend.boardend.repository;

import java.util.List;

import com.boardend.boardend.models.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findByDelivered(boolean delivered);
    List<Delivery> findByPackageName(String packageName);
}