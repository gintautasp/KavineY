package kavinex;

public class Uzsakymas {
	
	private int id;
	private String pav;
	private int trukme_ruosimo;
	private int trukme_kaitinimo;
	
	public Uzsakymas() {
		
	}
	
	public Uzsakymas (String pav, int trukme_ruosimo, int trukme_kaitinimo) {
		
		this.id = 0;
		this.pav = pav;
		this.trukme_kaitinimo = trukme_kaitinimo;
		this.trukme_ruosimo = trukme_ruosimo;
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
                && this.trukme_ruosimo == palyginimui.trukme_ruosimo 
                && this.trukme_kaitinimo == palyginimui.trukme_kaitinimo ){
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
}
