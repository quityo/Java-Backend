package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class JobAdvertDto {
		private int jobPositionId;
		private int cityId;
		private int openPositionCount;
		private int salaryMin;
		private int salaryMax;
		private int workTypeId;
		private int workTimeId;
		private LocalDate deadline;	
		private String description;
		private int employerId;
		@JsonIgnore
		private boolean isActive=true;
		
		@JsonIgnore
		private boolean isConfirm=false;
	}