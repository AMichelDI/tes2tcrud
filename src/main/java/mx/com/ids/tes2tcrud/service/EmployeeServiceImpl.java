package mx.com.ids.tes2tcrud.service;

import mx.com.ids.tes2tcrud.exception.ResourceNotFoundException;
import mx.com.ids.tes2tcrud.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.ids.tes2tcrud.repository.EmployeeRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeId(long employeeId) {
        Optional<Employee> employeeDb = this.employeeRepository.findById(employeeId);

        if (employeeDb.isPresent()) {
            return employeeDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found whit id: " + employeeId);
        }
    }


    @Override
    public List<Employee> getAllEmployee() {
        return this.employeeRepository.findAll();
    }


    @Override
    public void deleteEmployee(long employeeId) {
        Optional<Employee> employeeDb = this.employeeRepository.findById(employeeId);
        if (employeeDb.isPresent()) {
            this.employeeRepository.delete(employeeDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found whit id: " + employeeId);
        }
    }


    @Override
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> employeeDb = this.employeeRepository.findById(employee.getEmployeeId());

        if (employeeDb.isPresent()) {
            Employee employeeUpdate = employeeDb.get();
            employeeUpdate.setEmployeeId(employee.getEmployeeId());
            employeeUpdate.setSurname(employee.getSurname());
            employeeUpdate.setFirtsName(employee.getFirtsName());
            employeeUpdate.setCountry(employee.getCountry());
            employeeRepository.save(employeeUpdate);
            return employeeUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found whit id: " + employee.getEmployeeId());
        }
    }
}





