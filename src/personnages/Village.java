package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageoisMaximum ;
	
	public Village(String nom, Chef chef, int nbVillageoisMaximum) {
		this.nom = nom;
		this.chef = chef;
		this.nbVillageoisMaximum = nbVillageoisMaximum;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	// TP2 ---------------------------------------------------------------------------------------------
	
	private int nbVillageois = 0 ;
	
	// creation tableau villageois
	String[] villageois = new String[nbVillageoisMaximum] ;
	

	// methode ajouterHabitant
	public int ajouterHabitant(String gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois += 1;
		return nbVillageois;
	}
	
	// methode trouverHabitant
	public int trouverHabitant(int numero) {
		return reference;
	}
	
}
