

public interface IIngredient {

	public boolean AjouterIngrediant(Ingredient i);
	
	public boolean update(Ingredient i);
	
	public Ingredient get (int ID);
	
	public boolean delete (int ID);
}
