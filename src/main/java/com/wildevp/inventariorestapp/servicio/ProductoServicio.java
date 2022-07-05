package com.wildevp.inventariorestapp.servicio;

import com.wildevp.inventariorestapp.modelo.Producto;
import com.wildevp.inventariorestapp.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Declaramos la clase como un servicio
@Service
public class ProductoServicio {

    //Hacemos el llamado a nuestro repositorio
    @Autowired
    private ProductoRepositorio productoRepositorio;


    //Metodo para listar
    public List<Producto> productoList(){
        return productoRepositorio.findAll();
    }

    //Metodo para obtener producto por Id
    public Producto obtenerProductoPorId(Integer id){
        return productoRepositorio.findById(id).get();
    }

    //Metodo para guardar
    public void guardarProducto(Producto producto){
        productoRepositorio.save(producto);
    }

    //Metodo para eliminar
    public void eliminarProducto(Integer id){
        productoRepositorio.deleteById(id);
    }
}
