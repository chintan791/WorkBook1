package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the GRADEBOOK database table.
 * 
 */
@Entity
@NamedQuery(name="Gradebook.findAll", query="SELECT g FROM Gradebook g")
public class Gradebook implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long studentid;

	@Temporal(TemporalType.DATE)
	private Date assignmentdate;

	private String assignmentname;

	private String assignmenttype;

	private BigDecimal grade;

	public Gradebook() {
	}

	public long getStudentid() {
		return this.studentid;
	}

	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}

	public Date getAssignmentdate() {
		return this.assignmentdate;
	}

	public void setAssignmentdate(Date assignmentdate) {
		this.assignmentdate = assignmentdate;
	}

	public String getAssignmentname() {
		return this.assignmentname;
	}

	public void setAssignmentname(String assignmentname) {
		this.assignmentname = assignmentname;
	}

	public String getAssignmenttype() {
		return this.assignmenttype;
	}

	public void setAssignmenttype(String assignmenttype) {
		this.assignmenttype = assignmenttype;
	}

	public BigDecimal getGrade() {
		return this.grade;
	}

	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}

}