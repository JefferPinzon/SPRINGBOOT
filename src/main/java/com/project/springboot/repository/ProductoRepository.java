// repository/ProductoRepository.java
package com.project.springboot.repository;

import com.project.springboot.model.Producto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductoRepository extends ReactiveCrudRepository<Producto, String>
{
}