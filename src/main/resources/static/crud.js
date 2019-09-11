
	// alert ( 'from crud' );
	/**
	*
	*param field_data jei duomenu masyvas giliau tai lauko pavadiniamas, su tasku pradzioje, jei dar giliau - lauku seka, su taskais, bet butinai su tasku pradzioje, kitu atveju tuscias stringas
	*/
	function crud ( 
		
		params
	) {
		this.params = {};
		this.params.fields = params.fields;
		this.params.fields_names = params.fields_names;
		this.params.url = params.url;
		this.params.field_data = params.field_data;
		this.params.fields_ids = params.fields_ids;
		this.params.id_html_saraso = params.id_html_saraso;
		this.params.id_html_dialog_formos = params.id_html_dialog_formos;
		this.params.dialog_size_x = params.dialog_size_x;
		this.params.dialog_size_y = params.dialog_size_y;
		this.params.title_dialog_form = params.title_dialog_form;
		this.params.url_save_rec = params.url_save_rec;
		this.params.url_delete_rec = params.url_delete_rec;
		
		this.params.ed_fields = params.fields_edit;
		
		this.params.field_name = params.field_name;
		
		var i_am = this;		
		
		this.initEmpty = function() {
		
			this.params.o_ed_fields = [];

			this.params.dialog = null;
			this.params.form = null;		
			
			
			this.params.allFields = $( [] );
			
			this.params.data = {};
																																		// alert ( 'url: ' + url );
			this.params.res_str = '';
		}

	//	this.initEmpty();
		
		this.refreshData = function() {
		
			$.ajax(
					{
						url: this.params.url
														
					}
				)
				.done(
					
					function( data ) {

						i_am.params.data = data;
																																		// alert ( 'this.data 1 ' +JSON.stringify ( i_am.params.data  ) );
						i_am.sarasas();
					}
				);
		}
		
	//	this.refreshData();		

		this.sarasas = function() {
			
			this.params.res_str = '<table>';			
			
			this.sarasoAntraste();
																														alert ( 'this.params.data 2 ' + JSON.stringify ( this.params.data ) );	
			num_produktu = eval ( 'this.params.data' + this.params.field_data + '.length' );
																														alert ( 'num_produktu:' +  num_produktu );
			for ( i = 0; i < num_produktu; i++) {
																																					// alert ( i );
				this.params.res_str += '<tr data-id="' + eval ( 'this.params.data' +this.params.field_data + '[ i ].id' ) +'" ><td>' + i + '</td>';
																															// alert ( 'this.params.fields.length' + this.params.fields.length );
				for ( k=0; k < this.params.fields.length; k++ ) {
				
					this.params.res_str += '<td>'+ eval (  'this.params.data' + this.params.field_data +'[ i ].' + this.params.fields [ k ] ) + '</td>';
				}
				
				 this.params.res_str += '<td><input type="button" class="edit_button" value="redaguoti"><input  type="button" class="delete_button" value="šalinti"></td></tr>';
			} 
			this.params.res_str += '</table>';
			
			if ( this.params.id_html_dialog_formos == '' ) {

				this.htmlDialogo();
				this.params.id_html_dialog_formos = 'dialogo_forma';
			}

			$( '#' + this.params.id_html_saraso ).html( this.params.res_str );
			this.initDialog();
			this.edFields();
			
			$( "#naujas" ).button().on( "click", function() {
				
				$( '#name_item' ).html ( 'Naujas ' + i_am.params.title_dialog_form );
				
			        $( '#id_prod' ).val(  '0' );
				
			        i_am.params.dialog.dialog( "open" );
			});				
			
			$( '.edit_button' ).on ( 'click', function() {
				
				id_record = $( this ).parent().parent().data ( 'id' );
				
				i_record = i_am.surastiSarasePagalId ( id_record );
				
				for ( k=0; k < i_am.params.fields.length; k++ ) {
					
					field_val = eval (  'i_am.params.data' + i_am.params.field_data + '[ i_record ].' + i_am.params.fields [ k ] );
					
																															// alert (  i_am.params.fields [ k ]  + ': ' + field_val );
					$( '#' +  i_am.params.fields_ids [ k ] ).val ( field_val );
				}
				
				$( '#name_item' ).html ( eval (  'i_am.params.data' + i_am.params.field_data + '[ i_record ].' + i_am.params.field_name ) );
				
				$( '#id_rec' ).val ( id_record );
				i_am.params.dialog.dialog( "open" );				
			});
		}
		 
		this.sarasoAntraste= function() {
			
			this.params.res_str += '<tr><th>eil.<br>nr.</th>';
			
			for ( i =0; i< this.params.fields_names.length; i++ ) {
			
				this.params.res_str += '<th>' + this.params.fields_names [ i ] + '</th>';
				
			}
			this.params.res_str += 
			
				'<th>veiksmai ' +									
					'<input type="button" class="new_button" value="naujas" id="naujas"></th>' +
				'</tr>';
																													// alert ( this.params.res_str );
		}
		
		this.surastiSarasePagalId = function ( id ) {
		
			found = -1;
	
			for ( i = 0; i < num_produktu; i++) {	
			
				if ( id == eval ( 'this.params.data' +this.params.field_data + '[ i ].id' ) ) {
				
					found = i;
				}
			}
			return found;
		}
		
		this.htmlDialogo = function() {
			
			this.params.res_str += 
			
				'<div id="dialogo_forma" title="' + this.params.title_dialog_form + '">' +
					'<p class="validateTips">Visi laukeliai turi buti užpildyti.</p>' +
					'<p class="name_item" id="name_item"></p>' +
					'<form action="">' +
					'<fieldset>'
			;

			this.htmDialogoEditFields();

			this.params.res_str += 			
			
				'<!-- Allow form submission with keyboard without duplicating the dialog button -->' +
				'<input type="submit" tabindex="-1" style="position:absolute; top:-1000px">' +
				'</fieldset>' +
				'<input type="hidden" name="id" id="id_rec" value="0">' +
				'</form>' +
				'</div>'
			;
																															// console.log ( this.params.res_str );
		}
		
		this.htmDialogoEditFields = function() {
		
			for ( k=0; k < this.params.fields.length; k++ ) {
				
				
				if ( ( this.params.ed_fields.length > 0 ) && ( this.params.ed_fields.indexOf ( this.params.fields_ids [ k ] ) > -1 ) ) {
				
				
					this.params.res_str += 
					
						'<label for="' + this.params.fields_ids [ k ] + '">' + this.params.fields_names [ k ].replace( '-<br>', '' ).replace ( '<br>', ' ' ).replace( '_', '' ) + '</label>' +
							'<input type="text" name="' + this.params.fields_ids [ k ] + '" id="' + this.params.fields_ids [ k ] + '" value="" class="text ui-widget-content ui-corner-all">'
					;
				}
			}		
		}
		
		
		this.saveRecord = function() {
			
			var valid = true;
			i_am.params.allFields.removeClass( "ui-state-error" );
			
			valid = i_am.validate();
		 
			id  = $( '#id_rec' ).val();
			i_am.sendData ( id );
			 
			return valid;
		}
		
		this.edFields = function () {
		
			for ( k=0; k < this.params.fields.length; k++ ) {
				
				if ( ( this.params.ed_fields.length > 0 ) && ( this.params.ed_fields.indexOf ( this.params.fields_ids [ k ] ) > -1 ) ) {

					this.params.o_ed_fields.push ( $ ( '#' + this.params.fields [ k ] ) );
					this.params.allFields.add( this.params.o_ed_fields [ k ]  );
				}
			}
		}
		
		this.sendData = function( id ) {
			
			params_str = '?';
			
			if ( i_am.params.url_save_rec.indexOf ( '?' ) > -1 ) {
			
				params_str = '&';
			}			
		
			params_str += 'id=' + id;  
			
			for ( k=0; k < i_am.params.ed_fields.length; k++ ) {
				
				params_str += '&' + i_am.params.ed_fields [ k ] + '=' + $( '#' + i_am.params.ed_fields [ k ] ).val();
			}
				
			$.ajax(
				{
					url: i_am.params.url_save_rec + params_str
				}
			)
			.done( function( data ) {
				
																																	// alert ( data );
				i_am.params.dialog.dialog ( 'close' );
				i_am.refreshData(); 																											// paimtiProduktus();
			});
		}		
		
		
		this.validate = function() {
		
			return true;
		}
		
		this.initDialog = function() {
			
			alert ( this.params.id_html_dialog_formos  );
			
			this.params.dialog = $( '#' + this.params.id_html_dialog_formos ).dialog({
				
				autoOpen: false
				, height: this.params.dialog_size_y
				, width: this.params.dialog_size_x
				, modal: true
				, buttons: {
					
					"Saugoti": i_am.saveRecord
					
					, "Atšaukti": function() {
				
						i_am.params.dialog.dialog( "close" );
					}
			      }
			      , close: function() {
				      
					i_am.params.form[ 0 ].reset();
					i_am.params.allFields.removeClass( "ui-state-error" );
			      }
			});
			 
			this.params.form = this.params.dialog.find( 'form' );
		}
	}