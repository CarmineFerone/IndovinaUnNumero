/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.edu.isspitagora.model;

import java.security.InvalidParameterException;

/**
 *
 * @author Utente
 */
public class Model {
    
    private final int NMAX = 100 ;
    private final int TMAX = 8 ;
    private int segreto ;
    private int tentativiFatti ;
    private boolean inGioco = false;

    public boolean isInGioco() {
        return inGioco;
    }

    public void setInGioco(boolean inGioco) {
        this.inGioco = inGioco;
    }

    public int getSegreto() {
        return segreto;
    }

    public void setSegreto(int segreto) {
        this.segreto = segreto;
    }

    public int getTentativiFatti() {
        return tentativiFatti;
    }

    public void setTentativiFatti(int tentativiFatti) {
        this.tentativiFatti = tentativiFatti;
    }
    
    
    
    public void nuovaPartita () {
        
        this.segreto = (int) (Math.random()*NMAX) + 1;
        this.tentativiFatti = 0;
        this.inGioco = true;
    }
    
    public int tentativo(int tentativo){
        
        
        
        if(!this.inGioco){
            throw new IllegalStateException("La partita è finita... \n HAI PERSO... \n Il numero da indovinare era "+this.segreto+" Ritenta \n");
        }
        if(tentativo < 1 || tentativo >100){
            throw new InvalidParameterException("Devi inserire un valore tra 1 e 100...\n");
        }
        
        this.tentativiFatti++;
        
        if(this.tentativiFatti == this.TMAX)
            this.inGioco = false;
        if(tentativo == this.segreto){
            this.inGioco = false;
            return 0;
          }else if (tentativo < this.segreto){
              return -1;
          }else{
              return 1;
          }    
    }
}
