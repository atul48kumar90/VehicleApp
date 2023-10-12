package com.example.vehicle.repository;

import com.example.vehicle.entity.Pictures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepo extends JpaRepository<Pictures,String> {
}
