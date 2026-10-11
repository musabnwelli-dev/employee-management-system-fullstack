package net.java.employee_management_system_fullstack.controller;

import net.java.employee_management_system_fullstack.dto.EmployeeDto;
import net.java.employee_management_system_fullstack.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for handling employee requests
 */
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    /**
     * Creates a new employee
     * @param employeeDto employee data
     * @return created employee
     */
    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto employee = employeeService.addEmployee(employeeDto);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    /**
     * Retrieves an employee by ID
     * @param id employee ID
     * @return employee data
     */
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id)
    {
        EmployeeDto employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /**
     * Retrieves all employees
     * @return list of employees
     */
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees()
    {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * Updates an existing employee
     * @param id employee ID
     * @param employeeDto updated employee data
     * @return updated employee
     */
    @PutMapping("/{id}/update")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,
                                                      @RequestBody EmployeeDto employeeDto)
    {
        employeeDto.setId(id);
        EmployeeDto employee = employeeService.updateEmployee(id, employeeDto);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /**
     * Deletes an employee by ID
     * @param id employee ID
     * @return confirmation message
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id)
    {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("The Employee was deleted successfully", HttpStatus.OK);
    }





}
