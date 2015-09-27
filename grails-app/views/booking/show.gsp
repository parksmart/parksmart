<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="themeMain"/>
    <title>Booking</title>
    %{--<link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500">--}%
</head>
<body>


<div class="container">

    <h2>Details for Booking id: ${bookingInstance?.bookingId}</h2>

    <div class="row">

        <div class="col-sm-6">

            <div class="row">
                <g:if test="${bookingInstance?.isParking}">
                    <i class="fa fa-automobile 3x"></i>
                </g:if>
                <g:if test="${bookingInstance?.isCycle}">
                    <i class="fa fa-bicycle 3x"></i>
                </g:if>
            </div>

            <dl >
                <dt>Booking Date</dt>
                <dd>${bookingInstance?.dateCreated?.format('dd-MMM-yyyy HH:mm:aa')}</dd>
            </dl>

            <dl >
                <dt>Title</dt>
                <dd>${bookingInstance?.advertisement?.name}</dd>
            </dl>

            <dl >
                <dt>Property Owner</dt>
                <dd class="text-capitalize">${bookingInstance?.owner?.name} - ${bookingInstance?.owner?.mobileNumber}</dd>
            </dl>
            <dl >
                <dt>Booked By</dt>
                <dd class="text-capitalize">${bookingInstance.customer?.name} - ${bookingInstance?.customer?.mobileNumber}</dd>
            </dl>

            <dl>
                <dt>Booking period</dt>
                <dd>${bookingInstance.startDate?.format('dd-MMM-yyyy')} - ${bookingInstance.endDate?.format('dd-MMM-yyyy')}</dd>
            </dl>

            <dl >
                <dt>Amount</dt>
                <dd>${bookingInstance?.amount}</dd>
            </dl>

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

        var position = new google.maps.LatLng(${bookingInstance?.advertisement?.location[0]}, ${bookingInstance?.advertisement.location[1]});

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