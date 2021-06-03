package com.technolearns.repositories;

import org.springframework.data.repository.CrudRepository;

import com.technolearns.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
