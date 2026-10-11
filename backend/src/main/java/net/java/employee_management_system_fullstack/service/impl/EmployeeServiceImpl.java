package net.java.employee_management_system_fullstack.service.impl;

import net.java.employee_management_system_fullstack.dto.EmployeeDto;
import net.java.employee_management_system_fullstack.entity.Employee;
import net.java.employee_management_system_fullstack.exception.ResourceNotFoundException;
import net.java.employee_management_system_fullstack.repository.EmployeeRepository;
import net.java.employee_management_system_fullstack.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implements the business logic for employee management.
 */

@Service
public class EmployeeServiceImpl implements EmployeeService
{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto)
    {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDto.class);
        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long id)
    {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exist!")
        );


        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAllEmployees()
    {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().
                map((employee) -> modelMapper.map(employee, EmployeeDto.class)).
                toList();
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto)
    {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exist!")
        );

        existingEmployee.setFirstName(employeeDto.getFirstName());
        existingEmployee.setLastName(employeeDto.getLastName());
        existingEmployee.setEmail(employeeDto.getEmail());
        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return modelMapper.map(updatedEmployee, EmployeeDto.class);
    }

    @Override
    public void deleteEmployee(Long id)
    {
        Employee employee = employeeRepository.findById(id).get();
        if (employee == null)
        {
            throw new ResourceNotFoundException("Employee does not exist!");
        }
        employeeRepository.deleteById(id);

    }
}
