
	// alert ( 'from crud' );
	/**
	*
	*param field_data jei duomenu masyvas giliau tai lauko pavadiniamas, su tasku pradzioje, jei dar giliau - lauku seka, su taskais, bet butinai su tasku pradzioje, kitu atveju tuscias stringas
	*/

	function crud ( fields, fields_names, url, field_data, fields_ids, id_html_saraso, id_html_dialog_formos, dialog_size_x, dialog_size_y, title_dialog_form, url_save_rec  ) {
		
		this.fields = fields;
		this.fields_names = fields_names;
		this.field_data = field_data;
		this.fields_ids =fields_ids;
		this.id_html_saraso = id_html_saraso;
		this.id_html_dialog_formos = id_html_dialog_formos;
		this.dialog_size_x = dialog_size_x;
		this.dialog_size_y = dialog_size_y;
		this.title_dialog_form =title_dialog_form;
		this.url_save_rec = url_save_rec;
		
		this.dialog = null;
		this.form = null;
		this.ed_fields = [];
		this.allFields = $( [] );
		
		this.data = {};
																														// alert ( 'url: ' + url );
		this.res_str = '';
		
		var i_am = this;
		
		$.ajax(
				{
					url: url
													
				}
			)
			.done(
				
				function( data ) {

					i_am.data = data;
																														// alert ( 'this.data 1 ' +JSON.stringify ( i_am.data  ) );
					i_am.sarasas();
				}
			);

		this.sarasas = function() {
			
			this.res_str = '<table>';			
			
			this.sarasoAntraste();
																														// alert ( 'this.data 2 ' + JSON.stringify ( this.data ) );	
			num_produktu = eval ( 'this.data' + this.field_data + '.length' );
																															// alert ( 'num_produktu:' +  num_produktu );
			for ( i = 0; i < num_produktu; i++) {
																																					// alert ( i );
				this.res_str += '<tr data-id="' + eval ( 'this.data' +this.field_data + '[ i ].id' ) +'" ><td>' + i + '</td>';
																															// alert ( 'this.fields.length' + this.fields.length );
				for ( k=0; k < this.fields.length; k++ ) {
				
					this.res_str += '<td>'+ eval (  'this.data' + this.field_data +'[ i ].' + this.fields [ k ] ) + '</td>';
				}
				
				 this.res_str += '<td><input type="button" class="edit_button" value="redaguoti"><input  type="button" class="delete_button" value="šalinti"></td></tr>';
			} 
			this.res_str += '</table>';
			
			if ( this.id_html_dialog_formos == '' ) {

				this.htmlDialogo();
				this.id_html_dialog_formos = 'dialogo_forma';
			}

			$( '#' + this.id_html_saraso ).html( this.res_str );
			this.initDialog();
			this.edFields();
			
			$( "#naujas" ).button().on( "click", function() {
				
			      $( '#id_prod' ).val(  '0' );
				
			      i_am.dialog.dialog( "open" );
			});				
			
			$( '.edit_button' ).on ( 'click', function() {
				
				id_record = $( this ).parent().parent().data ( 'id' );
				
				i_record = i_am.surastiSarasePagalId ( id_record );
				
				for ( k=0; k < i_am.fields.length; k++ ) {
					
					field_val = eval (  'i_am.data' + i_am.field_data + '[ i_record ].' + i_am.fields [ k ] );
					
																															// alert (  i_am.fields [ k ]  + ': ' + field_val );
					$( '#' +  i_am.fields_ids [ k ] ).val ( field_val );
				}
				
				$( '#id_rec' ).val ( id_record );
				i_am.dialog.dialog( "open" );				
			});
		}
		 
		this.sarasoAntraste= function() {
			
			this.res_str += '<tr><th>eil.<br>nr.</th>';
			
			for ( i =0; i< this.fields_names.length; i++ ) {
			
				this.res_str += '<th>' + this.fields_names [ i ] + '</th>';
				
			}
			this.res_str += 
			
				'<th>veiksmai ' +									
					'<input type="button" class="new_button" value="naujas" id="naujas"></th>' +
				'</tr>';
																													// alert ( this.res_str );
		}
		
		this.surastiSarasePagalId = function ( id ) {
		
			found = -1;
	
			for ( i = 0; i < num_produktu; i++) {	
			
				if ( id == eval ( 'this.data' +this.field_data + '[ i ].id' ) ) {
				
					found = i;
				}
			}
			return found;
		}
		
		this.htmlDialogo = function() {
			
			this.res_str += 
			
				'<div id="dialogo_forma" title="' + this.title_dialog_form + '">' +
					'<p class="validateTips">Visi laukeliai turi buti užpildyti.</p>' +
					'<form action="">' +
					'<fieldset>'
			;

			for ( k=0; k < this.fields.length; k++ ) {
				
				
				this.res_str += 
				
					'<label for="' + this.fields_ids [ k ] + '">' + this.fields_names [ k ].replace ( '<br>', '' ).replace( '-', '' ) + '</label>' +
						'<input type="text" name="' + this.fields_ids [ k ] + '" id="' + this.fields_ids [ k ] + '" value="" class="text ui-widget-content ui-corner-all">'
				;
			}

			this.res_str += 			
			
				'<!-- Allow form submission with keyboard without duplicating the dialog button -->' +
				'<input type="submit" tabindex="-1" style="position:absolute; top:-1000px">' +
				'</fieldset>' +
				'<input type="hidden" name="id" id="id_rec" value="0">' +
				'</form>' +
				'</div>'
			;
				
			console.log ( this.res_str );
		}
		
		this.saveRecord = function() {
		
															// alert ( 'jquery ok ' + data 
															/*
																id
																pav
																mat_vnt
																mato_kiekis
																kaina
																kiekis_sand
															*/		
		
			var valid = true;
			allFields.removeClass( "ui-state-error" );
			
			valid = this.validate();
		 
			id  = $( '#id_rec' ).val();
			this.sendData ( id );
			 
			return valid;
		}
		
		this.edFields = function () {
		
			for ( k=0; k < this.fields.length; k++ ) {

				this.ed_fields.push ( $ ( '#' + this.fields [ k ] ) );
				this.allFields.add( this.ed_fields [ k ]  );
			}
		}
		
		this.sendData = function( id ) {
		
			params_str = 
				'id=' + id;
			;  
			
			for ( k=0; k < this.fields.length; k++ ) {

				params_str += '&' + this.fields [ k ] + this.ed_fields [ k ].val(); 
			}
				
			$.ajax(
				{
					url: this.url_save_rec + params_str
				}
			)
			.done( function( data ) {
				
				alert ( data );
				dialog.dialog ( 'close' );
				paimtiProduktus();
			});
		}		
		
		
		this.validate = function() {
		
			return true;
		}
		
		this.initDialog = function() {
			
			alert ( this.id_html_dialog_formos  );
			
			i_am.dialog = $( '#' + this.id_html_dialog_formos ).dialog({
				
				autoOpen: false
				, height: this.dialog_size_y
				, width: this.dialog_size_x
				, modal: true
				, buttons: {
					
					"Saugoti": i_am.saveRecord
					
					, "Atšaukti": function() {
				
						i_am.dialog.dialog( "close" );
					}
			      }
			      , close: function() {
				      
					i_am.form[ 0 ].reset();
					i_am.allFields.removeClass( "ui-state-error" );
			      }
			});
			 
			this.form = this.dialog.find( 'form' );
		}
	}