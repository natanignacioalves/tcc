package factory;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectioBd {
	public Connection getConnector(){
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root","");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
