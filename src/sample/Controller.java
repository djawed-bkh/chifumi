package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import javafx.stage.Stage;


import java.util.Random;

public class Controller {
    // initialisations
    @FXML
    private TextField screen1;
    @FXML
    private TextField screen;
    @FXML
    private TextField screen11;
    private int p=1;
    private int f=2;
    private int c=3;
    private int val=0;
    private int scorej=0;
    private int scoreo=0;
    private int joue;


    String nom;

    int i=1;
    private int nbrpartie=3;
    //initialisations
    //remmetre les comptes a zero
    public void resset(){
        scoreo=0;
        scorej=0;
        screen.setText("");
        screen.setText("");
        screen1.setText("");
        screen11.setText("");
        i=1;

    }

    public void replay(ActionEvent event ){
        resset();
    }
    @FXML
public void clique(ActionEvent event){


    if (i<=nbrpartie){
       nom=((Button)event.getSource()).getText();
        System.out.println( "jouer"+nom);
       joue=Integer.parseInt(nom);
       calculscore();
        i++;

    }
    if (i>nbrpartie){
        if (scorej>scoreo){
            screen11.setText("felicitations vous avez gagné avec  "+scorej+" points");
        }else if(scorej<scoreo){
            screen11.setText("le gagnant est l'ordinateur avec   "+scoreo+"  points");

        }else {
            screen11.setText("partie nulle ");
        }
    }


}
    //l'ordinateur qui joue
    public int ordiplay(){
        int low=1;
        int high=3;
        return val=(int)(Math.random()*(high-low))+low;
    }

    public void calculscore(){
        if (ordiplay()==1 && joue==2){
            scorej+=1;
            scoreo+=0;
            screen.setText("ordinateur:  "+scoreo);
            screen1.setText("joueur:  "+scorej);
        }
        if (ordiplay()==2 && joue==1){
            scorej+=0;
            scoreo+=1;
            screen.setText("ordinateur:  "+scoreo);
            screen1.setText("joueur:  "+scorej);
        }
        if (ordiplay()==1 && joue==3){
            scorej+=0;
            scoreo+=1;
            screen.setText("ordinateur:  "+scoreo);
            screen1.setText("joueur:  "+scorej);
        }
        if (ordiplay()==3 && joue==1){
            scorej+=1;
            scoreo+=0;
            screen.setText("ordinateur:  "+scoreo);
            screen1.setText("joueur:  "+scorej);
        }
        if (ordiplay()==2 && joue==3){
            scorej+=1;
            scoreo+=0;
            screen.setText("ordinateur:  "+scoreo);
            screen1.setText("joueur:  "+scorej);
        }
        if (ordiplay()==1 && joue==1){
            scorej+=0;
            scoreo+=0;
            screen.setText("ordinateur:  "+scoreo);
            screen1.setText("joueur:  "+scorej);
        }
        if (ordiplay()==2 && joue==2){
            scorej+=0;
            scoreo+=0;
            screen.setText("ordinateur:  "+scoreo);
            screen1.setText("joueur:  "+scorej);
        }
        if (ordiplay()==3 && joue==3){
            scorej+=0;
            scoreo+=0;
            screen.setText("ordinateur:  "+scoreo);
            screen1.setText("joueur:  "+scorej);
        }
    }
    @FXML
    private void retour(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/sample/acceuil.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Chifoumie");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
        resset();
    }
}
