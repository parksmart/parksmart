<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="themeMain"/>
  <title></title>
</head>
<body>


<h2>Book your Parking slot and a cycle now.</h2>

<div class="col-sm-6">
    <form role="form" lpformnum="1" >

        <div class="form-group">
            <div class="radio">
                <label>
                    <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">
                    Parking only
                </label>
            </div>

            <div class="radio">
                <label>
                    <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">
                    Cycle Only
                </label>
            </div>

            <div class="radio">
                <label>
                    <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">
                    Parking and Cycle both
                </label>
            </div>
        </div>

        <div class="form-group">
            <label for="exampleInputEmail1">Name</label>
            <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter your Name" autocomplete="off" style="cursor: auto; background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAASCAYAAABSO15qAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH3QsPDhss3LcOZQAAAU5JREFUOMvdkzFLA0EQhd/bO7iIYmklaCUopLAQA6KNaawt9BeIgnUwLHPJRchfEBR7CyGWgiDY2SlIQBT/gDaCoGDudiy8SLwkBiwz1c7y+GZ25i0wnFEqlSZFZKGdi8iiiOR7aU32QkR2c7ncPcljAARAkgckb8IwrGf1fg/oJ8lRAHkR2VDVmOQ8AKjqY1bMHgCGYXhFchnAg6omJGcBXEZRtNoXYK2dMsaMt1qtD9/3p40x5yS9tHICYF1Vn0mOxXH8Uq/Xb389wff9PQDbQRB0t/QNOiPZ1h4B2MoO0fxnYz8dOOcOVbWhqq8kJzzPa3RAXZIkawCenHMjJN/+GiIqlcoFgKKq3pEMAMwAuCa5VK1W3SAfbAIopum+cy5KzwXn3M5AI6XVYlVt1mq1U8/zTlS1CeC9j2+6o1wuz1lrVzpWXLDWTg3pz/0CQnd2Jos49xUAAAAASUVORK5CYII=); background-attachment: scroll; background-position: 100% 50%; background-repeat: no-repeat;">
        </div>

        <div class="form-group" style="display:flex;">
            <label for="exampleInputPassword1">Start Date</label>
            <g:datePicker name="startDate" class="form-control" precision="day"/>
        </div>

        <div class="form-group" style="display:flex;">
            <label for="exampleInputPassword1" >End Date</label>
            <g:datePicker name="endDate" class="form-control" precision="day"/>
        </div>

        %{--<button type="submit" class="btn btn-default ">Book Now</button>--}%
    </form>
</div>

<div class="col-sm-6">

    <div class="box-style-1 white-bg object-non-visible animated object-visible fadeInUpSmall" data-animation-effect="fadeInUpSmall" data-effect-delay="200">
        %{--<i class="fa fa-laptop"></i>--}%
        <h2>A cool parking with a smart cycle</h2>


        <dl class="dl-horizontal">
            <dt>Owned by</dt>
            <dd>John Doe</dd>
        </dl>

        <dl class="dl-horizontal">
            <dt>Parking</dt>
            <dd>Available for Sep15-Sep20, Sep22-Sep28 and Sep30 at Rs 30/- per day.</dd>
        </dl>

        <dl class="dl-horizontal">
            <dt>Cycle</dt>
            <dd>Available for Sep15-Sep20, Sep22-Sep28 and Sep30 at Rs 30/- per day.</dd>
        </dl>

        %{--<dl class="dl-horizontal">--}%
            %{--<dt>Availability</dt>--}%
            %{--<dd>--}%
                %{--<table class="table table-hover">--}%
                    %{--<thead>--}%
                    %{--<tr>--}%
                        %{--<td>Name</td>--}%
                        %{--<td>Availability</td>--}%
                    %{--</tr>--}%
                    %{--</thead>--}%
                    %{--<tbody>--}%
                    %{--<tr>--}%
                        %{--<td>Parking</td>--}%
                        %{--<td>--}%
                            %{--<ul>--}%
                                %{--<li>Sep15-Sep20</li>--}%
                                %{--<li>Sep21-Sep28</li>--}%
                            %{--</ul>--}%
                        %{--</td>--}%
                    %{--</tr>--}%

                    %{--<tr>--}%
                        %{--<td>Cycle</td>--}%
                        %{--<td>--}%
                            %{--<ul>--}%
                                %{--<li>Sep15-Sep20</li>--}%
                                %{--<li>Sep21-Sep28</li>--}%
                            %{--</ul>--}%
                        %{--</td>--}%
                    %{--</tr>--}%


                    %{--</tbody>--}%

                %{--</table>--}%

            %{--</dd>--}%
        %{--</dl>--}%
        %{--<p>Iure sequi unde hic. Sapiente quaerat labore sequi inventore veritatis cumque.</p>--}%
        <a href="page-services.html" class="">View more Details</a>
    </div>

</div>

<div class="col-sm-5 col-sm-offset-4">
    <button type="submit" class="btn btn-lg btn-default ">Book Now</button>
</div>


<g:javascript>

 $(function(){
     $('select').addClass('form-control').css("width", "25%");
 })

</g:javascript>
</body>
</html>