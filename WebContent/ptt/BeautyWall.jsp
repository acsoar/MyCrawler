<%@page import="java.util.*"%>
<%@page import="crawler.example.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>正妹圖庫</title>
 
<!-- Example code from  -->
<!--   http://creotiv.github.io/jquery-photowall/  -->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="http://creotiv.github.io/jquery-photowall/jquery-photowall/jquery-photowall.js"></script>
<link rel="stylesheet" type="text/css" href="http://creotiv.github.io/jquery-photowall/jquery-photowall/jquery-photowall.css">
<script type="text/javascript">
$(document).ready(function(){
    PhotoWall.init({
        el:             '#gallery'               // Gallery element
        ,zoom:          true                     // Use zoom
        ,zoomAction:    'mouseenter'             // Zoom on action
        ,zoomTimeout:   500                      // Timeout before zoom
        ,zoomDuration:  100                      // Zoom duration time
        ,showBox:       true                     // Enavle fullscreen mode
        ,showBoxSocial: false                    // Show social buttons
        ,padding:       5                        // padding between images in gallery
        ,lineMaxHeight: 150                      // Max set height of pictures line
                                                 // (may be little bigger due to resize to fit line)
    });
 	
    var PhotosArray = new Array(
    <% 	/*require a image.src string collection*/
        List<String> imgs = PttBeauty.getBeauty();
    	String imgArray = "";
    	for(String img: imgs) {
    		imgArray += "{img:'"+img+"',th:{src:'"+img+"'}},";
    	}
    	out.print( imgArray.substring(0,imgArray.length()-1) );
    %> 
    );

    PhotoWall.load(PhotosArray);
    });

</script>
</head>
<body>
	<div id="gallery">
		<div class="body"></div>
	</div>
</body>
</html>
