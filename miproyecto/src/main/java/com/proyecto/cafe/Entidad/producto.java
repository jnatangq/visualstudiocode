package com.proyecto.cafe.Entidad;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Productos")
public class producto {
   
 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_producto", nullable = false)
    private String nombre_producto;

    @Column(name = "precio_producto")
    private Long precio_producto;


    // relacion muchos a muchos con cursos
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "producto_precioytipo", joinColumns = {
            @JoinColumn(name = "id_producto", referencedColumnName = "id", nullable = false, updatable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "id_tipoproducto", referencedColumnName = "id", nullable = false, updatable = false)
    })

    private Set<tipo_producto> tipos = new HashSet<>();

    public producto() {
    }

    public producto(String nombre_producto,Long precio_producto) {
        this.nombre_producto = nombre_producto;
        this.precio_producto = precio_producto;
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public Long getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(Long precio_producto) {
        this.precio_producto = precio_producto;
    }

    public Set<tipo_producto> getTipos() {
        return tipos;
    }

    public void setTipos(Set<tipo_producto> tipos) {
        this.tipos = tipos;
    }

    
    public String toString() {
        return "producto{" + "nombre_producto=" + nombre_producto+ ", precio_producto=" + precio_producto + '}';
    }

}

         


