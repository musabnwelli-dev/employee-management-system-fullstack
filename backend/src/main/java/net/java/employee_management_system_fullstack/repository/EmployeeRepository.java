package net.java.employee_management_system_fullstack.repository;

import net.java.employee_management_system_fullstack.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for accessing employee data in the database.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
}
