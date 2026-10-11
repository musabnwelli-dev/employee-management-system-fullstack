package net.java.employee_management_system_fullstack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Exception thrown when a requested resource is not found.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException
{
    /**
     * Creates the exception with a custom message
     * @param message error message
     */
    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}
