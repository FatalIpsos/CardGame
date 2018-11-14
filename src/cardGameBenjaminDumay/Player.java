package cardGameBenjaminDumay;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name;
	int joueurNum;
	public ArrayList<String> playerList = new ArrayList<String>();
	public ArrayList<Card> player1 = new ArrayList<Card>();
	public ArrayList<Card> player2 = new ArrayList<Card>();
	public ArrayList<Card> player3 = new ArrayList<Card>();
	public ArrayList<Card> player4 = new ArrayList<Card>();

	/**
	 * Cela va créer les joueurs et leur associer un total de cartes
	 * 
	 * @param name
	 * @param totalCartes
	 */

	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.playerList.add(name);
		this.name = name;
	}
	
	public ArrayList<String> getListeJoueurs() {
		return playerList;
	}

	public void setHand(ArrayList<Card> hand, int joueurNum) {
		//supprimer la liste avec les mains pour la mise a jour des mains et ajout de la nouvelle main aux joueurs
		switch (joueurNum) {
			case 0:
				player1.removeAll(player1);
				player1.addAll(hand);
				break;
			case 1:
				player2.removeAll(player2);
				player2.addAll(hand);
				break;
			case 2:
				player3.removeAll(player3);
				player3.addAll(hand);
				break;
			case 3:
				player4.removeAll(player4);
				player4.addAll(hand);
				break;
				}
	}

	public ArrayList<Card> getPlayer1() {
		return player1;
	}
	
	public ArrayList<Card> getPlayer2() {
		return player2;
	}
	
	public ArrayList<Card> getPlayer3() {
		return player3;
	}
	
	public ArrayList<Card> getPlayer4() {
		for(int i=0; i<player4.size();i++) {
			player4.get(i);
		}
		return player4;
	}
	



	/**
	 * Retourne la représentation String d'un joueur
	 */
	/*public String toString() {
		return name + " a " + ;
	}*/


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
