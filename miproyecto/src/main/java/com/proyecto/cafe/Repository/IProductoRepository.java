package com.proyecto.cafe.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.cafe.Entidad.producto;

public interface IProductoRepository extends JpaRepository<producto, Long> {

@Query("FROM Productos  WHERE nombre_producto LIKE :nombre_producto")
List<producto> findByNameContaining(@Param("nombre_producto") String nombre_producto);

@Query("FROM Productos  WHERE precio_producto <= precio_producto  ")
List<producto> findByFellLessThan(@Param("precio_producto") double precio_producto);

@Query("FROM Productos  WHERE nombre_producto ORDER BY producto ASC")
public List<producto> findAllsortByName();

}

