package dao;

import model.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDAO {

    private EntityManager entityManager;

    public CategoriaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Categoria categoria) {
        entityManager.persist(categoria);
    }

    public Categoria buscar(Integer id) {
        return entityManager.find(Categoria.class, id);
    }
}
