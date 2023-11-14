package personnages;

public class Romain {
	private String nom;
	private int force;
	
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
		
	public Romain(String nom, int force) {
		// invariant pour force non inférieure à 0
		assert force >= 0 : "La force d'un Romain doit être toujous positive";
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
//	MA METHODE RECEVOIR COUP
//	public void recevoirCoup(int forceCoup) {
//		assert force > 0 : "La force d'un Romain doit être toujous positive";
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aie!");
//		} else {
//			parler("J'abandonne...");
//		}	
//		assert force < force + forceCoup : "La force d'un Romain doit diminuer.";
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		
		forceCoup = calculResistanceEquipement(forceCoup);
		
		force -= forceCoup;
	
		if (force==0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup + ".";
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte = texte + "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
		texte += resistanceEquipement + "!";
		}
		parler(texte);
		
		if (resistanceEquipement > forceCoup) {
			System.out.println("L'équipement a réussi a bloquer complétement la force du coup!");
			forceCoup = 0;
		} else {
			forceCoup -= resistanceEquipement;
		}
		
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	
	public void sEquiper(Equipement equipement) {
	    switch (nbEquipement) {
	        case 0:
	            ajouterEquipement(equipement);
	            break;
	        case 1:
	            if (equipements[0] == equipement) {
	                System.out.println("Le soldat " + nom + " possède déjà un " + equipement.getNom() + " !");
	            } else {
	                ajouterEquipement(equipement);
	            }
	            break;
	        case 2:
	            System.out.println("Le soldat " + nom + " est déjà bien protégé !");
	            break;
	        default:
	        	break;
	        }
	    }

	private void ajouterEquipement(Equipement equipement) {
	    equipements[nbEquipement] = equipement;
	    nbEquipement++;
	    System.out.println("Le soldat " + getNom() + " s'équipe avec un " + equipement.getNom() + ".");
	}
	
	// méthode principale (main)

	public static void main(String[] args) {
		
		Romain minus = new Romain("Minus", 6);
		
		minus.parler("Salut!");
		minus.recevoirCoup(8);


		Equipement monEquipement = Equipement.CASQUE;
		System.out.println("Équipement choisi : " + monEquipement);

		Equipement autreEquipement = Equipement.BOUCLIER;
		System.out.println("Équipement choisi : " + autreEquipement);
		   
        Equipement casque = Equipement.CASQUE;
        Equipement bouclier = Equipement.BOUCLIER;

        minus.sEquiper(casque);
        minus.sEquiper(casque); // Essai avec un équipement déjà possédé
        minus.sEquiper(bouclier);
        minus.sEquiper(casque); // Essai avec un troisième équipement
        
    }
	
}
