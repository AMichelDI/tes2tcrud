package mx.com.ids.tes2tcrud.controller;

import mx.com.ids.tes2tcrud.exception.Mensaje;
import mx.com.ids.tes2tcrud.model.Employee;
import mx.com.ids.tes2tcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/listaemployees")
    public ResponseEntity<?> getAllEmployee(){
        List<Employee> lista = employeeService.getAllEmployee();
        if(lista.isEmpty()) {
            return new ResponseEntity<>(new Mensaje("Sin employees en la base de datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(employeeService.getAllEmployee());
    }

    @GetMapping("/detalleemployee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
    }

    @PostMapping("crearemployee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok().body(this.employeeService.createEmployee(employee));
    }

    @PutMapping("actualizaremployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        employee.setEmployeeId(id);
        return ResponseEntity.ok().body(this.employeeService.updateEmployee(employee));
    }

    @DeleteMapping("eliminaremployee/{id}")
    public HttpStatus deleteEmployee(@PathVariable long id) {
        this.employeeService.deleteEmployee(id);
        return HttpStatus.OK;
    }
}
