package istanbul;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class PointOfInterest {
	
	public static void main(String[] args) {
		
		try {
			String uri="https://api.mapbox.com/geocoding/v5/mapbox.places/istanbul.json?types=poi&limit=10&access_token=pk.eyJ1IjoiYWZ0YWI2MjQ0IiwiYSI6ImNraHI0YWRxaDAwM3MycnBpdzJ2Z3pvbDYifQ.8IcQ1o9kGmcYqXrwcgv0Uw";
			URL url=new URL(uri);
			HttpURLConnection con=(HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			if(con.getResponseCode()==200)
			{
				BufferedReader in = new BufferedReader(
			             new InputStreamReader(con.getInputStream()));
				String inputLine;
			     StringBuffer response = new StringBuffer();
			     while ((inputLine = in.readLine()) != null) {
			     	response.append(inputLine);
			     	//in.close();
				     //print in String
				    // System.out.println(response.toString());
				     //Read JSON response and print
				     Object obj=JSONValue.parse(response.toString());  
				     JSONObject jsonObject = (JSONObject) obj;  
				     System.out.println(jsonObject);
				     System.out.println("GET Itinerary");
				     String placename=(String) jsonObject.get("place_name");
				     String categories=(String) jsonObject.get("properties.category"); 
				     String region=(String) jsonObject.get("place_type");
				     System.out.println("Name :"+placename);
				     System.out.println("Category :"+categories);
				     System.out.println("region :"+region);
			     }
			     
			     
			   }
			
			}
		catch(Exception e)
		{
			System.out.println("Exception occured"+e);
		}
		
	}

}
