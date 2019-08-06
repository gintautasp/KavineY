package kavinex;

public class Uzsakymas {
	
	private int id = 0;
	private String pav;
	private int trukme_ruosimo;
	private int trukme_kaitinimo;
	private String busena = "uzsakytas";
	private String laikas_uzsakymo;
	private String laikas_patekimo;
	private Double kaina;
	private String klientas; 	
	
	public Uzsakymas() {
		
	}
	
	public Uzsakymas (String pav, int trukme_ruosimo, int trukme_kaitinimo, String busena) {
		
		this.id = 0;
		this.pav = pav;
		this.trukme_kaitinimo = trukme_kaitinimo;
		this.trukme_ruosimo = trukme_ruosimo;
		this.busena = busena;
	}
	
	public Uzsakymas (
			String pav
			, int trukme_ruosimo
			, int trukme_kaitinimo
			, String busena, int id
			, String laikas_uzsakymo
			, String laikas_patekimo
			, Double kaina
			, String klientas			
		) {
		
		this.id = id;
		this.pav = pav;
		this.trukme_kaitinimo = trukme_kaitinimo;
		this.trukme_ruosimo = trukme_ruosimo;
		this.busena = busena;
		this.laikas_uzsakymo = laikas_uzsakymo;
		this.laikas_patekimo = laikas_patekimo;
		this.kaina = kaina;
		this.klientas = klientas; 		
	}	
	
	public String toString() {
		
		return 
			this.id 
				+ "/" + this.pav 
				+ "/" + this.trukme_ruosimo
				+ "/" + this.trukme_kaitinimo
				+ "/" + this.busena
			;
	}
	public boolean isCorrect() {
		
		boolean is_correct = true;
		
		if ( 
					( trukme_ruosimo < 0 )
				||
					( trukme_kaitinimo < 0 )
			) {
			
			is_correct = false;
		}
		return is_correct;
	}
	
	public boolean equals(Object obj){
    	
        Uzsakymas palyginimui = (Uzsakymas) obj;
        boolean status = false;
        
        if(
        			this.pav.equalsIgnoreCase(palyginimui.pav)
              &&  
                 (
                	this.trukme_ruosimo == palyginimui.trukme_ruosimo
                 )
              &&
              	 (	
              		this.trukme_kaitinimo == palyginimui.trukme_kaitinimo
              	 )
              && 
              	 ( 
              		this.busena == palyginimui.busena
                 )
        ){
            status = true;
        }
        return status;
    }	

	public void setId( int id ) {
		
		this.id = id;
	}
	
	public int getId () {
		
		return this.id;
	}
	
	public void setPav( String pav ) {
		this.pav = pav;
	}
	
	public String getPav () {
		
		return this.pav;
	}
	
	public void setTrukme_ruosimo( int trukme_ruosimo ) {
		
		this.trukme_ruosimo = trukme_ruosimo;
	}
	
	public int getTrukme_ruosimo () {
		
		return this.trukme_ruosimo;
	}
	
	public void setTrukme_kaitinimo( int trukme_kaitinimo ) {
		
		this.trukme_kaitinimo = trukme_kaitinimo;
	}
	
	public int getTrukme_kaitinimo () {
		
		return this.trukme_kaitinimo;
	}
	
	public void setBusena( String busena ) {
		
		this.busena = busena;
	}
	
	public String getBusena () {
		
		return this.busena;
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
	
	public String getKlientas() {
		return klientas;
	}

	public void setKlientas(String klientas) {
		this.klientas = klientas;
	}	
	
	public Double getKaina() {
		return kaina;
	}

	public void setKaina(Double kaina) {
		this.kaina = kaina;
	}	
}
