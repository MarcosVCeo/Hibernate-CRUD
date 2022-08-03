package dao;

import model.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Date;
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

    public List<Produto> buscarTodos() {
        var jpql =
                "SELECT p " +
                "FROM Produto AS p";

        return entityManager.createQuery(jpql, Produto.class).getResultList();
    }

    public Produto buscarPorNome(String nome) {
        var jpql =
                "SELECT p " +
                "FROM Produto AS p " +
                "WHERE p.nome = :nome";

        return entityManager.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }

    public List<Produto> buscarPorNomeCategoria(String nome) {
        return entityManager.createNamedQuery("Produto.produtosPorCategoria", Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<Produto> queryDinamica(String nome, BigDecimal preco, Date dataCadastro) {
        var builder = entityManager.getCriteriaBuilder();
        var query = builder.createQuery(Produto.class);
        var from = query.from(Produto.class);
        var filtros = builder.and();

        if (nome != null && !nome.trim().isEmpty()) {
            filtros = builder.and(filtros, builder.equal(from.get("nome"), nome));
        }
        if (preco != null) {
            filtros = builder.and(filtros, builder.equal(from.get("preco"), preco));
        }
        if (dataCadastro != null) {
            filtros = builder.and(filtros, builder.equal(from.get("dataCadastro"), dataCadastro));
        }

        query.where(filtros);

        return entityManager.createQuery(query).getResultList();
    }
}
