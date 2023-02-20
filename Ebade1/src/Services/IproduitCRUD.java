/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entités.ProduitShop;

/**
 *
 * @author Ayoub
 */
public interface IproduitCRUD {

    /**
     *
     * @param p
     */
    public void ajouterProduit(ProduitShop p);
     public void modifierProduit(ProduitShop p,String titre,float prix,String description);
     public void supprimerProduit(ProduitShop p);
     public void afficherProduits();
    
}
