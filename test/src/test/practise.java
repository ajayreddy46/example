package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class practise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Read Data Example!");
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/";
		String db = "persons";
		String driver = "com.mysql.jdbc.Driver";
		try {
		Class.forName(driver);
		System.out.println(url + db);
		con = DriverManager.getConnection(url + db, "root", "Sirisweety46");
		try {
				
			Statement st = con.createStatement();
			String selectSQL="SELECT * FROM  persons";
			
			ResultSet res = st.executeQuery(selectSQL);
			
			 
			  System.out.println("Data:");
			  while (res.next()) {
				  int accno = res.getInt("accno");
				  String firstname = res.getString("firstname");
				  String lastname = res.getString("lastname");
				  int phonenumber = res.getInt("phonenumber");
				  String state = res.getString("state");
				  System.out.println("accno: "+ accno);
				  System.out.println("firstname: "+ firstname);
				  System.out.println("lastname: "+ lastname);
				  System.out.println("phonenumber: "+ phonenumber);
				  System.out.println("state: "+ state);
			  }
			  

			System.out.println("Data Displayed");
		} catch (SQLException s) {
			System.out.println("SQL statement is not executed!");
		}

		con.close();
		} catch (Exception e) {
		e.printStackTrace();
		}


	}

}



