package com.api.product.controller;
import com.api.product.entity.DayInfo;
import com.api.product.entity.FocusSession;
import com.api.product.repositary.DayInfoRepository;
import com.api.product.service.DayInfoService;
import com.api.product.service.FocusSessionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@AllArgsConstructor
@CrossOrigin
@RestController
public class FocusSessionController {
	private DayInfoService dayInfoService;
	private FocusSessionService fsS;

	@PostMapping("/add/focusSession")
	public ResponseEntity<FocusSession> add(@Valid @RequestBody FocusSession fs){

		LocalDate ld;
		if(fs.getDate()==null){
			ld= LocalDate.now();
		}else{
			ld=fs.getDate().toLocalDate();
		}
		DayInfo di= dayInfoService.findDayInfoByDay(ld);
		if (di==null){
			di=new DayInfo();
			di.setDate(ld);
		}
		di.addFocusSession(fs);
		dayInfoService.createDayInfo(di);
		return  new ResponseEntity<>(fs,HttpStatus.CREATED);
	}

	@PutMapping("/put/focusSession/{id}")
	public ResponseEntity<FocusSession> put(@PathVariable Integer id,@Valid @RequestBody FocusSession fsNew){
		return fsS.updateFocusSession(fsNew,id);
	}

	@DeleteMapping("/delete/focusSession/{id}")
	public ResponseEntity<FocusSession> delete(@PathVariable Integer id){
		return fsS.deleteFocusSession(id);
	}

}
