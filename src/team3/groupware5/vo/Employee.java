package team3.groupware5.vo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

//@NamedQuery(name = "Employee.FindEmailByEmp",query = "select e.email from Employee e where e.employeeNo=:employeeNo and e.password=:password")
//@NamedQuery(name = "Employee.FindPwByEmp",query = "select e.password from Employee e where e.email=:email and e.employee=:employee")
//@NamedQuery(name="Employee.findLoginByEmp",query="select e from Employee e where e.email=:email and e.password=:password")
@NamedQuery(name = "Employee.FindEmailByEmp",query = "select e from Employee e where e.email=:email")
@Entity
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeNo;
   
    @Column(length = 10, nullable = false)
    private String teamName;
   
    
    @NonNull
    @Column(length = 50, nullable = false)
    private String employeeName;
    
    @NonNull
    @Column(length = 50, unique=true, nullable = false)
    private String email;
   
    @NonNull
    @Column(length = 50, nullable = false)
    private String password;
   
    
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
    
    @OneToMany(mappedBy = "employeeNo")
	private List<Scheduler> scheduler = new ArrayList<Scheduler>();
    
    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("사원번호 : ");
		builder.append(employeeNo);
		builder.append(", 부서명 : ");
		builder.append(teamName);
		builder.append(", 사원명 : ");
		builder.append(password);
		builder.append(", 이메일 주소 : ");
		builder.append(employeeName);
		builder.append(", 비밀번호 : ");
		builder.append(email);
		builder.append(", 역할 : ");
		builder.append(role);
		builder.append(", 직급: ");
		builder.append(positionName);
		return builder.toString();
	}
	

}


    @OneToMany(mappedBy = "employeeNo")
    private List<Approval> approval = new ArrayList<Approval>();

    @OneToMany(mappedBy = "employeeNo")
	private List<Scheduler> scheduler = new ArrayList<Scheduler>();
	
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

