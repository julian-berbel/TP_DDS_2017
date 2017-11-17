function eraseEnterprise(id){
	var resource = window.location.pathname;
	console.log(resource);
    $.ajax({
        url: resource + '/' + id,
        type: 'DELETE',
        success: function() {
        	alert('Operacion exitosa!')
        	window.location.href = "/enterprises";
        },
        error: function(a, b, c) {
        	alert(c)
        }
    });
}

function eraseIndicator(id){
	var resource = window.location.pathname;
	console.log(resource);
    $.ajax({
        url: resource + '/' + id,
        type: 'DELETE',
        success: function() {
        	alert('Operacion exitosa!')
        	window.location.href = "/indicators";
        },
        error: function(a, b, c) {
        	alert(c)
        }
    });
}

function eraseMethod(id){
	var resource = window.location.pathname;
	console.log(resource);
    $.ajax({
        url: resource + '/' + id,
        type: 'DELETE',
        success: function() {
        	alert('Operacion exitosa!')
        	window.location.href = "/methods";
        },
        error: function(a, b, c) {
        	alert(c)
        }
    });
}