function put(id){
	var name = $('#name').val();
	var formula = $('#formula').val();
	
	$.ajax({
	    url: '/indicators/' + id,
	    type: 'PUT',
	    data: {
	    	id: id,
	    	name: name,
	    	formula: formula
	    },
	    success: function() {
	    	alert("Edición exitosa!")
	    	window.location.href = "/indicators";
        },
        error: function(a, b, c) {
        	alert("Nombre de indicador repetido, ingrese otro")
        }
	});
};


