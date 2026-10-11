package net.java.employee_management_system_fullstack.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO used to transfer employee data between application layers.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto
{
    private Long id;

    private String firstName;

    private String lastName;

    private String email;
}
