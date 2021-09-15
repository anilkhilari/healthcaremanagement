package in.nit.hcma.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="specialization")
public class Specialization implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5050248613556459886L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String code;
	private String name;
	private String note;
	
	public Specialization() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Specialization(Integer id, String code, String name, String note) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.note = note;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Specialization [id=" + id + ", code=" + code + ", name=" + name + ", note=" + note + "]";
	}
	
	
	
	

}
