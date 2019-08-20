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
    
    public Patiekalu_produktai() {
    	
    }
    
    @ManyToOne
    @JoinTable(name = "patiekalai", joinColumns = @JoinColumn(name = "id_patiekalo", referencedColumnName = "id"))      
    private Patiekalai patiekalai;


    public Integer getId () {
    	return id;
    }
    
    public void setId( Integer id ) {
    	
    	this.id = id;
    } 
    
    public Patiekalai getPatiekalai () {
    	return patiekalai;
    }
    
    public void setPatiekalai( Patiekalai patiekalai ) {
    	
    	this.patiekalai = patiekalai;
    }     
        
    
    
    public Double getKiekis_produkto () {
    	
    	return kiekis_produkto;
    }
    
    public void setKiekis_produkto( Double kiekis_produkto ) {
    	
    	this.kiekis_produkto = kiekis_produkto;
    }    
    
}


