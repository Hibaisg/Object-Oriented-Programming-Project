package ReviewSite;

public class Produit extends ObjetEvaluation {
	private String marque;
	
	public Produit(String categorie, String nomComplet, String marque) {
		super(categorie, nomComplet);
		this.marque = marque;
	}
	public String getMarque() {
		return marque;
	}
	public void display() {
		super.display();
		System.out.println("Marque: " + marque);
	}
}
