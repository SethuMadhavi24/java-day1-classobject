package modell;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class ConnectionManager {
	private static Properties loadPropertiesFile() throws Exception{
		Properties prop=new Properties();
		InputStream in= ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close();
		return prop;
	}
	public static Connection getConnection() throws ClassNotFoundException  {
		Properties prop = null;
		Connection connection=null;
		try {
			prop=loadPropertiesFile();
		}
		catch(Exception e) {
			System.out.println("Error in property file"+e);
		}
		final String driver=prop.getProperty("driver");
		final String url=prop.getProperty("url");
		final String username=prop.getProperty("username");
		final String pasword=prop.getProperty("pasword");
		try {
			//load the driver defined in property life
			Class.forName(driver);
			connection=DriverManager.getConnection(url,username,pasword);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		if(connection!=null)
		{
			System.out.println("Connection established");
		}
		else
		{
			System.out.println("Connection does not established");	
		}
		return connection;
		
	}

}
