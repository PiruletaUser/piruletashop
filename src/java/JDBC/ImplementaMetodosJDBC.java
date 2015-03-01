package JDBC;

import DAO.MetodosDao;
import POJO.Cliente;
import POJO.Endereco;
import POJO.ItemCarrinho;
import POJO.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ImplementaMetodosJDBC implements MetodosDao {

    private PreparedStatement ps;
    private Connection conn;
    //private static ImplementaMetodosJDBC instancia = null;

    //asdasdasdasdasdad
    private ItemCarrinho itemcarrinho;
    private Produto produto;

    public void closeConnectionFactory(PreparedStatement ps) {

        int resultado = 0;

        try {
            resultado = ps.executeUpdate();
            ConnectionFactory.closeConnection();
            System.out.println("Operação realizada com sucesso!");
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.print(e.getMessage());
        }

        if (resultado == 0) {
            System.out.println("Falha na operação.");
        }
    }

    @Override
    public void Inserir(Object obj) {

        Integer IDF = 0;
        
        Cliente u = (Cliente) obj;
        
         try {
            conn = ConnectionFactory.getConnection();
            String sql = "INSERT INTO Usuario(login, senha, admin, coins) VALUES (?, ?, ?, ?)";

            ps = conn.prepareStatement(sql);

            ps.setString(1, u.getLogin());
            ps.setString(2, u.getSenha());
            ps.setString(3, "");
            ps.setInt(4, 0);

            closeConnectionFactory(ps);
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.print(e.getMessage());
        }
         
          try {
            conn = ConnectionFactory.getConnection();
            String sql = ("SELECT id FROM Usuario WHERE login = ? AND senha = ?");
            ps = conn.prepareStatement(sql);

            ps.setString(1, u.getLogin());
            ps.setString(2, u.getSenha());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                IDF = rs.getInt("id");
            }
            //closeConnectionFactory(ps);

        } catch (SQLException e) {
            System.out.print(e.getMessage());
            System.out.print(e.getCause());
        }

        try {
            conn = ConnectionFactory.getConnection();
            String sql = "INSERT INTO Cliente(nome, sobrenome, email, sexo, cpf, telefone, idf) VALUES (?, ?, ?, ?, ?, ?, ?)";

            ps = conn.prepareStatement(sql);

            ps.setString(1, u.getNome());
            ps.setString(2, u.getSobrenome());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getSexo());
            ps.setString(5, u.getCpf());
            ps.setString(6, u.getTelefone());
            ps.setInt(7, IDF);

            closeConnectionFactory(ps);
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.print(e.getMessage());
        }

        try {
            conn = ConnectionFactory.getConnection();
            String sql = "INSERT INTO Endereco(pais, estado, cidade, bairro, logradouro, numero, idf) VALUES (?, ?, ?, ?, ?, ?, ?)";

            ps = conn.prepareStatement(sql);

            ps.setString(1, u.getEndereco().getPais());
            ps.setString(2, u.getEndereco().getEstado());
            ps.setString(3, u.getEndereco().getCidade());
            ps.setString(4, u.getEndereco().getBairro());
            ps.setString(5, u.getEndereco().getLogradouro());
            ps.setString(6, u.getEndereco().getNumero());
            ps.setInt(7, IDF);

            closeConnectionFactory(ps);
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.print(e.getMessage());
        }
    }

    public Boolean OK = false;

    public Cliente Login(String Login, String Senha) {
        System.out.println("INCIANDO LOGIN");
        System.out.println("LOGIN: " + Login + "   SENHA: " + Senha);
        Cliente u = new Cliente();
        Integer IDF = null;
        OK = false;
        try {
            conn = ConnectionFactory.getConnection();
            String sql = ("SELECT * FROM Usuario WHERE login = ? AND senha = ?");
            ps = conn.prepareStatement(sql);

            ps.setString(1, Login);
            ps.setString(2, Senha);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("USUARIO - OK");
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setAdmin(rs.getString("admin"));
                u.setCoins(rs.getInt("coins"));
                IDF = rs.getInt("id");
                //u.setId(ID);
                System.out.println("OK - OK");

                OK = true;
            }
            //closeConnectionFactory(ps);

        } catch (SQLException e) {
            System.out.print(e.getMessage());
            System.out.print(e.getCause());
        }

        if (OK == true) {
            try {
                conn = ConnectionFactory.getConnection();
                String sql = ("SELECT * FROM Cliente WHERE idf = ?");
                ps = conn.prepareStatement(sql);

                ps.setInt(1, IDF);
                System.out.println("ID: " + IDF);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    System.out.println("CLIENTE- START");
                    u.setNome(rs.getString("nome"));
                    System.out.println("NOME" + u.getNome() + " - OK");
                    u.setSobrenome(rs.getString("sobrenome"));
                    u.setSexo(rs.getString("sexo"));
                    u.setTelefone(rs.getString("telefone"));
                    u.setCpf(rs.getString("cpf"));
                    u.setEmail(rs.getString("email"));
                    System.out.println("CLIENTE- OK");

                }

                //closeConnectionFactory(ps);
            } catch (SQLException e) {
                System.out.print(e.getMessage());
                System.out.print(e.getCause());
            }

            try {
                Endereco e = new Endereco();

                conn = ConnectionFactory.getConnection();
                String sql = ("SELECT * FROM Endereco WHERE idf = ?");
                ps = conn.prepareStatement(sql);

                ps.setInt(1, IDF);

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    //e.setId(ID);
                    u.setEndereco(e);

                    e.setPais(rs.getString("pais"));
                    e.setEstado(rs.getString("estado"));
                    e.setCidade(rs.getString("cidade"));
                    e.setBairro(rs.getString("bairro"));
                    e.setLogradouro(rs.getString("logradouro"));
                    e.setNumero(rs.getString("numero"));

                    //u.setEndereco(e);
                    System.out.println("ENDERECO - OK");
                }

                closeConnectionFactory(ps);
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }

            return u;

        } else {
            //JOptionPane.showMessageDialog(null, "Login ou Password incorreto(s).");
            System.out.print("Login ou Password Incorreto(s)");
            return null;
        }
    }

    public List<Produto> ReceberProdutos(List Produtos) {

        try {
            conn = ConnectionFactory.getConnection();
            String sql = ("SELECT * FROM Produto");
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            
            System.out.println("PRODUTOS - START");
            while (rs.next()) {
                Produtos.add(new Produto(rs.getInt("id"), rs.getString("nome"), rs.getInt("preco"), rs.getString("descricao"), rs.getString("imagem1"), rs.getString("imagem2")));                
            }
            closeConnectionFactory(ps);

        } catch (SQLException e) {
            System.out.print(e.getMessage());
            System.out.print(e.getCause());
        }

        return Produtos;
    }
    
    public void InserirProduto(String Nome, Integer Preco, String Descricao, String Imagem1, String Imagem2){
          try {
            conn = ConnectionFactory.getConnection();
            String sql = "INSERT INTO produto(preco, nome, descricao, imagem1, imagem 2) VALUES (?, ?, ?, ?, ?)";

            ps = conn.prepareStatement(sql);

            ps.setInt(1, Preco);
            ps.setString(2, Nome);
            ps.setString(3, Descricao);
            ps.setString(4, Imagem1);
            ps.setString(5, Imagem2);

            closeConnectionFactory(ps);
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.print(e.getMessage());
        }
    }

    @Override
    public List<?> Selecionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
