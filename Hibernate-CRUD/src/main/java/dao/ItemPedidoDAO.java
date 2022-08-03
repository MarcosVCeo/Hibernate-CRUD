package dao;

import model.ItemPedido;

import javax.persistence.EntityManager;

public class ItemPedidoDAO {

    private EntityManager entityManager;

    public ItemPedidoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(ItemPedido item) {
        entityManager.persist(item);
    }
}
