package MODEL;
import java.time.LocalDate;
import java.time.Period;

public class Client {

	private String Mail;
	private String Prenom;
	private String Nom;
	private LocalDate DateNaissaince;
	
	public int CalculerAge() {
		
		return Period.between(DateNaissaince, LocalDate.now()).getYears();
	}

	public Client(String mail, String prenom, String nom, LocalDate dateNaissaince) {
		super();
		Mail = mail;
		Prenom = prenom;
		Nom = nom;
		DateNaissaince = dateNaissaince;
	}
	
	public String toString() 
	{
		return String.format("%s, | %s | %d ans", Prenom, Nom, CalculerAge()  );
	}
	
	
}
