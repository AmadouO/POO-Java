/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;


import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;


public class Jeu extends Observable {

    public static final int SIZE_X = 20;
    public static final int SIZE_Y = 10;



    private Heros heros;

    public HashMap<Case, Point> map = new  HashMap<Case, Point>(); // permet de récupérer la position d'une case à partir de sa référence
    private Case[][] grilleEntites = new Case[SIZE_X][SIZE_Y]; // permet de récupérer une case à partir de ses coordonnées



    public Jeu() throws IOException {

        //initialisationNiveau();
        level1();
    }


    
    public Case[][] getGrille() {
        return grilleEntites;
    }
    
    public Heros getHeros() {
        return heros;
    }

    public Case getPos(int x, int y) {
        if (contenuDansGrille(new Point(x, y))) {
            return grilleEntites[x][y];
        } else {
            return null;
        }
    }

    public void deplacerHeros(Direction d) {
        heros.avancerDirectionChoisie(d);
        setChanged();
        notifyObservers();
    }

    
    private void initialisationNiveau() {




        // murs extérieurs horizontaux
        for (int x = 0; x < 20; x++) {
            addCase(new Mur(this), x, 0);
            addCase(new Mur(this), x, 9);
        }

        // murs extérieurs verticaux
        for (int y = 1; y < 9; y++) {
            addCase(new Mur(this), 0, y);
            addCase(new Mur(this), 19, y);
        }

        for (int x = 1; x < 19; x++) {
            for (int y = 1; y < 9; y++) {
                addCase(new Vide(this), x, y);
            }

        }

        heros = new Heros(this, grilleEntites[4][4]);
        Bloc b = new Bloc(this, grilleEntites[6][6]);
    }

    public  void level1() throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./Images/level.txt"));
            String line;
            int y = 0;
            while ((line = reader.readLine()) != null){
                for (int x = 0; x < line.length(); x++){
                    char cell = line.charAt(x);
                    switch (cell){
                        case 'V' :
                            addCase(new Vide(this),x,y);
                            break;
                        case 'M' :
                            addCase(new Mur(this),x,y);
                            break;
                        case 'C' :
                            addCase(new CaseCible(this),x,y);
                            break;
                        case 'G' :
                            addCase(new CaseGlasse(this),x,y);
                            break;
                    }
                }
                y++;
            }
            heros = new Heros(this, grilleEntites[4][4]);
            Bloc b = new Bloc(this, grilleEntites[6][6]);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void addCase(Case e, int x, int y) {
        grilleEntites[x][y] = e;
        map.put(e, new Point(x, y));
    }
    

    
    /** Si le déplacement de l'entité est autorisé (pas de mur ou autre entité), il est réalisé
     * Sinon, rien n'est fait.
     */
    public boolean deplacerEntite(Entite e, Direction d) {
        boolean retour = true;
        
        Point pCourant = map.get(e.getCase());
        
        Point pCible = calculerPointCible(pCourant, d);

        if (contenuDansGrille(pCible)) {
            Case caseCible = getPos(pCible.x, pCible.y);
            if (caseCible != null && caseCible.getEntite() == null) {
                if (caseCible instanceof CaseGlasse) {
                    return ((CaseGlasse) caseCible).glisser(e, d);
                }
            }
            Entite eCible = caseALaPosition(pCible).getEntite();
            if (eCible != null) {
                eCible.pousser(d);
            }

            // si la case est libérée
            if (caseALaPosition(pCible).peutEtreParcouru()) {
                e.getCase().quitterLaCase();
                caseALaPosition(pCible).entrerSurLaCase(e);

            } else {
                return false;
            }

        } else {
            return false;
        }
        return true;
    }
    
    
    public Point calculerPointCible(Point pCourant, Direction d) {
        Point pCible = null;
        
        switch(d) {
            case haut: pCible = new Point(pCourant.x, pCourant.y - 1); break;
            case bas : pCible = new Point(pCourant.x, pCourant.y + 1); break;
            case gauche : pCible = new Point(pCourant.x - 1, pCourant.y); break;
            case droite : pCible = new Point(pCourant.x + 1, pCourant.y); break;     
            
        }
        
        return pCible;
    }
    

    
    /** Indique si p est contenu dans la grille
     */
    public boolean contenuDansGrille(Point p) {
        return p.x >= 0 && p.x < SIZE_X && p.y >= 0 && p.y < SIZE_Y;
    }
    
    private Case caseALaPosition(Point p) {
        Case retour = null;
        
        if (contenuDansGrille(p)) {
            retour = grilleEntites[p.x][p.y];
        }
        
        return retour;
    }

}
