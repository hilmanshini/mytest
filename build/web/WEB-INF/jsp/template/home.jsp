<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="home">
    <div class="home_slider_container">

        <!-- Home Slider -->
        <div class="owl-carousel owl-theme home_slider">



            <!-- Home Slider Item -->
            <c:forEach var="i"  begin="0" end="3">
                <!-- Home Slider Item -->
                <div class="owl-item">
                    <div class="home_slider_background" style="background-image:url(images/home_slider_1.jpg)"></div>
                    <div class="home_slider_content">
                        <div class="container">
                            <div class="row">
                                <div class="col text-center">
                                    <div class="home_slider_title">Welcome to Etiqa University</div>
                                    <div class="home_slider_subtitle">Future Of Education Technology</div>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>

    <!-- Home Slider Nav -->

    
</div>
