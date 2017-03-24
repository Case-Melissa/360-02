/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author Melissa Case
 */
public class json {
      public static void main(String[] args) throws Exception {
        URL url = new URL("http://api.wunderground.com/api/6fac64a5bc1e7892/conditions/q/Nevada/Sparks.json");
        
        try {
        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
        
        InputStream stream = urlConn.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder result = new StringBuilder();
        String line;
        
        while((line = reader.readLine()) !=null) {
            result.append(line);
        }
        
        // This line reads parts of the JSON data and displays it on the screen
        JSONObject json = new JSONObject(result.toString());
            JSONObject sparksInfo = (JSONObject) json.get("current_observation");
            
            String wunderGround = "Info downloaded from: " + sparksInfo.getJSONObject("image").getString("title") +
                    "\nLink\t\t: " + sparksInfo.getJSONObject("image").getString("link") +
                    "\nCity\t\t: " +  sparksInfo.getJSONObject("display_location").getString("city") +
                    "\nState\t\t: " + sparksInfo.getJSONObject("display_location").getString("state_name") +
                    "\nTime\t\t: " + sparksInfo.get("observation_time_rfc822") +
                    "\nTemperature\t\t: " + sparksInfo.get("temperature_string") +
                    "\nWindchill\t\t: " + sparksInfo.get("windchill_string") +
                    "\nRelative Humidity\t: " + sparksInfo.get("relative_humidity") +
                    "\nWind\t\t\t: " + sparksInfo.get("wind_string") +
                    "\nWind Direction\t\t: " + sparksInfo.get("wind_dir") +
                    "\nBarometric Pressure\t\t: " + sparksInfo.get("pressure_in");
        System.out.println("\nSparks Weather: ");
        System.out.println("_________________________________________________");
        System.out.println(wunderGround);
    }
    
    catch(IOException e){
        System.out.println("***ERROR*************ERROR************ERROR*** " +
                "\nURL: " + url.toString() + "\nERROR: " + e.toString());
    }        
    }
    
}

