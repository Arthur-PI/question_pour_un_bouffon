/* ------------------------------------------------------------------------------

      ##    ###    ##     ##    ###    
      ##   ## ##   ##     ##   ## ##   
      ##  ##   ##  ##     ##  ##   ##  
      ## ##     ## ##     ## ##     ## 
##    ## #########  ##   ##  ######### 
##    ## ##     ##   ## ##   ##     ## 
 ######  ##     ##    ###    ##     ## 

Projet : Question pour un bouffon
Auteurs : PIGEON Arthur, BILLAUD Victor, BENOUDA Karim, JOVANOVIC Ivan
Role : Ce fichier contient les différents états de joueurs
Il fait partie du package "JEU"

------------------------------------------------------------------------------ */

package jeu;

public enum Status {
	ATTENTE,
	SELECTIONNER,
	GAGNANT,
	SUPER_GAGNANT,
	ELIMINER
}
