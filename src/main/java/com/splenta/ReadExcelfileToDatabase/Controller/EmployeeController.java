package com.splenta.ReadExcelfileToDatabase.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.splenta.ReadExcelfileToDatabase.Model.EmployeeEntity;
import com.splenta.ReadExcelfileToDatabase.Service.EmployeeService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/details")
	public ResponseEntity<?> getAllempdetails(){
		return ResponseEntity.ok().body(employeeService.getAllEmpDetails());
	}
	@PostMapping("/upload")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file){
		return ResponseEntity.ok().body(employeeService.uploadFile(file));
		}

}
