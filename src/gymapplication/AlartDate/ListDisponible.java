/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.AlartDate;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author abdelillah gharbi
 */
public class ListDisponible {
      public SimpleLongProperty id = new SimpleLongProperty();
    public SimpleStringProperty nom = new SimpleStringProperty();
    public SimpleIntegerProperty qte = new SimpleIntegerProperty();

    public void setId(Long id) {
        this.id.set(id);
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public void setQte(Integer qte) {
        this.qte.set(qte);
    }


    public Long getId() {
        return id.get();
    }

    public String getNom() {
        return nom.get();
    }

    public Integer getQte() {
        return qte.get();
    }
}
