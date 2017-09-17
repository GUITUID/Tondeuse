package jardinPack;

/*
 * Un jardin 
 */
public class Jardin {
	
	static int maxX;
	static int maxY;
	
	/**
	 * @return 
	 * 
	 */
	public static Object[][] InitSizeJardin(int x,int y){
		setMaxX(x);
		setMaxY(y);
		//Boucle for pour la construction du jardin
		//Construction du tableau à deux dimensions
				Object[][] jardin = new Object[getMaxX()][getMaxY()];
				
		//Parcours lignes et colonnes
				//lignes
				for(int i=0; i<jardin.length; i++)
				{
						//colonnes
					   for(int j=0; j<jardin[i].length; j++)
					   {
						   //coordonnées
						   jardin[i][j] = +i+" "+j;  
						   //System.out.println(jardin[i][j]); 
					   }
				}
		return jardin;
	}
	
	public static void setMaxX(int x){
		maxX=x+1;
	}
	public static void setMaxY(int y){
		maxY=y+1;
	}
	public static int getMaxX(){
		return maxX;
	}
	public static int getMaxY(){
		return maxY;
	}
}

