<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title></title>
    <meta name="layout" content="themeMain"/>
    <title>Advertisement</title>
    <link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500">
</head>
<body>

<h2>Advertisement Details</h2>

<div class="container">

    <div class="row">

        <div class="col-sm-6">
            <dl >
                <dt>Title</dt>
                <dd>${advertisementInstance.name}</dd>
            </dl>


            <dl >
                <dt>Address</dt>
                <dd>${advertisementInstance.address}</dd>
            </dl>

            <dl >
                <dt>Parking slots</dt>
                <dd>${advertisementInstance.numberOfParkingSlots} slots available at Rs ${advertisementInstance.pricePerParkingSlot} per per slot per day</dd>
            </dl>

            <dl >
                <dt>Cycle</dt>
                <dd>${advertisementInstance.numberOfCycles} cycles available at Rs ${advertisementInstance.pricePerCycle}</dd>
            </dl>
        </div>
        <div class="col-sm-6">

        </div>

    </div>
</div>

</body>
</html>