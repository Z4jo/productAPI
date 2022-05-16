package com.api.product.service;



import com.api.product.entity.RestInfo;
import com.api.product.repositary.RestInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RestInfoService {

	RestInfoRepository riR;
	public ResponseEntity<RestInfo> deleteRestInfo(Integer id){
		RestInfo ri=riR.findById(id).orElse(null);
		riR.delete(ri);
		return new ResponseEntity<>(ri, HttpStatus.OK);
	}

	public ResponseEntity<RestInfo> updateRestInfo(RestInfo riNew,Integer id){
		RestInfo riOld= riR.findById(id).orElseThrow();
		riOld.setRestType(riNew.getRestType());
		riOld.setRating(riNew.getRating());
		riOld.setTimeInMinutes(riNew.getTimeInMinutes());

		RestInfo updatedRestInfo=riR.save(riOld);
		return new ResponseEntity<>(updatedRestInfo,HttpStatus.ACCEPTED);

	}

}
