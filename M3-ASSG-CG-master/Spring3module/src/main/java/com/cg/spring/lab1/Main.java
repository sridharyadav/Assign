package com.cg.spring.lab1;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String args[])
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		Employee employee=(Employee) context.getBean("employee");
		System.out.println(employee.getEmployeeId());
		System.out.println(employee.getEmployeeName());
		System.out.println(employee.getSalary());
		System.out.println(employee.getBusinessUnit());
		System.out.println(employee.getAge());
		System.out.println(employee.getSbu().getSbuId());
		System.out.println(employee.getSbu().getSbuName());
		System.out.println(employee.getSbu().getSbuHead());
		SBU sbu=(SBU) context.getBean("sbu");
		System.out.println("******************************************");
		for(Employees a:sbu.employees)
		{
			System.out.println(a.getEmployeeId());
			System.out.println(a.getEmployeeName());
			System.out.println(a.getSalary());
		}
		Scanner scanner=new Scanner(System.in);
		int employeeId=scanner.nextInt();
		boolean b=false;
		for(Employees employee1:sbu.employees)
		{
			if(employeeId==employee1.getEmployeeId())
			{
				System.out.println(employee1.getEmployeeName());
				System.out.println(employee1.getSalary());
				b=true;
			}
			
		}
		if(b==false)
		{
			System.out.println("EmployeeId doesnot Exists");
		}
		
		
		
	}

}
