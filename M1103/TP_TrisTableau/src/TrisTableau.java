public class TrisTableau
{
	/**
	 * Variable globale, compteur du nombre d'operations
	 */
	 long cpt = 0;

    /**
    * La methode principale
    */
    void principal()
    {
        //testRemplacerAuHasard();
        //testRechercheSeq();
        //testRechercheDicho();
        //testVerifTri();
        //testTriSimple();
        //testSeparer();
        //testTriRapide();
        testCreerTabFreq();
        //testTriParComptage();
        //testTriABulle();
    }

    /**
    * Verifie les parametres
    * @param leTab le tableau
    * @param nbElem le nombre d'elements du tableau
    * @return renvoie vrai si les parametres sont corrects
    */
    boolean verifieParamTab(int [] leTab, int nbElem)
    {
        boolean correct = true;
        if (leTab == null)
        {
            System.out.println("Le tableau est null");
            correct = false;
        }
        else if (nbElem <= 0)
        {
            System.out.println("nbElem doit etre positif");
            correct = false;
        }
        else if (nbElem > leTab.length)
        {
            System.out.println("nbElem est en dehors des bornes du tableau");
            correct = false;
        }
        return correct;
    }

    /**
    * Renvoie un entier aleatoire compris entre min et max (min &le; valeur &le; max)
    * @param min valeur minimum
    * @param max valeur maximum
    * @return l'entier aleatoire
    */
    int tirerAleatoire(int min, int max)
    {
        return (int)(Math.random() * (max+1-min)) + min;
    }

    /**
    * Affiche le tableau
    * @param leTab le tableau a afficher
    * @param nbElem le nombre d'elements a afficher
    */
    void afficherTab(int[] leTab, int nbElem)
    {
        if (verifieParamTab(leTab, nbElem))
        {
            for(int i = 0; i < nbElem; i++)
            {
                System.out.println(leTab[i]);
            }
        }
    }

    /**
    * A partir d'un tableau créé, remplit aléatoirement le tableau de
    *  nbElem valeurs comprises entre min et max. Tenir compte du cas
    * particulier où le tableau n'est pas créé. Vérifier que
    * nbElem <= taille sinon afficher une erreur. Vérifier que
    * min <= max, sinon afficher une erreur. Utiliser obligatoirement
    * la méthode "int tirerAleatoire (int min, int max)".
    * @param leTab le tableau à remplir de valeurs tirées aléatoirement
    * @param nbElem le nombre d'entiers que contiendra le tableau
    * @param nbElem le nombre d'entiers que contiendra le tableau
    * @param max la valeur de l'entier maximum
    */
    void remplirAleatoire(int[] leTab, int nbElem, int min, int max)
    {
        if(min > max)
        {
            System.out.println("max doit etre superieur ou egale a min");
        }
        else if(verifieParamTab(leTab, nbElem))
        {
            for(int i = 0; i < nbElem; i++)
            {
                leTab[i] = tirerAleatoire(min,max);
            }
        }
    }


    /**
    * Remplace dans le tableau passé en paramtre une case tiree
    * au hasard entre 0 et (nbElem-1) par une nouvelle valeur newInt
    * @param leTab le tableau dont 1 case sera remplacee
    * @param nbElem le nombre d'element
    * @param newInt le nouvel entier a placer dans le tableau
    */
    void remplacerAuHasard(int [] leTab, int nbElem, int newInt)
    {
        if (verifieParamTab(leTab, nbElem))
        {
            int indiceAleatoire = tirerAleatoire(0, (nbElem-1));
            leTab[indiceAleatoire] = newInt;
        }
    }

    /**
    * Test de la methode remplacerAuHasard
    */
    void testRemplacerAuHasard()
    {
        System.out.println("\n=== Test de la methode remplacerAuHasard ===\n");

        int[] tab = null;
        int[] tab2 = new int [5];

        System.out.println("Test avec un tableau vide");
        remplacerAuHasard(tab, 0, 0);

        System.out.println("Test avec nbElem = 0");
        remplacerAuHasard(tab2, 0, 5);

        System.out.println("Test avec ce tableau");
        afficherTab(tab2, 5);
        System.out.println("Test avec newInt = 5");
        remplacerAuHasard(tab2, 5, 5);
        afficherTab(tab2, 5);
        System.out.println("Test avec newInt = 15");
        remplacerAuHasard(tab2, 5, 15);
        afficherTab(tab2, 5);
        System.out.println("Test avec newInt = 3");
        remplacerAuHasard(tab2, 5, 3);
        afficherTab(tab2, 5);

        System.out.println("\n=== Fin du test de la methode remplacerAuHasard ===\n");
    }

    /**
    * Recherche sequentielle d'une valeur dans un tableau. La valeur
    * a rechercher peut exister en plusieurs exemplaires mais la
    * recherche s'arrete des qu'une premiere veleur est trouvee. On
    * suppose que le tableau passé en parametre est cree et possede
    * au moins une valeur (nbElem > 0). Ceci ne doit donc pas etre
    * verifie.
    * @param leTab le tableau dans lequel effetuer la recherche
    * @param nbElem le nombre d'entiers que contient le tableau
    * @param aRech l'entier a rechercher dans le tableau
    * @return l'indice (>=0) de la position de l'entier dans le
    * tableau ou -1 s'il n'est pas present
    */
    int rechercheSeq(int[] leTab, int nbElem, int aRech)
    {
        int indice = -1;

        if (verifieParamTab(leTab, nbElem))
        {
            for (int i = 0; (i < nbElem && indice == -1); i++)
            {
                if (leTab[i] == aRech)
                {
                    indice = i;
                }
            }
        }

        return indice;
    }

    /**
    * Test de la methode rechercheSeq
    */
    void testRechercheSeq()
    {
        System.out.println("\n=== Test de la methode rechercheSeq ===\n");

        int[] tab = null;
        int[] tab2 = {0, 1, 2, 3 , 4, 5};

        System.out.println("Test avec un tableau vide");
        remplacerAuHasard(tab, 0, 0);

        System.out.println("Test avec nbElem = 0");
        remplacerAuHasard(tab2, 0, 5);

        System.out.println("Test avec ce tableau :");
        afficherTab(tab2, 6);
        System.out.println("\nIndice de -5 : " + rechercheSeq(tab2, 6, -5));
        System.out.println("Indice de 0 : " + rechercheSeq(tab2, 6, 0));
        System.out.println("Indice de 3 : " + rechercheSeq(tab2, 6, 3));
        System.out.println("Indice de 5 : " + rechercheSeq(tab2, 6, 5));

        System.out.println("\n=== Fin du test de la methode rechercheSeq ===\n");
    }

    /**
    * Recherche dichotomique d'une valeur dans un tableau. On
    * suppose que le tableau est trie par odre croissant. La valeur
    * a rechercher peut exister en plusieurs exemplaires, danc ce
    * cas, c'est cas c'est la valeur a l'indice le + faible qui sera
    * trouve. On suppose egalement que le tableau est passe en
    * parametre est cree et possede au moins une valeur (nbElem>0).
    * @param le tableau trie par odre croissant dans lequel
    * effectuer la recherche
    * @param nbElem le nombre d'entiers que contient le tableau
    * @param aRech l'entier a rechercher dans le tableau
    * @return l'entier a rechercher dans le tableau
    */
    int rechercheDicho(int[] leTab, int nbElem, int aRech)
    {
        int indice = -1;
        int indD = 0;
        int indF = nbElem-1;
        int indC = 0;

        while (indice != -1 && indD <= indF)
        {
            indC = (int)(indD + indF)/2;

            if (leTab[indC] == aRech)
            {
                indice = indC;
            }
            else if (leTab[indC] < aRech)
            {
                indD = indC + 1;
            }
            else
            {
                indF = indC - 1;
            }
        }

        return indice;
    }

    /**
    * Test de la methode rechercheDicho
    */
    void testRechercheDicho()
    {
        System.out.println("\n=== Test de la methode rechercheDicho ===\n");

        System.out.println("Test avec un tableau contenenant les entiers de 0 a 300 par ordre croissant");

        int [] tab = new int[301];
        for (int i = 0; i < 301; i++)
        {
            tab[i] = i;
        }

        System.out.println("\nIndice de -5 : " + rechercheSeq(tab, 6, -5));
        System.out.println("Indice de 0 : " + rechercheSeq(tab, 301, 0));
        System.out.println("Indice de 30 : " + rechercheSeq(tab, 301, 30));
        System.out.println("Indice de 50 : " + rechercheSeq(tab, 301, 50));
        System.out.println("Indice de 180 : " + rechercheSeq(tab, 301, 180));
        System.out.println("Indice de 300 : " + rechercheSeq(tab, 301, 300));

        System.out.println("\n=== Fin du test de la methode rechercheDicho ===\n");
    }

    /**
    * Verifie que le tableau passe en paramtre est trie par odre
    * croissant des valeurs. On suppose que le tableau passe en
    * parametre est cree et possede au moins une valeur.
    * @param leTab le tableau a verifier (odre croissant)
    * @param nbElem le nombdre d'entier presents dans le tableau
    * @return true si le tableau est trie
    */
    boolean verifTri(int[] leTab, int nbElem)
    {
        boolean trie = true;

        for (int i = 0; (i < (nbElem-1) && trie); i++)
        {
            if (leTab[i] > leTab[i+1])
            {
                trie = false;
            }
        }

        return trie;
    }

    /**
    * Test de la methode verifTri
    */
    void testVerifTri()
    {
        System.out.println("\n=== Test de la methode verifTri ===\n");

        System.out.println("Test avec ce tableau :");
        int [] tab1 = {2, 8, -5, -89, 6};
        afficherTab(tab1, 5);
        System.out.println("Est il trie : " + verifTri(tab1, 5));

        System.out.println("\nTest avec ce tableau :");
        int [] tab2 = {9, 3, 4, 5};
        afficherTab(tab2, 4);
        System.out.println("Est il trie : " + verifTri(tab2, 4));

        System.out.println("\nTest avec ce tableau :");
        int [] tab3 = {2, 3, 4, 1};
        afficherTab(tab3, 4);
        System.out.println("Est il trie : " + verifTri(tab3, 4));

        System.out.println("\nTest avec ce tableau :");
        int [] tab4 = {2, 3, 4, 5, 6};
        afficherTab(tab4, 5);
        System.out.println("Est il trie : " + verifTri(tab4, 5));

        System.out.println("\n=== Fin du test de la methode verifTri ===\n");
    }

    /**
    * Renvoie le maximum parmi les elements du tableau
    * @param leTab le tableau
    * @param nbElem le nombre d'entiers presents dans le tableau
    * @return le minimum des elements du tableau
    */
    int leMin(int[] leTab, int nbElem)
    {
        int min = 0;

        if (verifieParamTab(leTab, nbElem))
        {
            min = leTab[0];
            for (int i = 0; i < nbElem; i++)
            {
                if (min > leTab[i])
                {
                    min = leTab[i];
                }
            }
        }
        return min;
    }

    /**
    * Tri par ordre croissant d'un tableau selon la methode
    * simple : l'element min est place en debut de tableau
    * (efficacite en n carre). On suppose que le tableau
    * est passe en parametre est cree et possede au moins une
    * valeur (nbElem > 0).
    * @param leTab le tableau a trier par ordre croissant
    * @param nbElem le nombre d'entier que contient le tableau
    */
    void triSimple(int[] leTab, int nbElem)
    {
        int min = leMin(leTab, nbElem);
        for(int i = 0; i < nbElem; i++)
        {
            for (int j = i; j < nbElem; j++)
            {
                if (min > leTab[j])
                {
                    min = leTab[j];
                }
            }
            leTab[i] = min;
        }
    }

    /**
    * Test de la methode triSimple
    */
    void testTriSimple()
    {
        System.out.println("\n=== Test de la methode triSimple ===\n");

        int taille = 9999;
        System.out.println("Generation d'un tableau aléatoire de " + taille + " valeurs entre 0 et 500");
        int tab1[] = new int[taille];
        remplirAleatoire(tab1, taille, 0, 500);
        System.out.println("Tri par comptage");
        triSimple(tab1, taille);
        System.out.println("Verification : ");
        System.out.println("Tableau trie ? " + verifTri(tab1, taille));

        System.out.println("\n=== Fin du test de la methode triSimple ===\n");
    }

    /**
    * Cette methode renvoie l'indice de separation du tableau
    * en 2 parties par placement du pivot a la bonne case.
    * @param tab le tableau des valeurs
    * @param indR indice Right de fin de tableau
    * @param indL indice Left de debut de tableau
    * @return l'indice de separation du tableau
    */
    int separer(int[] tab, int indL, int indR)
    {
        int pivot = tab[indL];

        while(indL != indR)
        {
            if(tab[indL] > tab[indR])
            {
                echange(tab, tab.length, indL, indR);
            }

            if(tab[indL] == pivot)
            {
                indR--;
            }
            else
            {
                indL++;
            }
        }

        return indL;
    }

    /**
    * Test de la methode separer
    */
    void testSeparer()
    {
        System.out.println("\n=== Test de la methode separer ===\n");

        System.out.println("Test avec ce tableau:");
        int [] tab1 = new int[6];
        remplirAleatoire(tab1, 6, 1, 10);
        afficherTab(tab1, 6);
        int indP = separer(tab1, 0, 5);
        System.out.println("\nAffichage du tableau: ");
        afficherTab(tab1, 6);
        System.out.println("\nIndice : " + indP + " Valeur : " + tab1[indP]);

        System.out.println("\n=== Fin du test de la methode separer ===\n");
    }

    /**
    * Methode de tri recursive selon le principe de seoaration. La
    * methode s'appelle elle meme sur les tableaux gauche et droite
    * par rapport a un pivot.
    * @param tab le tableau sur lequel est effectue la separation
    * @param indL l'indice gauche de debut de tableau
	* @param indR l'indice droit de fin de tableau
    */
    void triRapideRec(int[] tab, int indL, int indR)
    {
		int indS = separer (tab, indL, indR);
		
		if ((indS-1) > indL)
		{
			triRapideRec(tab, indL,(indS-1));
		}
		if ((indS+1) < indR)
		{
			triRapideRec(tab, (indS+1), indR);
		}
	}
	 
	 /**
	  * Tri par ordre croissant d'un tableau selon la methode du tri
	  * rapide (QuickSort). On suppose que le tableau passé en parametre
	  * est cree et possede au moins une valeur (nbElem > 0).
	  * Cette methode appelle triRapideRec qui elle effecture reelement
	  * le tri rapide selon la methode de separation recursive.
	  * @param leTab le tableau a trier par ordre croissant
	  * @param nbElem le nombre d'entier qui contient le tableau
	  */
	  void triRapide(int [] leTab, int nbElem)
	  {
		  triRapideRec(leTab, 0, (nbElem-1));
	  }
	  
	  /**
	   * Test de la methode triRapide
	   */
	   void testTriRapide()
	   {
		   System.out.println("\n=== Test de la methode triRapide ===\n");
		   
		   int taille = 1000000;
		   System.out.println("Generation d'un tableau aléatoire de " + taille + " valeurs entre 0 et 500");
		   int tab1[] = new int[taille];
		   remplirAleatoire(tab1, taille, 0, 500);
		   System.out.println("Tri par triRapide");
		   triRapide(tab1, taille);
		   System.out.println("Verification : ");
		   System.out.println("Tableau trie ? " + verifTri(tab1, taille));
		   
		   System.out.println("\n=== Fin du test de la methode triRapide ===\n");
	   }
	   
    /**
    * Renvoie le maximum parmi les elements du tableau
    * @param leTab le tableau
    * @param nbElem le nombre d'entiers presents dans le tableau
    * @return le maximum des elements du tableau
    */
    int leMax(int[] leTab, int nbElem)
    {
        int max = 0;

        if (verifieParamTab(leTab, nbElem))
        {
            max = leTab[0];
            for (int i = 0; i < nbElem; i++)
            {
                if (max < leTab[i])
                {
                    max = leTab[i];
                }
            }
        }
        return max;
    }

    /**
    * Renvoie le nombre d'occurrences d'un entier dans un tableau
    * @param leTab le tableau
    * @param nbElem le nombre d'entiers presents dans le tableau
    * @param elem l'entier a rechercher dans le tableau
    * @return le nombre d'occurrences
    */
    int nbOccurrences(int[] leTab, int nbElem, int elem)
    {
        int occurences = 0;
        if (verifieParamTab(leTab, nbElem))
        {
            for (int i = 0; i < nbElem; i++)
            {
                if(leTab[i] == elem)
                {
                    occurences++;
                }
            }
        }
        return occurences;
    }

    int[] creerTabFreq(int [] leTab, int nbElem)
    {
        int taille = leMax(leTab, nbElem) + 1;
        int tabFreq[] = new int [taille];

        for(int i = 0; i < nbElem; i++)
        {
            if(tabFreq[leTab[i]] == 0)
            {
                tabFreq[leTab[i]] = nbOccurrences(leTab, nbElem, leTab[i]);
            }
        }

        return tabFreq;
    }
    
    /**
     * Test de la methode creerTabFreq
     */
     void testCreerTabFreq()
     {
		 System.out.println("\n=== Test de la methode creerTabFreq ===\n");
		 
		 System.out.println("Test avec ce tableau : ");
		 int tab1[] = {1, 2, 2, 3, 4, 4, 5};
		 afficherTab(tab1, 7);
		 System.out.println("\ntabFreq : ");
		 int tab2[] = creerTabFreq(tab1, 7);
		 afficherTab(tab2, 6);
		 
		 System.out.println("\n=== Fin du test de la methode creerTabFreq ===\n");
	 }

    int[] triParComptage(int[] leTab, int nbElem)
    {
        int tabFreq[] = creerTabFreq(leTab, nbElem);
        int tabTrie[] = new int [nbElem];
        int j = 0;

        for(int i = 0; i < nbElem; i++)
        {
            while(tabFreq[j] == 0)
            {
                j++;
            }

            tabTrie[i] = j;
            tabFreq[j]--;
        }

        return tabTrie;
    }

    void testTriParComptage()
    {
        System.out.println("\n=== Test de la methode testTriParComptage ===\n");

        int taille = 99999999;
        System.out.println("Generation d'un tableau aléatoire de " + taille + " valeurs entre 0 et 500");
        int tab1[] = new int[taille];
        remplirAleatoire(tab1, taille, 0, 500);
        System.out.println("Tri par comptage");
        int tab2[] = triParComptage(tab1, taille);
        System.out.println("Verification : ");
        System.out.println("Tableau trie ? " + verifTri(tab2, taille));

        System.out.println("\n=== Fin du test de la methode testTriParComptage ===\n");
    }

    /**
    * Echange les contenus des cases du tableau passe en
    * parametre, cases identifiees par les indices ind1 et ind2
    * @param leTab le tableau
    * @param nbElem le nombre d'entiers presents dans le tableau
    * @param ind1 numero de la premiere case a echanger
    * @param ind2 numero de la deuxieme case a echanger
    */
    void echange(int[] leTab, int nbElem, int ind1, int ind2)
    {
        if (ind1 < 0 || ind1 < 0)
        {
            System.out.println("Indice trop petit");
        }
        else if (ind1 > nbElem || ind2 > nbElem)
        {
            System.out.println("Indice trop grand");
        }
        else if (verifieParamTab(leTab, nbElem))
        {
            int tmp = leTab[ind2];
            leTab[ind2] = leTab[ind1];
            leTab[ind1] = tmp;
        }
    }

    void triABulles(int[] leTab, int nbElem)
    {
        while(!verifTri(leTab, nbElem))
        {
            for(int i = 0; i < nbElem-1; i++)
            {
                if(leTab[i] > leTab[i+1])
                {
                    echange(leTab, nbElem, i, i+1);
                }
            }
        }
    }

    void testTriABulle()
    {
        System.out.println("\n=== Test de la methode testTriParComptage ===\n");

        int taille = 9999;
        System.out.println("Generation d'un tableau aléatoire de " + taille + " valeurs entre 0 et 500");
        int tab1[] = new int[taille];
        remplirAleatoire(tab1, taille, 0, 500);
        System.out.println("Tri par comptage");
        triABulles(tab1, taille);
        System.out.println("Verification : ");
        System.out.println("Tableau trie ? " + verifTri(tab1, taille));

        System.out.println("\n=== Fin du test de la methode testTriParComptage ===\n");
    }

}
