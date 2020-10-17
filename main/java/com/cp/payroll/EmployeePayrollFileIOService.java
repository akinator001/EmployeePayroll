package com.cp.payroll;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollFileIOService {
	public static String EMP_PAYROLL_FILE = "EmployeePayrollFile.txt";

	public void writeData(List<EmployeePayrollData> empList) {
		StringBuffer empBuffer = new StringBuffer();
		empList.forEach(e -> {
			String empData = e.toString().concat("\n");
			empBuffer.append(empData);
		});
		
		try {
			Files.write(Paths.get(EMP_PAYROLL_FILE), empBuffer.toString().getBytes());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public long countEntries() {
		long entries = 0;
		try {
			entries = Files.lines(new File(EMP_PAYROLL_FILE).toPath()).count();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return entries;
	}
	
	public void printData() {
		try {
			Files.lines(new File(EMP_PAYROLL_FILE).toPath()).forEach(System.out::println);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<EmployeePayrollData> readData(){
		List<EmployeePayrollData> empPayrollList = new ArrayList<>();
		try {
			Files.lines(new File(EMP_PAYROLL_FILE).toPath()).map(line -> line.trim()).forEach(line -> {
				String[] words = line.split("[\\s,=]+");
				int id = Integer.parseInt(words[1]);
				String name = words[3];
				double salary = Double.parseDouble(words[6]);
				EmployeePayrollData e = new EmployeePayrollData(id, name, salary);
				empPayrollList.add(e);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return empPayrollList;
	}	
	
}
