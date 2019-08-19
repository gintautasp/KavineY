package kaviney;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Produktai {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String pav;
    
    // mat_vnt	mato_kiekis	kaina	kiekis_sand

    private String mat_vnt;
    
    private Double mato_kiekis;    
    
    private Double kaina;
    
    private Double kiekis_sand;

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
	
	public String getMat_vnt() {
		
		return mat_vnt;
	}

	public void setMat_vnt(String mat_vnt) {
		
		this.mat_vnt = mat_vnt;
	}
	
	public Double getMato_kiekis() {
		
		return mato_kiekis;
	}

	public void setMato_kiekis(Double mato_kiekis) {
		
		this.mato_kiekis = mato_kiekis;
	}	
	
	public Double getKiekis_sand() {
		
		return kiekis_sand;
	}

	public void setKiekis_sand(Double kiekis_sand) {
		
		this.kiekis_sand = kiekis_sand;
	}
	
	public Double getKaina() {
		return kaina;
	}

	public void setKaina(Double kaina) {
		this.kaina = kaina;
	}
	
	public String toString() {
		
		return this.id + " / " + this.pav + " / " + this.mat_vnt + " / " + this.mato_kiekis + " / " + this.kaina + " / " + this.kiekis_sand;
	}
}
