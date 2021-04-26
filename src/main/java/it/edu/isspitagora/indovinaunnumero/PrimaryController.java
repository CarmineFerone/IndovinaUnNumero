/**
 * Sample Skeleton for 'esercizio1.fxml' Controller Class
 */

package it.edu.isspitagora.indovinaunnumero;

import it.edu.isspitagora.model.Model;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class PrimaryController {

    private Model model;
    
    public void setModel(Model model){
        this.model = model;
    }
    
    private final int NMAX = 100 ;
    private final int TMAX = 8 ;
    private int segreto ;
    private int tentativiFatti ;
    private boolean inGioco = false;
    
    
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="layoutTentativo"
    private HBox layoutTentativo; // Value injected by FXMLLoader

    @FXML // fx:id="btnNuovaPartita"
    private Button btnNuovaPartita; // Value injected by FXMLLoader

    @FXML // fx:id="txtTentativi"
    private TextField txtTentativi; // Value injected by FXMLLoader

    @FXML // fx:id="txtTentativoUtente"
    private TextField txtTentativoUtente; // Value injected by FXMLLoader

    @FXML // fx:id="btnProva"
    private Button btnProva; // Value injected by FXMLLoader

    @FXML // fx:id="txtRisultato"
    private TextArea txtRisultato; // Value injected by FXMLLoader

    @FXML
    void handleNuovaPartita(ActionEvent event) {
        this.model.nuovaPartita();
        
        
        this.txtRisultato.clear();
    }

    @FXML
    void handleTentativo(ActionEvent event) {

        String ts = txtTentativoUtente.getText();
        
        int tentativo;
        try{
            tentativo = Integer.parseInt(ts);
        }catch(NumberFormatException e){
            txtRisultato.appendText("Devi digitare un numero...\n");
            txtTentativoUtente.clear();
            return;
        }
        txtTentativoUtente.clear();
        
        int result;
        try{
            result = model.tentativo(tentativo);
        }catch(IllegalStateException se){
            this.txtRisultato.appendText(ts);
            this.btnNuovaPartita.setDisable(this.model.isInGioco());
            this.layoutTentativoUtente.setDisable(!(this.model.isInGico()));
            return;
        }catch(InvalidParameterException pe){
            this.txtRisultato.appendText(pe.getMessage());
            return;
        }
        this.txtTentativi.setText(Integer.toString(this.model.getTMAX()-this.model.getTentativiFatti()));
        
        
        this.tentativiFatti++;
        this.txtTentativi.setText(Integer.toString(TMAX-this.tentativiFatti));
        
        if(tentativo == this.segreto){
           txtRisultato.appendText("COMPLIMENTI,HAI VINTO!!! con "+this.tentativiFatti+"Tentativi...");
           this.inGioco = false;
           this.layoutTentativo.setDisable(false);
           return;
        }
        if(this.tentativiFatti == TMAX){
           txtRisultato.appendText("HAI PERSO,il numero da indovinare era  "+this.segreto+"Ritenta...");
           this.inGioco = false;
           this.layoutTentativo.setDisable(false);
           return; 
        }
        if(tentativo < this.segreto){
            txtRisultato.appendText("TENTATIVO TROPPO BASSO \n");
        }else {
            txtRisultato.appendText("TENTATIVO TROPPO ALTO \n");
        }
        
        
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert layoutTentativo != null : "fx:id=\"layoutTentativo\" was not injected: check your FXML file 'esercizio1.fxml'.";
        assert btnNuovaPartita != null : "fx:id=\"btnNuovaPartita\" was not injected: check your FXML file 'esercizio1.fxml'.";
        assert txtTentativi != null : "fx:id=\"txtTentativi\" was not injected: check your FXML file 'esercizio1.fxml'.";
        assert txtTentativoUtente != null : "fx:id=\"txtTentativoUtente\" was not injected: check your FXML file 'esercizio1.fxml'.";
        assert btnProva != null : "fx:id=\"btnProva\" was not injected: check your FXML file 'esercizio1.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'esercizio1.fxml'.";

    }
}

