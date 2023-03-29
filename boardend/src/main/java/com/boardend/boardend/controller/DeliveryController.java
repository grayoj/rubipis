package com.boardend.boardend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boardend.boardend.models.Delivery;
import com.boardend.boardend.repository.DeliveryRepository;

@CrossOrigin(origins = "https://dashboard.rubidelivery.com/")
@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

    @Autowired
    DeliveryRepository deliveryRepository;

    @GetMapping("/delivery")
    public ResponseEntity<List<Delivery>> getAllDelivery(@RequestParam(required = false) String packageName) {
        try {
            List<Delivery> deliveries = new ArrayList<Delivery>();

            if (packageName == null)
                deliveryRepository.findAll().forEach(deliveries::add);
            else
                deliveryRepository.findByPackageName(packageName).forEach(deliveries::add);

            if (deliveries.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(deliveries, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/delivery/{id}")
    public ResponseEntity<Delivery> getDeliveryById(@PathVariable("id") long id) {
        Optional<Delivery> deliveryData = deliveryRepository.findById(id);

        if (deliveryData.isPresent()) {
            return new ResponseEntity<>(deliveryData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/delivery")
    public ResponseEntity<Delivery> createDelivery(@RequestBody Delivery delivery) {
        try {
            Delivery _delivery = deliveryRepository
                    .save(new Delivery(delivery.getDropAddress(), delivery.getPickupAddress(),
                            delivery.getPackageName(), delivery.getPackageType(), delivery.getDeliveryRider(),
                            false));
            return new ResponseEntity<>(_delivery, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/delivery/{id}")
    public ResponseEntity<Delivery> updateDelivery(@PathVariable("id") long id, @RequestBody Delivery delivery) {
        Optional<Delivery> deliveryData = deliveryRepository.findById(id);

        if (deliveryData.isPresent()) {
            Delivery _delivery = deliveryData.get();
            _delivery.setDeliveryRider(delivery.getDeliveryRider());
            _delivery.setPackageName(delivery.getPackageName());
            _delivery.setPackageType(delivery.getPackageType());
            _delivery.setDropAddress(delivery.getDropAddress());
            _delivery.setPickupAddress(delivery.getPickupAddress());
            _delivery.setDelivered(delivery.isDelivered());
            return new ResponseEntity<>(deliveryRepository.save(_delivery), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delivery/{id}")
    public ResponseEntity<HttpStatus> deleteDelivery(@PathVariable("id") long id) {
        try {
            deliveryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delivery")
    public ResponseEntity<HttpStatus> deleteAllDelivery() {
        try {
            deliveryRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/delivery/delivered")
    public ResponseEntity<List<Delivery>> findByDelivered() {
        try {
            List<Delivery> delivery = deliveryRepository.findByDelivered(true);

            if (delivery.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(delivery, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}