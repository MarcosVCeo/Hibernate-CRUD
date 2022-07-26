package model;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    public Categoria() {

    }

    public Integer getId() {
        return id;
    }

    public Categoria(String nome) {
        this.nome = nome;
    }
}
