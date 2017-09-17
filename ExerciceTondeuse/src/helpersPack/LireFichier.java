package helpersPack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import jardinPack.Jardin;
import tondeusePack.Tondeuse;

public class LireFichier {

	static int nombreTondeuses;
	static List<Tondeuse> tondeuses = new ArrayList<Tondeuse>();
	
	/**
	 * 
	 * @return nombreTondeuses
	 * </br>Retourne le nombre de tondeuses obtenues lors de la lecture du fichier 
	 */
	public static int getNombreTondeuses() {
		return nombreTondeuses;
	}

	/**
	 * 
	 * @param nombreTondeusesFromFichier
	 * </br>Paramètre le nombre de tondeuses obtenues lors de la lecture du fichier
	 */
	public static void setNombreTondeuses(int nombreTondeusesFromFichier) {
		nombreTondeuses=nombreTondeusesFromFichier;
	}

	/**
	 * Lit les instructions du fichier et paramètre le nombre de tondeuses à traiter puis traite les instructions
	 */
	public static void lireInstructions(){
	
	List<String> listeInstructions = new ArrayList<String>();

	try{
		InputStream flux=new FileInputStream("datas/Instructions.txt"); 
		InputStreamReader lecture=new InputStreamReader(flux);
		BufferedReader buff=new BufferedReader(lecture);
		String ligne;
		
			while ((ligne=buff.readLine())!=null){
				listeInstructions.add(ligne);
			}
		buff.close(); 
		
		/*
		 * On calcule le nombre de tondeuses en comptant le nombre de lignes du fichier :
		 * '-1' (la ligne pour la définition de la grille) 
		 * '/2' (pour avoir le nombre de tondeuses car il y a deux lignes d'instructions pour chaque tondeuse)
		 */
		// On teste si le nombre d'instructions pour les tondeuses est pair
		//if(((listeInstructions.size()-1)/2)%2==0){
			setNombreTondeuses((listeInstructions.size()-1)/2);
			
			// On met les premiers caractères de la ligne dans un tableau, si 
			String [] casesJardin = listeInstructions.get(0).split(" ");
			// On teste si le nombre de coordonnées de la grille est pair
			//if(casesJardin.length%2==0){
			
			// TODO check if int and not negative
			int casesJardinX = Integer.parseInt(casesJardin[0]);
			int casesJardinY = Integer.parseInt(casesJardin[1]);
			
			Jardin.InitSizeJardin(casesJardinX,casesJardinY);
		
			//Boucle de création des Tondeuses
			int premiereTondeuse=getNombreTondeuses();
				
			for(int i = 0 ;i!=getNombreTondeuses();i++){
						//System.out.println("tondeuse "+i);
						String[] positionsTondeuse=listeInstructions.get(premiereTondeuse-1).split(" ");
						String[] instructionsTondeuse=listeInstructions.get(premiereTondeuse).split("");
						Tondeuse tondeuse = new Tondeuse();
						
						//TODO check if int and not negative
						
						// On créé un objet Tondeuse qu'on ajoute dans la liste des tondeuses
						tondeuse.tondeuseConstructor(i,Integer.parseInt(positionsTondeuse[0]),Integer.parseInt(positionsTondeuse[1]),positionsTondeuse[2]);
						tondeuse.getStatutTondeuse();
						// Ajout dans la liste des tondeuses
						tondeuses.add(tondeuse);
						
						//System.out.println("Départ tondeuse "+i+" : ");
						//tondeuses.get(i).getStatutTondeuse();
						
							// On traite les instructions de la tondeuse
							for(int y = 0 ;y!=instructionsTondeuse.length;y++){
								//System.out.println("instruction: " +instructionsTondeuse[y]);
								tondeuses.get(i).instructionTondeuse(instructionsTondeuse[y],tondeuses.get(i).getTondeuseOrientation(),tondeuses.get(i).getPosXTondeuse(),tondeuses.get(i).getPosYTondeuse());
								//tondeuses.get(i).getStatutTondeuse();
							}
							premiereTondeuse=premiereTondeuse+2;
						}

						getStatutToutesTondeuses();
		//}else{
			//throw new NombreInstructionsGrilleExceptions();
		//}
		
		//}else{
			//throw new NombreInstructionsTondeuseExceptions();
		//}

		}		
		catch (Exception e){
		System.out.println(e.toString());
		}
	}
	
	/**
	 * Renvoie le statut de toutes les tondeuses
	 */
	public static void getStatutToutesTondeuses(){
		for(int z = 0 ;z!=getNombreTondeuses();z++){ 
			System.out.println("Arrivée tondeuse "+z+" : ");
			tondeuses.get(z).getStatutTondeuse();
		}
	}
	
}
