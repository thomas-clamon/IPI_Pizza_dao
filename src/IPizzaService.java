import java.util.List;

public interface IPizzaService {
	
	List<Ingredient> getIngredient(int ID);
	
	int ajouterIngredientPizza(int id_ingredient, int id_pizza );

}
