package com.carpark.springcarpark.api.dto.request;

import com.carpark.springcarpark.api.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class EmployeeRequest {

    private String account;
    private String department;
    private String employeeAddress;
    private Date employeeBirthdate;
    private String employeeEmail;
    private String employeeName;
    private String employeePhone;
    private Boolean sex;

    public EmployeeRequest() {

    }


    public EmployeeRequest(String account, String department, String employeeAddress, Date employeeBirthdate, String employeeEmail,
                           String employeeName, String employeePhone, Boolean sex) {
        this.account = account;
        this.department = department;
        this.employeeAddress = employeeAddress;
        this.employeeBirthdate = employeeBirthdate;
        this.employeeEmail = employeeEmail;
        this.employeeName = employeeName;
        this.employeePhone = employeePhone;
        this.sex = sex;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Date getEmployeeBirthdate() {
        return employeeBirthdate;
    }

    public void setEmployeeBirthdate(Date employeeBirthdate) {
        this.employeeBirthdate = employeeBirthdate;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
}
