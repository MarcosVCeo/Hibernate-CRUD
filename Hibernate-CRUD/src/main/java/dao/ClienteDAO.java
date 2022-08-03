package dao;

import model.Cliente;

import javax.persistence.EntityManager;

public class ClienteDAO {

    private EntityManager entityManager;

    public ClienteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Cliente cliente) {
        entityManager.persist(cliente);
    }
}
