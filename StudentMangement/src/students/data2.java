package students;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class data2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/studentmanagement";
		String user = "root";
		String pass = "root";
		
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			
			// create sql query 
			String query = "select * from students where RollNO=?";
			
			// create prepared statement
			PreparedStatement pstm = con.prepareStatement(query);
			
			// insert parameter value into prepare statement
			pstm.setInt(1, 2);
			
			// execute stm
			ResultSet rs = pstm.executeQuery();
			
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
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
