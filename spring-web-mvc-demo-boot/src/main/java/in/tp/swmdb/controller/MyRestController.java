package in.tp.swmdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.tp.swmdb.model.ArithmeticModel;
import in.tp.swmdb.model.Employee;
import in.tp.swmdb.service.ArithmeticService;

@RestController
public class MyRestController{

	@Autowired
	private ArithmeticService arthService;
	
    @GetMapping("/f1")
    public String f1(){
        return "Hello! Welcome";
    }

    @GetMapping("/getEmp")
    public Employee f2(){
        Employee emp = new Employee();
        emp.setEmpId(101);
        emp.setName("Vamsy");
        return emp;
    }
    
    @PostMapping("/compute")
    public ResponseEntity<ArithmeticModel> compute(@RequestBody ArithmeticModel model){
    	ResponseEntity<ArithmeticModel> response;
    	
    	if(model!=null) {
    		arthService.computeResults(model);
    		response = new ResponseEntity<>(model,HttpStatus.OK);
    	}else {
    		response = new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    	}
    	
    	return response;
    }
}