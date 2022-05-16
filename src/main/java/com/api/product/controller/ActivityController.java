package com.api.product.controller;
import com.api.product.entity.Activity;
import com.api.product.entity.DayInfo;
import com.api.product.entity.FoodInfo;
import com.api.product.entity.RestInfo;
import com.api.product.repositary.ActivityRepository;
import com.api.product.repositary.DayInfoRepository;
import com.api.product.service.ActivityService;
import com.api.product.service.DayInfoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@CrossOrigin
@AllArgsConstructor
public class ActivityController {
	private DayInfoService dayInfoService;
	private ActivityService activityService;

	@PostMapping("/add/activity")
	public ResponseEntity<Activity> add(@Valid @RequestBody Activity activity){
		DayInfo di= dayInfoService.findDayInfoByDay(activity.getDate().toLocalDate());
		if (di==null){
			di=new DayInfo();
			di.setDate(activity.getDate().toLocalDate());
		}
		di.addActivity(activity);
		dayInfoService.createDayInfo(di);
		return  new ResponseEntity<>(activity,HttpStatus.CREATED);
	}

	@PutMapping("/put/activity/{id}")
	public ResponseEntity<Activity>update(@Valid @RequestBody Activity activity,@PathVariable Integer id){
		return activityService.updateActivity(activity,id);
	}

	@DeleteMapping("/delete/activity/{id}")
	public ResponseEntity<Activity> delete(@PathVariable Integer id){
		return activityService.deleteActivity(id);

	}



}
