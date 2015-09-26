<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="themeMain"/>
    <title>Search Parking and Cycles</title>
</head>

<body>

<div class="container-fluid">

    <form class="form-inline text-center" id="searchForm">

        <input type="hidden" id="latitude" name="latitude"/>
        <input type="hidden" id="longitude" name="longitude"/>

        <div class="form-group">
            <label class="sr-only" for="address">Address</label>
            <input type="text" onFocus="geolocate()" class="form-control" id="address"  placeholder="Address">
        </div>

        <div class="form-group">
            <label class="sr-only" for="radiusInKm">Radius</label>
            <input type="number" min="0"  class="form-control" id="radiusInKm" name="radiusInKm" placeholder="Radius In Km">
        </div>

        <div class="form-group">
            <label class="sr-only" for="startDate">Start Date</label>
            <input type="date" class="form-control" id="startDate" name="startDate" placeholder="Start Date">
        </div>

        <div class="form-group">
            <label class="sr-only" for="endtDate">End Date</label>
            <input type="date" class="form-control" id="endtDate" name="endtDate" placeholder="End Date">
        </div>



        <button type="button" onclick="searchAvailabelLocations()" class="btn btn-default">Search</button>
    </form>

    <div class="row">
        <div class="col-sm-10 col-sm-offset-1" >
            <div id="map" style="height: 300px;"></div>
        </div>
    </div>
    <br/><br/>
</div>



<asset:javascript src="searchLocation.js"/>
<script src="https://maps.googleapis.com/maps/api/js?libraries=places&callback=initAutocomplete"
        async defer></script>
</body>
</html>