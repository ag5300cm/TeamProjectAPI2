package API;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;
import org.json.JSONArray;


public class ImageAPI {

    public static String getImageOfSubject(String searchText) {

        String address = "";

        try {

            String API_KEY = System.getenv("API_KEY");

            String urlString = "https://pixabay.com/api/?key=" + API_KEY + "&q=" + searchText + "&image_type=photo";

            URL urlObject = new URL(urlString);

            HttpURLConnection con = (HttpURLConnection) urlObject.openConnection();

            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();

            if(responseCode == 200 || responseCode == 201) {

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));

                String inputLine;

                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                JSONObject json = new JSONObject(response.toString());

                JSONArray jsonarr = json.getJSONArray("hits");
                address = jsonarr.getJSONObject(0).getString("previewURL");

                in.close();

            }

            con.disconnect();


        } catch (MalformedURLException me) {
            System.out.println("Error " + me);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return address;
    }
}