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
public class Approval {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int apno; // 게시글 번호
	
	@NonNull
	@Column(length = 50, nullable = false)
	private String title; // 게시글 제목
	
	@ManyToOne
	@NonNull
	@JoinColumn(name = "employeeNo")
	private Employee employeeNo; // 사번(작성자)
	
	@NonNull
	@Column(length = 50, nullable = false)
	private String contents; // 게시글 내용 

	@NonNull
	@Column(length = 50, nullable = false)
	private String admincheck; // 관리자 확인
	
}