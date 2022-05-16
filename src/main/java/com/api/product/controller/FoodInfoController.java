package com.api.product.controller;


import com.api.product.entity.DayInfo;
import com.api.product.entity.FoodInfo;
import com.api.product.service.DayInfoService;
import com.api.product.service.FoodInfoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@AllArgsConstructor
@CrossOrigin
@RestController
public class FoodInfoController {
	private DayInfoService dayInfoService;
	private FoodInfoService foodInfoService;

	@PostMapping("/add/foodInfo")
	public ResponseEntity<FoodInfo> add(@Valid @RequestBody FoodInfo fi){

		DayInfo di=dayInfoService.findDayInfoByDay(fi.getDate().toLocalDate());
		if (di==null){
			di=new DayInfo();
			di.setDate(fi.getDate().toLocalDate());
		}
		di.addFoodInfoes(fi);
		dayInfoService.createDayInfo(di);
		return   new ResponseEntity<>(fi,HttpStatus.CREATED);
	}

	@PutMapping("/put/foodInfo/{id}")
	public ResponseEntity<FoodInfo>update(@Valid @RequestBody FoodInfo foodInfo,@PathVariable Integer id){
		return foodInfoService.updateFoodInfo(foodInfo,id);
	}

	@DeleteMapping("/delete/foodInfo/{id}")
	public ResponseEntity<FoodInfo>delete(@PathVariable Integer id){
		return foodInfoService.deleteFoodInfo(id);
	}

}
