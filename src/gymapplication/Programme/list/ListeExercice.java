/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.Programme.list;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author hdegd
 */
public class ListeExercice {
    private SimpleStringProperty Nom_Exo= new SimpleStringProperty();
    private SimpleStringProperty Nombre_Repetition= new SimpleStringProperty();
    private SimpleStringProperty Nombre_Series= new SimpleStringProperty();
    private SimpleStringProperty idJour= new SimpleStringProperty();

    public String getNom_Exo() {
        return Nom_Exo.get();
    }

    public void setNom_Exo(String Nom_Exo) {
        this.Nom_Exo.set(Nom_Exo);
    }

    public String getNombre_Repetition() {
        return Nombre_Repetition.get();
    }
    public void setNombre_Repetition(String Nombre_Repetition) {
        this.Nombre_Repetition.set(Nombre_Repetition);
    }

    

    public String getNombre_Series() {
        return Nombre_Series.get();
    }

    public void setNombre_Series(String Nombre_Series) {
        this.Nombre_Series.set(Nombre_Series);
    }

    public String getIdJour() {
        return idJour.get();
    }

    public void setIdJour(String idJour) {
        this.idJour.set(idJour);
    }

    
}
