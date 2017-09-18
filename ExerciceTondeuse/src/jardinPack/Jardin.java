package jardinPack;

public class Jardin {
	
	static int maxX;
	static int maxY;
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return jardin
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
	
	/**
	 * 
	 * @param x
	 */
	public static void setMaxX(int x){
		maxX=x+1;
	}
	/**
	 * 
	 * @param y
	 */
	public static void setMaxY(int y){
		maxY=y+1;
	}
	/**
	 * 
	 * @return Maximum de X
	 */
	public static int getMaxX(){
		return maxX;
	}
	/**
	 * 
	 * @return Maximum de Y
	 */
	public static int getMaxY(){
		return maxY;
	}
}

