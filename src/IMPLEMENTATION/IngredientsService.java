package IMPLEMENTATION;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.PizzaDAO;
import INTERFACE.IIngredientService;
import MODEL.Ingredient;
import MODEL.unite_ingredient;

public class IngredientsService implements IIngredientService {
	
	private PizzaDAO dao = new PizzaDAO();

	@Override
	public boolean AjouterIngrediant(Ingredient i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Ingredient i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Ingredient get(int ID) {
		
		String SQL = String.format("SELECT * FROM Ingredients WHERE ID = %d", ID);
		
		try {
			ResultSet rs = dao.getStatement().executeQuery(SQL);
	
			while (rs.next())
			{
				String nom = rs.getString("nom");
				int quantite = rs.getInt("Quantite");
				unite_ingredient unite = unite_ingredient.valueOf(rs.getString("unite"));
				float prix = rs.getFloat("prix");
				
				Ingredient i = new Ingredient(nom,quantite,unite, prix);
				
				return i;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean delete(int ID) {
		// TODO Auto-generated method stub
		return false;
	}

}
