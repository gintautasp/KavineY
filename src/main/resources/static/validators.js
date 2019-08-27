
		tips = $( ".validateTips" );
	  
		function updateTips( t ) {
			tips
			.text( t )
			.addClass( "ui-state-highlight" );
			
			setTimeout( function() {
				
				tips.removeClass( "ui-state-highlight", 1500 );
			}, 500 );
		}
	 
		function checkLength( o, n, min, max ) {
			
			if ( o.val().length > max || o.val().length < min ) {
				
				o.addClass( "ui-state-error" );
				updateTips( "Simbolių sk. " + n + " turi būti nuo " + min + " iki " + max + "." );
				return false;
				
			} else {
				
				return true;
			}	
		}
		
		function checkBetween( o, n, min, max, tipas ) {
			
			reiksme = o.val();
			
			if ( tipas == "sveikas" ) {
			
				reiksme = parseInt( reiksme);
			}
			
			if ( tipas == "realus" ) {
			
				reiksme = parseFloat ( reiksme );
			}
			
			if ( reiksme > max || reiksme < min ) {
				
				o.addClass( "ui-state-error" );
				updateTips( "Simbolių sk. " + n + " turi būti nuo " + min + " iki " + max + "." );
				return false;
				
			} else {
				
				return true;
			}	
		}	
	 
		/**
		* tikrina atitikimą pagal reguliarią išraišką 
		*/
		function checkRegexp( o, regexp, n ) {
			
			if ( !( regexp.test( o.val() ) ) ) {
				
				o.addClass( "ui-state-error" );
				updateTips( n );
				return false;
				
			} else {
				
				return true;
			}
		}
		/**
		* @param String tipas nurodo ar turi būti sveikas(int) ar realus(float, su kableliu)
		*/
		function checkNumber( o, n, tipas ) {
			
			if ( 
					(
							isNaN ( parseInt ( o.val() ) )
						&&
							tipas == "sveikas"
					)
			
				||
					(
				
							isNaN ( parseFloat ( o.val() ) )
						&&
							tipas == "realus"		
					)
			)  {
				
				o.addClass( "ui-state-error" );
				updateTips( "Laukelyje turi būti " + tipas + " skaičius" );
				return false;
				
			} else {
				
				return true;
			}	
		}
	