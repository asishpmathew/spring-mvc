package com.asish.demo.controller;
 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 
import com.asish.demo.model.EmployeeListVO;
import com.asish.demo.model.EmployeeVO;
 
@RestController
public class EmployeeRESTController 
{
    @RequestMapping(value = "/employees")
    public @ResponseBody EmployeeListVO getAllEmployees() 
    {
        EmployeeListVO employees = new EmployeeListVO();
         
        EmployeeVO empOne = new EmployeeVO(1,"test1","..","asish@gmail.com");
        EmployeeVO empTwo = new EmployeeVO(2,"test2","Singhal","as@yahoo.com");
        EmployeeVO empThree = new EmployeeVO(3,"tes3","Mishra","as@gmail.com");
         
         
        employees.getEmployees().add(empOne);
        employees.getEmployees().add(empTwo);
        employees.getEmployees().add(empThree);
         
        return employees;
    }
     
    @RequestMapping(value = "/employees/{id}")
    @ResponseBody
    public ResponseEntity<EmployeeVO> getEmployeeById (@PathVariable("id") int id) 
    {
        if (id <= 3) {
            EmployeeVO employee = new EmployeeVO(1,"test","Gupta","asish@gmail.com");
            return new ResponseEntity<EmployeeVO>(employee, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}