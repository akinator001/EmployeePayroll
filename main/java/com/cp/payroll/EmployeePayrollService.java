package com.cp.payroll;

import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
	
	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}
	
	private List<EmployeePayrollData> employeePayrollList;
	

	public EmployeePayrollService() {
	}

	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	private void readEmployeePayrollData(Scanner sc) {
		System.out.print("Enter Employee ID: ");
		int id = sc.nextInt();
		
		System.out.print("Enter Employee Name: ");
		String name = sc.next();
		
		System.out.print("Enter Employee Salary: ");
		double salary = sc.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id, name, salary));
	}

	public void writeEmployeePayrollData(IOService ioService) {
		if (ioService.equals(IOService.CONSOLE_IO))
			System.out.println("\nWriting Payroll to Console\n" + employeePayrollList);
		else if (ioService.equals(IOService.FILE_IO))
			new EmployeePayrollFileIOService().writeData(employeePayrollList);

    }

    public long countEntries(IOService ioService) {
		if (ioService.equals(IOService.FILE_IO))
			return new EmployeePayrollFileIOService().countEntries();
		return 0;
	}
    
    public void printEmployeePayrollData(IOService ioService) {
    	if(ioService.equals(IOService.FILE_IO)) {
    		new EmployeePayrollFileIOService().printData();
    	}
    }
    
	
}