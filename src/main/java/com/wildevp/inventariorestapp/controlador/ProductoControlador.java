package com.wildevp.inventariorestapp.controlador;


//Declaramos la clase como un restController

import com.wildevp.inventariorestapp.modelo.Producto;
import com.wildevp.inventariorestapp.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoControlador {
    @Autowired
    private ProductoServicio productoServicio;

    //Agregamos el controlador para exponer la ruta en la consumiremos nuestro servicio(Rest)

    //Metodo para consultar todos los productos
    @GetMapping("/productos")
    public List<Producto> productoList() {
        return productoServicio.productoList();
    }

    //Metodo para filtrar por id
    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> productoById(@PathVariable Integer id) {
        try {
            Producto producto = productoServicio.obtenerProductoPorId(id);
            return new ResponseEntity<Producto>(producto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    //Metodo para guardar un nuevo producto
    @PostMapping("/productos")
    public void saveProducto(@RequestBody Producto producto) {
        productoServicio.guardarProducto(producto);
    }

    //Metodo actualizar producto
    @PutMapping("/productos/{id}")
    public ResponseEntity<?> updateProducto(@RequestBody Producto producto, @PathVariable Integer id) {
        try {
            Producto productoExiste = productoServicio.obtenerProductoPorId(id);
            productoExiste.setNombre(producto.getNombre());
            productoExiste.setPrecio(producto.getPrecio());
            productoServicio.guardarProducto(productoExiste);
            return new ResponseEntity<Producto>(producto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    //Metodo eliminar producto
    @DeleteMapping("/productos/{id}")
    public void deleteProducto(@PathVariable Integer id){
        productoServicio.eliminarProducto(id);
    }

}
