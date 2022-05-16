package com.api.product.service;

import com.api.product.entity.FoodInfo;
import com.api.product.repositary.FoodInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FoodInfoService {

	FoodInfoRepository fiR;

	public ResponseEntity<FoodInfo> deleteFoodInfo(Integer id){
		FoodInfo foodInfo=fiR.findById(id).orElse(null);
		fiR.delete(foodInfo);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	public ResponseEntity<FoodInfo> updateFoodInfo(FoodInfo foodInfoNew, Integer id){
		FoodInfo foodInfoOld = fiR.findById(id).orElse(null);
		foodInfoOld.setFood(foodInfoNew.getFood());
		foodInfoOld.setFoodType(foodInfoNew.getFoodType());
		FoodInfo updatedFoodInfo=fiR.save(foodInfoOld);
		return new ResponseEntity<>(updatedFoodInfo, HttpStatus.ACCEPTED);
	}
}
