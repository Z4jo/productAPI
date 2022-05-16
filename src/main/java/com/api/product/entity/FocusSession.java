package com.api.product.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;

import javax.validation.constraints.NotBlank;
import java.sql.Date;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "focus_session")
public class FocusSession  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "session_id", nullable = false)
	private Integer id;

	@Column(name = "session_type", nullable = false, length = 40)
	@NotBlank(message = "session type need's to be filled")
	private String sessionType;

	@Column(name = "time_in_minutes", nullable = false)
	@Min(value = 1, message = "time can't be under one minute")
	private Integer timeInMinutes;

	@Column(name = "note")
	private String note;

	@Column(name = "rating", nullable = false)
	private Integer rating;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "day_info_day_id")
	private DayInfo dayInfo;

	@Transient
	private Date date;
}