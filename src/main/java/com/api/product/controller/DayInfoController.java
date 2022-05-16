package com.api.product.controller;
import com.api.product.entity.DayInfo;
import com.api.product.repositary.DayInfoRepository;
import com.api.product.service.DayInfoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

@CrossOrigin
@AllArgsConstructor
@RestController
public class DayInfoController {
	private final DayInfoRepository dIr;
	private DayInfoService dayInfoService;

	@GetMapping("/getDay/{date}")
	public DayInfo getDayInfoByDate(@PathVariable Date date){
		return dayInfoService.findDayInfoByDay(date.toLocalDate());
	}

	@GetMapping("/getDays")
	public ArrayList<DayInfo> getDays(){
		return (ArrayList<DayInfo>) dIr.findAll();
	}

	@GetMapping("/get/daysByMonth/{month}")
	public ArrayList<DayInfo> getDaysByMonth(@PathVariable String month){
		//2022,01
		//TODO UDĚLAT METODU
		//TODO UDĚLAT EXCEPTION, KDYŽ PŘÍJDE PRÁZDNÝ MĚSÍC
		String[]date=month.split(",");

		LocalDate dateStart=LocalDate.of
				(Integer.parseInt(date[0]),Integer.parseInt(date[1]),1);
		LocalDate dateEnd=LocalDate.of
				(Integer.parseInt(date[0]),Integer.parseInt(date[1]),dateStart.lengthOfMonth());

		System.out.println(dateEnd.getDayOfMonth());

		return dayInfoService.getDaysByMonth(dateStart,dateEnd);

	}




}
