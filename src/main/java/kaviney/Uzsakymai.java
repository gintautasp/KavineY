package kaviney;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Uzsakymai {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String pav;

    private Integer trukme_ruosimo;
    
    private Integer trukme_kaitinimo;
    
    private String busena;
    
    private String klientas;    
    
    private Double kaina; 
    
    private Integer id_patiekalo;
    
	private String laikas_uzsakymo;
	private String laikas_patekimo;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_patiekalo", insertable=false, updatable=false)
    private Patiekalai patiekalai;	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId_patiekalo() {
		return id_patiekalo;
	}

	public void setId_patiekalo(Integer id_patiekalo) {
		this.id_patiekalo = id_patiekalo;
	}	

	public String getPav() {
		return pav;
	}

	public void setPav(String pav) {
		this.pav = pav;
	}
	
	public String getKlientas() {
		return klientas;
	}

	public void setKlientas(String klientas) {
		this.klientas = klientas;
	}	

	public Integer getTrukme_ruosimo() {
		return trukme_ruosimo;
	}

	public void setTrukme_ruosimo(Integer trukme_ruosimo) {
		this.trukme_ruosimo = trukme_ruosimo;
	}

	public Integer getTrukme_kaitinimo() {
		return trukme_kaitinimo;
	}

	public void setTrukme_kaitinimo(Integer trukme_kaitinimo) {
		this.trukme_kaitinimo = trukme_kaitinimo;
	}	
	
	public String getBusena() {
		return busena;
	}

	public void setBusena(String busena) {
		this.busena = busena;
	}
	
	public Double getKaina() {
		return kaina;
	}

	public void setKaina(Double kaina) {
		this.kaina = kaina;
	}
	
	public String getLaikas_uzsakymo() {
		return laikas_uzsakymo;
	}

	public void setLaikas_uzsakymo(String laikas_uzsakymo) {
		this.laikas_uzsakymo = laikas_uzsakymo;
	}	
	
	public String getLaikas_patekimo() {
		return laikas_patekimo;
	}

	public void setLaikas_patekimo(String laikas_patekimo) {
		this.laikas_patekimo = laikas_patekimo;
	}	
	
	public String toString() {
		
	    return 
	    		id 
	    		+ " / " + pav

				+ " / " + trukme_ruosimo	    		
				
				+ " / " + trukme_kaitinimo	    		
				
				+ " / " + busena	    		
				
				+ " / " + klientas	    		
				
				+ " / " +  kaina
			; 		
	}
	
}

