/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import ConnectionBD.myConnection;
import Entités.ProduitShop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Ayoub
 */
public class ProduitServices implements IproduitCRUD{
    Connection myConn = myConnection.getInstance().getConnection();

    @Override
    public void ajouterProduit(ProduitShop p) {
        try {
            String sql="INSERT INTO produitshop VALUES(null,null,?,?,?,?)"; 
            PreparedStatement ste= myConn.prepareStatement(sql);
            ste.setString(1,p.getTitre());
            ste.setFloat(2,p.getPrix());
            ste.setString(3,p.getDescription());
            ste.setString(4,null);
            int rowsInserted = ste.executeUpdate();
            if (rowsInserted > 0) {
    System.out.println("une nouvelle produit a été insérée avec succés ");
}
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
       
    }

    @Override
    public void modifierProduit(ProduitShop p, String titre, float prix, String description) {
    }
       

    @Override
    public void supprimerProduit(ProduitShop p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void afficherProduits() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
