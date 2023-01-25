package com.project.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AngularRepository extends JpaRepository<Project,Integer> {
	@Query(value = "select * from product_object.project where product_object.project.number=?;", nativeQuery = true)
	List<Project> queryByNumber(String number);
	
	@Query(value = "select * from product_object.project where product_object.project.number=? and product_object.project.name=?;", nativeQuery = true)
	List<Project> queryByNumberAndName(String number,String name);
	
}

