import java.util.*;
import java.sql.*;

public class Example {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Example();

	}

	public Example() {
		try
		{

			//*******************************************************
			//     CONNECT TO DATABASE
			//
			//
			// check for jdbc driver


               //Looks for the database by the given information
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://ec2-54-204-24-202.compute-1.amazonaws.com:5432/d95r26089mgb07";

			Properties props = new Properties();
			props.setProperty("user", "enheidiptehcsa");
			props.setProperty("password", "EM9N7RPQOHUE00fsf12hPRlOfN");
			props.setProperty("ssl", "true");
			props.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
			//
			// connect to the database

			Connection conn = DriverManager.getConnection(url,props);
			//
			//*******************************************************


			//*******************************************************
			// build the query and get result from result set
			//
			//
			String query = "SELECT * FROM \"NODEDESCRIPTION\" WHERE \"TYPE\" = 0";
			//
			//
			// create statement and execute query
			//
			//
			Statement stmt2 = conn.createStatement();
			//
			ResultSet rs2 = stmt2.executeQuery(query);  // return a result set
			//
			//
			//step through all records in the result set and print contents
			//
			//
			while(rs2.next()) {
				//gets string of the SID in the node tables created
				String sid = rs2.getString("SID");
				//gets the description from the node tables created
				String desc = rs2.getString("Description");
				//Prints out the value
				System.out.println("SID = " + sid +  " Description = " + desc);
			}
			//******************************************************

			// close the database connection

			conn.close();

		}
		//Catches any errors
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

}

