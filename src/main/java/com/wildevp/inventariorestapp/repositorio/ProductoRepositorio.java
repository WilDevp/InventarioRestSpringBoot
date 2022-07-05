package com.wildevp.inventariorestapp.repositorio;

import com.wildevp.inventariorestapp.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {

}
