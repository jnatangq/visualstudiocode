package com.proyecto.cafe.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto.cafe.Entidad.producto;
import com.proyecto.cafe.Entidad.tipo_producto;
import com.proyecto.cafe.Repository.ITipoRepository;
import com.proyecto.cafe.servicio.ProductoServicio;



@Controller


public class controladorcafe {

    @Autowired
    private ProductoServicio productoservicio;
    @Autowired
    private ITipoRepository tipoRepository;

    private List<tipo_producto> tiposList = new ArrayList<>();

    public controladorcafe(ProductoServicio productoservicio, ITipoRepository tipoRepository) {
        this.productoservicio = productoservicio;
        this.tipoRepository = tipoRepository;

        this.tiposList = this.tipoRepository.findAllSortByName();
    }

    @GetMapping("/paginaproductos")
    public String home(Model model) {
        model.addAttribute("productos", productoservicio.getAllProductos());
        return "paginaproductos";
    }

    @GetMapping("/pagina1")
    public String listproductos(Model model) {
        model.addAttribute("productos", productoservicio.getAllProductos());
        return "paginaproductos";
    }

    @GetMapping("/paginaproductos/new")
    public String createProductosForm(Model model) {

        producto producto = new producto();

        model.addAttribute("productos", producto);
        model.addAttribute("tiposList", tiposList);

        return "paginaproductos";
    }

    @PostMapping("/paginaproductos")
    public String savenombre_producto(@ModelAttribute("productos") producto producto) {
        productoservicio.savenombre_producto( producto);
        return "redirect:/paginaproductos";
    }

    @GetMapping("/productos/edit/{id}")
    public String editProductoForm(@PathVariable Long id, Model model) {
        producto pt = productoservicio.getnombre_productoById(id);

        model.addAttribute("productos", pt);
        model.addAttribute("tiposList", tiposList);

        return "paginaproductos";
    }

    @PostMapping("/productos/{id}")
    public String updateStudent(@PathVariable Long id,
            @ModelAttribute("producto") producto producto,
            Model model) {
        // sacar el producto de la b.d. por el id
        producto existentProducto = productoservicio.getnombre_productoById(id);
        // cargarlo
        existentProducto.setId(id);
        existentProducto.setNombre_producto(producto.getNombre_producto());
        existentProducto.setPrecio_producto(producto.getPrecio_producto());
        existentProducto.setTipos(producto.getTipos());

        // guardar el estudiante actualizado
        productoservicio.updatenombre_producto(existentProducto);

        return "redirect:/paginaproductos";
    }
}
    

      
      