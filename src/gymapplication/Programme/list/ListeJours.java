/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.Programme.list;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author hdegd
 */
public class ListeJours {
    private   ArrayList<ListeExercice> listeExo  = new ArrayList<ListeExercice>();
    
   private  SimpleStringProperty NomJ= new SimpleStringProperty(); 
   private SimpleStringProperty idProgramme= new SimpleStringProperty(); 
   private SimpleStringProperty Muscles= new SimpleStringProperty(); 

    public ArrayList<ListeExercice> getListeExo() {
        return listeExo;
    }

    public void setListeExo(ListeExercice Exo) {
        this.listeExo.add(Exo);
    }

    public void viderListe(){
        for (ListeExercice var : listeExo) 
        { 
            listeExo.remove(var);
        }
        
    }
   
      public  ArrayList<ListeExercice> ReturnListe(){
       
        return listeExo;
    }
   
    public String getNomJ() {
        return NomJ.get();
    }

    public void setNomJ(String NomJ) {
        this.NomJ.set(NomJ);
    }

    public String getIdProgramme() {
        return idProgramme.get();
    }

    public void setIdProgramme(String idProgramme) {
        this.idProgramme.set(idProgramme);
    }

    public String getMuscles() {
        return Muscles.get();
    }

    public void setMuscles(String Muscles) {
        this.Muscles.set(Muscles);
    }

}
