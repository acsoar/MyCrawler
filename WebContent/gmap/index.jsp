<%@page import="java.util.*"%>
<%@page import="crawler.example.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>GeoJson 練習</title>
    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">
    <style>
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #map {
        height: 100%;
      }
    </style>
  </head>
  <body>
    <div id="map"></div>
    <script>
      var map;
      function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
          zoom: 9,
          center:  {lat: 25.047886, lng: 121.516950}
        });

        // Load GeoJSON.
        map.data.loadGeoJson(
        	// 可輸入資料網址 或直接 輸入 GeoJson
        	"http://128.199.204.20/pm25/geojson.php"
        	
        	// 找出土壤液化的資料源
        );
        
        
      }
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?callback=initMap">
    </script>
  </body>
</html>