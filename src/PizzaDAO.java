import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	
	public void enregistrerPizza(Pizza p) throws SQLException {
		
		// on formatte le prix de la pizza 2 chiffre aprés la virgule, et on remplace par un point
		String prix = String.format("%.2f", p.getPrix()).replace(',', '.');
		String request = String.format("INSERT INTO [dbo].[Pizzas]"
				+ "           ([Nom]"
				+ "           ,[Prix]"
				+ "           ,[Taille])"
				+ "     VALUES"
				+ "           ('%s' "
				+ "           ,%s "
				+ "           ,'%s')", p.getNom(), prix, p.getTaille().name()) ;
		
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
	public void afficherPizza() throws SQLException {
		
		String request = "SELECT * FROM Pizzas ";
		
		ResultSet rs = statement.executeQuery(request);
		
		// on boucle sur le resultat de la requete
		while (rs.next()) {
			
			// on crée une String avec le format
			// 	-- %d = Decimal pour les int
			// 	-- %s = String pour les chaine
			// 	-- %f = float pour le prix
			String line = String.format("%d | %s | %f | %s", 
					rs.getInt("ID"), 
					rs.getString("Nom"),
					rs.getFloat("Prix"),
					rs.getString("Taille"));
			
			System.out.println(line);
		}
	}

}
