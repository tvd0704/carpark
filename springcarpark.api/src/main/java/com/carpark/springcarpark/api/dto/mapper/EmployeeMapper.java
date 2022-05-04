package com.carpark.springcarpark.api.dto.mapper;

import com.carpark.springcarpark.api.dto.reponse.EmployeeResponse;
import com.carpark.springcarpark.api.dto.request.EmployeeRequest;
import com.carpark.springcarpark.api.model.Employee;

public class EmployeeMapper {
    private static EmployeeMapper INSTANCE;
    //Get an employee mapper instance
    public static EmployeeMapper getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new EmployeeMapper();
        }
        return INSTANCE;
    }

    //convert DTO into Entity
    public Employee toEntity(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        employee.setAccount(employeeRequest.getAccount());
        employee.setDepartment(employeeRequest.getDepartment());
        employee.setEmployeeAddress(employeeRequest.getEmployeeAddress());
        employee.setEmployeeBirthdate(employeeRequest.getEmployeeBirthdate());
        employee.setEmployeeEmail(employeeRequest.getEmployeeEmail());
        employee.setEmployeeName(employeeRequest.getEmployeeName());
        employee.setEmployeePhone(employeeRequest.getEmployeePhone());
        employee.setSex(employeeRequest.getSex());
        return employee;
    }

    //convert Entity into DTO
    public EmployeeResponse toDTO(Employee employee) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setAccount(employee.getAccount());
        employeeResponse.setDepartment(employee.getDepartment());
        employeeResponse.setEmployeeAddress(employee.getEmployeeAddress());
        employeeResponse.setEmployeeBirthdate(employee.getEmployeeBirthdate());
        employeeResponse.setEmployeeEmail(employee.getEmployeeEmail());
        employeeResponse.setEmployeeName(employee.getEmployeeName());
        employeeResponse.setEmployeePhone(employee.getEmployeePhone());
        employeeResponse.setSex(employee.getSex());
        return employeeResponse;


    }




}
