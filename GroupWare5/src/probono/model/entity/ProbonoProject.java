/*
CREATE TABLE probono_project (
	   probono_project_id     		NUMBER(5) PRIMARY KEY,
	   probono_project_name 		VARCHAR2(50) NOT NULL,
       probono_id           			VARCHAR2(50) NOT NULL,       
       activist_id          				VARCHAR2(20) NOT NULL,
       receive_id           				VARCHAR2(20) NOT NULL, 
       project_content      			VARCHAR2(100) NOT NULL
);   */

package probono.model.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

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

@NamedQuery(name = "ProbonoProject.allProbonoProject",
			query = "select p from ProbonoProject p")

@Entity
public class ProbonoProject {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private int probonoProjectId;
	   
	   @NonNull
	   @Column(length = 50, nullable = false)
	   private String probonoProjectName;

	   @NonNull
	   @Column(length = 50, nullable = false)
	   private String projectContent;
	   
	   
	   @ManyToOne
	   @NonNull
	   @JoinColumn(name="Probono_id")
	   private Probono probono;
	   
	   @ManyToOne
	   @NonNull
	   @JoinColumn(name="Activist_id")
	   private Activist activist;
   
   
   
}
