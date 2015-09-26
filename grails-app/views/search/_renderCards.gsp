<g:each in="${advertisements}" var="advertisement">
    <div class="col-sm-12">
        <div class="panel panel-default">
            <div class="panel-heading text-center">
                <b>${advertisement?.name}</b>
            </div>

            <div class="panel-body">
                <div class="col-sm-2">
                    <i style="margin-right: 20px;" class="fa fa-car fa-3x ${advertisement?.numberOfParkingSlots ? 'green' : 'grey'}"></i>
                    <i class="fa fa-bicycle fa-3x ${advertisement?.numberOfCycles ? 'green' : 'grey'}"></i>
                </div>

                <div class="col-sm-10">
                    <ps:fieldValue fieldName="Address" value="${advertisement?.address}"/>
                    <ps:fieldValue fieldName="Available On" value="${advertisement?.daysAvailable*.shortName?.join(", ")}"/>
                    <ps:fieldValue fieldName="Parking Rent/Day" value="${advertisement?.pricePerParkingSlot}">
                        <i class="fa fa-inr"></i>
                    </ps:fieldValue>
                    <ps:fieldValue fieldName="Cycle Rent/Day" value="${advertisement?.pricePerCycle}"/>

                </div>
            </div>
            <div class="panel-footer text-right" style="padding-top: 0px; padding-bottom: 0px;">
                <a class="btn btn-sm btn-default" href="#"> Book Now </a>
            </div>
        </div>
    </div>
</g:each>