import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	
	private static PizzaDAO dao = new PizzaDAO();
	
	private static IIngredient service = new IngredientsService();

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("Que voulez vous faire :");
		System.out.println("1 | Ajouter une nouvelle pizza" );
		System.out.println("2 | Afficher toutes les pizza" );
		System.out.println("3 | Supprimer Pizza" );
		System.out.println("4 | Afficher un ingredient" );
		System.out.println("5 | Afficher un ingredients d'une Pizza" );
		int choix = sc.nextInt();
		
		switch(choix) {
		
		case 1 :
			AjouterPizza(sc);
		break;
		case 2 :
			AfficherPizza(sc);
		break;
		case 4 :
			System.out.println("numero de l'ingredients");
			int id = sc.nextInt();
			
			System.out.println(service.get(id));
		break;
		
		case 5 :
			System.out.println("veuillez entrer l'ID");
			int ID = sc.nextInt();
			Pizza p = new Pizza(ID);
			System.out.println(p.getList_ingredient());
		break;
		
			
		default :
			throw new Exception("Choix incorrect");
			// on declenche une exeption
		}
	
		

	}
	
	public static void AjouterPizza(Scanner sc) throws Exception {
		
		System.out.println("choix de la taille :");
		System.out.println("1 | PETITE" );
		System.out.println("2 | MOYENNE" );
		System.out.println("3 | GRANDE" );
		
		int choix = sc.nextInt();
		Taille_pizza taille = null;
		
		switch(choix) {
		
			case 1 :
				taille = Taille_pizza.PETITE;
			break;
			case 2 :
				taille = Taille_pizza.MOYENNE;
			break;
			case 3 :
				taille = Taille_pizza.GRANDE;
			break;
			default :
				throw new Exception("Choix incorrect");// on declenche une exeption
			
		}
		
		System.out.println("saisir le prix de la pizza");
		float prix = sc.nextFloat();

		System.out.println("veuiller saisir le nom de la pizza");
		String nom = sc.nextLine();

		
		// on enrigistre la pizza dans la memoire java
		Pizza p = new Pizza(nom, prix,taille); 
		
		// on demande au DAO d'enrigistrer la pizza en base
		
		dao.enregistrerPizza(p);
		
	}

	public static void AfficherPizza(Scanner sc) throws Exception
	{
		dao.afficherPizza();
	}
	public static void SupprimerPizza(Scanner sc) throws Exception{
		
	}
}
