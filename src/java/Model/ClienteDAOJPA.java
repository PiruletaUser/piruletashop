package Model;

import POJO.Cliente;
import javax.persistence.EntityManager;

public class ClienteDAOJPA extends DAOJPA<Cliente, Integer> implements ClienteDAO{

    public ClienteDAOJPA(EntityManager manager) {
        super(manager);
    }
    
}
