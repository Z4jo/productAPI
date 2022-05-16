package com.api.product.service;

import com.api.product.entity.DayInfo;
import com.api.product.repositary.DayInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;


@Service
@AllArgsConstructor
public class DayInfoService {

	private DayInfoRepository dayInfoRepository;



	public DayInfo createDayInfo(DayInfo dayInfo){
		return dayInfoRepository.save(dayInfo);
	}

	public DayInfo findDayInfoByDay(LocalDate ld){
		return dayInfoRepository.findDayInfoByDate(ld);
	}


	public ArrayList<DayInfo> getDaysByMonth(LocalDate dateStart, LocalDate dateEnd){
		return dayInfoRepository.findDayInfosByDateBetween(dateStart,dateEnd);
	}
}
