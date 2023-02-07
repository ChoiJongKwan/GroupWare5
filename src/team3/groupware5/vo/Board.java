package team3.groupware5.vo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	
	@NonNull
	@Column(length = 50, nullable = false)
	private String title;
	
	@NonNull
	@Column(length = 500, nullable = false)
	private String content;
	
	@NonNull
	@Column(length = 10, nullable = false)
	private String password;
	
	@NonNull
	@Column(nullable = false)
	private String writedate;
	
	@NonNull
	@Column(nullable = false)
	private int hit;
	
	@ManyToOne
	@NonNull
	@JoinColumn(name="employeeNo")
	private Employee employeeNo;
	
	@OneToMany(mappedBy = "boardNo")
	private List<Reply> reply = new ArrayList<Reply>();
	

	

}
