package com.spring.esameJava.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.esameJava.entity.venditore;


public interface DaoVenditori extends JpaRepository<venditore, Integer> {

}
