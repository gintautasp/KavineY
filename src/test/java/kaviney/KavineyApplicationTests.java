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
				
			new kavinex.Uzsakymas ( "Ledai", 0, 0, "uzsakytas" )								// 0
			, new kavinex.Uzsakymas ( "Kava Juoda", 0, 0, "uzsakytas" ) 						// 1
			, new kavinex.Uzsakymas ( "Tortilija su falafeliais", 20, 5, "uzsakytas" ) 		// 2
			, new kavinex.Uzsakymas ( "Cezario salotos", 15, 0, "uzsakytas" )				// 3
			, new kavinex.Uzsakymas ( "Obuoliu pyragas su braskemis", 15, 0, "uzsakytas" )	// 4			
			, new kavinex.Uzsakymas ( "Kava Late", -1, -1, "uzsakytas" )						// 5
			, new kavinex.Uzsakymas ( "Humus Pica", -1, -1, "uzsakytas" )					// 6
			, new kavinex.Uzsakymas ( "Trijų sūrių Pica", 15, -1, "uzsakytas" )				// 7
			, new kavinex.Uzsakymas ( "Saltibarsciai su bulvemis", -1, 5, "uzsakytas" )		// 8
			, new kavinex.Uzsakymas ( "Saltibarsciai", -1, -1, "uzsakytas" )					// 9
			, null																// 10
			, null																// 11
			, new kavinex.Uzsakymas ( "1", 0, 0, "uzsakytas" )								// 12
			, new kavinex.Uzsakymas ( "Saltibarsciai su bulvemis", -1, 5, "uzsakytas" )	    // 13				
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
				
			new Uzsakymas ( "Ledai", 0, 0, "uzsakytas", 1 )							// 0
			, new Uzsakymas ( "Tortilija su falafeliais", 20, 5, "uzsakytas", 2 ) 		// 1
			, new Uzsakymas ( "Cezario salotos", 15, 0, "uzsakytas", 3 )				// 2			
			, new Uzsakymas ( "Kava Late", -1, -1, "uzsakytas", 4 )						// 3
			, new Uzsakymas ( "Trijų sūrių Pica", 0, 10, "uzsakytas", 5)				// 4
			, new Uzsakymas ( "Saltibarsciai su bulvemis", -1, 5, "uzsakytas", 6 )		// 5
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
				
			new Patiekalas ( "Ledai", "uzsakytas", 1 )								// 0
			, new KarstasPatiekalas ( "Tortilija su falafeliais", "uzsakytas", 2, 20, 5 ) 	// 1
			, new RuosiamasPatiekalas ( "Cezario salotos", "uzsakytas", 3, 15 )		// 2			
			, null													// 3
			, new KarstasPatiekalas ( "Trijų sūrių Pica", "uzsakytas", 3, 0, 10 )	// 4
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
	public void testParuosti() {
	/*	
									ruoš.	šild.	laikas virėjo	paruoštas tiekti	gaus klientas
		Ledai																			2	
		Kava Juoda																		4	
		Tortilija su falafeliais	20		5		20				25					27	
		Cezario salotos				15		35		35				37	
		Kremine pievagrybiu sriuba	10		5		45				50					52	
		Obuoliu pyragas su braskemis													6	
		Kava Late																		8	
		Humus Pica					15		8		60				68					70	
		Saltibarsciai su bulvemis	15		5		75				80					82	
		Bulviniai blynai			10		15		85				100					102	
		Vaisine arbata																	10	
		Blyneliai su bananais		15		10		100				110					112	
*/		
		int kiek_patiekalu = 12;	
		
		Patiekalas[] etalonas = {
				
				 new Patiekalas ( "Ledai", "uzsakytas", 1 )
				 , new Patiekalas ( "Kava Juoda", "uzsakytas", 2 )
				 , new KarstasPatiekalas ( "Tortilija su falafeliais", "uzsakytas", 3, 20, 5 )		
				 , new RuosiamasPatiekalas ( "Cezario Salotos", "uzsakytas", 4, 15 )
				 
				 , new KarstasPatiekalas ( "Kremine pievagrybiu sriuba", "uzsakytas", 5, 10, 5 )
				 , new Patiekalas ( "Obuoliu pyragas su braskemis", "uzsakytas", 6 )
				 , new Patiekalas ( "Kava Late", "uzsakytas", 7 )
				 
				 , new KarstasPatiekalas ( "Humus Pica", "uzsakytas", 8, 15, 8 )
				 , new KarstasPatiekalas ( "Saltibarsciai su bulvemis", "uzsakytas", 9, 15, 5 )						
				 , new KarstasPatiekalas ( "Bulviniai blynai", "uzsakytas", 10, 10, 15 )
				 
				 , new Patiekalas ( "Vaisine arbata", "uzsakytas", 11 )
				 , new KarstasPatiekalas ( "Blyneliai su bananais", "uzsakytas", 12, 15, 10 )
		};

		
		/**
		 * norėtusi taip dariti, bet nerizikuojam, nes greičiausiai, operuos su tuo pačiu patiekalu 
		 *
		for ( int i= 0; i< kiek_patiekalu; i++) {
		
			uzsak.papildytiPatiekalus( new Patiekalas ( "Kava Juoda" ) );
		}
		*/
		int[] laikas_virejo = { 0, 0, 20,  35, 45, 0,   0, 60, 75,   85, 0, 100 };

		for ( int i= 0; i< kiek_patiekalu; i++) {
			
			etalonas[ i ].setTrukmeRuosimo( laikas_virejo [ i ] );
		}		
		
		UzsakymaiSpring uzsak = new UzsakymaiSpring( kiek_patiekalu );		
		uzsak.papildytiPatiekalus( new Patiekalas ( "Ledai", "uzsakytas", 1 ) );		
		uzsak.papildytiPatiekalus( new Patiekalas ( "Kava Juoda", "uzsakytas", 2 ) );
		uzsak.papildytiPatiekalus( new KarstasPatiekalas ( "Tortilija su falafeliais", "uzsakytas", 3, 20, 5 ) );		
		uzsak.papildytiPatiekalus( new RuosiamasPatiekalas ( "Cezario Salotos", "uzsakytas", 4, 15 ) );
		uzsak.papildytiPatiekalus( new KarstasPatiekalas ( "Kremine pievagrybiu sriuba", "uzsakytas", 5, 10, 5 ) );
		
		uzsak.papildytiPatiekalus( new Patiekalas ( "Obuoliu pyragas su braskemis", "uzsakytas", 6 ) );
		uzsak.papildytiPatiekalus( new Patiekalas ( "Kava Late", "uzsakytas", 7 ) );		
		uzsak.papildytiPatiekalus( new KarstasPatiekalas ( "Humus Pica", "uzsakytas", 8, 15, 8 ) );
		uzsak.papildytiPatiekalus( new KarstasPatiekalas ( "Saltibarsciai su bulvemis", "uzsakytas", 9, 15, 5 ) );	
		
		uzsak.papildytiPatiekalus( new KarstasPatiekalas ( "Bulviniai blynai", "uzsakytas", 10, 10, 15 ) );		
		uzsak.papildytiPatiekalus( new Patiekalas ( "Vaisine arbata", "uzsakytas", 11 ) );
		uzsak.papildytiPatiekalus( new KarstasPatiekalas ( "Blyneliai su bananais", "uzsakytas", 12, 15, 10 ) );		
		uzsak.ruostiPatiekalus();
		
		assertArrayEquals ( etalonas, uzsak.atiduokPatiekalus() );
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
