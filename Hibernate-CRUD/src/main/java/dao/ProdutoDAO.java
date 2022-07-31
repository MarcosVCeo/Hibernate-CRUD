package dao;

import model.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDAO {

    private EntityManager entityManager;

    public ProdutoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Produto produto) {
        entityManager.persist(produto);
    }

    public void atualizar(Produto produto) {
        entityManager.merge(produto);
    }

    public void remover(Produto produto) {
        entityManager.remove(produto);
    }

    public Produto buscar(Integer id) {
        return entityManager.find(Produto.class, id);
    }

    public List<Produto> buscarTodos(){
        var jpql =
                "SELECT p " +
                "FROM Produto AS p";

        return entityManager.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> buscarPorNome(String nome) {
        var jpql =
                "SELECT p " +
                "FROM Produto AS p " +
                "WHERE p.nome = :nome";

        return entityManager.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<Produto> buscarPorNomeCategoria(String nome) {
        var jpql =
                "SELECT p " +
                "FROM Produto AS p " +
                "WHERE p.categoria.nome = :nome";

        return entityManager.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }
}
