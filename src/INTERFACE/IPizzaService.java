package INTERFACE;
import java.sql.SQLException;
import java.util.List;

import MODEL.Ingredient;
import MODEL.Pizza;

public interface IPizzaService {
	
	void enregistrerPizza(Pizza p) throws SQLException;
	
	List<Ingredient> getIngredient(int ID);
	
	int ajouterIngredientPizza(int id_ingredient, int id_pizza );
	
	Pizza get (int ID);
	
	int delete(int ID);

}
