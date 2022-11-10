package INTERFACE;
import MODEL.Ingredient;

public interface IIngredientService {

	public boolean AjouterIngrediant(Ingredient i);
	
	public boolean update(Ingredient i);
	
	public Ingredient get (int ID);
	
	public boolean delete (int ID);
}
