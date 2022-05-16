package com.api.product.repositary;

import com.api.product.entity.FoodInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FoodInfoRepository extends CrudRepository<FoodInfo, Integer> {



}