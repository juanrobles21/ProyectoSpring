package com.usta.proyecto.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "detalle_prestamos")
public class DetallePrestamos {
    private static final long serialVesionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalleprestamo")
    private Long idDetallePrestamo;

    @JoinColumn(name = "id_prestamo", referencedColumnName = "id_prestamo")
    @ManyToOne(fetch = FetchType.EAGER)
    private Prestamos fkPrestamos;

    @JoinColumn(name = "id_libro", referencedColumnName = "id_libro")
    @ManyToOne(fetch = FetchType.EAGER)
    private Libro fkLibro;

    @Column(name = "fecha_devolucion")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;

    @Column(name = "dias_mora")
    private Integer diasMora;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_entrega")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;

    public DetallePrestamos() {
    }

    public DetallePrestamos(Long idDetallePrestamo, Prestamos fkPrestamos, Libro fkLibro, Date fechaDevolucion, Integer diasMora, String descripcion, Date fechaEntrega) {
        this.idDetallePrestamo = idDetallePrestamo;
        this.fkPrestamos = fkPrestamos;
        this.fkLibro = fkLibro;
        this.fechaDevolucion = fechaDevolucion;
        this.diasMora = diasMora;
        this.descripcion = descripcion;
        this.fechaEntrega = fechaEntrega;
    }

    public Long getIdDetallePrestamo() {
        return idDetallePrestamo;
    }

    public void setIdDetallePrestamo(Long idDetallePrestamo) {
        this.idDetallePrestamo = idDetallePrestamo;
    }

    public Prestamos getFkPrestamos() {
        return fkPrestamos;
    }

    public void setFkPrestamos(Prestamos fkPrestamos) {
        this.fkPrestamos = fkPrestamos;
    }

    public Libro getFkLibro() {
        return fkLibro;
    }

    public void setFkLibro(Libro fkLibro) {
        this.fkLibro = fkLibro;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Integer getDiasMora() {
        return diasMora;
    }

    public void setDiasMora(Integer diasMora) {
        this.diasMora = diasMora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
}

