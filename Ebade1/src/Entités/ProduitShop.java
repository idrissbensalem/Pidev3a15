/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entités;

import java.util.Objects;

/**
 *
 * @author Ayoub
 */
public class ProduitShop {
    private int id_P;
    private String titre;
    private float prix;
    private String description;
    private String image_b;
    
    
    public ProduitShop(){
    }

    public ProduitShop(String titre, float prix, String description, String image_b) {
        this.titre = titre;
        this.prix = prix;
        this.description = description;
        this.image_b = image_b;
    }

    public int getId_P() {
        return id_P;
    }

    public String getTitre() {
        return titre;
    }

    public float getPrix() {
        return prix;
    }

    public String getDescription() {
        return description;
    }

    public String getImage_b() {
        return image_b;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage_b(String image_b) {
        this.image_b = image_b;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.titre);
        hash = 29 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProduitShop other = (ProduitShop) obj;
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        return Objects.equals(this.description, other.description);
    }
    
    
    
    
}
