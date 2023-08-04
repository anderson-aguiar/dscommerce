package com.amtechnology.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amtechnology.dscommerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
