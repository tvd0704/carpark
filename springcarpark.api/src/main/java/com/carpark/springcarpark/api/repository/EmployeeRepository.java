package com.carpark.springcarpark.api.repository;

import com.carpark.springcarpark.api.dto.request.EmployeeRequest;
import com.carpark.springcarpark.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
