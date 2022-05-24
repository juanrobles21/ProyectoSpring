package com.usta.proyecto.model;

import javax.persistence.*;

@Entity
@Table(name = "autores_libro")
public class AutoresLibro {
    private static final long serialVesionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autorlibro")
    private Long idAutorLibro;

    @JoinColumn(name = "id_autor", referencedColumnName = "id_autor")
    @ManyToOne(fetch = FetchType.EAGER)
    private Autor fkAutor;

    @JoinColumn(name = "id_libro", referencedColumnName = "id_libro")
    @ManyToOne(fetch = FetchType.EAGER)
    private Libro fkLibro;

    public AutoresLibro() {
    }

    public AutoresLibro(Long idAutorLibro, Autor fkAutor, Libro fkLibro) {
        this.idAutorLibro = idAutorLibro;
        this.fkAutor = fkAutor;
        this.fkLibro = fkLibro;
    }

    public Long getIdAutorLibro() {
        return idAutorLibro;
    }

    public void setIdAutorLibro(Long idAutorLibro) {
        this.idAutorLibro = idAutorLibro;
    }

    public Autor getFkAutor() {
        return fkAutor;
    }

    public void setFkAutor(Autor fkAutor) {
        this.fkAutor = fkAutor;
    }

    public Libro getFkLibro() {
        return fkLibro;
    }

    public void setFkLibro(Libro fkLibro) {
        this.fkLibro = fkLibro;
    }
}
