/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.listeCondidat.list;

import java.sql.PreparedStatement;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author gharbi abdelillah
 */
public class ListCondidat {
    private SimpleStringProperty cin = new SimpleStringProperty();
    private SimpleStringProperty nom = new SimpleStringProperty();
    private SimpleStringProperty age = new SimpleStringProperty();
    private SimpleStringProperty tel = new SimpleStringProperty();
    private SimpleStringProperty abonnement = new SimpleStringProperty();
    private SimpleStringProperty debut = new SimpleStringProperty();
    private SimpleStringProperty fin = new SimpleStringProperty();

    public String getCin() {
        return cin.get();
    }

    public void setCin(String cin) {
        this.cin.set(cin);
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public String getAge() {
        return age.get();
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    public String getTel() {
        return tel.get();
    }

    public void setTel(String tel) {
        this.tel.set(tel);
    }

    public String getAbonnement() {
        return abonnement.get();
    }

    public void setAbonnement(String abonnement) {
        this.abonnement.set(abonnement);
    }

    public String getDebut() {
        return debut.get();
    }

    public void setDebut(String debut) {
        this.debut.set(debut);
    }

    public String getFin() {
        return fin.get();
    }

    public void setFin(String fin) {
        this.fin.set(fin);
    }
    
}
