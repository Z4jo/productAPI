package com.api.product.repositary;

import com.api.product.entity.Activity;
import org.springframework.data.repository.CrudRepository;

public interface ActivityRepository extends CrudRepository<Activity, Integer> {
}