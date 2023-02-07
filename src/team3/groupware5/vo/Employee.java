package team3.groupware5.vo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

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

@Entity
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeNo;
   
    @Column(length = 10, nullable = false)
    private String teamName;
   
    @NonNull
    @Column(length = 50, unique=true, nullable = false)
    private String email;
   
    @NonNull
    @Column(length = 50, nullable = false)
    private String password;
   
    @NonNull
    @Column(length = 50, nullable = false)
    private String employeeName;
   
    
    @Column(length = 10, nullable = false)
    private String role;
   
    @NonNull
    @Column(length = 50, nullable = false)
    private String positionName;
    
    @OneToMany(mappedBy = "employeeNo")
	private List<Notice> notice = new ArrayList<Notice>();
 
	@OneToMany(mappedBy = "employeeNo")
	private List<Board> board = new ArrayList<Board>();
	
	@OneToMany(mappedBy = "employeeNo")
	private List<Reply> reply = new ArrayList<Reply>();
	
	@OneToMany(mappedBy = "employeeNo")
	private List<Message> msg = new ArrayList<Message>();
	
    @OneToMany(mappedBy = "employeeNo")
    private List<Todolist> list = new ArrayList<Todolist>();

    @OneToMany(mappedBy = "employeeNo")
    private List<Approval> approval = new ArrayList<Approval>();
	
    @Override
    public String toString() {
       StringBuilder builder = new StringBuilder();
       builder.append("사원번호 : ");
       builder.append(employeeNo);
       builder.append(", 부서명 : ");
       builder.append(teamName);
       builder.append(", 사원명 : ");
       builder.append(employeeName);
       builder.append(", 비밀번호 : ");
       builder.append(password);
       builder.append(", 이메일 주소 : ");
       builder.append(email);
       builder.append(", 역할 : ");
       builder.append(role);
       builder.append(", 직급: ");
       builder.append(positionName);
       return builder.toString();
    }

}

