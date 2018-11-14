package cardGameBenjaminDumay;

import java.util.ArrayList;

public class Card {
	private String nomDeLaCarte, couleur;
	private static int valeurDeLaCarte;
	
	/**
	 * Constructeur pour la classe Card
	 * 
	 * @param nomDeLaCarte = 2,3,4,5,6,7,8,9,10,Valet,Dame,Roi,As
	 * @param couleur      "Trèfle" "Pique" "Cœur" "Carreau"
	 * @param valeur       2,3,4,5,6,7,8,9,10,11,12,13,14
	 * @param owner        player1, ...
	 */

	// Constructeur
	public Card(String nomDeLaCarte, String couleur, int valeur) {
		this.nomDeLaCarte = nomDeLaCarte;
		this.couleur = couleur;
		this.valeurDeLaCarte = valeur;
	}
	/**
	 * Retourne la représentation "String" d'un object "Card"
	 * 
	 * @return
	 */
	public String toString() {
		return nomDeLaCarte + " de " + couleur;
	}

	/**
	 * Retourne la valeur d'une carte sous forme d'entier
	 * @return 
	 * 
	 * @return
	 */
		

}
