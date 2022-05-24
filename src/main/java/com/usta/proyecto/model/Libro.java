package com.usta.proyecto.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "libro")
public class Libro {
    private static final long serialVesionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Long idLibro;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "fecha_publicacion")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;

    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "isbn")
    private String isbn;

    @JoinColumn(name = "id_editorial", referencedColumnName = "id_editorial")
    @ManyToOne(fetch = FetchType.EAGER)
    private Editorial fkEditorial;

    public Libro() {
    }

    public Libro(Long idLibro, String titulo, Date fechaPublicacion, Integer codigo, String isbn, Editorial fkEditorial) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.codigo = codigo;
        this.isbn = isbn;
        this.fkEditorial = fkEditorial;
    }

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Editorial getFkEditorial() {
        return fkEditorial;
    }

    public void setFkEditorial(Editorial fkEditorial) {
        this.fkEditorial = fkEditorial;
    }
}
