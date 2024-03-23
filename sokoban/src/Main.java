
import VueControleur.VueControleur;
import modele.Jeu;

import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Main {
    public static void main(String[] args) throws IOException {
        Jeu jeu = new Jeu();
        
        VueControleur vc = new VueControleur(jeu);
        vc.setVisible(true);

    }
}
