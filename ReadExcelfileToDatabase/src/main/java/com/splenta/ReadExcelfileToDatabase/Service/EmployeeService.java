package com.splenta.ReadExcelfileToDatabase.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.splenta.ReadExcelfileToDatabase.Model.EmployeeEntity;
import com.splenta.ReadExcelfileToDatabase.Repo.EmployeeRepo;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;
	

	public List<EmployeeEntity> getAllEmpDetails() {
		
		return employeeRepo.findAll();
	}


//	@SuppressWarnings("deprecation")
	public List<EmployeeEntity>  uploadFile(@RequestParam("file") MultipartFile file) {
		List<EmployeeEntity> employees=new ArrayList();

		try {
			XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
			
		
	        XSSFSheet worksheet = workbook.getSheetAt(0);

			// creating a row of a Excel sheet and iterating over a rows
			for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
	            if (index > 0) {
	                EmployeeEntity employee = new EmployeeEntity();

	                XSSFRow row = worksheet.getRow(index);
	                Integer id = (int) row.getCell(0).getNumericCellValue();

	                employee.setEmpId(id);
	                employee.setEmpName(row.getCell(1).getStringCellValue());
	                employee.setEmpDesignation(row.getCell(2).getStringCellValue());
	                employee.setEmpEmail(row.getCell(3).getStringCellValue());
	                employeeRepo.save(employee);
	                
//	                employees.add(employee);
	            }
	        }
		}catch(Exception e) {
			e.getMessage();
		}
//		try {
//			XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
//			
//		
//	        XSSFSheet worksheet = workbook.getSheetAt(0);
//
//	        for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
//	            if (index > 0) {
//	                EmployeeEntity employee = new EmployeeEntity();
//
//	                XSSFRow row = worksheet.getRow(index);
//	                Integer id = (int) row.getCell(0).getNumericCellValue();
//
//	                employee.setEmpId(id);
//	                employee.setEmpName(row.getCell(1).getStringCellValue());
//	                employee.setEmpDesignation(row.getCell(2).getStringCellValue());
//	                employee.setEmpEmail(row.getCell(3).getStringCellValue());
//	                
//	                employees.add(employee);
//	            }
//	        }
//		}catch(Exception e) {
//			e.getMessage();
//		}

		return employees;
	}

}
