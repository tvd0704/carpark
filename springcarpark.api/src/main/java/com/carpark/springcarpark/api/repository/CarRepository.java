package com.carpark.springcarpark.api.repository;

import com.carpark.springcarpark.api.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface CarRepository extends JpaRepository<Car,String> {
}
