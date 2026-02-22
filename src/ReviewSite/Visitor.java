package ReviewSite;
import java.util.Scanner;
public class Visitor extends Utilisateur {
	private String ID;
	
	// Ajoutez le constructeur qui prend un nom en argument
	public Visitor(String nom, String ID) {
		super(nom);
		this.ID = ID;
	}
	public Visitor() {
		this.ID = "";
	}
	@Override
	public String getName() {
		return super.getName();
	}
	public String getID() {
		return ID;
	}
	public void setID() {
			Scanner s = new Scanner(System.in);
		do {
			System.out.print("Créez votre ID (longueur = 8): ");
			ID = s.next();
		} while (ID.length() != 8);
	}
	public void display() {
		super.display();
		System.out.println("ID: " + ID);
	}
}


