package API;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;
import org.json.JSONArray;


    public class ImageAPI {

        @SuppressWarnings("unchecked")
        public static void main(String[] args) {

            Scanner inputScanner = new Scanner(System.in);

            System.out.println("Please enter what you are looking for: ");
            String searchText = inputScanner.nextLine();

            try {

                String API_Key = System.getenv("AVI_Key");

                String urlString = "https://pixabay.com/api/?key= + " + API_Key + "&q=" + searchText + "&image_type=photo";

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
                    String address = jsonarr.getJSONObject(0).getString("largeImageURL");

                    System.out.println(address);

                    in.close();

                }

                con.disconnect();


            } catch (MalformedURLException me) {
                System.out.println("Error " + me);
            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }
    }