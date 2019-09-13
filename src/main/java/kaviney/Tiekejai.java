package kaviney;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tiekejai {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String pav;

    private String adresas;	

    private String kontaktai;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPav() {
		return pav;
	}

	public void setPav(String pav) {
		this.pav = pav;
	}

	public String getAdresas() {
		return adresas;
	}

	public void setAdresas(String adresas) {
		this.adresas = adresas;
	}

	public String getKontaktai() {
		return kontaktai;
	}

	public void setKontaktai(String kontaktai) {
		this.kontaktai = kontaktai;
	}
	
	public String toString() {
		
		return this.id + " / " + this.pav + " / " + this.adresas + " / " + this.kontaktai;
	}	
}
