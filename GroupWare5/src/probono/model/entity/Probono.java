/*
CREATE TABLE probono (
       probono_id          	VARCHAR2(50) PRIMARY KEY,
       probono_name      VARCHAR2(50) NOT NULL,
       probono_purpose  	VARCHAR2(200) NOT NULL
);  */
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

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@NamedQuery(name = "Probono.allProbono",
			query = "select p from Probono p")

@Entity
public class Probono {
	@Id
	@NonNull
	@Column(length = 10)
	private String probonoId;
	
	@NonNull
	@Column(length = 50, nullable = false)
	private String probonoName;
	
	@NonNull
	@Column(length = 50, nullable = false)
	private String probonoPurpose;
	
	
	
	@OneToMany(mappedBy = "probono")
	 private List<ProbonoProject> probonoProject = new ArrayList<ProbonoProject>();
	
	
	//Probonoproject에 아이디 객체 생성하여 추가하기 위한 생성자
	public Probono(String probonoId) {
		this.probonoId = probonoId;
	}


//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("프로보노 정보 1. 프로보노 아이디 = ");
//		builder.append(probonoId);
//		builder.append("2. 프로보노 이름 : ");
//		builder.append(probonoName);
//		builder.append("3. 프로보노 목적 : ");
//		builder.append(probonoPurpose);
//		return builder.toString();
//	}
}
