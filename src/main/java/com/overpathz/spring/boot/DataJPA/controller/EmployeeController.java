package com.overpathz.spring.boot.DataJPA.controller;


import com.overpathz.spring.boot.DataJPA.entity.Employee;
import com.overpathz.spring.boot.DataJPA.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> showAllEmployee() {
        List<Employee> allEmployee = employeeService.getAllEmployees();
        return allEmployee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public Employee deleteEmployee(@PathVariable("id") int id) {
        Employee deletedEmployee = employeeService.getEmployee(id);
        employeeService.deleteEmployee(id);
        System.out.println("devtools, test, id: " + id);
        return deletedEmployee;
    }

    @GetMapping("/employees/{id}")
    public Employee showAllEmployee(@PathVariable("id") int id) {
        Employee employee = employeeService.getEmployee(id);
        return employee;
    }
}
