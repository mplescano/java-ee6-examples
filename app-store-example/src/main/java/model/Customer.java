package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	@Column(name = "COUNTRY")
	private String country;
	@Column(name = "NAME")
	private String name;

	@OneToMany(mappedBy = "customerFK", fetch = EAGER)
	private List<Item> items;

	public Customer() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
