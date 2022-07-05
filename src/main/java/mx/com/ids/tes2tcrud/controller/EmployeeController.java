package mx.com.ids.tes2tcrud.controller;

import mx.com.ids.tes2tcrud.exception.Mensaje;
import mx.com.ids.tes2tcrud.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import mx.com.ids.tes2tcrud.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/listemployee")
    public ResponseEntity<?> getAllEmployee() {
        List<Employee> lista = employeeService.getAllEmployee();
        if (lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Sin empleados en la BD"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(employeeService.getAllEmployee());
    }

    @GetMapping("/oneemployee/{id}")
    public ResponseEntity<Employee> getEmployeeId(@PathVariable long id) {
        return ResponseEntity.ok().body(employeeService.getEmployeeId(id));
    }

    @PutMapping("/updatemployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        employee.setEmployeeId(id);
        return ResponseEntity.ok().body(this.employeeService.updateEmployee(employee));
    }

    @DeleteMapping("/deletemployeet/{id}")
    public HttpStatus deleteEmployee(@PathVariable long id) {
        this.employeeService.deleteEmployee(id);
        return HttpStatus.OK;
    }
}


