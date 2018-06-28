package com.example.repository;

import org.assertj.core.internal.Bytes;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Produto;

public interface ProdutoRespository extends JpaRepository<Produto, Long >{

}
