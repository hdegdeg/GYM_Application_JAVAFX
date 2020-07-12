/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.Programme.list;

import java.sql.PreparedStatement;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author hdegd
 */
public class ListeProgramme {
    
    private  SimpleStringProperty idprog= new SimpleStringProperty();
    private  SimpleStringProperty nomprog= new SimpleStringProperty();
    private  SimpleStringProperty nbjourprog= new SimpleStringProperty();

    public String getIdprog() {
        return idprog.get();
    }

    public void setIdprog(String idProg) {
        this.idprog.set(idProg);
    }

    public String getNomprog() {
        return nomprog.get();
    }

    public void setNomprog(String nomProg) {
        this.nomprog.set(nomProg);
    }

    public String getNbjourprog() {
        return nbjourprog.get();
    }

    public void setNbjourprog(String nbJourProg) {
        this.nbjourprog.set(nbJourProg);
    }
    
    
}
