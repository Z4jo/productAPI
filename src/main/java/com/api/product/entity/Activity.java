package com.api.product.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "activity")
public class Activity  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "activity_id", nullable = false)
	private Integer id;

	@Column(name = "activity_type", nullable = false, length = 40)
	@NotBlank(message = "activity type need's to be filled")
	private String activityType;

	@Column(name = "time_in_minutes", nullable = false)
	@Min(value = 1, message = "time can't be under one minute")
	private Integer timeInMinutes;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "day_info_day_id")
	private DayInfo dayInfo;

	@Transient

	private Date date;

}