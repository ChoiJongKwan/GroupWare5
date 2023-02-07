/**
CREATE TABLE activist (
       activist_id          	VARCHAR2(20)  PRIMARY KEY,
       name               	VARCHAR2(20) NOT NULL,
       password         	VARCHAR2(20) NOT NULL,
       major                	VARCHAR2(50) NOT NULL
); */
package probono.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
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

@NamedQuery(name = "Activist.allActivist",
			query = "select a from Activist a")

@Entity
public class Activist {
	
	
	
	@Id
	@NonNull
	@Column(length = 20)
	private String id;
	
	@NonNull
	@Column(length = 10, nullable = false)
	private String name;
	
	@NonNull
	@Column(length = 10, nullable = false)
	private String password;
	
	@NonNull
	@Column(length = 15, nullable = false)
	private String major;
	
	@OneToMany(mappedBy = "probono")
	 private List<ProbonoProject> probonoProject = new ArrayList<ProbonoProject>();
	
	//Probonoproject에 아이디 객체 생성하여 추가하기 위한 생성자
	public Activist(String id){
		this.id =id;
	}
	

	
}
