
public class Ingredient {

	private String ID;
	private String Nom;
	private int Quantite;
	private unite_ingredient Unite;
	private float prix;
	
	
	
	

	public Ingredient(String nom, int quantite, unite_ingredient unite, float prix) {
		super();
		Nom = nom;
		Quantite = quantite;
		Unite = unite;
		this.prix = prix;
	}
	
	
	

	@Override
	public String toString() {
		return "Ingredient [ID=" + ID + ", Nom=" + Nom + ", Quantite=" + Quantite + ", Unite=" + Unite + ", prix="
				+ prix + "]";
	}




	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public int getQuantite() {
		return Quantite;
	}

	public void setQuantite(int quantite) {
		Quantite = quantite;
	}

	public unite_ingredient getUnite() {
		return Unite;
	}

	public void setUnite(unite_ingredient unite) {
		Unite = unite;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	
	
	
}
