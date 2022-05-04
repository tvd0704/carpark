package com.carpark.springcarpark.api.service;

import com.carpark.springcarpark.api.dto.mapper.EmployeeMapper;
import com.carpark.springcarpark.api.dto.reponse.EmployeeResponse;
import com.carpark.springcarpark.api.dto.request.EmployeeRequest;
import com.carpark.springcarpark.api.model.Employee;
import com.carpark.springcarpark.api.model.ResponseObject;
import com.carpark.springcarpark.api.repository.BookingOfficeRepository;
import com.carpark.springcarpark.api.repository.EmployeeRepository;
import com.carpark.springcarpark.api.repository.TripRepository;
import com.carpark.springcarpark.api.service.Interface.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceIml implements EmployeeService {


    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceIml(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    @Transactional
    public EmployeeResponse addEmp(EmployeeRequest employeeRequest) {
        //convert employee DTO into employee
        Employee employee = EmployeeMapper.getInstance().toEntity(employeeRequest);
        return EmployeeMapper.getInstance().toDTO(employeeRepository.save(employee));
    }


    @Override
    @Transactional
    public List<EmployeeResponse> viewEmp() {
        return employeeRepository.findAll().stream()
                .map(employee -> EmployeeMapper.getInstance()
                        .toDTO(employee)).collect(Collectors.toList());
    }


    @Override
    @Transactional
    public ResponseEntity<ResponseObject> findEmployeeById(Long employeeId) {
        Optional<Employee> foundEmployee = employeeRepository.findById(employeeId);
        if (foundEmployee.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok", "Query Employee by ID successfully", foundEmployee)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("Not Found", "Cannot find Employee with Id = " + employeeId, "")
            );
        }
    }

    @Override
    @Transactional
    public Page<Employee> getEmployeePagination(Integer pageNumber, Integer pageSize) {

        Pageable pageable=PageRequest.of(pageNumber,pageSize);
        return employeeRepository.findAll(pageable);

    }

    @Override
    public Page<Employee> getEmployeeSortPagination(Integer pageNumber, Integer pageSize) {

        Sort sort=Sort.by(Sort.Direction.ASC,"employeeName");
        Pageable pageable=PageRequest.of(pageNumber,pageSize);
        return employeeRepository.findAll(pageable);
    }




}
