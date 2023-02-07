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
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

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
}
