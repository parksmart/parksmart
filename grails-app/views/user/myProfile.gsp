<%@ page import="java.math.MathContext; com.parksmart.Advertisement" contentType="text/html;charset=UTF-8" %>
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
        <li class="">
            <a data-toggle="tab" role="tab" href="#stats" aria-expanded="false">
                <i class="fa fa-bar-chart pr-5"></i>
                Stats
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
        <div id="stats" class="tab-pane fade">

            <div class="col-sm-12">
                <div class="panel panel-default">
                    <div class="panel-heading text-center" style="padding: 15px;">
                        <b>Health Benefits</b>
                    </div>
                    <div class="panel-body">
                        <div class="col-sm-2">
                            <i class="fa fa-globe fa-3x"></i>
                        </div>
                        <div class="col-sm-8">
                            <ps:fieldValue fieldName="You cycled" value="${myBookingDaysCount*15} mins"/>
                            <ps:fieldValue fieldName="You burned" value="${myBookingDaysCount*15 * 10} Calories"/>
                            <ps:fieldValue fieldName="You reduced carbon emission by" value="${myBookingDaysCount*15 *(30*5/120)} gms"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-sm-12">
                <div class="panel panel-default">
                    <div class="panel-heading text-center" style="padding: 15px;">
                        <b>Financial Benefits</b>
                    </div>
                    <div class="panel-body">
                        <div class="col-sm-2">
                            <i class="fa fa-rupee fa-3x"></i>
                        </div>
                        <div class="col-sm-8">
                            <ps:fieldValue fieldName="You saved" value="${((myBookingDaysCount*15 * (1/60)) * 100).toInteger().toBigDecimal() / 100    } litre of fuel"/>

                            <ps:fieldValue fieldName="You saved " value="Rs ${myBookingDaysCount*15} on your gym subscription"/>
                            <ps:fieldValue fieldName="You saved " value="1 hr from Gym by cycling to work"/>
                            <ps:fieldValue fieldName="You saved " value="1 hr from commute time"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>