package Control;

import JDBC.ImplementaMetodosJDBC;
import POJO.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ProdutoBean {

    private Produto produto;

    public List<Produto> Produtos = new ArrayList<>();


    public void InserirProduto(Integer ID, String Nome, Integer Preco, String Descricao, String Imagem1, String Imagem2) {
        Produtos.add(new Produto(ID, Nome, Preco, Descricao, Imagem1, Imagem2));
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return Produtos;
    }

    public void setProdutos(List<Produto> Produtos) {
        this.Produtos = Produtos;
    }

    public void produtosDatabase() {
        if (Produtos.isEmpty()) {
            ImplementaMetodosJDBC i = new ImplementaMetodosJDBC();
            Produtos = i.ReceberProdutos(Produtos);
        }
    }

    public String back() {
        return "products";
    }

    /**
     *
     * @param preco
     * @return
     */
    public String precoString(Integer preco) {
        return String.valueOf(preco);
    }
}
