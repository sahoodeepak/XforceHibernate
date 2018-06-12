package relation.one.to.many;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pencil {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int pencilId;
	
	@Column
	String name;

	public int getPencilId() {
		return pencilId;
	}

	public void setPencilId(int pencilId) {
		this.pencilId = pencilId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}