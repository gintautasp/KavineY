		$(document).ready ( function() {
					
		pasiimtiUzsakymus();
		
		function keistiBusena( id, busena) {
		
			params_str = 'id=' + id + '&busena=' + busena;  
		
			$.ajax(
				{
					url: "http://localhost:8080/restfull/changestatus?" + params_str
				}
			)
			.done( function( data ) {
				
				alert ( data );
				pasiimtiUzsakymus();
			});			
		
		}
		
		function pasiimtiUzsakymus() {
			
			alert ("pakeistas 3");
		
			$.ajax(
				{
					url: "http://localhost:8080/restfull/all" 
															/*
															, beforeSend: function( xhr ) {
																xhr.overrideMimeType( "text/plain; charset=x-user-defined" );
															}
															*/
				}
			)
			.done(
					function( data ) {
															// alert ( 'jquery ok ' + data );
						res_str = '<table>'
								+ '<tr><th rowspan="2">id</th><th rowspan="2">pav</th><th colspan="2">trukmė</th></tr>'
								+ '<tr><th>ruošimo</th><th>kaitinimo</th><th>veiksmas</th></tr>';
						
						for ( i = 0; i < data.length; i++) {
						
							res_str += '<tr class="s' + data [ i ].busena  + '" data-id="' + data [ i ].id  +'" >'
								+ '<td>' + data [ i ].id + '</td>' 
								+ '<td>' + data [ i ].pav + '</td>'
								+ '<td>' + data [ i ].trukme_ruosimo + '</td>'
								+ '<td>' + data [ i ].trukme_kaitinimo + '</td>'
								;
							if ( data [ i ].busena == 'uzsakytas' ) {	
							
								res_str +=
								
									'<td><input type="button" class="anuliuotas" value="anuliuotas"></td>'
									+ '<td><input type="button" class="ivykdytas" value="įvykdytas"></td>'
							}
							res_str += '</tr>';
						}
						
						res_str += '</table>'
						$( '#uzsakymai' ).html ( res_str );
						
						$( '.anuliuotas' ).on ( 'click', function() {
						
							$( this ).each ( function() {
								
								id_uzsakymo = $( this ).parent( ).parent().data ( 'id' );

								keistiBusena ( id_uzsakymo, 'anuliuotas' );
							});
						});
						
						$( '.ivykdytas' ).on ( 'click', function() {
						
							$( this ).each ( function() {
								
								id_uzsakymo = $( this ).parent( ).parent().data ( 'id' );

								keistiBusena ( id_uzsakymo, 'ivykdytas' );
							});
						});
					}
			);		
		}
		
		$( '#naujas_uzsakymas' ).click( function() {
		
			alert ( 'vykdomas ' );
		
			uzsakymas = {
				
				pav: $( '#pav' ).val()
				, trukme_ruosimo: parseInt ( $( '#trukme_ruosimo' ).val() )
				, trukme_kaitinimo: parseInt ( $( '#trukme_kaitinimo' ).val() )
			}
			
			// alert ( 'uzsakymas  ' + uzsakymas.pav + ' ' );
			
			params_str = 
				"pav="  + uzsakymas.pav 
				+ '&trukme_ruosimo=' + uzsakymas.trukme_ruosimo 
				+ '&trukme_kaitinimo=' + uzsakymas.trukme_kaitinimo 
				
			alert ( "http://localhost:8080/restfull/add?" + params_str );
				
			$.ajax(
				{
					url: "http://localhost:8080/restfull/add?" + params_str
				}
			)
			.done( function( data ) {
				
				alert ( data );
				pasiimtiUzsakymus();
			});
		} );
	});