package GUI;
import Entités.Boutique;
import Services.BoutiqueServices;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
public class AjouterboutiqueController implements  Initializable{
       private boolean isValid(String email) {
        String EMAIL_PATTERN = 
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
       private boolean isvalid(int num){
           String phonenumberstr = Integer.toString(num);
           if(phonenumberstr.length()!=8){
               return false;
           }
           for (int i =0; i<phonenumberstr.length();i++){
               if(!Character.isDigit(phonenumberstr.charAt(i))){
                   return false;
           }
           }
           return num != 12345678;
 
    }
       
       
      @FXML
    private Button btnChoisir;
      @FXML
    private ImageView imageview;
    @FXML
    private TextField textdesc;
    @FXML
    private TextField txtG;

    @FXML
    private TextField txtV;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtlien;

    @FXML
    private TextField txtnom;

    @FXML
    private TextField txtnumF;

    @FXML
    private TextField txtnumT;
     @FXML
    void ajouter(ActionEvent event){
        
        boolean test=true;
        String nom,email,lien,desc,governerat,ville;
        int num_t , num_f ; 
        nom=txtnom.getText();
        email=txtemail.getText(); 
        lien = txtlien.getText(); 
        desc=textdesc.getText();
        num_t = Integer.valueOf(txtnumT.getText());
        num_f = Integer.valueOf(txtnumF.getText());
        governerat=txtG.getText();
        ville=txtV.getText();
        
        if(isValid(email)==false) {
            test= false ; 
             Alert alert = new Alert(AlertType.ERROR);
             alert.setTitle("Invalid Email");
             alert.setHeaderText(null);
             alert.setContentText("entrer une adresse email valide");
             alert.show();
             txtemail.requestFocus();
             txtemail.selectAll();
          }  
        if((isvalid(num_t)==false)&&(isvalid(num_f))==false) {
            test= false ; 
             Alert alert1 = new Alert(AlertType.ERROR);
             alert1.setTitle("Invalid numero");
             alert1.setHeaderText(null);
             alert1.setContentText("entrer une numero valide");
             alert1.show();
             txtemail.requestFocus();
             txtemail.selectAll();
             
}

        if(test==true ){
            Boutique nouvelleBoutique  =new Boutique (nom,null,email,lien,desc,num_t,num_f,governerat,ville);
            BoutiqueServices bs = new BoutiqueServices();
            bs.ajouterBoutique(nouvelleBoutique);
            Alert alert2 = new Alert(AlertType.CONFIRMATION);
             alert2.setTitle("Information Dialog");
             alert2.setHeaderText(null);
             alert2.setContentText("Boutique insérée avec succés!");
             alert2.show();
             if (txtnom.getText().isEmpty()|| txtemail.getText().isEmpty()|| txtlien.getText().isEmpty()|| textdesc.getText().isEmpty()|| txtnumT.getText().isEmpty() || txtnumF.getText().isEmpty()  || txtG.getText().isEmpty() || txtV.getText().isEmpty()) {
             {
              //test=false;
              Alert alert1 = new Alert(AlertType.WARNING);
             alert1.setTitle("oops");
             alert1.setHeaderText(null);
             alert1.setContentText("remplir tous les champs");
             alert1.showAndWait();
             
                 }
            }
             try {
              Parent page1 =  FXMLLoader.load(getClass().getResource("../GUI/ListeDesBoutiques.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AjouterboutiqueController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    

    
      @FXML
    void choisir(ActionEvent event) {
      FileChooser fileChooser = new FileChooser();
      fileChooser.setTitle("Choisir une image");
       // Filtrage des fichiers pour n'afficher que les images
            FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter(
                   "Images", "*.png", "*.jpg", "*.gif");
          boolean add = fileChooser.getExtensionFilters().add(imageFilter);
          File selectedFile = fileChooser.showOpenDialog(btnChoisir.getScene().getWindow());
         if (selectedFile != null) {
                Image selectedImage = new Image(selectedFile.toURI().toString());
                 imageview.setImage(selectedImage);
    }
}
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

  
}
