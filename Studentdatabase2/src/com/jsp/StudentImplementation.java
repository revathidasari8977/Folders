package com.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentImplementation implements StudentInterface{

	Scanner scanner=new Scanner(System.in);
	@Override
	public void addStudent() {
		System.out.println("Enter The Student Id:");
		int id=scanner.nextInt();

		System.out.println("Enter The Student Name:");
		String name=scanner.next();

		System.out.println("Enter The Student age:");
		int age=scanner.nextInt();

		System.out.println("Enter The Student Gender:");
		String gender=scanner.next();

		System.out.println("Enter The Student marks:");
		double marks=scanner.nextDouble();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase2"
					+ "","root","root");
			PreparedStatement preparedstatement=connection.prepareStatement("insert into student values(?,?,?,?,?)");

			preparedstatement.setInt(1,id);
			preparedstatement.setString(2, name);
			preparedstatement.setInt(3, age);
			preparedstatement.setString(4, gender);
			preparedstatement.setDouble(5, marks);
			preparedstatement.execute();
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void deleteStudent() {
		System.out.println("Enter id:");
		int id=scanner.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase2","root","root");
			PreparedStatement preparedstatement=connection.prepareStatement("delete from student where id=?");
			preparedstatement.setInt(1, id);
			preparedstatement.execute();
			connection.close();
			System.out.println("Student Record deleted Successfully!");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}



	}

	@Override
	public void UpdateStudent() {
		System.out.println("Enter Marks:");
		double marks=scanner.nextDouble();
		System.out.println("Enter id:");

		int id=scanner.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase2","root","root");
			PreparedStatement preparedstatement=connection.prepareStatement("update student set marks=? where id=?");
			preparedstatement.setDouble(1, marks);
			preparedstatement.setInt(2, id);
			preparedstatement.execute();
			connection.close();
			System.out.println("Student Record deleted Successfully!");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}





	}

	@Override
	public void getStudentByMarks() {

		System.out.println("Enter Marks:");
		double marks=scanner.nextDouble();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase2","root","root");
			PreparedStatement preparedstatement=connection.prepareStatement("select * from student where marks>=? ");
			preparedstatement.setDouble(1, marks);
			ResultSet resultset=preparedstatement.executeQuery();
			while( resultset.next()) {
				System.out.println("id:"+resultset.getInt(1));

				System.out.println("Name:"+resultset.getString(2));

				System.out.println("Age:"+resultset.getInt(3));

				System.out.println("Gender:"+resultset.getString(4));

				System.out.println("Marks:"+resultset.getDouble(5));

			}
			connection.close();
			System.out.println("Student Record deleted Successfully!");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void getAllStudents() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase2","root","root");
			PreparedStatement preparedstatement=connection.prepareStatement("select * from student ");

			ResultSet resultset=preparedstatement.executeQuery();
			while( resultset.next()) {
				System.out.println("id:"+resultset.getInt(1));

				System.out.println("Name:"+resultset.getString(2));

				System.out.println("Age:"+resultset.getInt(3));

				System.out.println("Gender:"+resultset.getString(4));

				System.out.println("Marks:"+resultset.getDouble(5));

			}
			connection.close();
			System.out.println("Student Record deleted Successfully!");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}



	}

}
