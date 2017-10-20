function postIndicator(){
	var name = $('#name').val();
	var formula = $('#formula').val();
	
	$.ajax({
	    url: '/indicators',
	    type: 'post',
	    data: {	    	
	    	name: name,
	    	formula: formula
	    },
	    success: function() {
	    	alert("Indicador agregado exitosamente!")
	    	window.location.href = "/indicators";
        },
        error: function(a, b, c) {
        	alert("Nombre de indicador " + name + " ya existe, ingrese otro")
        	window.location.href = "/indicators/new";
        }
	});
};
