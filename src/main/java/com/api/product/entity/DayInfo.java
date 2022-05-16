package com.api.product.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "day_info")
public class DayInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "day_id", nullable = false)
	private Integer id;

	@JsonManagedReference
	@OneToMany(mappedBy = "dayInfo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Activity> activities = new java.util.ArrayList<>();

	@JsonManagedReference
	@OneToMany(mappedBy = "dayInfo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FocusSession> focusSessions = new java.util.ArrayList<>();

	@JsonManagedReference
	@OneToMany(mappedBy = "dayInfo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FoodInfo> foodInfoes = new java.util.ArrayList<>();

	@JsonManagedReference
	@OneToMany(mappedBy = "dayInfo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RestInfo> restInfoes = new java.util.ArrayList<>();

	@Column(name = "date", nullable = false)
	private LocalDate date;

	public void addActivity(Activity activity){
		activities.add(activity);
		activity.setDayInfo(this);
	}
	public void addRestInfoes(RestInfo restInfo){
		restInfoes.add(restInfo);
		restInfo.setDayInfo(this);
	}
	public void addFoodInfoes(FoodInfo foodInfo){
		foodInfoes.add(foodInfo);
		foodInfo.setDayInfo(this);
	}
	public void addFocusSession(FocusSession focusSession){
		focusSessions.add(focusSession);
		focusSession.setDayInfo(this);
	}

}