$("#submit").live('click', function() {
  var number = $("#number").val();
  $.ajax({
    url: "/plusone/"+number,
    success: function( retval ) {
      $("#result").html(retval)
    },
    complete: function( hxr, status ) {
      if ( status == "error" ) {
        $("#result").html("eh?")
      }
    }
  });
});