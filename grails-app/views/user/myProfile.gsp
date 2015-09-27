<%@ page import="com.parksmart.Advertisement" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="themeMain"/>
    <title>My Profile</title>
</head>

<body>
<div class="tabs-style-2 col-lg-12" style="padding-left:80px">
    <!-- Nav tabs -->
    <ul role="tablist" class="nav nav-tabs">
        <li class="active">
            <a data-toggle="tab" role="tab" href="#ads" aria-expanded="true">
                <i class="fa fa-automobile pr-5"></i>My Advertisements
            </a>
        </li>
        <li class="">
            <a data-toggle="tab" role="tab" href="#rentOutAds" aria-expanded="false">
                <i class="fa fa-dollar pr-5"></i>My Rent-out Bookings
            </a>
        </li>
        <li>
            <a data-toggle="tab" role="tab" href="#bookings" aria-expanded="true">
                <i class="fa fa-automobile pr-5"></i>My Bookings
            </a>
        </li>

        <li class="">
            <a data-toggle="tab" role="tab" href="#profile" aria-expanded="false">
                <i class="fa fa-user pr-5"></i>
                Profile
            </a>
        </li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
        <div id="ads" class="tab-pane fade active in">


            <g:if test="${!myAdvertisementList}">
                <div class="h3">
                    You have not posted any advertisements yet.
                </div>
            </g:if>
            <g:else>
                <h3>
                    Showing the advertisements posted by you
                </h3>
                <g:render template="/search/renderCards" model="[advertisements : myAdvertisementList , ifViewerIsOwner:true]"/>
            </g:else>
        </div>

        <div id="rentOutAds" class="tab-pane fade">
            <g:if test="${!myRentOutBookings}">
                <h3>
                        You have not recieved any bookings against your advertisements.
                </h3>
            </g:if>
            <g:else>
                <g:render template="/booking/bookingCard" model="[bookings : myRentOutBookings]"/>
            </g:else>
        </div>

        <div id="bookings" class="tab-pane fade">
            <g:if test="${!myBookingList}">
                <h3>
                    You have not booked any parking or bicycles yet.
                </h3>
            </g:if>
            <g:else>

                <g:render template="/booking/bookingCard" model="[bookings : myBookingList]"/>

            </g:else>

        </div>
        <div id="profile" class="tab-pane fade">
            <dl class="dl-horizontal">
                <dt>Name</dt>
                <dd>${currentUser?.name}</dd>
                <dt>Username</dt>
                <dd>${currentUser?.username}</dd>
                <dt>Phone</dt>
                <dd>${currentUser?.mobileNumber}</dd>
            </dl>
            <hr>

        </div>
    </div>
</div>
</body>
</html>