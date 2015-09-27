

<g:each in="${advertisements}" var="advertisement">
    <div class="col-sm-12">
        <div class="panel panel-default">
            <div class="panel-heading text-center result-card-title" style="padding: 15px;;">
                <b>${advertisement?.name}</b>
            </div>

            <div class="panel-body">
                <div class="col-sm-2">

                    <g:if test="${advertisement?.numberOfParkingSlots}">
                        <i style="margin-right: 20px;" class="fa fa-car fa-3x"></i>
                    </g:if>

                    <g:if test="${advertisement?.numberOfCycles}">
                        <i class="fa fa-bicycle fa-3x"></i>
                    </g:if>

                </div>

                <div class="col-sm-10">
                    <ps:fieldValue fieldName="Address" value="${advertisement?.address}"/>
                    <ps:fieldValue fieldName="Available On" value="${advertisement?.daysAvailable*.shortName?.join(", ")}"/>
                    <ps:fieldValue fieldName="Contact" value="${advertisement?.owner?.name} - ${advertisement?.owner?.mobileNumber}"/>
                    <g:if test="${advertisement?.numberOfParkingSlots}">
                        <ps:fieldValue fieldName="Parking Rent/Day" value="${advertisement?.pricePerParkingSlot}">
                            <i class="fa fa-inr"></i>
                        </ps:fieldValue>
                    </g:if>

                    <g:if test="${advertisement?.numberOfCycles}">
                        <ps:fieldValue fieldName="Cycle Rent/Day" value="${advertisement?.pricePerCycle}"/>
                    </g:if>
                    <input type="hidden" id="username" value="${advertisement?.owner?.name}"/>
                    <input type="hidden" id="advertisementId" value="${advertisement?.id}"/>

                </div>

                <div class="row">
                    <div class="col-sm-offset-8 col-sm-2">
                        <a href="${createLink(controller: 'advertisement', action: 'show', id: advertisement?.id)}" class="btn btn-default">View Details</a>

                    </div>
                    <div class="col-sm-2">
                        <a class="btn btn-default" href="${createLink(controller: 'booking', action: 'create', params: [advertisementId : advertisement?.id])}"> Book Now </a>
                    </div>


                </div>



            </div>

            <g:if test="${!ifViewerIsOwner}">
                <div class="panel-footer text-right" style="padding-top: 0px; padding-bottom: 0px;">


                </div>
            </g:if>
        </div>
    </div>
</g:each>