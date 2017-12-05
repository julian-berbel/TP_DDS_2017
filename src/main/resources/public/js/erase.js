function erase(id){
	var resource = window.location.pathname;
	console.log(resource);
    $.ajax({
        url: resource + '/' + id,
        type: 'DELETE',
        success: function() {
        	alert('Operacion exitosa!')
        	window.location.href = resource;
        },
        error: function(a, b, c) {
        	alert(c)
        }
    });
}