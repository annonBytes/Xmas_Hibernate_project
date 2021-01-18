package im430.xmasHibernate.business;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="addresses")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String text;
    
    @OneToMany(mappedBy="address", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<Child> children;
    
    public Address() {
    	this.id = -1;
    	this.text ="";
    }
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public Set<Child> getChildren() {
		if(this.children == null) {
			this.children = new HashSet<Child>();
		}
		return children;
	}


	public void setChildren(Set<Child> child) {
		this.children = child;
	}
	
	public void addChild(Child c) {
		c.setAddress(this);
		getChildren().add(c);
	}

	public void removeChild(Child c) {
		if (getChildren().contains(c)) {
			c.setAddress(null);
			getChildren().remove(c);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
    
    
}
