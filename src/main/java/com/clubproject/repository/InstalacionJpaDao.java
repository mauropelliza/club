package com.clubproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clubproject.model.Instalacion;
import org.springframework.stereotype.Repository;

@Repository
public interface InstalacionJpaDao extends JpaRepository<Instalacion, Integer>{

}