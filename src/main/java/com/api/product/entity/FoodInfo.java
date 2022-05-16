package com.api.product.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "food_info")
public class FoodInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_id", nullable = false)
	private Integer id;

	@Column(name = "food_type", nullable = false, length = 20)
	@NotBlank(message = "food type need's to be filled")
	private String foodType;

	@Column(name = "food", nullable = false, length = 40)
	@NotBlank(message = "meal need's to be filled")
	private String food;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "day_info_day_id")
	private DayInfo dayInfo;

	@Transient

	private Date date;
}