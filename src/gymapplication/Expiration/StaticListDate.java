/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.Expiration;

import gymapplication.AlertDate.*;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author gharbi abdelillah
 */
public class StaticListDate {

   private static SimpleStringProperty  idCondidat = new SimpleStringProperty();
   private static SimpleStringProperty nomCondidat = new SimpleStringProperty();
   private static SimpleStringProperty telCondidat = new SimpleStringProperty();
   private static  SimpleStringProperty idAbonnement = new SimpleStringProperty();
   private static  SimpleStringProperty type = new SimpleStringProperty();
   private static SimpleStringProperty dateExp = new SimpleStringProperty();
    
    
    
    
    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }
    

    public void setidCondidat(String idCondidat) {
        this.idCondidat.set(idCondidat);
    }

    public void setNomCondidat(String nomCondidat) {
        this.nomCondidat.set(nomCondidat);
    }

    public void setDateExp(String dateExp) {
        this.dateExp.set(dateExp);
    }

    public void setTelCondidat(String telCondidat) {
        this.telCondidat.set(telCondidat);
    }
    public void setIdAbonnement(String idAbonnement) {
        this.idAbonnement.set(idAbonnement);
    }
    
    public String getidCondidat() {
        return idCondidat.get();
    }

    public String getNomCondidat() {
        return nomCondidat.get();
    }

    public String getDateExp() {
        return dateExp.get();
    }
     public String getTelCondidat() {
        return telCondidat.get();
    }
     public String getIdAbonnement() {
        return idAbonnement.get();
    }

}
