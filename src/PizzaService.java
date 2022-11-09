import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PizzaService implements IPizzaService {
	
	private PizzaDAO dao = new PizzaDAO();

	@Override
	public List<Ingredient> getIngredient(int ID) {
		
		List<Ingredient> list = new ArrayList<Ingredient>();
		
		String SQL = "SELECT nom, unite, prix, quantite FROM Contenir, Ingredients  "
		+ " WHERE Ingredients.ID = Contenir.ID_Ingredient "
		+ "and ID_Pizza = " +ID;
		
		try {
			ResultSet rs = dao.getStatement().executeQuery(SQL);
			
			while (rs.next()) {
				
				String nom = rs.getString(1);
				unite_ingredient unite = unite_ingredient.valueOf(rs.getString(2));
				float prix = rs.getFloat(3);
				int quantite = rs.getInt(4);
				
				Ingredient i = new Ingredient(nom, quantite, unite, prix);
				
				list.add(i);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
			return null;
		}
		return list;
		
	}

	@Override
	public int ajouterIngredientPizza(int id_ingredient, int id_pizza) {
		
		String SQL = String.format("INSERT INTO [dbo].[Contenir]\r\n"
				+ "           ([ID_Pizza]\r\n"
				+ "           ,[ID_Ingredient])\r\n"
				+ "     VALUES (%d,%d)", id_pizza, id_ingredient);
		
		try {
			dao.getStatement().executeUpdate(SQL);
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
	}



}
