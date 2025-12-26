package generic_utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtils {
	Connection conn = null;
	ResultSet result = null ; 
	/**
	 * This method is used to connect and register db
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException
	{
//		registerDB
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
//		get connection for DB
		conn = DriverManager.getConnection(IPathConstants.dbURL,IPathConstants.dbUserName,IPathConstants.dbPassword);
	}
	/**
	 * This method is used to execute query 
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String query)throws SQLException
	{
		  Statement state = conn.createStatement();
		  result = state.executeQuery(query);
		  return result;
	}
	/**
	 * This method is used to update query
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public int updateQuery(String query) throws SQLException
	{
		
		Statement state = conn.createStatement();
		int res = state.executeUpdate(query);
		return res;
		
	}
	/**
	 * this method is used to close db
	 * @throws SQLException
	 */
	public void disconnectDB()throws SQLException
	{
		conn.close();
	}

}
