package com.cp.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
	
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

	private void writeEmployeePayrollData() {
		System.out.println("\n Writing Employee Payroll Data to Console\n" + employeePayrollList);
	}
	
	public static void main(String[] args) {
		List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
		Scanner sc = new Scanner(System.in);
		employeePayrollService.readEmployeePayrollData(sc);
		employeePayrollService.writeEmployeePayrollData();
	}
}