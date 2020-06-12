/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.Abonnement.list;

import gymapplication.listeCondidat.list.*;
import java.sql.PreparedStatement;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author gharbi abdelillah
 */
public class ListAbonnement {
    private SimpleStringProperty idAbonnement2 = new SimpleStringProperty();
    private SimpleStringProperty Date_Debut = new SimpleStringProperty();
    private SimpleStringProperty Date_Fin = new SimpleStringProperty();
    private SimpleStringProperty Nombre_Mois = new SimpleStringProperty();
    private SimpleStringProperty Type = new SimpleStringProperty();
    private SimpleStringProperty idCondidat = new SimpleStringProperty();

  
 public String getidAbonnement() {
        return idAbonnement2.get();
    }

    public void setidAbonnement(String idAbonnement2) {
        this.idAbonnement2.set(idAbonnement2);
    }
    
    public String getDate_Debut() {
        return Date_Debut.get();
    }

    public void setDate_Debut(String Date_Debut) {
        this.Date_Debut.set(Date_Debut);
    }

    public String getDate_Fin() {
        return Date_Fin.get();
    }

    public void setDate_Fin(String Date_Fin) {
        this.Date_Fin.set(Date_Fin);
    }

    public String getNombre_Mois() {
        return Nombre_Mois.get();
    }

    
    
    public void setNombre_Mois(String Nombre_Mois) {
        this.Nombre_Mois.set(Nombre_Mois);
    }

    public String getType() {
        return Type.get();
    }

    public void setType(String Type) {
        this.Type.set(Type);
    }

    public String getidCondidat() {
        return idCondidat.get();
    }

    public void setidCondidat(String idCondidat) {
        this.idCondidat.set(idCondidat);
    }

   
   
}
