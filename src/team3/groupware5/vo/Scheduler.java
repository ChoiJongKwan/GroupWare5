package team3.groupware5.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity

public class Scheduler {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int schNo;

	@ManyToOne
	@NonNull
	@JoinColumn(name = "employeeNo")
	private Employee employeeNo;


	@NonNull
	private String schName;

	@NonNull
	private String schstartDate;

	@NonNull
	private String schstartTime;

	@NonNull
	private String schendDate;

	@NonNull
	private String schendTime;

	@NonNull
	private String schContent;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Scheduler [schNo=");
		builder.append(schNo);
		builder.append(", employeeNo=");
		builder.append(employeeNo.getEmployeeNo());
		builder.append(", schName=");
		builder.append(schName);
		builder.append(", schstartDate=");
		builder.append(schstartDate);
		builder.append(", schstartTime=");
		builder.append(schstartTime);
		builder.append(", schendDate=");
		builder.append(schendDate);
		builder.append(", sch_end_Time=");
		builder.append(schendTime);
		builder.append(", sch_Contenet=");
		builder.append(schContent);
		builder.append("]");
		return builder.toString();
	}

}
