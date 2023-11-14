package personnages;

public class Village {
	private String nom;
	private Chef chef;
	
	private int nbVillageois = 0 ;
	private int nbVillageoisMaximum = 30;
	private Gaulois[] villageois = new Gaulois[nbVillageoisMaximum] ;

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
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois += 1;
	}
	
	public Gaulois trouverHabitant(int numero) {
		return villageois[numero];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		for(int i=0;i<nbVillageois;i++) {
			System.out.println("- " + villageois[i].getNom());
		}
	}
	
	// méthode principale (main)
	
	public static void main(String[] args) {
		
		Village village = new Village("Village des Irréductibles", null,30);
	
		Chef chef = new Chef("Abraracourcix", 6, village);
		village.setChef(chef);		
		
		Gaulois asterix = new Gaulois("Astérix",8);
		village.ajouterHabitant(asterix);	
		
		Gaulois obelix = new Gaulois("Obelix",25);
		village.ajouterHabitant(obelix);	

		village.afficherVillageois();
		
//		Gaulois gaulois = village.trouverHabitant(30);
//		Gaulois gaulois = village.trouverHabitant(1);
//		Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0 at personnages.Village.ajouterHabitant(Village.java:31)	at personnages.Village.main(Village.java:51)
	}
	
}
