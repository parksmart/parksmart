<%@ page import="com.parksmart.com.parksmart.enums.DayType" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Advertisement</title>
    <link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500">

</head>

<body>

<div class="container-fluid">

    <legend>Advertisement</legend>

    <g:render template="/templates/errorContainer" model="[object: advertisement]"/>

    <g:form controller="advertisement" action="save" class="form-horizontal">
        <input type="hidden" id="id" name="id" value="${advertisement?.id}"/>
        <input type="hidden" id="locality" name="city" value="${advertisement?.city}"/>
        <input type="hidden" id="route" name="locality" value="${advertisement?.locality}"/>
        <input type="hidden" id="location-lat" name="location" value="${advertisement?.location ? advertisement?.location[0] : ''}"/>
        <input type="hidden" id="location-long" name="location" value="${advertisement?.location ? advertisement?.location[1] : ''}"/>

        <div class="row">

            <div class="col-sm-6">
                <form:textField label="Name/Title" name="name" value="${advertisement?.name}"/>
                <form:textField label="Address" onFocus="geolocate()" name="address" value="${advertisement?.address}"/>

                <div class="form-group">
                    <label for="numberOfParkingSlots" class="col-sm-3 control-label">Number of parking slots</label>

                    <div class="col-sm-3">
                        <input id="numberOfParkingSlots" type="number" name="numberOfParkingSlots" min="0"
                               class="form-control"
                               value="${advertisement?.numberOfParkingSlots}" placeholder="Number of parking slots"/>
                    </div>

                    <label for="pricePerParkingSlot" class="col-sm-3 control-label">Price per parking slot</label>

                    <div class="col-sm-3">
                        <input id="pricePerParkingSlot" type="number" name="pricePerParkingSlot" min="0"
                               class="form-control"
                               value="${advertisement?.pricePerParkingSlot}" placeholder="Price per parking slot"/>
                    </div>

                </div>

                <div class="form-group">
                    <label for="numberOfCycles" class="col-sm-3 control-label">Number of cycles</label>

                    <div class="col-sm-3">
                        <input type="number" id="numberOfCycles" name="numberOfCycles" min="0" class="form-control"
                               value="${advertisement?.numberOfCycles}" placeholder="Number of cycles"/>
                    </div>

                    <label for="pricePerCycle" class="col-sm-3 control-label">Price per cycle</label>

                    <div class="col-sm-3">
                        <input type="number" id="pricePerCycle" name="pricePerCycle" min="0" class="form-control"
                               value="${advertisement?.pricePerCycle}" placeholder="Price per cycle"/>
                    </div>

                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">Delivery Days</label>

                    <div class="col-sm-9">

                        <g:each in="${DayType.values()}" var="day">
                            <div class="time-slot-check-box">
                                ${day.shortName}<br/>
                                <g:checkBox title="${day}" name="daysAvailable"
                                            checked="${advertisement?.daysAvailable?.contains(day.jodaDayValue)}"
                                            value="${day.jodaDayValue}"/>
                            </div>
                        </g:each>

                    </div>
                </div>
            </div>

            <div class="col-sm-6">
                <div id="map" class="col-sm-12" style="height: 300px;"></div>
            </div>

        </div>


        <div class="form-group">
            <div class="col-sm-6 text-center">
                <button type="submit" class="btn btn-default">Create</button>
            </div>
        </div>
    </g:form>

</div>


<script>
    // This example displays an address form, using the autocomplete feature
    // of the Google Places API to help users fill in the information.

    var placeSearch, autocomplete, map;
    var componentForm = {
        route: 'long_name',
        locality: 'long_name'
    };

    var locationList = [{lat: 28.5383658, long: 77.3496595, message: "Location A"}, {
        lat: 38.5383658,
        long: 77.3496595,
        message: "Location B"
    }, {lat: 28.5383658, long: 67.3496595, message: "Location C"}];

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

        document.getElementById("location-lat").value = place.geometry.location.lat()+"d";
        document.getElementById("location-long").value = place.geometry.location.lng()+"d";


        for (var component in componentForm) {
            document.getElementById(component).value = '';
        }


        // Get each component of the address from the place details
        // and fill the corresponding field on the form.
        for (var i = 0; i < place.address_components.length; i++) {
            var addressType = place.address_components[i].types[0];
            if (componentForm[addressType]) {
                console.log(place.address_components[i]);
                var val = place.address_components[i][componentForm[addressType]];
                document.getElementById(addressType).value = val;
            }
        }

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

</script>
<script src="https://maps.googleapis.com/maps/api/js?libraries=places&callback=initAutocomplete"
        async defer></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

</body>
</html>