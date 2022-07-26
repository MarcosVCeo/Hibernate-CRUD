package dao;

import model.Produto;

import javax.persistence.EntityManager;

public class ProdutoDAO {

    private EntityManager entityManager;

    public ProdutoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Produto produto) {
        entityManager.persist(produto);
    }
}
