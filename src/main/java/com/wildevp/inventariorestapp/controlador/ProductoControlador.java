package com.wildevp.inventariorestapp.controlador;


//Declaramos la clase como un restController

import com.wildevp.inventariorestapp.modelo.Producto;
import com.wildevp.inventariorestapp.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductoControlador {
    @Autowired
    private ProductoServicio productoServicio;

    //Agregamos el controlador para exponer la ruta en la consumiremos nuestro servicio(Rest)
    @GetMapping("/productos")
    public List<Producto> productoList(){
        return productoServicio.productoList();
    }

}
