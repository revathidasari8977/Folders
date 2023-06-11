package com.jsp;

import java.util.Scanner;

public class Student {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);

		StudentInterface si=new StudentImplementation();//upcasting


		while(true)
		{
			System.out.println("WECOME TO STUDENT DATABASE");
			System.out.println("1.Add Student\n2.Delete Student\n3.Update Student");
			System.out.println("4.Get Student by marks\n5.Get All Students");
			int choice=scanner.nextInt();

			switch(choice)
			{

			case 1:
				si.addStudent();
				System.out.println("Student details Added Successfully!");
				break;
			case 2:
				si.deleteStudent();
				System.out.println("Student Details Deleted Successfully!");
				break;

			case 3:
				si.UpdateStudent();
				System.out.println("Student Details Updated Successfully!");
				break;
			case 4:
				si.getStudentByMarks();
				System.out.println("Student Details got Successfully By Marks!");
				break;
			case 5:
				si.getAllStudents();
				System.out.println("All Student Details Are as Follows!");
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}
	}

}
