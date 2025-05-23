package br.com.villaca.ProjetoTurma2.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "noticia")
@Data
@NoArgsConstructor
public class Noticia {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "corpo")
    @Lob
    private String corpo;

    @Column(name = "data_publicacao")
    private LocalDate dataPublicacao;

    @Column(name = "imagem_url")
    private String imagem_url;

    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    @ManyToOne
    private Categoria categoria;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuario;  

    @JoinColumn(name = "id_autor", referencedColumnName = "id")
    @ManyToOne
    private Autor autor; 

}
