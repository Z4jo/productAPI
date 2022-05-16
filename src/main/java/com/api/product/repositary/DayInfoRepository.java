package com.api.product.repositary;

import com.api.product.entity.DayInfo;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public interface DayInfoRepository extends CrudRepository<DayInfo, Integer> {
	DayInfo findDayInfoByDate(LocalDate date);

	ArrayList<DayInfo> findDayInfosByDateBetween(LocalDate dateStart, LocalDate dateEnd);
}