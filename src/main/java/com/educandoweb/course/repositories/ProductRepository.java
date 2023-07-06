package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Product;

//Não é necessário criar a implementação dessa interface pq o spring data jpa já tem uma implementação padrão
public interface ProductRepository extends JpaRepository<Product, Long>{

}
