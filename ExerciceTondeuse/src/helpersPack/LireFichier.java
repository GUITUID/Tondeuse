package helpersPack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import jardinPack.Jardin;
import tondeusePack.Tondeuse;

class NombreInstructionsTondeuseExceptions extends Exception {
	private static final long serialVersionUID = 1L;

	public NombreInstructionsTondeuseExceptions() {
		System.out.println("Le nombre d'instructions pour les tondeuses est impair.");
	}
}

class NombreInstructionsGrilleExceptions extends Exception {
	private static final long serialVersionUID = 1L;

	public NombreInstructionsGrilleExceptions() {
		System.out.println("Les instructions pour les coordonnées de la grille sont insuffisantes.");
	}
}

class InstructionsNonIntExceptions extends Exception {
	private static final long serialVersionUID = 1L;

	public InstructionsNonIntExceptions() {
		System.out.println("Les instructions pour les coordonnées ne sont pas des nombres.");
	}
}

class InstructionsTondeusesCoordonneesInvalidesExceptions extends Exception {
	private static final long serialVersionUID = 1L;

	public InstructionsTondeusesCoordonneesInvalidesExceptions() {
		System.out.println("Les instructions pour les coordonnées des tondeuses sont invalides.");
	}
}

class InstructionsTondeusesInvalidesExceptions extends Exception {
	private static final long serialVersionUID = 1L;

	public InstructionsTondeusesInvalidesExceptions() {
		System.out.println("Les instructions pour le déplacement des tondeuses sont invalides.");
	}
}

class NombreNegatifExceptions extends Exception {
	private static final long serialVersionUID = 1L;

	public NombreNegatifExceptions() {
		System.out.println("Les instructions sont invalides (valeurs négatives).");
	}
}

class NonStringExceptions extends Exception {
	private static final long serialVersionUID = 1L;

	public NonStringExceptions() {
		System.out.println("L'instruction n'est pas une chaine de caractère.");
	}
}

public class LireFichier {
	/**
	 * @param valeur
	 * @return
	 * @throws InstructionsNonIntExceptions
	 *             </br>
	 *             Vérifie si la valeur est un nombre (int)
	 */
	public static boolean isNombre(String valeur) throws InstructionsNonIntExceptions {
		// Regex \\d : Un chiffre, équivalent à : [0-9]
		if (valeur.matches("\\d")) {
			return true;
		} else {
			// valeur est un String
			throw new InstructionsNonIntExceptions();
		}
	}

	/**
	 * @param valeur
	 * @return
	 * @throws InstructionsNonIntExceptions
	 *             </br>
	 *             Vérifie si la valeur est un nombre (int)
	 */
	public static boolean isString(String valeur) throws NonStringExceptions {
		// Regex \\d : Un chiffre, équivalent à : [0-9]
		if (valeur.matches("\\d")) {
			// valeur est un int
			throw new NonStringExceptions();
		} else {
			return true;
		}
	}

	// Ce test n'a pas lieu car on split les carctères du fichier avec ""
	/**
	 * @param valeur
	 * @return
	 * @throws NombreNegatifExceptions
	 *             </br>
	 *             Vérifie si la valeur est positive
	 */
	public static boolean isPositif(int valeur) throws NombreNegatifExceptions {
		if (valeur > 0) {
			return true;
		} else {
			throw new NombreNegatifExceptions();
		}
	}

	static int nombreTondeuses;
	static List<Tondeuse> tondeuses = new ArrayList<Tondeuse>();

	/**
	 * 
	 * @return nombreTondeuses </br>
	 *         Retourne le nombre de tondeuses obtenues lors de la lecture du
	 *         fichier
	 */
	public static int getNombreTondeuses() {
		return nombreTondeuses;
	}

	/**
	 * 
	 * @param nombreTondeusesFromFichier
	 *            </br>
	 *            Paramètre le nombre de tondeuses obtenues lors de la lecture
	 *            du fichier
	 */
	public static void setNombreTondeuses(int nombreTondeusesFromFichier) {
		nombreTondeuses = nombreTondeusesFromFichier;
	}

	/**
	 * Lit les instructions du fichier et paramètre le nombre de tondeuses à
	 * traiter puis traite les instructions
	 */
	public static void lireInstructions() {

		List<String> listeInstructions = new ArrayList<String>();

		try {
			InputStream flux = new FileInputStream("datas/Instructions.txt");
			InputStreamReader lecture = new InputStreamReader(flux);
			BufferedReader buff = new BufferedReader(lecture);
			String ligne;

			while ((ligne = buff.readLine()) != null) {
				listeInstructions.add(ligne);
			}
			buff.close();

			/*
			 * On calcule le nombre de tondeuses en comptant le nombre de lignes
			 * du fichier : '-1' (la ligne pour la définition de la grille) '/2'
			 * (pour avoir le nombre de tondeuses car il y a deux lignes
			 * d'instructions pour chaque tondeuse)
			 */
			// On teste si le nombre d'instructions pour les tondeuses est pair
			if (((listeInstructions.size() - 1) / 2) % 2 == 0) {
				setNombreTondeuses((listeInstructions.size() - 1) / 2);

				// On met les premiers caractères de la ligne dans un tableau,
				// si
				String[] casesJardin = listeInstructions.get(0).split(" ");
				// On teste si le nombre de coordonnées de la grille est pair
				if (casesJardin.length % 2 == 0) {

					// Vérifie si la valeur est un nombre non négatif
					if (isNombre(casesJardin[0])) {
						if (isPositif(Integer.parseInt(casesJardin[0]))) {
						}
					}
					if (isNombre(casesJardin[1])) {
						if (isPositif(Integer.parseInt(casesJardin[1]))) {
						}
					}
					int casesJardinX = Integer.parseInt(casesJardin[0]);
					int casesJardinY = Integer.parseInt(casesJardin[1]);

					isNombre(casesJardin[0]);

					Jardin.InitSizeJardin(casesJardinX, casesJardinY);

					// Boucle de création des Tondeuses
					int premiereTondeuse = getNombreTondeuses();

					for (int i = 0; i != getNombreTondeuses(); i++) {
						// System.out.println("tondeuse "+i);
						String[] positionsTondeuse = listeInstructions.get(premiereTondeuse - 1).split(" ");
						String[] instructionsTondeuse = listeInstructions.get(premiereTondeuse).split("");
						Tondeuse tondeuse = new Tondeuse();

						// Vérifie si la valeur est un nombre non négatif
						if (isNombre(positionsTondeuse[0])) {
							if (isPositif(Integer.parseInt(positionsTondeuse[0]))) {
							}
						}
						if (isNombre(positionsTondeuse[1])) {
							if (isPositif(Integer.parseInt(positionsTondeuse[1]))) {
							}
						}

						// On créé un objet Tondeuse qu'on ajoute dans la liste
						// des tondeuses
						tondeuse.tondeuseConstructor(i, Integer.parseInt(positionsTondeuse[0]),
								Integer.parseInt(positionsTondeuse[1]), positionsTondeuse[2]);
						// Ajout dans la liste des tondeuses
						tondeuses.add(tondeuse);
						// On traite les instructions de la tondeuse
						for (int y = 0; y != instructionsTondeuse.length; y++) {
							// System.out.println("instruction: "
							// +instructionsTondeuse[y]);
							// Vérifie si l'instruction est bien un String
							isString(instructionsTondeuse[y]);

							tondeuses.get(i).instructionTondeuse(instructionsTondeuse[y],
									tondeuses.get(i).getTondeuseOrientation(), tondeuses.get(i).getPosXTondeuse(),
									tondeuses.get(i).getPosYTondeuse());
						}
						premiereTondeuse = premiereTondeuse + 2;
					}
					getStatutToutesTondeuses();
				} else {
					throw new NombreInstructionsGrilleExceptions();
				}

			} else {
				throw new NombreInstructionsTondeuseExceptions();
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * Renvoie le statut de toutes les tondeuses
	 */
	public static void getStatutToutesTondeuses() {
		for (int i = 0; i != getNombreTondeuses(); i++) {
			tondeuses.get(i).getStatutTondeuse();
		}
	}

}