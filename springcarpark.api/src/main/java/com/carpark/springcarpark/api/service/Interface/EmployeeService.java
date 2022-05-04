package com.carpark.springcarpark.api.service.Interface;

import com.carpark.springcarpark.api.dto.reponse.EmployeeResponse;
import com.carpark.springcarpark.api.dto.request.EmployeeRequest;
import com.carpark.springcarpark.api.model.Employee;
import com.carpark.springcarpark.api.model.ResponseObject;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpoint;
import java.util.List;


public interface EmployeeService {


    public EmployeeResponse addEmp(EmployeeRequest employeeRequest);
    public List<EmployeeResponse> viewEmp();

    public ResponseEntity<ResponseObject> findEmployeeById(Long employeeId);

    public Page<Employee> getEmployeePagination(Integer pageNumber,Integer pageSize);

    public  Page<Employee> getEmployeeSortPagination(Integer pageNumber,Integer pageSize);

}
