package com.proyecto.cafe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.cafe.Entidad.tipo_producto;

public interface ITipoRepository extends JpaRepository<tipo_producto, Long> {

@Query("FROM Tipos_producto  WHERE tipo_producto LIKE :tipo_producto")
List<tipo_producto> findByNameContaining(@Param("tipo_producto") String tipo_producto);

@Query("FROM Tipos_producto  WHERE tipo_producto ORDER BY producto ASC")
public List<tipo_producto> findAllsortByName();

List<tipo_producto> findAllSortByName();
}