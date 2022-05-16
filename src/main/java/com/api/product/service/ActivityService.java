package com.api.product.service;

import com.api.product.entity.Activity;
import com.api.product.repositary.ActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActivityService {

	ActivityRepository aI;
	public ResponseEntity<Activity> deleteActivity(Integer id){
		Activity activity=aI.findById(id).orElse(null);
		aI.delete(activity);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	public ResponseEntity<Activity> updateActivity(Activity activityNew,Integer id){
		Activity activityOld=aI.findById(id).orElse(null);
		activityOld.setActivityType(activityNew.getActivityType());
		activityOld.setTimeInMinutes(activityNew.getTimeInMinutes());
		Activity updatedActivity=aI.save(activityOld);
		return new ResponseEntity<>(updatedActivity, HttpStatus.ACCEPTED);
	}
}
