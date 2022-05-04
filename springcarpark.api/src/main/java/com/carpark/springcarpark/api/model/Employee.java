package com.carpark.springcarpark.api.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "employee")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long employeeId;

    private String account;

    private String department;

    private String employeeAddress;

    private Date employeeBirthdate;

    private String employeeEmail;

    private String employeeName;

    private String employeePhone;

    private Boolean sex;

    public Employee() {
    }

    public Employee(Long employeeId, String account, String department, String employeeAddress, Date employeeBirthdate, String employeeEmail,
                    String employeeName, String employeePhone, Boolean sex) {
        this.employeeId = employeeId;
        this.account = account;
        this.department = department;
        this.employeeAddress = employeeAddress;
        this.employeeBirthdate = employeeBirthdate;
        this.employeeEmail = employeeEmail;
        this.employeeName = employeeName;
        this.employeePhone = employeePhone;
        this.sex = sex;
    }

    public Employee(String account, String department,
                    String employeeAddress, Date employeeBirthdate,
                    String employeeEmail, String employeeName,
                    String employeePhone, Boolean sex) {
        this.account = account;
        this.department = department;
        this.employeeAddress = employeeAddress;
        this.employeeBirthdate = employeeBirthdate;
        this.employeeEmail = employeeEmail;
        this.employeeName = employeeName;
        this.employeePhone = employeePhone;
        this.sex = sex;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", account='" + account + '\'' +
                ", department='" + department + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", employeeBirthdate='" + employeeBirthdate + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeePhone='" + employeePhone + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
