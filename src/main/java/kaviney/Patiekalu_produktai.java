package kaviney;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@Entity
public class Patiekalu_produktai implements Serializable {
	
    private static final long serialVersionUID = -6790693372846798580L;	
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer id;
    

    private Integer patiekalai_id;
      
    private Integer produktai_id;

    private Double kiekis_produkto;	
    
    @ManyToOne
    @JoinColumn(insertable=false, updatable=false)
    private Patiekalai patiekalai;

    @JsonIgnoreProperties("patiekalu_produktai")
    @ManyToOne
    @JoinColumn(insertable=false, updatable=false)
    private Produktai produktai; 
    
    public Patiekalu_produktai() {
    	
    }    
    
    public Integer getId () {
    	return id;
    }
    
    public void setId( Integer id ) {
    	
    	this.id = id;
    } 
/*   
    public Patiekalai getPatiekalai () {
    	return patiekalai;
    }
    
    public void setPatiekalai ( Patiekalai patiekalai ) {
    	
    	this.patiekalai = patiekalai;
    }             
*/    
    public Double getKiekis_produkto () {
    	
    	return kiekis_produkto;
    }
    
    public void setKiekis_produkto( Double kiekis_produkto ) {
    	
    	this.kiekis_produkto = kiekis_produkto;
    }    
    
    public Produktai getProduktai () {
    	return produktai;
    }

    public void setProduktai( Produktai produktai ) {
	
    	this.produktai = produktai;
    }
    
    public void setProduktai_id ( Integer produktai_id ) {
    	
    	this.produktai_id = produktai_id;
    }
    
    public Integer getProduktai_id () {
    	
    	return this.produktai_id;
    }
    
    public void setPatiekalai_id ( Integer patiekalai_id ) {
    	
    	this.patiekalai_id = patiekalai_id;
    }
    
    public Integer getPatieklai_id () {
    	
    	return this.patiekalai_id;
    } 
    
	public String toString() {
		
		return "id: " + this.id + " patiekalai id: " + this.patiekalai_id + " produktai id " + this.produktai_id + "kiekis prod.: " + this.kiekis_produkto;
	}    
}


