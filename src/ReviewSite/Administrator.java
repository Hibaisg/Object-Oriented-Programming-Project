package ReviewSite;
import java.util.Scanner;
public class Administrator extends Utilisateur {
	private String code;
	
	public Administrator() {
		code = "123456";
	}
	// Add this method to verify the administrator code
	public boolean verifyCode(String enteredCode) {
		return code.equals(enteredCode);
	}
	public void setCode() {
			Scanner s = new Scanner(System.in);
		do {
			System.out.print("Choisissez votre nouveau CODE (longueur > 6): ");
			code = s.next();
		} while (code.length() < 6);
	}
	public void display() {
		super.display();
		System.out.println("CODE: " + code);
	}
}



