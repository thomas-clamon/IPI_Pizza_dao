package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import MODEL.Pizza;

public class PizzaDAO {
	
	private String url = "jdbc:sqlserver://thomasclamon.database.windows.net:1433;databaseName=PizzaDB";
	private String user = "toto";
	private String pwd = "Soleil123";
	
	private Statement statement;
	
	public PizzaDAO() {
		
		try {
			Connection con = DriverManager.getConnection(url, user, pwd);
			this.statement = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Statement getStatement() {
		return statement;
	}
	

}