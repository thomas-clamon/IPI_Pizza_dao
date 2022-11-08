import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PizzaDAO {
	
	private String url = "jdbc:sqlserver://localhost:1433;databaseName=PizzaDB";
	private String user = "sa";
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
	
	
	public void enregistrerPizza(Pizza p) throws SQLException {
		
		String request = "INSERT INTO [dbo].[Pizzas]"
				+ "           ([Nom]"
				+ "           ,[Prix]"
				+ "           ,[Taille]"
				+ "     VALUES"
				+ "           (<Nom,"+p.getNom()+">"
				+ "           ,<Prix,"+p.getPrix()+">"
				+ "           ,<Taille,"+p.getTaille().name()+")>)";
		statement.executeUpdate(request);
		
	}
	
	public void updatePizza(Pizza p) throws SQLException
	{
		String request = "UPDATE [dbo].[Pizzas]"
				+ "   SET [Nom] = '"+p.getNom()+"'"
				+ "      ,[Prix] = "+p.getPrix()+""
				+ "      ,[Taille] = '"+p.getTaille().toString()+"'"
				+ " WHERE ID = " + p.getID();
		
		System.out.println(request);
		statement.executeUpdate(request);
	}
	
	public void deletePizza(int ID) throws SQLException {
		
		String request = "DELETE FROM Pizzas Where ID = "+ID;
		
		statement.executeUpdate(request);
	}

}
