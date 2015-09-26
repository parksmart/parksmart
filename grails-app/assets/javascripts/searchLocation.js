// This example displays an address form, using the autocomplete feature
// of the Google Places API to help users fill in the information.

    var autocomplete, map;


    var locationList = [];


    function initAutocomplete() {
        // Create the autocomplete object, restricting the search to geographical
        // location types.
        autocomplete = new google.maps.places.Autocomplete(
            /** @type {!HTMLInputElement} */(document.getElementById('address')),
            {types: ['geocode']});

        // When the user selects an address from the dropdown, populate the address
        // fields in the form.
        autocomplete.addListener('place_changed', fillInAddress);

        var mapProp = {
            center: new google.maps.LatLng(28.5383658, 77.3496595),
            zoom: 5,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        map = new google.maps.Map(document.getElementById('map'), mapProp);
    }

    function dropMarkersOnMap() {
        var markers = [];
        $.each(locationList, function (idx, loc) {

            var currentMarker = new google.maps.Marker({
                position: new google.maps.LatLng(loc.lat, loc.long),
                map: map,
                title: loc.message
            });


            var address = "<a target='_blank' href='https://www.google.co.in/maps/dir//"+loc.fullAddress+"'>"+loc.fullAddress+"</a>"
            //We can also add html div in the info window content
            var infowindow = new google.maps.InfoWindow({
                content: address
            });

            currentMarker.addListener('click', function () {
                map.setZoom(17);
                map.panTo(currentMarker.position);
                infowindow.open(map, currentMarker);
            });

            markers.push(currentMarker);
        });
        var bounds = new google.maps.LatLngBounds();
        for (i = 0; i < markers.length; i++) {
            bounds.extend(markers[i].getPosition());
        }
        map.fitBounds(bounds);
    }

// [START region_fillform]
    function fillInAddress() {
        // Get the place details from the autocomplete object.
        var place = autocomplete.getPlace();
        console.log("latitude " + place.geometry.location.lat());
        console.log("longitude " + place.geometry.location.lng());

        document.getElementById("latitude").value = place.geometry.location.lat();
        document.getElementById("longitude").value = place.geometry.location.lng();

        var infowindow = new google.maps.InfoWindow({
            content: $("#address").val()
        });

        var marker = new google.maps.Marker({
            position: place.geometry.location,
            map: map,
            title: $("#address").val()
        });

        marker.addListener('click', function () {
            map.setZoom(17);
            map.panTo(marker.position);
            infowindow.open(map, marker);
        });
        dropMarkersOnMap()
    }
// [END region_fillform]

// [START region_geolocation]
// Bias the autocomplete object to the user's geographical location,
// as supplied by the browser's 'navigator.geolocation' object.
    function geolocate() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (position) {
                var geolocation = {
                    lat: position.coords.latitude,
                    lng: position.coords.longitude
                };
                var circle = new google.maps.Circle({
                    center: geolocation,
                    radius: position.coords.accuracy
                });
                autocomplete.setBounds(circle.getBounds());
                map.setCenter(new google.maps.LatLng(position.coords.latitude, position.coords.longitude))
            });
        }
    }
// [END region_geolocation]


    var successCallback = function(responseJson){
        console.log(responseJson);
        locationList = responseJson.map(function(obj){
            var rObj = {};
            rObj.lat=obj.geoLocation.x;
            rObj.long=obj.geoLocation.y;
            rObj.message=obj.name;
            rObj.fullAddress=obj.address;
            return rObj;
        });
        dropMarkersOnMap();
    };

    function searchAvailabelLocations(){
        var queryParams = $("#searchForm").serialize();
        delete queryParams.address;
        $.ajax({
            url: "/advertisement/index.json",
            method: "GET",
            data: queryParams,
            dataType: "json",
            success : successCallback
        });
    }

