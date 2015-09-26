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
            <g:render template="/search/renderCards" model="[advertisements : advertisementList, ifViewerIsOwner:true]"/>
            <g:if test="${!advertisementList}">
                <div>
                    You have not rented out any advertisements yet.
                </div>
            </g:if>
        </div>
        <div id="rentOutAds" class="tab-pane fade">
            <g:render template="/search/renderCards" model="[advertisements : rentOutAdvertisementList, ifViewerIsOwner:true]"/>
            <g:if test="${!rentOutAdvertisementList}">
                <div>
                        You have not rented out any advertisements yet.
                </div>
            </g:if>
        </div>
        <div id="bookings" class="tab-pane fade">
            <div class="space-bottom"></div>
            <div class="row">
                <g:set var="dateFormat" value="MM/dd/yyyy"/>
                <table class="table table-hover">
                    <tr>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Parking</th>
                        <th>Bicycle</th>
                        <th>Amount</th>
                    </tr>
                    <g:each in="${bookingList}" var="booking">
                    %{--<g:each in="${[1, 2, 3 ,4]}" var="booking">--}%
                        <tr>
                            <td><g:formatDate date="${booking.startDate}" format="${dateFormat}"/> </td>
                            %{--<td><g:formatDate date="${new Date()}" format="${dateFormat}"/> </td>--}%
                            <td><g:formatDate date="${booking.endDate}" format="${dateFormat}"/></td>
                            %{--<td><g:formatDate date="${new Date().minus(5)}" format="${dateFormat}"/></td>--}%
                            <td>
                                <g:if test="${booking?.isParking}">
                                    <i class="fa fa-2x fa-car"></i>
                                </g:if>
                            </td>
                            <td>
                                <g:if test="${booking?.isParking}">
                                    <i class="fa fa-2x fa-bicycle"></i>
                                </g:if>
                            </td>
                            <td>
                                %{--${booking * 100}--}%
                                ${booking.amount}
                            </td>
                        </tr>
                    </g:each>
                    <g:if test="${!bookingList}">
                        <tr>
                            <td colspan="5">
                                You do not have any bookings yet.
                            </td>
                        </tr>
                    </g:if>
                </table>
            </div>
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