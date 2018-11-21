<!DOCTYPE html>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html lang="en">
    <tiles:insertAttribute name="dashboard.head"/>
    <body>
        <div class="parallax-mirror" style="visibility: hidden; z-index: -100; position: fixed; top: 0px; left: 0px; overflow: hidden; height: 0px; width: 0px; transform: translate3d(0px, 251px, 0px);"><img class="parallax-slider" src="images/newsletter.jpg" style="position: absolute; height: 0px; width: 0px; max-width: none; transform: translate3d(0px, -50.2px, 0px);"></div><div class="parallax-mirror" style="visibility: hidden; z-index: -100; position: fixed; top: 0px; left: 0px; overflow: hidden; height: 0px; width: 0px; transform: translate3d(0px, 563.547px, 0px);"><img class="parallax-slider" src="images/team_background.jpg" style="position: absolute; height: 0px; width: 0px; max-width: none; transform: translate3d(0px, -112.709px, 0px);"></div><div class="parallax-mirror" style="visibility: hidden; z-index: -100; position: fixed; top: 0px; left: 0px; overflow: hidden; height: 0px; width: 0px; transform: translate3d(0px, 289px, 0px);"><img class="parallax-slider" src="images/courses_background.jpg" style="position: absolute; height: 0px; width: 0px; max-width: none; transform: translate3d(0px, -57.8px, 0px);"></div>

        <div class="super_container">

            <!-- Header -->

            <header class="header">

                <!-- Top Bar -->
                <tiles:insertAttribute name="dashboard.topbar"/>

                <!-- Header Content -->
                <tiles:insertAttribute name="dashboard.header_content"/>

                <!-- Header Search Panel -->
                <tiles:insertAttribute name="dashboard.header_search_panel"/>
            </header>

            <!-- Menu -->
            <tiles:insertAttribute name="dashboard.menu"/>


            <!-- Home -->
            <tiles:insertAttribute name="dashboard.home"/>




            <!-- Footer -->

            <tiles:insertAttribute name="dashboard.footer"/>
        </div>
        <tiles:insertAttribute name="dashboard.bottom_script"/>


    </body>
</html>