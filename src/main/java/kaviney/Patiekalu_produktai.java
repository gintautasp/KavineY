package kaviney;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Patiekalu_produktai implements Serializable {
	
    private static final long serialVersionUID = -6790693372846798580L;	
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer id;

    private Double kiekis_produkto;	
    
    @ManyToOne
    private Patiekalai patiekalai;

    @ManyToOne
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
    
    public Produktai getProduktai () {
    	return produktai;
    }

    public void setProduktai( Produktai produktai ) {
	
    	this.produktai = produktai;
    }     
    
    public void setKiekis_produkto( Double kiekis_produkto ) {
    	
    	this.kiekis_produkto = kiekis_produkto;
    }    
    
}


