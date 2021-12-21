/* ------------------------------------------------------------------------------

Projet : Question pour un bouffon
Auteurs : PIGEON Arthur, BILLAUD Victor, BENOUDA Karim, JOVANOVIC Ivan
Role : Ce fichier contient les différents états de joueurs
Il fait partie du package "JEU"

------------------------------------------------------------------------------ */

package jeu;

/**
 * Enum qui contient tous les statuts d'un joueur
 */
public enum Status {
	ATTENTE,
	SELECTIONNER,
	GAGNANT,
	SUPER_GAGNANT,
	ELIMINER
}
