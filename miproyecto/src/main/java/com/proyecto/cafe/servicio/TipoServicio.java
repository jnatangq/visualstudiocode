package com.proyecto.cafe.servicio;



import java.util.List;

import com.proyecto.cafe.Entidad.tipo_producto;
import com.proyecto.cafe.Repository.ITipoRepository;

public class TipoServicio implements ITipoServicio {
    private ITipoRepository tipoRepository;

    

    public TipoServicio(ITipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    
    public List<tipo_producto> getAlltipos_producto() {
        return tipoRepository.findAllsortByName();
    }

    @Override
    public List<tipo_producto> gettipo_productoBytipo_producto(String tipo_producto) {
        return tipoRepository.findByNameContaining(tipo_producto);
    }

    @Override
    public List<tipo_producto> gettipo_productoBycont_cafe (String cont_cafe ){
        return tipoRepository. findByNameContaining(cont_cafe);
    }

    @Override
    public tipo_producto savetipo_producto(tipo_producto tipo_producto) {
        return tipoRepository.save(tipo_producto);
    }

    @Override
    public tipo_producto gettipo_productoById(Long id) {
        return tipoRepository.getReferenceById(id);

    }

    @Override
    public  void deletetipo_productoById(Long id){
        tipoRepository.deleteById(id);
    }

    @Override
    public tipo_producto updatetipo_producto(tipo_producto tipo_producto) {
        return tipoRepository.save(tipo_producto);
    }
}


