
	function crud ( fields, fields_names, url ) {
		
		this.fields = fields;
		this.fields_name = fields_names;
		this.data = data;
		
		this.res_str = '';


		$.ajax(
				{
					url: url
													
				}
			)
			.done(
				
				function( data ) {

					this.data = data;
				}
			);
	
		
		this.sarasas = function() {
			
			this.res_str = '<table>';			
			
			sarasoAntraste();
			/*
			for ( i = 0; i < this.data.length; i++) {
						
				this.res_str += '<tr data-id="' + data [ i ].id  +'" >';
				
				for ( k=0; k < this.fields.length; k++ ) {
				
					this.res_str += '<td>' + data [ i ] [ fields [ i ] ] + '</td>' 
				}
			} */
			this.res_str = '</table>';			
		}
		
		this.sarasoAntraste() {
			
			
			this.res_str = '<tr>';
			
			for (i =0; i< fields_names.length; i++ ) {
			
				this.res_str += '<th>' +fields_names [ i ] + '</th>';
				
			}
			this.res_str += '</tr>'; 
		}
	}