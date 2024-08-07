package students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
public class data {
	
	public void createdb() {
		
		try {
			String url = "jdbc:mysql://Localhost:/";
			String username = "root";
			String pass = "root";
			
			Connection con = DriverManager.getConnection(url,username,pass);
			
			Statement stm = con.createStatement();
			String query = "CREATE DATABASE studentmanagement;";
			stm.execute(query);
			System.out.println("Database Created");
			con.close();
		
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void createtable() {

	
	try {
		String url = "jdbc:mysql://Localhost:/studentmanagement";
		String username = "root";
		String pass = "root";
		
		Connection con = DriverManager.getConnection(url,username,pass);
		
		Statement stm = con.createStatement();
		String query = "CREATE TABLE Students (\r\n"
				+ "    EnrollmentNo INT PRIMARY KEY,\r\n"
				+ "    Name VARCHAR(100),\r\n"
				+ "    RollNo INT,\r\n"
				+ "    ContactNo VARCHAR(15),\r\n"
				+ "    EmailID VARCHAR(100)\r\n"
				+ ");";
		stm.execute(query);
		System.out.println("Table  Created");
		con.close();
		
		
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	
}

	public void insertdata() {
    try {
        String url = "jdbc:mysql://localhost/studentmanagement";
        String username = "root";
        String pass = "root";

        Connection con = DriverManager.getConnection(url, username, pass);

        Statement stm = con.createStatement();

        String query1 = "INSERT INTO Students VALUES (1001, 'Yash', 1, '9876543210', 'yash@example.com')";
        stm.executeUpdate(query1);

        String query2 = "INSERT INTO Students  VALUES (1002, 'smit', 2, '8765432109', 'smit@example.com')";
        stm.executeUpdate(query2);

        String query3 = "INSERT INTO Students  VALUES (1003, 'rutan', 3, '7654321098', 'rutan@example.com')";
        stm.executeUpdate(query3);

        String query4 = "INSERT INTO Students VALUES (1004, 'utsav', 4, '6543210987', 'utsav@example.com')";
        stm.executeUpdate(query4);

       
      

        System.out.println("Data inserted");
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

	public void fetchdata() {
    try {
        String url = "jdbc:mysql://localhost:3306/studentmanagement"; // Ensure the correct database name and port
        String username = "root";
        String password = "root";

        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection created: " + con);

        Statement stm = con.createStatement();

        ResultSet rs = stm.executeQuery("SELECT * FROM Students");

        System.out.println("EnrollmentNo  Name            RollNo  ContactNo     EmailID");
        while (rs.next()) {
            int enrollmentNo = rs.getInt("EnrollmentNo");
            String name = rs.getString("Name");
            int rollNo = rs.getInt("RollNo");
            String contactNo = rs.getString("ContactNo");
            String emailID = rs.getString("EmailID");
            System.out.printf("%-13d %-15s %-7d %-12s %-30s%n", enrollmentNo, name, rollNo, contactNo, emailID);
        }

        System.out.println("Data displayed");

        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
	
	

}
