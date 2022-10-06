package com.proyecto.cafe.Entidad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Tipos_producto")
public class tipo_producto implements Serializable {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo_producto;

    private String cont_cafe;


    public tipo_producto() {

    }

    public tipo_producto(String tipo_producto,String cont_cafe ) {
        this.tipo_producto = tipo_producto;
        this.cont_cafe = cont_cafe;
        
    }
    @ManyToMany(mappedBy = "Productos", fetch = FetchType.LAZY)
    private Set<producto> productos = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public String getCont_cafe() {
        return cont_cafe;
    }

    public void setCont_cafe(String cont_cafe) {
        this.cont_cafe = cont_cafe;
    }

    public Set<producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<producto> productos) {
        this.productos = productos;
    }

    public String toString() {
        return "tipo_producto{" + "tipo_producto=" +tipo_producto + ", cont_cafe=" + cont_cafe + '}';
    }

    
}
