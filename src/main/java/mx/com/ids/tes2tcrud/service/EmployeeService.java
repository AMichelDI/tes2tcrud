package mx.com.ids.tes2tcrud.service;

import mx.com.ids.tes2tcrud.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee updateEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployeeId(long employeeId);

    void deleteEmployee(long id);
}
