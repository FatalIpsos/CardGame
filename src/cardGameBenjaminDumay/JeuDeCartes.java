package cardGameBenjaminDumay;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Benjamin Dumay also known as Fatalispo
 */

public class JeuDeCartes {
 
	private Card[] aSet;
	private Card carte;
	private int cardNow;
	public ArrayList<String> valeurJoueur = new ArrayList<String>();
	public ArrayList<Card> hand = new ArrayList<Card>();
	public ArrayList<Card> reserve = new ArrayList<Card>();
	static JeuDeCartes leJeu = new JeuDeCartes();
	public static Scanner sc = new Scanner(System.in);
	static Player joueur = new Player();
	String[] valeurDeCartes = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As" };
	int cardValue1 = 0, cardValue2 = 0, cardValue4 = 0, cardValue3 = 0;

	/**
	 * Un constructeur servant à créer un jeu de cartes
	 */
	public JeuDeCartes() {
		String[] noms2Cartes = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As" };
		String[] couleur = { "Trèfle", "Pique", "Cœur", "Carreau" };

		aSet = new Card[52];
		cardNow = 0;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {

				// Remplissage du jeu de carte 4 couleurs x 13 cartes
				aSet[(j + (i * 13))] = new Card(noms2Cartes[j], couleur[i], j + 2);
			}
		}
	}

	public void presenterleJeu() {
		int i = 0;
		for (Card card : aSet) {
			System.out.println(card);
			i++;
			if (i == 13) {
				i = 0;
				System.out.println("------");
			}
		}
	}

	/**
	 * Cela mélangera le jeu de cartes
	 */
	public void melangeur() {
		SecureRandom chiffreAleatoire = new SecureRandom();

		// parmis toutes les cartes du jeu, pioche une carte au hasard
		for (int i = 0; i < aSet.length; i++) {
			// piocher une carte au hasard
			int j = chiffreAleatoire.nextInt(52);

			// echange les positions
			Card temp = aSet[i];
			aSet[i] = aSet[j];
			aSet[j] = temp;
		}
	}

	/**
	 * Parcours du jeu de cartes et retourne une carte
	 * 
	 * @return la carte au dessus du jeu
	 */
	public List<Card> distribuer() {
		if (cardNow < aSet.length)
			return Arrays.asList(aSet[cardNow++]);
		else
			return null;
	}

	// Distribution entre 4 joueurs
	public void distribution() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				hand.addAll(leJeu.distribuer());
			}
			joueur.setHand(hand, i);
			hand.removeAll(hand);
		}
	}

	public void letsCompare() {
		//Attribution du nom de carte sans la couleur afin de la comparer au tableau
		String valeur1 = ("" + joueur.player1.get(0)).substring(0, ("" + joueur.player1.get(0)).indexOf(" "));
		String valeur2 = ("" + joueur.player2.get(0)).substring(0, ("" + joueur.player2.get(0)).indexOf(" "));
		String valeur3 = ("" + joueur.player3.get(0)).substring(0, ("" + joueur.player3.get(0)).indexOf(" "));
		String valeur4 = ("" + joueur.player4.get(0)).substring(0, ("" + joueur.player4.get(0)).indexOf(" "));		
		
		//Recherche dans le tableau valeurDeCartes de la carte des joueurs, attribution d'une valeur par rapport à sa position
		for (int i = 0; i < 13; i++) {
			if (valeurDeCartes[i].equals(valeur1)) {
				this.cardValue1 = i;
			} if (valeurDeCartes[i].equals(valeur2)) {
				this.cardValue2 = i;
			} if (valeurDeCartes[i].equals(valeur3)) {
				this.cardValue3 = i;
			} if (valeurDeCartes[i].equals(valeur4)) {
				this.cardValue4 = i;
			}
		}
		
		// Comparaison des cartes et changement de position des cartes

			if (this.cardValue1 > this.cardValue2 && this.cardValue1 > this.cardValue3 && this.cardValue1 > this.cardValue4) {
				System.out.println(joueur.playerList.get(0) + " a gagné ce tour avec " + joueur.getPlayer1().get(0));
				//ajout de la carte du joueur et suppression de cette carte pour le joueur 2
				joueur.player1.add(joueur.getPlayer2().get(0));
				joueur.player2.remove(0);
				joueur.player1.add(joueur.getPlayer3().get(0));
				joueur.player3.remove(0);
				joueur.player1.add(joueur.getPlayer4().get(0));
				joueur.player4.remove(0);
				joueur.player1.add(joueur.getPlayer1().get(0));
				joueur.player1.remove(0);
				joueur.player1.addAll(reserve);
				reserve.removeAll(reserve);
				
			} if (this.cardValue2 > this.cardValue1 && this.cardValue2 > this.cardValue3 && this.cardValue2 > this.cardValue4) {
				System.out.println(joueur.playerList.get(1) + " a gagné ce tour avec " + joueur.getPlayer2().get(0));
				joueur.player2.add(joueur.getPlayer1().get(0));
				joueur.player1.remove(0);
				joueur.player2.add(joueur.getPlayer3().get(0));
				joueur.player3.remove(0);
				joueur.player2.add(joueur.getPlayer4().get(0));
				joueur.player4.remove(0);
				joueur.player2.add(joueur.getPlayer2().get(0));
				joueur.player2.remove(0);
				joueur.player2.addAll(reserve);
				reserve.removeAll(reserve);
				
			} if (this.cardValue3 > this.cardValue2 && this.cardValue3 > this.cardValue1 && this.cardValue3 > this.cardValue4) {
				System.out.println(joueur.playerList.get(2) + " a gagné ce tour avec " + joueur.getPlayer3().get(0));
				joueur.player2.remove(0);
				joueur.player3.add(joueur.getPlayer2().get(0));
				joueur.player3.add(joueur.getPlayer1().get(0));
				joueur.player1.remove(0);
				joueur.player3.add(joueur.getPlayer4().get(0));
				joueur.player4.remove(0);
				joueur.player3.add(joueur.getPlayer3().get(0));
				joueur.player3.remove(0);
				joueur.player3.addAll(reserve);
				reserve.removeAll(reserve);
				
			} if (this.cardValue4 > this.cardValue1 && this.cardValue4 > this.cardValue2 && this.cardValue4 > this.cardValue3) {
				System.out.println(joueur.playerList.get(3) + " a gagné ce tour avec " + joueur.getPlayer4().get(0));
				joueur.player4.add(joueur.getPlayer2().get(0));
				joueur.player2.remove(0);
				joueur.player4.add(joueur.getPlayer3().get(0));
				joueur.player3.remove(0);
				joueur.player4.add(joueur.getPlayer1().get(0));
				joueur.player1.remove(0);
				joueur.player4.add(joueur.getPlayer4().get(0));
				joueur.player4.remove(0);
				joueur.player4.addAll(reserve);
				reserve.removeAll(reserve);
				
			} else if (this.cardValue1 == this.cardValue2 || this.cardValue3 == this.cardValue2 || this.cardValue3 == this.cardValue1 || this.cardValue4 == this.cardValue1 || this.cardValue4 == this.cardValue2 || this.cardValue4 == this.cardValue3) {
				System.out.println("Égalité, le vainqueur du prochain tour, remportera ce pli.");
				reserve.add(joueur.getPlayer2().get(0));
				joueur.player2.remove(0);
				reserve.add(joueur.getPlayer3().get(0));
				joueur.player3.remove(0);
				reserve.add(joueur.getPlayer1().get(0));
				joueur.player1.remove(0);
				reserve.add(joueur.getPlayer4().get(0));
				joueur.player4.remove(0);
			}
		this.cardValue1=0; this.cardValue2=0; this.cardValue3=0; this.cardValue4=0;
		System.out.println("");
	}
	public void deroulementTour() {
		do {
			letsCompare();
			System.out.println(" ");
		} while (joueur.player1.size() > 1 || joueur.player2.size() > 1 || joueur.player3.size() > 1 || joueur.player4.size() > 1);
	}

	public static void main(String[] args) {

		// Présentation des cartes triees
				leJeu.presenterleJeu();

				// Sauvegarde du nom des joueurs dans une liste
				for (int i = 1; i <= 4; i++) {
					System.out.println("Nom du joueur " + i + " : ");
					joueur.setName(sc.nextLine());
				}
				
				// Mélange des cartes
				leJeu.melangeur();
				leJeu.distribution();

				//distribution
				/*System.out.println(joueur.getPlayer1());
				System.out.println(joueur.getPlayer2());
				System.out.println(joueur.getPlayer3());
				System.out.println(joueur.getPlayer4());
				
				leJeu.letsCompare();*/
				
				System.out.println(joueur.getPlayer1());
				System.out.println(joueur.getPlayer2());
				System.out.println(joueur.getPlayer3());
				System.out.println(joueur.getPlayer4());
				try {
				leJeu.deroulementTour();
				} finally {
					System.out.println(joueur.getPlayer1());
					System.out.println(joueur.getPlayer2());
					System.out.println(joueur.getPlayer3());
					System.out.println(joueur.getPlayer4());
				}
				
				
	}

}
