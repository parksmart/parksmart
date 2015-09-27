

<g:each in="${advertisements}" var="advertisement">
    <div class="col-sm-12">
        <div class="panel panel-default">
            <div class="panel-heading text-center">
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
                    <g:if test="${advertisement?.numberOfParkingSlots}">
                        <ps:fieldValue fieldName="Parking Rent/Day" value="${advertisement?.pricePerParkingSlot}">
                            <i class="fa fa-inr"></i>
                        </ps:fieldValue>
                    </g:if>

                    <g:if test="${advertisement?.numberOfCycles}">
                        <ps:fieldValue fieldName="Cycle Rent/Day" value="${advertisement?.pricePerCycle}"/>
                    </g:if>

                    %{--These hidden field are requied for the mobile site--}%
                    <input type="hidden" id="username" value="${advertisement?.owner?.name}"/>
                    <input type="hidden" id="advertisementId" value="${advertisement?.id}"/>
                    <input type="hidden" id="ownerId" value="${advertisement?.ownerId}"/>

                </div>


            </div>

            <div class="row">
                <div class="col-sm-2 col-sm-offset-7">
                    <a href="${createLink(controller: 'advertisement', action: 'show', id: advertisement?.id)}" class="btn btn-default">View Details</a>
                </div>
            </div>
            <g:if test="${!ifViewerIsOwner}">
                <div class="panel-footer text-right" style="padding-top: 0px; padding-bottom: 0px;">
                    <a class="btn btn-sm btn-default" href="${createLink(controller: 'booking', action: 'create', params: [advertisementId : advertisement?.id])}"> Book Now </a>
                </div>
            </g:if>
        </div>
    </div>
</g:each>