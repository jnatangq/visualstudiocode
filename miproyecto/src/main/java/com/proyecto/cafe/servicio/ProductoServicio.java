package com.proyecto.cafe.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.cafe.Entidad.producto;
import com.proyecto.cafe.Repository.IProductoRepository;

@Service

public class ProductoServicio implements IProductoServicio {

    private IProductoRepository productoRepository;

    public ProductoServicio(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    @Override
    public  List<producto> getAllProductos() {
        return productoRepository.findAll();
    }
    @Override
   
    public List<producto> getProductotBynombre_producto(String nombre_producto) {
        return productoRepository.findByNameContaining(nombre_producto);
    }


    @Override
    public producto savenombre_producto (producto nombre_producto ) {
        return productoRepository.save(nombre_producto);
    }

    @Override
    public producto getnombre_productoById(Long id) {
        return productoRepository.findById(id).get();
    }

    @Override
    public producto updatenombre_producto(producto nombre_producto) {
        return productoRepository.save(nombre_producto);
    }

    @Override
    public  void deletenombre_productotById(Long id)  {
        productoRepository.deleteById(id);
    }

   

}

      
      
