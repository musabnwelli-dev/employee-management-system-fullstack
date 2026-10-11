package net.java.employee_management_system_fullstack.service;

import net.java.employee_management_system_fullstack.dto.EmployeeDto;

import java.util.List;

/**
 * Defines business operations for employee management
 */
public interface EmployeeService
{
    /**
     * Adds a new employee
     * @param employeeDto employee data
     * @return saved employee
     */
    EmployeeDto addEmployee(EmployeeDto employeeDto);

    /**
     * Finds an employee by ID
     * @param id employee ID
     * @return employee data
     */
    EmployeeDto getEmployeeById(Long id);

    /**
     * Returns all employees
     * @return list of employees
     */
    List<EmployeeDto> getAllEmployees();

    /**
     * Updates an employee
     * @param id employee ID
     * @param employeeDto updated data
     * @return updated employee
     */
    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);

    /**
     * Deletes an employee.
     * @param id employee ID
     */
    void deleteEmployee(Long id);
}
