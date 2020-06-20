/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.AlartDate;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author gharbi abdelillah
 */
public class listDate {
    SimpleStringProperty cin = new SimpleStringProperty();
    SimpleStringProperty name= new SimpleStringProperty();
   
    SimpleStringProperty dateExp= new SimpleStringProperty();

    public void setCin(String cin) {
        this.cin.set(cin);
    }

    public void setName(String name) {
        this.name.set(name);
    }


    public void setDateExp(String dateExp) {
        this.dateExp.set(dateExp);
    }
    
    public String getCin() {
        return cin.get();
    }

    public String getName() {
        return name.get();
    }


    public String getDateExp() {
        return dateExp.get();
    }
    
    
}
