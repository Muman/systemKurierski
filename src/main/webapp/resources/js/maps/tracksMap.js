/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function initialize() {
  var mapOptions = {
    center: new google.maps.LatLng(51.219987, 4.396237),
    zoom: 12,
    mapTypeId: google.maps.MapTypeId.ROADMAP
  };
  var map = new google.maps.Map(document.getElementById("mapCanvas"),
    mapOptions);
  var marker = new google.maps.Marker({
    position: new google.maps.LatLng(51.219987, 4.396237)
  });
  marker.setMap(map);
  
  $('#myModal').on('shown', function () {
    google.maps.event.trigger(map, "resize");
});
}
