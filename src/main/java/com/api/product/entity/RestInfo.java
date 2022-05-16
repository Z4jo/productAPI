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
@Table(name = "rest_info")
public class RestInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rest_id", nullable = false)
	private Integer id;

	@Column(name = "rest_type", nullable = false, length = 20)
	@NotBlank(message = "rest type need's to be filled")
	private String restType;

	@Column(name = "time_in_minutes", nullable = false)
	@Min(value = 1,message = "time must be over 1 minute")
	private Integer timeInMinutes;

	@Column(name = "rating")
	private Integer rating;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "day_info_day_id")
	private DayInfo dayInfo;


	@Transient
	private Date date;

}