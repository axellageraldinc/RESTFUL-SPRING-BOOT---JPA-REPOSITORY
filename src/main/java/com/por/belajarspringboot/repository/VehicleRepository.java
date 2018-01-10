package com.por.belajarspringboot.repository;

import com.por.belajarspringboot.entity.Person;
import com.por.belajarspringboot.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findAllByPersonId(Long personId);
    Vehicle findByPersonIdAndId(Long personId, Long vehicleId);
    void deleteByPersonIdAndId(Long personId, Long vehicleId);

}
