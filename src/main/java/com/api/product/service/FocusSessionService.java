package com.api.product.service;
import com.api.product.entity.FocusSession;
import com.api.product.repositary.FocusSessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class FocusSessionService {

	FocusSessionRepository fsR;

	public ResponseEntity<FocusSession> deleteFocusSession(Integer id){
		FocusSession focusSession= fsR.findById(id).orElse(null);
		fsR.delete(focusSession);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	public ResponseEntity<FocusSession> updateFocusSession(FocusSession fsNew,Integer id){
		FocusSession fsOld= fsR.findById(id).orElse(null);
		fsOld.setSessionType(fsNew.getSessionType());
		fsOld.setNote(fsNew.getNote());
		fsOld.setRating(fsNew.getRating());
		fsOld.setTimeInMinutes(fsNew.getTimeInMinutes());

		FocusSession updatedFocusSession=fsR.save(fsOld);
		return new ResponseEntity<>(updatedFocusSession, HttpStatus.ACCEPTED);
	}

}
