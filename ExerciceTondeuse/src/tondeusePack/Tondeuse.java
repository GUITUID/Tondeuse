package tondeusePack;

import jardinPack.Jardin;

public class Tondeuse {

	/* Caractéristiques d'une tondeuse */
	private int numTondeuse;
	private int posXTondeuse;
	private int posYTondeuse;
	private String TondeuseOrientation;

	public void getStatutTondeuse() {
		System.out.println(getPosXTondeuse() + " " + getPosYTondeuse() + " " + getTondeuseOrientation());
	}

	/**
	 * Initialise la position de la tondeuse
	 */
	void InitPos(int numTondeuse, int posXTondeuseBefore, int posYTondeuseBefore) {

	}

	/**
	 * 
	 * @param numTondeuse
	 * @param positionsTondeuseX
	 * @param positionsTondeuseY
	 * @param TondeuseOrientation
	 */
	public void tondeuseConstructor(int numTondeuse, int positionsTondeuseX, int positionsTondeuseY,
			String TondeuseOrientation) {
		setNumTondeuse(numTondeuse);
		setPosXTondeuse(positionsTondeuseX);
		setPosYTondeuse(positionsTondeuseY);
		setTondeuseOrientation(TondeuseOrientation);
	}

	/**
	 * 
	 * @param instruction
	 * @param sens
	 * @param orientation
	 * @param posXTondeuse
	 * @param posYTondeuse
	 */
	public void instructionTondeuse(String instruction, String orientation, int posXTondeuse, int posYTondeuse) {
		switch (instruction) {
		case "A":
			avancer(orientation, posXTondeuse, posYTondeuse);
			break;
		default:
			tourner(instruction, orientation);
			break;
		}
	}

	/**
	 * 
	 * @param orientation
	 * @param posXTondeuseBefore
	 * @param posYTondeuse
	 */
	void avancer(String orientation, int posXTondeuse, int posYTondeuse) {
		switch (orientation) {
		// Haut
		case "N":
			if ((posYTondeuse + 1) <= Jardin.getMaxY()) {
				setPosYTondeuse(posYTondeuse + 1);
			}
			break;
		// Droite
		case "E":
			if ((posXTondeuse + 1) <= Jardin.getMaxX()) {
				setPosXTondeuse(posXTondeuse + 1);
			}
			break;
		// Gauche
		case "W":
			if (posXTondeuse - 1 != -1) {
				setPosXTondeuse(posXTondeuse - 1);
			}
			break;
		// Bas
		case "S":
			if ((posYTondeuse - 1) != -1) {
				setPosYTondeuse(posYTondeuse - 1);
			}
			break;
		}
	}

	/**
	 * 
	 * @param sens
	 * @param orientation
	 * @param pointsCardinaux
	 */
	public void tourner(String sens, String orientation) {
		switch (sens) {
		case "G":
			switch (orientation) {
			case "N":
				setTondeuseOrientation("W");
				break;
			case "E":
				setTondeuseOrientation("N");
				break;
			case "W":
				setTondeuseOrientation("S");
				break;
			case "S":
				setTondeuseOrientation("E");
				break;
			default:
				setTondeuseOrientation(getTondeuseOrientation());
				break;
			}
			break;
		case "D":
			switch (orientation) {
			case "N":
				setTondeuseOrientation("E");
				break;
			case "E":
				setTondeuseOrientation("S");
				break;
			case "W":
				setTondeuseOrientation("N");
				break;
			case "S":
				setTondeuseOrientation("W");
				break;
			default:
				setTondeuseOrientation(getTondeuseOrientation());
				break;
			}
			break;
		}
	}

	/**
	 * 
	 * @param orientation
	 */
	public void setTondeuseOrientation(String orientation) {
		TondeuseOrientation = orientation;
	}

	/**
	 * 
	 * @return Orientation de la tondeuse
	 */
	public String getTondeuseOrientation() {
		return TondeuseOrientation;
	}

	/**
	 * 
	 * @return Numéro de la tondeuse
	 */
	public int getNumTondeuse() {
		return numTondeuse;
	}

	/**
	 * 
	 * @param numTondeuseFromFile
	 */
	public void setNumTondeuse(int numTondeuseFromFile) {
		numTondeuse = numTondeuseFromFile;
	}

	/**
	 * 
	 * @return Position X de la tondeuse
	 */
	public int getPosXTondeuse() {
		return posXTondeuse;
	}

	/**
	 * 
	 * @param posXTondeuseFromFile
	 */
	public void setPosXTondeuse(int posXTondeuseFromFile) {
		posXTondeuse = posXTondeuseFromFile;
	}

	/**
	 * 
	 * @return Position Y de la tondeuse
	 */
	public int getPosYTondeuse() {
		return posYTondeuse;
	}

	/**
	 * 
	 * @param posYTondeuseFromFile
	 */
	public void setPosYTondeuse(int posYTondeuseFromFile) {
		posYTondeuse = posYTondeuseFromFile;
	}
}
