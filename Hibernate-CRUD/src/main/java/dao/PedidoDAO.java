package dao;

import model.Pedido;
import vo.RelatorioDeVendasVO;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDAO {

    private EntityManager entityManager;

    public PedidoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Pedido pedido) {
        entityManager.persist(pedido);
    }

    public BigDecimal valorTotalVendido(){
        var jpql =
                "SELECT SUM(p.valorTotal) " +
                "FROM Pedido AS p ";

        return entityManager.createQuery(jpql, BigDecimal.class)
                .getSingleResult();
    }

    public Pedido buscar(Integer id){
        return entityManager.find(Pedido.class, id);
    }

    public List<RelatorioDeVendasVO> relatorioVendas(){
        var jpql =
                "SELECT new vo.RelatorioDeVendasVO(" +
                "    produto.nome," +
                "    SUM(item.quantidade), " +
                "    MAX(pedido.data)) " +
                "FROM Pedido AS pedido " +
                "JOIN pedido.itens item " +
                "JOIN item.produto AS produto " +
                "GROUP BY " +
                "    produto.nome, " +
                "    item.quantidade, " +
                "    pedido.data " +
                "ORDER BY item.quantidade DESC ";

        return entityManager.createQuery(jpql, RelatorioDeVendasVO.class)
                .getResultList();
    }
}
