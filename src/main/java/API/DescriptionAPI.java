package API;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import org.json.JSONObject;

public class DescriptionAPI {

    public static void main(String[] args) {

        try {
            String searchText = "moon";

            String urlString = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles=" + searchText;

            URL urlObject = new URL(urlString);

            HttpURLConnection con = (HttpURLConnection) urlObject.openConnection();

            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();

            System.out.println(urlObject);

            if(responseCode == 200 || responseCode == 201) {

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));

                String inputLine;

                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                // Read JSON response and retrieve subject's description
                JSONObject json = new JSONObject(response.toString());

                Iterator<String> keys = json.getJSONObject("query").getJSONObject("pages").keys();

                String key ="";

                if(keys.hasNext()){
                    key = keys.next(); // First key in your json object
                }

                System.out.println("Description: " + json.getJSONObject("query").getJSONObject("pages").getJSONObject(key).getString("extract"));

                in.close();
            }

            con.disconnect();

        } catch (java.net.MalformedURLException me) {
            System.out.println("Error " + me);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
