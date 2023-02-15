package team3.groupware5.vo;

import javax.persistence.Column;
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
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;

	@ManyToOne
	@NonNull
	@JoinColumn(name = "employeeNo")
	private Employee employeeNo;

	@NonNull
	@Column(length = 200, nullable = false)
	private String content;

	@NonNull
	@Column(nullable = false)
	private String writeDate;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Massage [no=");
		builder.append(no);
		builder.append(", employeeNo=");
		builder.append(employeeNo.getEmployeeNo());
		builder.append(", content=");
		builder.append(content);
		builder.append(", writeDate=");
		builder.append(writeDate);
	   	builder.append("]");
		return builder.toString();
   }
}
