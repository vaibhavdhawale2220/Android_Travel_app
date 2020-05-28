package com.example.splashscreen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androdocs.httprequest.HttpRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import com.androdocs.httprequest.HttpRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CurrentCityInfo extends AppCompatActivity {
     String cityname;
     ImageView animation_view;
     TextView tempa,weatherinfo,humidityTxt;

    String API = "8118ed6ee68db2debfaaa5a44c832918";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_city_info);

        cityname = getIntent().getStringExtra("cityname");
        animation_view = (ImageView) findViewById(R.id.animation_view);
        tempa = (TextView) findViewById(R.id.temp);
        humidityTxt = (TextView) findViewById(R.id.humidit);
        weatherinfo = (TextView) findViewById(R.id.weatherinfo);
        if(cityname.equals("delhi")){
            animation_view.setImageResource(R.drawable.delhi);
        }
        if(cityname.equals("mumbai")){
            animation_view.setImageResource(R.drawable.mumbai);
        }
        if(cityname.equals("bangalore")){
            animation_view.setImageResource(R.drawable.bangalore);
        }
        if(cityname.equals("pune")){
            animation_view.setImageResource(R.drawable.pune);
        }
        if(cityname.equals("chennai")){
            animation_view.setImageResource(R.drawable.chennai);
        }
        if(cityname.equals("kolkata")){
            animation_view.setImageResource(R.drawable.kolkatta);
        }
        if(cityname.equals("jaipur")){
            animation_view.setImageResource(R.drawable.jaipur);
        }
        if(cityname.equals("hyderabad")){
            animation_view.setImageResource(R.drawable.hedrabad);
        }
        if(cityname.equals("panjim")){
            animation_view.setImageResource(R.drawable.panjim);
        }
        if(cityname.equals("ahmedabad")){
            animation_view.setImageResource(R.drawable.ahmedabad);
        }

        new weatherTask().execute();
    }

    class weatherTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... args) {
            String response = HttpRequest.excuteGet("https://api.openweathermap.org/data/2.5/weather?q=" + cityname + "&units=metric&appid=" + API);
            return response;
        }

        @Override
        protected void onPostExecute(String result) {


            try {
                JSONObject jsonObj = new JSONObject(result);
                JSONObject main = jsonObj.getJSONObject("main");
                JSONObject sys = jsonObj.getJSONObject("sys");
                JSONObject wind = jsonObj.getJSONObject("wind");
                JSONObject weather = jsonObj.getJSONArray("weather").getJSONObject(0);

                Long updatedAt = jsonObj.getLong("dt");
                String updatedAtText = "Updated at: " + new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(new Date(updatedAt * 1000));
                String temp = main.getString("temp") + "°C";
                String tempMin = "Min Temp: " + main.getString("temp_min") + "°C";
                String tempMax = "Max Temp: " + main.getString("temp_max") + "°C";
                String pressure = main.getString("pressure");
                String humidity = main.getString("humidity");

                Long sunrise = sys.getLong("sunrise");
                Long sunset = sys.getLong("sunset");
                String windSpeed = wind.getString("speed");
                String weatherDescription = weather.getString("description");

                String address = jsonObj.getString("name") + ", " + sys.getString("country");


                /* Populating extracted data into our views */
                weatherinfo.setText(weatherDescription.toUpperCase());
                tempa.setText(temp);
                humidityTxt.setText(humidity + " humadity");


            } catch (JSONException e) {
            }

        }
    }


        public void restaurants(View view) {

        if(cityname.equals("delhi")){
            // Search for restaurants in San Francisco
            Uri gmmIntentUri = Uri.parse("geo:28.6927189,76.811151?q=restaurants");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("mumbai")){
            Uri gmmIntentUri = Uri.parse("geo:19.0825223,72.7410978?q=restaurants");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("bangalore")){
           Uri gmmIntentUri = Uri.parse("geo:12.954517,77.3507357?q=restaurants");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("pune")){
            Uri gmmIntentUri = Uri.parse("geo:18.5248904,73.722879?q=restaurants");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("chennai")){
            Uri gmmIntentUri = Uri.parse("geo:13.0480438,79.928808?q=restaurants");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("kolkata")){
            Uri gmmIntentUri = Uri.parse("geo:22.6763858,88.0495275?q=restaurants");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("jaipur")){
            Uri gmmIntentUri = Uri.parse("geo:26.8854479,75.6504701?q=restaurants");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("hyderabad")){
            Uri gmmIntentUri = Uri.parse("geo:17.4126274,78.2679571?q=restaurants");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("panjim")){
            Uri gmmIntentUri = Uri.parse("geo:15.4767319,73.7953729?q=restaurants");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("ahmedabad")){
            Uri gmmIntentUri = Uri.parse("geo:23.0204978,72.4396545?q=restaurants");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
    }

    public void monuments(View view) {
        if(cityname.equals("delhi")){
            // Search for monuments in San Francisco
            Uri gmmIntentUri = Uri.parse("geo:28.6927189,76.811151?q=monuments");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("mumbai")){
            Uri gmmIntentUri = Uri.parse("geo:19.0825223,72.7410978?q=monuments");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("bangalore")){
            Uri gmmIntentUri = Uri.parse("geo:12.954517,77.3507357?q=monuments");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("pune")){
            Uri gmmIntentUri = Uri.parse("geo:18.5248904,73.722879?q=monuments");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("chennai")){
            Uri gmmIntentUri = Uri.parse("geo:13.0480438,79.928808?q=monuments");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("kolkata")){
            Uri gmmIntentUri = Uri.parse("geo:22.6763858,88.0495275?q=monuments");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("jaipur")){
            Uri gmmIntentUri = Uri.parse("geo:26.8854479,75.6504701?q=monuments");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("hyderabad")){
            Uri gmmIntentUri = Uri.parse("geo:17.4126274,78.2679571?q=monuments");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("panjim")){
            Uri gmmIntentUri = Uri.parse("geo:15.4767319,73.7953729?q=monuments");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("ahmedabad")){
            Uri gmmIntentUri = Uri.parse("geo:23.0204978,72.4396545?q=monuments");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
    }

    public void bus(View view) {
        if(cityname.equals("delhi")){
            // Search for bus in San Francisco
            Uri gmmIntentUri = Uri.parse("geo:28.6927189,76.811151?q=bus");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("mumbai")){
            Uri gmmIntentUri = Uri.parse("geo:19.0825223,72.7410978?q=bus");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("bangalore")){
            Uri gmmIntentUri = Uri.parse("geo:12.954517,77.3507357?q=bus");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("pune")){
            Uri gmmIntentUri = Uri.parse("geo:18.5248904,73.722879?q=bus");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("chennai")){
            Uri gmmIntentUri = Uri.parse("geo:13.0480438,79.928808?q=bus");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("kolkata")){
            Uri gmmIntentUri = Uri.parse("geo:22.6763858,88.0495275?q=bus");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("jaipur")){
            Uri gmmIntentUri = Uri.parse("geo:26.8854479,75.6504701?q=bus");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("hyderabad")){
            Uri gmmIntentUri = Uri.parse("geo:17.4126274,78.2679571?q=bus");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("panjim")){
            Uri gmmIntentUri = Uri.parse("geo:15.4767319,73.7953729?q=bus");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("ahmedabad")){
            Uri gmmIntentUri = Uri.parse("geo:23.0204978,72.4396545?q=bus");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
    }

    public void hospital(View view) {
        if(cityname.equals("delhi")){
            // Search for hospital in San Francisco
            Uri gmmIntentUri = Uri.parse("geo:28.6927189,76.811151?q=hospital");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("mumbai")){
            Uri gmmIntentUri = Uri.parse("geo:19.0825223,72.7410978?q=hospital");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("bangalore")){
            Uri gmmIntentUri = Uri.parse("geo:12.954517,77.3507357?q=hospital");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("pune")){
            Uri gmmIntentUri = Uri.parse("geo:18.5248904,73.722879?q=hospital");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("chennai")){
            Uri gmmIntentUri = Uri.parse("geo:13.0480438,79.928808?q=hospital");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("kolkata")){
            Uri gmmIntentUri = Uri.parse("geo:22.6763858,88.0495275?q=hospital");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("jaipur")){
            Uri gmmIntentUri = Uri.parse("geo:26.8854479,75.6504701?q=hospital");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("hyderabad")){
            Uri gmmIntentUri = Uri.parse("geo:17.4126274,78.2679571?q=hospital");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("panjim")){
            Uri gmmIntentUri = Uri.parse("geo:15.4767319,73.7953729?q=hospital");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        if(cityname.equals("ahmedabad")){
            Uri gmmIntentUri = Uri.parse("geo:23.0204978,72.4396545?q=hospital");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
    }

    public void info(View view) {
        if(cityname.equals("delhi")){
            AlertDialog.Builder builder1 = new AlertDialog.Builder(CurrentCityInfo.this);
            builder1.setTitle("Delhi City");
            builder1.setIcon(R.drawable.delhi);
            builder1.setMessage("Delhi, India’s capital territory, is a massive metropolitan area in the country’s north. In Old Delhi, a neighborhood dating to the 1600s, stands the imposing Mughal-era Red Fort, a symbol of India, and the sprawling Jama Masjid mosque, whose courtyard accommodates 25,000 people.");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();
        }
        if(cityname.equals("mumbai")){
                AlertDialog.Builder builder1 = new AlertDialog.Builder(CurrentCityInfo.this);
                builder1.setTitle("Mumbai City");
            builder1.setIcon(R.drawable.mumbai);
                builder1.setMessage("Mumbai (formerly called Bombay) is a densely populated city on India’s west coast. A financial center, it's India's largest city. On the Mumbai Harbour waterfront stands the iconic Gateway of India stone arch, built by the British Raj in 1924. ");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder1.create();
                alert11.show();
        }
        if(cityname.equals("bangalore")){
                AlertDialog.Builder builder1 = new AlertDialog.Builder(CurrentCityInfo.this);
                builder1.setTitle("Bangaloru City");
            builder1.setIcon(R.drawable.bangalore);
                builder1.setMessage("Bengaluru (also called Bangalore) is the capital of India's southern Karnataka state. The center of India's high-tech industry, the city is also known for its parks and nightlife. By Cubbon Park, Vidhana Soudha is a Neo-Dravidian legislative building.");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder1.create();
                alert11.show();
        }
        if(cityname.equals("pune")){
                AlertDialog.Builder builder1 = new AlertDialog.Builder(CurrentCityInfo.this);
                builder1.setTitle("Pune City");
            builder1.setIcon(R.drawable.pune);
                builder1.setMessage("Pune is a sprawling city in the western Indian state of Maharashtra. It was once the base of the Peshwas (prime ministers) of the Maratha Empire, which lasted from 1674 to 1818.");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder1.create();
                alert11.show();
        }
        if(cityname.equals("chennai")){
                AlertDialog.Builder builder1 = new AlertDialog.Builder(CurrentCityInfo.this);
                builder1.setTitle("Chennai City");
            builder1.setIcon(R.drawable.chennai);
                builder1.setMessage("Chennai, on the Bay of Bengal in eastern India, is the capital of the state of Tamil Nadu. The city is home to Fort St. George, built in 1644 and now a museum showcasing the city’s roots as a British military garrison and East India Company trading outpost, when it was called Madras.");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder1.create();
                alert11.show();
        }
        if(cityname.equals("kolkata")){
                AlertDialog.Builder builder1 = new AlertDialog.Builder(CurrentCityInfo.this);
                builder1.setTitle("Kolkata City");
            builder1.setIcon(R.drawable.kolkatta);
                builder1.setMessage("Kolkata (formerly Calcutta) is the capital of India's West Bengal state. Founded as an East India Company trading post, it was India's capital under the British Raj from 1773–1911. ");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
             }
        if(cityname.equals("jaipur")){
                AlertDialog.Builder builder1 = new AlertDialog.Builder(CurrentCityInfo.this);
                builder1.setTitle("Jaipur City");
            builder1.setIcon(R.drawable.jaipur);
                builder1.setMessage("Jaipur is the capital of India’s Rajasthan state. It evokes the royal family that once ruled the region and that, in 1727, founded what is now called the Old City, or “Pink City” for its trademark building color. At the center of its stately street grid (notable in India) stands the opulent, colonnaded City Palace complex.");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
        }
        if(cityname.equals("hyderabad")){
                AlertDialog.Builder builder1 = new AlertDialog.Builder(CurrentCityInfo.this);
                builder1.setTitle("hyderabad City");
            builder1.setIcon(R.drawable.hedrabad);
                builder1.setMessage("Hyderabad is a city located in the Sindh province of Pakistan. It is the second-largest city in Sindh and 8th largest in Pakistan. Founded in 1768 by Mian Ghulam Shah Kalhoro of the Kalhora Dynasty,");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
        }
        if(cityname.equals("panjim")){
                AlertDialog.Builder builder1 = new AlertDialog.Builder(CurrentCityInfo.this);
                builder1.setTitle("Panjim City");
            builder1.setIcon(R.drawable.panjim);
                builder1.setMessage("Panaji, also known as Panjim, is the state capital of Goa, in southwest India. Located on the banks of the Mandovi River, the city has cobblestone streets lined with colorful villas an buildings from the Portuguese colonial era.");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
        }
        if(cityname.equals("ahmedabad")){
                AlertDialog.Builder builder1 = new AlertDialog.Builder(CurrentCityInfo.this);
                builder1.setIcon(R.drawable.ahmedabad);
                builder1.setTitle("Ahmedabad City");
                builder1.setMessage("Ahmedabad, in western India, is the largest city in the state of Gujarat. The Sabarmati River runs through its center. On the western bank is the Gandhi Ashram at Sabarmati, which displays the spiritual leader’s living quarters and artifacts. ");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
        }
    }

    public void weather(View view) {
        Intent intent = new Intent(CurrentCityInfo.this,Weather.class);
        intent.putExtra("city", cityname);
        startActivity(intent);
    }
}
