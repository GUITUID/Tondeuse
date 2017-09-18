package launcherPack;

import java.util.LinkedList;

import helpersPack.LireFichier;

public class Launcher {

	public static void main(String[] args) {

		LinkedList<String> pointsCardinaux = new LinkedList<String>();
		pointsCardinaux.add("N");
		pointsCardinaux.add("E");
		pointsCardinaux.add("W");
		pointsCardinaux.add("S");

		// On lit le fichier d'instructions
		LireFichier.lireInstructions();

	}

}
