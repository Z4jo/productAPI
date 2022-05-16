package com.api.product.controller;


import com.api.product.entity.DayInfo;
import com.api.product.entity.FocusSession;
import com.api.product.entity.RestInfo;
import com.api.product.repositary.DayInfoRepository;
import com.api.product.service.DayInfoService;
import com.api.product.service.RestInfoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@AllArgsConstructor
@CrossOrigin
@RestController
public class RestInfoController {

	private DayInfoService dayInfoService;
	private RestInfoService riS;

	@PostMapping("/add/restInfo")
	public ResponseEntity<RestInfo> add(@Valid @RequestBody RestInfo ri){
		DayInfo di= dayInfoService.findDayInfoByDay(ri.getDate().toLocalDate());
		if (di==null){
			di=new DayInfo();
			di.setDate(ri.getDate().toLocalDate());
		}
		di.addRestInfoes(ri);
		dayInfoService.createDayInfo(di);
		return new ResponseEntity<>(ri,HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/restInfo/{id}")
	public ResponseEntity<RestInfo>delete(@PathVariable Integer id){
		return riS.deleteRestInfo(id);
	}

	@PutMapping("/put/restInfo/{id}")
	public ResponseEntity<RestInfo>put(@PathVariable Integer id, @Valid @RequestBody RestInfo ri){
		return riS.updateRestInfo(ri,id);
	}

}
