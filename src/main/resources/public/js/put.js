$(function() {
  $('#put').click(function(){
    var id = $('#id').val();
    var name = $('#name').val();
    var formula = $('#formula').val();
    
    console.log(id);
    console.log(name);
    console.log(formula);
    
    $.ajax({
        url: '/indicators/' + id,
        type: 'PUT',
        data: {
        	id: id,
        	name: name,
        	formula: formula
        },
        success: function() {
            console.out("awwww yissssss")
        }
    });
  });
});
