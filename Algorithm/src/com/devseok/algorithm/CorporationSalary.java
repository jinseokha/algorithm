package com.devseok.algorithm;

public class CorporationSalary {

	private long[] salaries;
	
	public static void main(String[] args) {
		new CorporationSalary();
	}
	
	public CorporationSalary() {
		
		String[] realations1 = {"N"};
		String[] realations2 = {"NNYN","NNYN","NNNN","NYYN"};
		String[] realations3 = {"NNNNNN","YNYNNY", "YNNNNY", "NNNNNN", "YNYNNN", "YNNYNN"};
		String[] realations4 = {"NYNNYN","NNNNNN","NNNNNN","NNYNNN","NNNNNN","NNNYYN"};
		String[] realations5 = {"NNNN","NNNN","NNNN","NNNN"};
		
		
		
		long ans1 = totalSalary(realations1);
		long ans2 = totalSalary(realations2);
		long ans3 = totalSalary(realations3);
		long ans4 = totalSalary(realations4);
		long ans5 = totalSalary(realations5);
		
		System.out.println("ans1 = " + ans1);
		System.out.println("ans2 = " + ans2);
		System.out.println("ans3 = " + ans3);
		System.out.println("ans4 = " + ans4);
		System.out.println("ans5 = " + ans5);
	}
	
	
	public long totalSalary(String[] relations) {
		
		salaries = new long[relations.length];
		
		long total = 0;
		for (int index = 0; index < relations.length; index++) {
			total += getSalary(index, relations);
		}
		
		return total;
		
	}
	
	private long getSalary(int i, String[] relations) {
		if (salaries[i] == 0) {
			long salary = 0;
			String relation = relations[i];
			
			for (int index = 0; index < relation.length(); index++) {
				if (relation.charAt(index) == 'Y') {
					salary += getSalary(index, relations);
				}
			}
			
			if (salary == 0) {
				salary = 1;
			}
			
			salaries[i] = salary;
		}
		
		return salaries[i];
	}
}
