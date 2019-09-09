package kaviney;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
																						// import org.springframework.boot.test.autoconfigure.orm.jpa.*; - nereikia iš pvz. !
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
																						// @DataJpaTest											         - nereikia iš pvz. !
public class ProduktaiRepositoryTest {
	
    @Autowired
    private ProduktaiRepository produktaiRepository;
   
    @Test
    public void testSaveGetProduktai() {

        																			     // System.out.println (" starting here test ! ");    	
        Produktai produktai = new Produktai("saulėgražos", "g", 111.1, 1.1, 11.1 );
        Produktai produkt = produktaiRepository.save(produktai);
        Produktai prod = produktaiRepository.findByPav("saulėgražos");
        																			     // System.out.println (" kt1 : " + produkt.getId() );        
        assertNotNull(produktai);
        																			     // System.out.println (" kt2 ! ");        
        assertNotNull(prod);        
        																			     // System.out.println (" kt3 ! ");        
        assertEquals(prod.getPav(), produktai.getPav());
        																				 // System.out.println (" kt4 ! ");   
        																				 // -- neveiks kt4 nespaudina .. 
        assertEquals(prod.getMato_kiekis(), produktai.getMato_kiekis());
        																				 // System.out.println (" kt5 ! ");      
        
        produktaiRepository.deleteById(produkt.getId());        					  
        System.out.println (" ending here test ! ");
    }
    
    @Test   
    public void testFindAllProduktai() {
        assertNotNull(produktaiRepository.findAll());
    }
    
    @Test    
    public void deleteFoundedByName() {
        																			// System.out.println (" kt6 ! ");       
        Produktai produktai = new Produktai( "sezamai", "g", 333.3, 3.3, 33.3 );        
		produktaiRepository.delete(produktai);                  					// -- pagal pavyzdį neveikia  :(  
    }    

    @Test
    public void deletByProduktaiIdTest() {
    	
        Produktai produktai = new Produktai( "moliūgų sėklos", "g", 222.2, 2.2, 22.2);    	
        Produktai prod = produktaiRepository.save(produktai);
        produktaiRepository.deleteById(prod.getId());
    }   
}
