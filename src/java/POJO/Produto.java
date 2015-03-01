package POJO;

import java.io.Serializable;

public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer ID;
    private String Nome;
    private Integer Preco;
    private String Descricao;
    private String Imagem1;
    private String Imagem2;

    public Produto(Integer ID, String nome, Integer preco, String descricao, String imagem1, String imagem2) {
        this.ID = ID;
        this.Nome = nome;
        this.Preco = preco;
        this.Descricao = descricao;
        this.Imagem1 = imagem1;
        this.Imagem2 = imagem2;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

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

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getImagem1() {
        return Imagem1;
    }

    public void setImagem1(String Imagem) {
        this.Imagem1 = Imagem;
    }

    public String getImagem2() {
        return Imagem2;
    }

    public void setImagem2(String Imagem2) {
        this.Imagem2 = Imagem2;
    }

    @Override
    public String toString() {
        
        return String.valueOf(ID);
    }
    
    private String IDstr;

    public String getIDstr() {
        return String.valueOf(ID);
    }

    public void setIDstr(String IDstr) {
        this.IDstr = String.valueOf(ID);
    }
    
}
