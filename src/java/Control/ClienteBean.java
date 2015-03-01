package Control;

import JDBC.ImplementaMetodosJDBC;
import POJO.Cliente;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ClienteBean {

    private Cliente cliente;

    public ClienteBean() {
        cliente = new Cliente();
    }

    public String insere() {
        ImplementaMetodosJDBC i = new ImplementaMetodosJDBC();
        i.Inserir(getCliente());

        EmailBean E = new EmailBean();
        E.EnviarEmail(cliente.getEmail(), cliente.getNome());

        logar(cliente.getLogin(), cliente.getSenha());

        return "cliente";
    }

    public String logar(String Login, String Senha) {

        cliente = new Cliente();

        ImplementaMetodosJDBC i = new ImplementaMetodosJDBC();
        cliente = i.Login(Login, Senha);

        String Return = "account";

        if (i.OK == true) {
            setMinhaContaLink("cliente");
            ContaTexto = this.cliente.getNome();
            setMinhaContaTexto(this.cliente.getNome());
            setAdminimg("images/key.png");
            setCarteiraimg("images/wallet.png");
            setAdmintexto("Adicionar Produtos");

            Return = "cliente";
        }
        return Return;
    }

    public static String ContaTexto = "Minha Conta";
    private String MinhaContaTexto = "Minha Conta";
    private String MinhaContaLink = "account";
    private String admintexto = "";
    private String LOGINlogin;
    private String LOGINsenha;
    private String carteiraimg = "images/null.png";
    private String adminimg = "images/null.png";
    private String coinsStr;

    public String deslogar() {

        cliente = new Cliente();

        LOGINlogin = "";
        LOGINsenha = "";
        carteiraimg = "images/null.png";
        adminimg = "images/null.png";
        admintexto = "";
        coinsStr = "";
        MinhaContaTexto = "Minha Conta";
        MinhaContaLink = "account";
        ContaTexto = "Minha Conta";

        return "index";
    }

    public String getAdmintexto() {
        return admintexto;
    }

    public void setAdmintexto(String Admintexto) {
        this.admintexto = Admintexto;
    }

    public String getCoinsStr() {
        if (String.valueOf(cliente.getCoins()) != "null") {
            return String.valueOf(cliente.getCoins()) + " PCoins";
        } else {
            return "";
        }
    }

    public void setCoinsStr(String coinsStr) {
        this.coinsStr = coinsStr;
    }

    public String getCarteiraimg() {
        return carteiraimg;
    }

    public void setCarteiraimg(String carteiraimg) {
        this.carteiraimg = carteiraimg;
    }

    public String getAdminimg() {
        return adminimg;
    }

    public void setAdminimg(String adminimg) {
        this.adminimg = adminimg;
    }

    public static String getContaTexto() {
        return ContaTexto;
    }

    public static void setContaTexto(String ContaTexto) {
        ClienteBean.ContaTexto = ContaTexto;
    }

    public String getLOGINlogin() {
        return LOGINlogin;
    }

    public void setLOGINlogin(String LOGINlogin) {
        this.LOGINlogin = LOGINlogin;
    }

    public String getLOGINsenha() {
        return LOGINsenha;
    }

    public void setLOGINsenha(String LOGINsenha) {
        this.LOGINsenha = LOGINsenha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getMinhaContaTexto() {
        return MinhaContaTexto;
    }

    public void setMinhaContaTexto(String MinhaContaTexto) {
        this.MinhaContaTexto = MinhaContaTexto;
    }

    public String getMinhaContaLink() {
        return MinhaContaLink;
    }

    public void setMinhaContaLink(String MinhaContaLink) {
        this.MinhaContaLink = MinhaContaLink;
    }

}
