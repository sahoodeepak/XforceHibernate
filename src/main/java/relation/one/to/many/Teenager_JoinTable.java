package relation.one.to.many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Teenager_JoinTable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="teen_id")
	private int id;
	
	@Column
	private String name;
	
	@Column
	private int age;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="teen_phones", joinColumns=@JoinColumn(name="teen_id"),
					inverseJoinColumns=@JoinColumn(name="phone_id")) 
	private List<Smartphone> phones = new ArrayList<Smartphone>();
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Smartphone> getPhones() {
		return phones;
	}

	public void setPhones(List<Smartphone> phones) {
		this.phones = phones;
	}
}