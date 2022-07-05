package mx.com.ids.tes2tcrud.service;

import mx.com.ids.tes2tcrud.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee (Employee employee);
    Employee updateEmployee (Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(long employeeId);
    void deleteEmployee(long id);
}
