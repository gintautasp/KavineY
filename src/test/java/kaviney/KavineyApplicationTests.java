package kaviney;
import kavinex.*;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KavineyApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test 
	public void testUzsakymuIvedimas() {
		
		String[] uzsakymu_eilutes = {
				
		   "Ledai,0,0"											// 0
		   , "Kava Juoda"										// 1
		   , "Tortilija su falafeliais,20,5"					// 2
		   , "Cezario salotos,15"								// 3
		   , "Obuoliu pyragas su braskemis,15,0"				// 4
		   , "Kava Late,bar,foo"								// 5		   
		   , "Humus Pica,15abc,iks"								// 6
		   , "Trijų sūrių Pica,15,iks"							// 7		   
		   , "Saltibarsciai su bulvemis,xyz,5"					// 8
		   , "Saltibarsciai,xyz,5ccc"							// 9
		   , ""													// 10
		   , "   "												// 11
		   , "1"												// 12	
		   , "Saltibarsciai su bulvemis,-1,5"					// 13		   
		};
		
		kavinex.Uzsakymas[] uzsakymai = {
				
			new kavinex.Uzsakymas ( "Ledai", 0, 0 )								// 0
			, new kavinex.Uzsakymas ( "Kava Juoda", 0, 0 ) 						// 1
			, new kavinex.Uzsakymas ( "Tortilija su falafeliais", 20, 5 ) 		// 2
			, new kavinex.Uzsakymas ( "Cezario salotos", 15, 0 )				// 3
			, new kavinex.Uzsakymas ( "Obuoliu pyragas su braskemis", 15, 0 )	// 4			
			, new kavinex.Uzsakymas ( "Kava Late", -1, -1 )						// 5
			, new kavinex.Uzsakymas ( "Humus Pica", -1, -1 )					// 6
			, new kavinex.Uzsakymas ( "Trijų sūrių Pica", 15, -1 )				// 7
			, new kavinex.Uzsakymas ( "Saltibarsciai su bulvemis", -1, 5 )		// 8
			, new kavinex.Uzsakymas ( "Saltibarsciai", -1, -1 )					// 9
			, null																// 10
			, null																// 11
			, new kavinex.Uzsakymas ( "1", 0, 0 )								// 12
			, new kavinex.Uzsakymas ( "Saltibarsciai su bulvemis", -1, 5 )	    // 13				
		};

		String[] tikrinimai = {
				
			"Tikrinimas, kai nurodytos nulinės abiejų trukmių reikšmės"					// 0
			, "Tikrinimas, kai nenurodytos trukmių reikšmės"							// 1
			, "Tikrinimas, kai nurodytos nenulinės abiejų trukmių reikšmės" 			// 2
			, "Tikrinimas, kai nurodyta, tik trukmė ruošimo"							// 3
			, "Tikrinimas, kai nurodyta nenulinė ruošimo ir nulinė kaitinimo trukmių reikšmės" 		// 4
			, "Tikrinimas, kai abi trukmės ne skaičiai"									// 5
			, "Tikrinimas, kai abi trukmės ne skaičiai, bet pirmos trukmė prasideda skaičiais" 		// 6
			, "Tikrinimas, kai antra trukmė ne skaičiai, bet pirmos trukmė skaičiai" 	// 7						
			, "Tikrinimas, kai pirma trukmė ne skaičiai, bet antra trukmė skaičius" 	// 8						
			, "Tikrinimas, kai abi trukmės ne skaičiai, bet antros trukmė prasideda skaičiais" 		// 9
			, "Tikrinimas, kai tuščia eilutė" 											// 10						
			, "Tikrinimas, kai eilutė iš tarpų" 										// 11						
			, "Tikrinimas, kai eilutė tik skaičius" 									// 12
			, "Tikrinimas, kai iš karto bloga ruošimo trukmė "							// 13
		};
		
		SkaitymasIsFailo dsf = new SkaitymasIsFailo();
		
		for ( int i = 0; i < uzsakymu_eilutes.length; i++ ) {
		
			dsf.setFile_line ( uzsakymu_eilutes [ i ] );
			assertEquals (
				tikrinimai [ i ]
				, uzsakymai [ i ]
				, dsf.paimtiFragmenta()		
			);
		}
	}
	
	@Test
	public void testPatiekaluFormavimas() {
		
		Uzsakymas[] uzsakymai = {
				
			new Uzsakymas ( "Ledai", 0, 0 )								// 0
			, new Uzsakymas ( "Tortilija su falafeliais", 20, 5 ) 		// 1
			, new Uzsakymas ( "Cezario salotos", 15, 0 )				// 2			
			, new Uzsakymas ( "Kava Late", -1, -1 )						// 3
			, new Uzsakymas ( "Trijų sūrių Pica", 0, 10)				// 4
			, new Uzsakymas ( "Saltibarsciai su bulvemis", -1, 5 )		// 5
		};

		String[] tikrinimai = {
				
			"Tikrinimas, kai nurodytos nulinės abiejų trukmių reikšmės"			// 0
			, "Tikrinimas, kai nurodytos nenulinės abiejų trukmių reikšmės" 			// 2
			, "Tikrinimas, kai nurodyta, tik trukmė ruošimo"							// 3
			, "Tikrinimas, kai abi trukmės neteisingos"									// 5
			, "Tikrinimas, kai yra trukmė kaitinimo, bet nėra trukmės ruošimo" 			// 6
			, "Tikrinimas, kai trukmė ruošimo yra neteisinga"						 	// 7						
		};	
		
		Patiekalas[] patiekalai = {
				
			new Patiekalas ( "Ledai" )								// 0
			, new KarstasPatiekalas ( "Tortilija su falafeliais", 20, 5 ) 	// 1
			, new RuosiamasPatiekalas ( "Cezario salotos", 15 )		// 2			
			, null													// 3
			, new KarstasPatiekalas ( "Trijų sūrių Pica", 0, 10 )	// 4
			, null												    // 5
		};		
		
		UzsakymaiSpring uzsak = new UzsakymaiSpring();	

		for ( int i = 0; i < uzsakymai.length; i++ ) {
			/*
			System.out.println ( uzsakymai [ i ].toString() );
			
			if ( patiekalai [ i ] != null ) {
				
				System.out.println ( patiekalai [ i ].toString() );
				
			} else {
				
				System.out.println ( "null" );
			}
			*/
			assertEquals (
				tikrinimai [ i ]
				, uzsak.uzsakymas2Patiekalas( uzsakymai [ i ])
				, patiekalai [ i ]
			);
		}
	}
	
	@Test
	public void testIsnesioti() {

        /**
         * we are demonstrating the usage of assertArrayEquals()
         * method here, so we are preparing input data here itself.
         * In real scenario, we will consider the methods returned 
         * value which suppose to be test, as a input. 
         */
        //assume that the below array represents expected result
        String[] expectedOutput = {"apple", "mango", "grape"};
        //assuem that the below array is returned from the method 
        //to be tested.
        String[] methodOutput = {"apple", "mango", "grape"};
        assertArrayEquals(expectedOutput, methodOutput);		
		
	}
}
