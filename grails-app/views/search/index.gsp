<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="themeMain"/>
    <title>Search Parking and Cycles</title>
</head>

<body>

<div class="container-fluid">

    <div class="row">
        <div class="col-sm-3">
            <form class="form-group text-center" id="searchForm">

                <input type="hidden" id="latitude" name="latitude"/>
                <input type="hidden" id="longitude" name="longitude"/>

                <div class="form-group">
                    <label class="pull-left" for="address">Address</label>
                    <input type="text" onFocus="geolocate()" class="form-control" id="address" placeholder="Address">
                </div>

                <div class="form-group">
                    <label class="pull-left" for="radiusInKm">Radius</label>
                    <input type="number" min="0" class="form-control" id="radiusInKm" name="radiusInKm"
                           placeholder="Radius In Km" value="5">
                </div>

                <div class="form-group">
                    <label class="pull-left" for="startDate">Start Date</label>
                    <input type="date" class="form-control" id="startDate" name="startDate" placeholder="Start Date" value="${new Date()?.format("yyyy-MM-dd")}">
                </div>

                <div class="form-group">
                    <label class="pull-left" for="endDate">End Date</label>
                    <input type="date" class="form-control" id="endDate" name="endDate" placeholder="End Date" value="${(new Date() + 7)?.format("yyyy-MM-dd")}">
                </div>



                <button type="button" onclick="searchAvailabelLocations()" class="btn btn-default">Search</button>
            </form>
        </div>

        <div class="col-sm-9">
            <div class="row">
                <div class="col-sm-11 col-sm-offset-1">
                    <div id="map" style="height: 300px; margin-top: 40px;"></div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-10 col-sm-offset-1" id="cards-div">

        </div>
    </div>

</div>



<asset:javascript src="searchLocation.js"   />
<script src="https://maps.googleapis.com/maps/api/js?libraries=places&callback=initAutocomplete"
        async defer></script>
</body>
</html>