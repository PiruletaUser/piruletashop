/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import POJO.ItemCarrinho;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author JR
 */
@ManagedBean
@SessionScoped
public class CarrinhoBean {

    ItemCarrinho itemCarrinho;

    public List<ItemCarrinho> Carrinho = new ArrayList<>();

    public void InserirItemCarrinho(String Nome, Integer Preco) {
        Carrinho.add(new ItemCarrinho(Nome, Preco));
    }

    public String InserirItemCarrinhoSingle(String Nome, Integer Preco) {
        Carrinho.add(new ItemCarrinho(Nome, Preco));
        return "singleOK";
    }

    public void RemoverItemCarrinho(int ID) {
        Carrinho.remove(ID);
    }

    public String RemoverItemCarrinhoSingle(int ID) {
        Carrinho.remove(ID);
        return "single";
    }

    private String somaTotal() {
        Integer somaTotal = 0;

        for (int i = 0; i < Carrinho.size(); i++) {
            somaTotal += Carrinho.get(i).getPreco();
        }

        return String.valueOf(somaTotal);
    }

    public String getsomaTotal() {
        return somaTotal() + " PCoins";
    }

    public void ResetarCarrinho() {
        Carrinho.removeAll(Carrinho);
    }

    public ItemCarrinho getItemCarrinho() {
        return itemCarrinho;
    }

    public void setItemCarrinho(ItemCarrinho itemCarrinho) {
        this.itemCarrinho = itemCarrinho;
    }

    public List<ItemCarrinho> getCarrinho() {
        return Carrinho;
    }

    public void setCarrinho(List<ItemCarrinho> Carrinho) {
        this.Carrinho = Carrinho;
    }

    public String Comprar() {
        if (Carrinho.isEmpty()) {
            return "products";
        } else {
            if (ClienteBean.ContaTexto.equals("Minha Conta")) {
                return "account";
            } else {
                ResetarCarrinho();
                return "fimcompra";
            }
        }
    }

    public String comprarMoedas() {
        return "comprarmoedas";
    }

}
