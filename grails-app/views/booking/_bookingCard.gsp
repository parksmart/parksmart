<g:each in="${bookings}" var="booking">
    <div class="col-sm-12">
        <div class="panel panel-default">
            <div class="panel-heading text-center">
                <b>${booking?.bookingId}</b>
                <b> - ${booking?.advertisement?.name} </b>
            </div>

            <div class="panel-body">

                <div class="col-sm-2">

                    <g:if test="${booking?.isParking}">
                        <i style="margin-right: 20px;" class="fa fa-car fa-3x"></i>
                    </g:if>

                    <g:if test="${booking?.isCycle}">
                        <i class="fa fa-bicycle fa-3x"></i>
                    </g:if>

                </div>

                <div class="col-sm-8">
                    <ps:fieldValue fieldName="Booking Date" value="${booking?.dateCreated?.format('MM/dd/yyyy')}"/>
                    <ps:fieldValue fieldName="Booked By" value="${booking?.customer?.name}"/>
                    <ps:fieldValue fieldName="Phone Number" value="${booking?.customer?.mobileNumber}"/>
                    <ps:fieldValue fieldName="Email" value="${booking?.customer?.username}"/>
                    <ps:fieldValue fieldName="Start Date" value="${booking?.startDate?.format("MM/dd/yyyy")}"/>
                    <ps:fieldValue fieldName="End Date" value="${booking?.endDate?.format("MM/dd/yyyy")}"/>
                    <ps:fieldValue fieldName="Amount" value="${booking?.amount}"/>

                </div>

                <div class="col-sm-2">
                    <a href="${createLink(controller: 'booking', action: 'show', id: booking?.id)}" class="btn btn-default">View Details</a>
                </div>
            </div>

        </div>
    </div>
</g:each>