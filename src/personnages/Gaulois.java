package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;

	private int  nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;	
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
//		romain.recevoirCoup((force / 3) * effetPotion);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophees  = romain.recevoirCoup((force / 3) *effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = trophees[i];
		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée.");
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	// méthode principale (main)
	
	public static void main(String[] args) {
		
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain minus = new Romain("Minus", 6);		
		
//		System.out.println(asterix.nom);
		System.out.println(asterix);
		asterix.parler("Salut!");
		asterix.frapper(minus);
		
		asterix.boirePotion(5);	
	}	
}
	
	

// Méthodes et constructeurs  qui ont été supprimés 	
	
//	public int getEffetPotion() {
//		return effetPotion;
//	}
	
//	public void setNom(String nom) {
//		this.nom = nom;
//	}

//	public void setEffetPotion(int effetPotion) {
//		this.effetPotion = effetPotion;
//	}
