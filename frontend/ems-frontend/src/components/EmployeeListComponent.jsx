import React from 'react'
import { deleteEmployee, employeeList } from '../service/EmployeeList'
import { useState } from 'react'
import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

const EmployeeListComponent = () => {
   
    const [employees, setEmployees] = useState([]);
    useEffect(() =>
    {
        getAllEmployees();
    }, []);

    function getAllEmployees()
    {
        employeeList().then(response =>{
            setEmployees(response.data)

        }).catch(errors => console.error(errors));
    }

    const navigator = useNavigate();

    function addNewEmployee()
    {
        navigator('/add-employee');

    }
    function handleUpdateEmployee(id)
    {
        navigator(`/edit-employee/${id}`);
    }

    function handleDeleteEmployee(id)
    {
        console.log(id);
        deleteEmployee(id).then((response) => getAllEmployees());
    }

    return (
    <div className='container'>
        <br />
        <h2 className='text-center'>List of Employees</h2>
        <br />
        <button className  ="btn btn-primary" onClick={addNewEmployee}>Add Employee</button>
        <br /> <br /> 
     <table className='table table-striped table-bordered'>
        <thead>
            <tr>
                <th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>

        </thead>
        <tbody>
            {
                employees.map(employee => 
                    <tr key={employee.id}>
                        <td>{employee.id}</td>
                        <td>{employee.firstName}</td>
                        <td>{employee.lastName}</td>
                        <td>{employee.email}</td>
                        <td>
                            <button className = "btn btn-info" onClick={() => handleUpdateEmployee(employee.id)}>Update</button>
                            <button className = "btn btn-danger" onClick={() => handleDeleteEmployee(employee.id)} style={{marginLeft : "10px"}}>Delete</button>

                        </td>
                    </tr>
                )
            }
        </tbody>
        </table>   
    </div>
  )
}

export default EmployeeListComponent