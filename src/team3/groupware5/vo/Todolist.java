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
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter


@Entity
public class Todolist {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int num;//pk주기위해서 
   
   @ManyToOne
   @NonNull
   @JoinColumn(name="employeeNo")
   private Employee employeeNo;
   @NonNull
   private String title;//제목
   @NonNull
   private String content;//내용
   
   private int importance;//중요도
   @NonNull
   private String checked;//체크여부
   @NonNull
   private String date;//날짜
   @NonNull
   private String time;//시간
@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Todolist [num=");
	builder.append(num);
	builder.append(", employeeNo=");
	builder.append(employeeNo.getEmployeeNo());
	builder.append(", title=");
	builder.append(title);
	builder.append(", content=");
	builder.append(content);
	builder.append(", importance=");
	builder.append(importance);
	builder.append(", checked=");
	builder.append(checked);
	builder.append(", date=");
	builder.append(date);
	builder.append(", time=");
	builder.append(time);
	builder.append("]");
	return builder.toString();
}

   
   

}