package vo;

import java.util.Date;

public class RelatorioDeVendasVO {

    private String nome;
    private Long quantidade;
    private Date data;

    public RelatorioDeVendasVO(String nome, Long quantidade, Date data) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public Date getData() {
        return data;
    }

    @Override
    public String toString() {
        return "RelatorioDeVendasVO{" +
                "nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", data=" + data +
                '}';
    }
}
