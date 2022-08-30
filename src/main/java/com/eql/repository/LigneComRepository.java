package com.eql.repository;

import com.eql.model.LigneCom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneComRepository extends JpaRepository<LigneCom,Integer> {


}
