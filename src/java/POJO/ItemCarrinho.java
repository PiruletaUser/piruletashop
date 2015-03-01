/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author JR
 */

@Entity
public class ItemCarrinho implements Serializable{
     
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
    
    private String Nome;
    private Integer Preco;

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Integer getPreco() {
        return Preco;
    }

    public void setPreco(Integer Preco) {
        this.Preco = Preco;
    }
    
    public ItemCarrinho(String Nome, Integer Preco){
        this.Nome = Nome;
        this.Preco = Preco;
    }
    
    
}
