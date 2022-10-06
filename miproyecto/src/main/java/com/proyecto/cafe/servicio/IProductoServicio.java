package com.proyecto.cafe.servicio;



import java.util.List;

import com.proyecto.cafe.Entidad.producto;

public interface IProductoServicio {

    List<producto> getAllProductos();

    List<producto> getProductotBynombre_producto(String nombre_producto);

    producto savenombre_producto (producto nombre_producto );

    producto getnombre_productoById(Long id);

    producto updatenombre_producto(producto nombre_producto);

    void deletenombre_productotById(Long id);

}

