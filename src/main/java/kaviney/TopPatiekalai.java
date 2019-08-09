package kaviney;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class TopPatiekalai implements Serializable  {
	@Id
	private int pat_id;
	private String patiekalas;
	private int ruosti;
	private int kaitinti;
	private double kaina_patiek;
	private int uzsakymu;
	private double uz_suma;
	private String fld_delim = " ";

	
	public TopPatiekalai() {
	}
	
	public void setPat_id ( int pat_id ) {
		
		this.pat_id = pat_id;
	}
	
	public int getPat_id ( ) {
		
		return this.pat_id; 
	}
	
	public void setPatiekalas ( String patiekalas ) {
		
		this.patiekalas = patiekalas;
	}
	
	public String getPatiekalas ( ) {
		
		return this.patiekalas; 
	}	
	
	public void setRuosti ( int ruosti ) {
		
		this.ruosti = ruosti;
	}
	
	public int getRuosti ( ) {
		
		return this.ruosti; 
	}
	
	public void setKaitinti ( int kaitinti ) {
		
		this.kaitinti = kaitinti;
	}
	
	public int getKaitinti ( ) {
		
		return this.kaitinti; 
	}
	
	public void setKainaPatiek ( double kaina_patiek ) {
		
		this.kaina_patiek = kaina_patiek;
	}
	
	public double getKaina_patiek ( ) {
		
		return this.kaina_patiek; 
	}	
	
	public void setUzsakymu ( int uzsakymu ) {
		
		this.uzsakymu = uzsakymu;
	}
	
	public int getUzsakymu ( ) {
		
		return this.uzsakymu; 
	}	
	
	public void setUz_suma ( double uz_suma ) {
		
		this.uz_suma = uz_suma;
	}
	
	public double getUz_suma ( ) {
		
		return this.uz_suma; 
	}	
	
	public void setFld_delim ( String fld_delim ) {
	
		this.fld_delim = fld_delim;
	}

	public String toString () {
		
		return 
				this.pat_id 
				+ fld_delim + this.patiekalas
				+ fld_delim + this.ruosti
				+ fld_delim + this.kaitinti
				+ fld_delim + this.kaina_patiek
				+ fld_delim + this.uzsakymu
				+ fld_delim + this.uz_suma				
			;
	}
	
}
