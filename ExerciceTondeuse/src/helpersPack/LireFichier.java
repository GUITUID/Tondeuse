package helpersPack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import jardinPack.Jardin;
import tondeusePack.Tondeuse;

class NombreInstructionsTondeuseExceptions extends Exception{ 
	  public NombreInstructionsTondeuseExceptions(){
	    System.out.println("Le nombre d'instructions pour les tondeuses est impair.");

	  }  
	}

class NombreInstructionsGrilleExceptions extends Exception{ 
	  public NombreInstructionsGrilleExceptions(){
	    System.out.println("Les instructions pour les coordonn�es de la grille sont insuffisantes.");

	  }  
	}

/**
 * 
 * On peut ajouter ces exceptions personnalis�es, pour des raison esthetiques, pour le traitement du fichier cependant ces cas renvoient d�j� une exception qui arr�te le programme
 *
 **/

class InstructionsNonIntExceptions extends Exception{ 
	  public InstructionsNonIntExceptions(){
	    System.out.println("Les instructions pour les coordonn�es ne sont pas des nombres.");

	  }  
	}

class InstructionsTondeusesCoordonneesInvalidesExceptions extends Exception{ 
	  public InstructionsTondeusesCoordonneesInvalidesExceptions(){
	    System.out.println("Les instructions pour les coordonn�es des tondeuses sont invalides.");

	  }  
	}

class InstructionsTondeusesInvalidesExceptions extends Exception{ 
	  public InstructionsTondeusesInvalidesExceptions(){
	    System.out.println("Les instructions pour le d�placement des tondeuses sont invalides.");

	  }  
	}

// Ne survient pas le test sur la parit� des instructions discrimine ce test
class NombreNegatifExceptions extends Exception{ 
	  public NombreNegatifExceptions(){
	    System.out.println("Les instructions sont invalides (valeurs n�gatives).");
	  }  
}


public class LireFichier {
	
	public static boolean isNombre(String valeur) throws InstructionsNonIntExceptions{
	    boolean parsable = false;
	    try{
	        Integer.parseInt(valeur);
	        parsable = true;
	    }catch(NumberFormatException e){
	    	throw new InstructionsNonIntExceptions();
	    }
		return parsable;
	}
	
	public static boolean isPositif(int valeur) throws NombreNegatifExceptions{
	    if(valeur>0){
	    	return true;
	    }
	    else{
	    	throw new NombreNegatifExceptions();
	    }
	}

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
	 * </br>Param�tre le nombre de tondeuses obtenues lors de la lecture du fichier
	 */
	public static void setNombreTondeuses(int nombreTondeusesFromFichier) {
		nombreTondeuses=nombreTondeusesFromFichier;
	}

	/**
	 * Lit les instructions du fichier et param�tre le nombre de tondeuses � traiter puis traite les instructions
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
		 * '-1' (la ligne pour la d�finition de la grille) 
		 * '/2' (pour avoir le nombre de tondeuses car il y a deux lignes d'instructions pour chaque tondeuse)
		 */
		// On teste si le nombre d'instructions pour les tondeuses est pair
		if(((listeInstructions.size()-1)/2)%2==0){
			setNombreTondeuses((listeInstructions.size()-1)/2);
			
			// On met les premiers caract�res de la ligne dans un tableau, si 
			String [] casesJardin = listeInstructions.get(0).split(" ");
			// On teste si le nombre de coordonn�es de la grille est pair
			if(casesJardin.length%2==0){
			
			// V�rifie si la valeur est un nombre non n�gatif
			if(isNombre(casesJardin[0])){
				if(isPositif(Integer.parseInt(casesJardin[0]))){
				}
			}
			if(isNombre(casesJardin[1])){
				if(isPositif(Integer.parseInt(casesJardin[1]))){
				}
			}
			int casesJardinX = Integer.parseInt(casesJardin[0]);
			int casesJardinY = Integer.parseInt(casesJardin[1]);
			
			isNombre(casesJardin[0]);
			
			Jardin.InitSizeJardin(casesJardinX,casesJardinY);
		
			//Boucle de cr�ation des Tondeuses
			int premiereTondeuse=getNombreTondeuses();
				
			for(int i = 0 ;i!=getNombreTondeuses();i++){
						//System.out.println("tondeuse "+i);
						String[] positionsTondeuse=listeInstructions.get(premiereTondeuse-1).split(" ");
						String[] instructionsTondeuse=listeInstructions.get(premiereTondeuse).split("");
						Tondeuse tondeuse = new Tondeuse();
						
						// V�rifie si la valeur est un nombre non n�gatif
						if(isNombre(positionsTondeuse[0])){
							if(isPositif(Integer.parseInt(positionsTondeuse[0]))){
							}
						}
						if(isNombre(positionsTondeuse[1])){
							if(isPositif(Integer.parseInt(positionsTondeuse[1]))){
							}
						}
						
						// On cr�� un objet Tondeuse qu'on ajoute dans la liste des tondeuses
						tondeuse.tondeuseConstructor(i,Integer.parseInt(positionsTondeuse[0]),Integer.parseInt(positionsTondeuse[1]),positionsTondeuse[2]);
						//tondeuse.getStatutTondeuse();
						// Ajout dans la liste des tondeuses
						tondeuses.add(tondeuse);
						/*
						System.out.println("D�part tondeuse "+i+" : ");
						tondeuses.get(i).getStatutTondeuse();
						*/
							// On traite les instructions de la tondeuse
							for(int y = 0 ;y!=instructionsTondeuse.length;y++){
								// System.out.println("instruction: " +instructionsTondeuse[y]);
								// V�rifie si l'instruction est bien un String
								
								
								tondeuses.get(i).instructionTondeuse(instructionsTondeuse[y],tondeuses.get(i).getTondeuseOrientation(),tondeuses.get(i).getPosXTondeuse(),tondeuses.get(i).getPosYTondeuse());
								//tondeuses.get(i).getStatutTondeuse();
							}
						}
						
						premiereTondeuse=premiereTondeuse+2;
		
						getStatutToutesTondeuses();
		}else{
			throw new NombreInstructionsGrilleExceptions();
		}
		
		}else{
			throw new NombreInstructionsTondeuseExceptions();
		}

		}		
		catch (Exception e){
		System.out.println(e.toString());
		}
	}
	
	/**
	 * Renvoie le statut de toutes les tondeuses
	 */
	public static void getStatutToutesTondeuses(){
		for(int i = 0 ;i!=getNombreTondeuses();i++){ 
			System.out.println("Arriv�e tondeuse "+i+" : ");
			tondeuses.get(i).getStatutTondeuse();
		}
	}
	
}
