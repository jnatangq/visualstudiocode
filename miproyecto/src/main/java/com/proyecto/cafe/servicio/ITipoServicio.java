package com.proyecto.cafe.servicio;

import java.util.List;


import com.proyecto.cafe.Entidad.tipo_producto;


public interface ITipoServicio {
    
    List<tipo_producto> getAlltipos_producto();

    List<tipo_producto> gettipo_productoBytipo_producto(String tipo_producto);

    List<tipo_producto> gettipo_productoBycont_cafe(String cont_cafe );

    tipo_producto savetipo_producto(tipo_producto tipo_producto);

    tipo_producto gettipo_productoById(Long id);

    tipo_producto updatetipo_producto(tipo_producto tipo_producto);

    void deletetipo_productoById(Long id);

}