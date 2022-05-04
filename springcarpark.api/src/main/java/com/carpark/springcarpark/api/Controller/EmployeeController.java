package com.carpark.springcarpark.api.Controller;


import com.carpark.springcarpark.api.dto.reponse.EmployeeResponse;
import com.carpark.springcarpark.api.dto.request.EmployeeRequest;
import com.carpark.springcarpark.api.model.Employee;
import com.carpark.springcarpark.api.model.ResponseObject;
import com.carpark.springcarpark.api.service.Interface.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Employee/V1")
public class EmployeeController {


    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/viewAllEmployee")
    ResponseEntity<List<EmployeeResponse>> viewAllEmployee() {
        return new ResponseEntity<>(employeeService.viewEmp(), HttpStatus.OK);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<EmployeeResponse> add(@RequestBody EmployeeRequest employeeRequest) {
        return new ResponseEntity<>(employeeService.addEmp(employeeRequest), HttpStatus.CREATED);
    }

    @GetMapping("/viewEmployee/{employeeId}")
    ResponseEntity<ResponseObject> viewEmployeeById(@PathVariable Long employeeId) {
        return employeeService.findEmployeeById(employeeId);
    }

    @RequestMapping(value = "/paging/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public Page<Employee> employeePagination(@PathVariable Integer pageNumber, @PathVariable Integer pageSize) {

        return employeeService.getEmployeePagination(pageNumber, pageSize);
    }

    @RequestMapping(value = "/pagingAndSorting/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public Page<Employee> getEmployeeSortPagination(@PathVariable Integer pageNumber, @PathVariable Integer pageSize) {

        return employeeService.getEmployeePagination(pageNumber, pageSize);
    }
}
