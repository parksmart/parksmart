<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title></title>
    <meta name="layout" content="themeMain"/>
    <title>Advertisement</title>
    %{--<link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500">--}%
</head>
<body>


<div class="container">

<h2>Advertisement Details</h2>



    <div class="row container-fluid">

        <div class="col-sm-6">

            <dl >
                <dt>Title</dt>
                <dd>${advertisementInstance.name}</dd>
            </dl>


            <dl >
                <dt>Address</dt>
                <dd>${advertisementInstance.address}</dd>
            </dl>

            <g:if test="${advertisementInstance.numberOfParkingSlots}">
                <dl>
                    <dt>Parking</dt>
                    <dd>${advertisementInstance.numberOfParkingSlots == 1 ? 'Parking': "${advertisementInstance.numberOfParkingSlots} Parking slots"} available at Rs ${advertisementInstance.pricePerParkingSlot} per per slot per day</dd>
                </dl>
            </g:if>
            <g:if test="${advertisementInstance.numberOfCycles}">
                <dl >
                    <dt>Cycle</dt>
                    <dd>${advertisementInstance.numberOfCycles==1?'Cycle':"${advertisementInstance.numberOfCycles} Cycles"} available at Rs ${advertisementInstance.pricePerCycle}</dd>
                </dl>
            </g:if>

            <dl >
                <dt>Timings</dt>
                <dd>${advertisementInstance.startTime}hrs - ${advertisementInstance.endTime}hrs</dd>
            </dl>

            <dl >
                <dt>Days</dt>
                <dd>${advertisementInstance?.daysAvailable*.toString()?.join(',')}</dd>
            </dl>

            <a href="${g.createLink(controller: 'booking', action: 'create', params: [advertisementId : advertisementInstance?.id])}" class="btn btn-default btn-lg">Book now</a>

        </div>
        <div class="col-sm-6">
            <div id="map" class="col-sm-12" style="height: 300px;"></div>
        </div>

    </div>
</div>
<g:javascript>


    function initAutocomplete() {
        // Create the autocomplete object, restricting the search to geographical
        // location types.

        var position = new google.maps.LatLng(${advertisementInstance.location[0]}, ${advertisementInstance.location[1]});

        var mapProp = {
            center: position,
            zoom: 13,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        map = new google.maps.Map(document.getElementById('map'), mapProp);


         var marker = new google.maps.Marker({
            position: position,
            map: map,
            title: $("#address").val()
        });

    }

</g:javascript>

<script src="https://maps.googleapis.com/maps/api/js?libraries=places&callback=initAutocomplete"
        async defer></script>
%{--<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>--}%

</body>
</html>