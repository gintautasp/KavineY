
	// alert ( 'from crud' );
	/**
	*
	*param field_data jei duomenu masyvas giliau tai lauko pavadiniamas, su tasku pradzioje, jei dar giliau - lauku seka, su taskais, bet butinai su tasku pradzioje, kitu atveju tuscias stringas
	*/

	function crud ( fields, fields_names, url, field_data, html_saraso ) {
		
		this.fields = fields;
		this.fields_name = fields_names;
		this.field_data = field_data;
		this.html_saraso = html_saraso;
		this.data = {};
		
		alert ( 'url: ' + url );
		
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
			alert ( 'num_produktu:' +  num_produktu );
			
			for ( i = 0; i < num_produktu; i++) {
				
				// alert ( i );
						
				this.res_str += '<tr data-id="' + eval ( 'this.data' +this.field_data + '[ i ].id' ) +'" ><td>' + i + '</td>';
				
				// alert ( 'this.fields.length' + this.fields.length );
				
				
				for ( k=0; k < this.fields.length; k++ ) {
				
					this.res_str += '<td>'+ eval (  'this.data' + this.field_data +'[ i ].' + this.fields [ k ] ) + '</td>';
				}
				
				 this.res_str += '</tr>';				
			} 
			this.res_str += '</table>';

			$( '#' + this.html_saraso ).html( this.res_str );
		}
		 
		this.sarasoAntraste= function() {
			
			
			this.res_str = '<tr><th>eil.<br>nr.</th>';
			
			for (i =0; i< fields_names.length; i++ ) {
			
				this.res_str += '<th>' +fields_names [ i ] + '</th>';
				
			}
			this.res_str += '</tr>'; 
			// alert ( this.res_str );
		}
	}