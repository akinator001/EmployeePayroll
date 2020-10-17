package com.cp.payroll;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
}
