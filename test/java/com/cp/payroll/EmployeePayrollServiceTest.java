package com.cp.payroll;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class EmployeePayrollServiceTest {	    
	    @Test
		public void given3EmployeesWhenWrittenToFileShouldMatchNumberOfEmployeeEntries() {
			EmployeePayrollData[] arrayOfEmployees = { 
					new EmployeePayrollData(1, "Aakash Gandhi", 5000.0),
					new EmployeePayrollData(2, "sumit pandey", 4800.0),
					new EmployeePayrollData(3, "Dhanraj Bansal", 6500.0) };
			EmployeePayrollService employeePayrollService; 
			employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmployees));
			employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
			Assert.assertEquals(3, employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO));
		}	    
}
