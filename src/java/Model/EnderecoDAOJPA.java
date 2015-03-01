package Model;

import POJO.Endereco;
import javax.persistence.EntityManager;

public class EnderecoDAOJPA extends DAOJPA<Endereco, Integer> implements EnderecoDAO{

    public EnderecoDAOJPA(EntityManager manager) {
        super(manager);
    }
    
}
