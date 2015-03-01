/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
 
/**
 * Created by JBoss Tools
 */
@ManagedBean(name = "prod")
@RequestScoped
/**
 *
 * @author JR
 */
public class ProdutoAtual {
    private Integer IDAtual;

    public Integer getIDAtual() {
        return IDAtual;
    }

    public void setIDAtual(Integer IDAtual) {
        this.IDAtual = IDAtual;
    }
    
    
}
