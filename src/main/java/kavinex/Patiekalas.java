package kavinex;


public class Patiekalas {
	
	public String pavadinimas;
	public int bus_paruostas_uz; /* minutemis */
	public int bus_patiektas_apytiksliai_uz; /* minutemis */
	public int patiekimo_laikas = 0;
	public PatiekaluPateikimoBusenos bukle = PatiekaluPateikimoBusenos.Paruoštas;
	public String busena = "uzsakytas";
	public int id_uzsakymo;
	public String laikas_uzsakymo;
	public String laikas_patekimo;
	public Double kaina;
	public String klientas;	
	
	public Patiekalas() {
		
	}
	
	public Patiekalas(
			
			String pavadinimas
			, String busena
			, int id_uzsakymo
			, String laikas_uzsakymo
			, String laikas_patekimo
			, Double kaina
			, String klientas			
		) {
		
		this.pavadinimas = pavadinimas;
		bus_paruostas_uz = 0;
		bus_patiektas_apytiksliai_uz = 0;
		this.busena = busena;
		this.id_uzsakymo = id_uzsakymo;
		this.laikas_uzsakymo = laikas_uzsakymo;
		this.laikas_patekimo = laikas_patekimo;
		this.kaina = kaina;
		this.klientas = klientas; 		
	}
	
	public void busPradetasRuostiUz (int ruosimo_pradzia) {
		
		bus_paruostas_uz += ruosimo_pradzia;
		bus_patiektas_apytiksliai_uz += ruosimo_pradzia; 
	}
	
	public void setTrukmeRuosimo( int trukme_ruosimo ) {
		
		bus_paruostas_uz = trukme_ruosimo;
	}
	
	public int trukmeRuosimo() {
		
		return bus_paruostas_uz;
	}
	
	public int trukmePateikimo() {
		
		return bus_patiektas_apytiksliai_uz;
	}
	
	public void patiekti(int patiekimo_laikas) {
		
		this.patiekimo_laikas = patiekimo_laikas;
	}
	
	public int kadaPatiekta() {
		
		return this.patiekimo_laikas; 
	}
	
	public boolean equals(Object obj){
		
        Patiekalas palyginimui = (Patiekalas) obj;
        boolean status = false;
        
        if(
        		this.pavadinimas.equalsIgnoreCase(palyginimui.pavadinimas)
              &&  
              	papildomiPalyginimai ( obj )
              &&	
              	this.trukmeRuosimo() == palyginimui.trukmeRuosimo() 
              		// pridedame papildomą tikrinimą patiekalų paruošimo metodui ..
              		// .. tikėdamiesi, kad nepakenks ankstesniems testams
        		){
        	
            status = true;
        }
        return status;
	}
	
	public String toString() {
		
		return this.pavadinimas + " - " + bus_paruostas_uz + " - " +  ";";
	}
	
	public boolean papildomiPalyginimai ( Object obj ) {
		
		return true;
	}
	
	public void rodyk() {
		
		System.out.println ( "\t" + pavadinimas + " -> " + bus_paruostas_uz + " / " + bus_patiektas_apytiksliai_uz + " min." );
	}
	
	public String getBusena () {
		
		return this.busena;
	}
}

