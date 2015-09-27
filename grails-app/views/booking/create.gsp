
<%@ page import="com.parksmart.Advertisement" contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <meta name="layout" content="themeMain"/>
    <title>Booking</title>
</head>

<body>
<div class="container-fluid">


    <g:render template="/templates/errorContainer" model="[object: booking]"/>
    <h2>Book your Parking slot and a cycle now.</h2>

    <div class="col-sm-4">
        <g:form class="form" controller="booking" action="save">

                <g:hiddenField name="advertisementId" value="${params.advertisementId}"/>
                <div class="form-group">
                    <div class="check-box">
                        <label>
                            <g:checkBox name="isParking" value="${booking?.isParking}"/>
                            Parking
                        </label>
                    </div>
                </div>

                <div class="form-group">
                    <label class="check-box">
                        <g:checkBox name="optionsRadios" id="optionsRadios1" value="${booking?.isCycle}"/>
                        Cycle
                    </label>
                </div>

                <div class="form-group">
                    <label for="startDate" class="control-label ">Start Date</label>

                        <input type="date" name="startDate" id="startDate" class="form-control"
                               value="${booking?.startDate}"/>
                </div>

                <div class="form-group">
                    <label for="endDate" class="control-label">End Date</label>
                        <input name="endDate" id="endDate" type="date" class="form-control" value="${booking?.endDate}"/>
                </div>
            <button type="submit" class="btn btn-default ">Book Now</button>
        </g:form>
    </div>

    <div class="col-sm-8">

        <div class="box-style-1 white-bg object-non-visible animated object-visible fadeInUpSmall"
             data-animation-effect="fadeInUpSmall" data-effect-delay="200">
            %{--<i class="fa fa-laptop"></i>--}%
            <h2>A cool parking with a smart cycle</h2>


            <dl class="dl-horizontal">
                <dt>Owned by</dt>
                <dd>${Advertisement.get(params.advertisementId)?.owner?.name}</dd>
            </dl>

            <dl class="dl-horizontal">
                <dt>Parking</dt>
                <dd>Available for Sep15-Sep20, Sep22-Sep28 and Sep30 at Rs 30/- per day.</dd>
            </dl>

            <dl class="dl-horizontal">
                <dt>Cycle</dt>
                <dd>Available for Sep15-Sep20, Sep22-Sep28 and Sep30 at Rs 30/- per day.</dd>
            </dl>

            <a href="page-services.html" class="">View more Details</a>
        </div>

    </div>



    <g:javascript>

        $(function () {
            $('select').addClass('form-control').css("width", "25%");
        })

    </g:javascript>
</div>

</body>
</html>