/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model.entities;

import javafx.beans.property.SimpleStringProperty;

public class ListaMemoria {
	private SimpleStringProperty endereco;
    private SimpleStringProperty valor;

    public ListaMemoria(String endereco, String valor) {
        this.endereco = new SimpleStringProperty(endereco);
        this.valor = new SimpleStringProperty(valor);
    }
    
    public String getEndereco() {
        return endereco.get();
    }

    public void setEndereco(SimpleStringProperty endereco) {
        this.endereco =  endereco;
    }

    public String getValor() {
        return valor.get();
    }

    public void setValor(String valor) {
        this.valor = new SimpleStringProperty(valor);
    }
}