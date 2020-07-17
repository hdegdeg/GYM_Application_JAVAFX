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
public class ListCondidatStatic {
    private static SimpleStringProperty cin = new SimpleStringProperty();
    private static SimpleStringProperty nom = new SimpleStringProperty();
    private static SimpleStringProperty age = new SimpleStringProperty();
    private static SimpleStringProperty tel = new SimpleStringProperty();
    private static SimpleStringProperty sexe = new SimpleStringProperty();
    private static SimpleStringProperty nomProgramme = new SimpleStringProperty();


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
    
    public String getSexe() {
        return sexe.get();
    }

    public void setSexe(String Sexe) {
        this.sexe.set(Sexe);
    }

    public String getTel() {
        return tel.get();
    }

    public void setTel(String tel) {
        this.tel.set(tel);
    }

    public String getNomProgramme() {
        return nomProgramme.get();
    }

    public void setNomProgramme(String nomProgramme) {
        this.nomProgramme.set(nomProgramme);
    }
    
}
