package com.online.shopping.ebayandroidapp;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;


public class MainActivity extends ActionBarActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getKeyPad(View V){
        final EditText keyword = (EditText) findViewById(R.id.key_input);
        final InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(keyword, InputMethodManager.SHOW_IMPLICIT);
    }

    public void clickSearch(View v) throws MalformedURLException, UnsupportedEncodingException {

        EditText keyword = (EditText) findViewById(R.id.key_input);
        EditText priceFrom = (EditText) findViewById(R.id.from_input);
        EditText priceTo = (EditText) findViewById(R.id.to_input);
        Spinner sort = (Spinner) findViewById(R.id.spinner);
        TextView text = (TextView) findViewById(R.id.textResult);

        String keyValue,minValue,maxValue;
        float minPrice=0,maxPrice=0;
        String url = "http://ebayonlineshopping-env.elasticbeanstalk.com/";
        int flag = 1;
        keyValue = keyword.getText().toString().trim();
        minValue = priceFrom.getText().toString();
        maxValue = priceTo.getText().toString();
        if(!minValue.isEmpty())
            minPrice = Float.valueOf(priceFrom.getText().toString());
        if(!maxValue.isEmpty())
            maxPrice = Float.valueOf(priceTo.getText().toString());
        if(minValue.isEmpty())
            minValue = "nil";
        if(maxValue.isEmpty())
            maxValue = "nil";
        if(keyValue.isEmpty()){
            text.setText("Please enter a keyword");
            flag = 0;
        }
        if(!minValue.equals("nil") && !maxValue.equals("nil") && flag == 1) {
            if ((minPrice > maxPrice)) {
                text.setText("Maximum Price cannot be less than Minimum Price");
                flag = 0;
            }
        }
        if(minPrice < 0){
            text.setText("Minimum Price must be a positive or decimal number");
            flag = 0;
        }
        if(maxPrice < 0){
            text.setText("Maximum Price must be a positive or decimal number");
            flag = 0;
        }


        if(flag == 1) {
            text.setText("");
            url+="?keywords="+java.net.URLEncoder.encode(keyValue,"UTF-8").replace(" ","+");

            if(priceFrom.getText().toString().isEmpty())
               url+="&from="+minValue;
            else
                url+="&from="+minPrice;

            if(priceTo.getText().toString().isEmpty())
                url+="&to="+maxValue;
            else
                url+="&to="+maxPrice;

           /* if(sort.getSelectedItemPosition() == 0)
                url+="?sort=BestMatch";
            else if(sort.getSelectedItemPosition() == 1)
                url+="?sort=CurrentPriceHighest";
            else if(sort.getSelectedItemPosition() == 2)
                url+="?sort=PricePlusShippingHighest";
            else if(sort.getSelectedItemPosition() == 3)
                url+="?sort=PricePlusShippingLowest";*/

            String sortValue = sort.getSelectedItem().toString();
            if(sortValue.equals("Best Match"))
                url+="&sort=BestMatch";
            else if(sortValue.equals("Price: highest first"))
                url+="&sort=CurrentPriceHighest";
            else if(sortValue.equals("Price + Shipping: highest first"))
                url+="&sort=PricePlusShippingHighest";
            else if(sortValue.equals("Price + Shipping: lowest first"))
                url+="&sort=PricePlusShippingLowest";

            url+="&result=5&pageNum=1";
            new RunBackground().execute(url);
        }
    }

    //Button clearButton = (Button)findViewById(R.id.clear);

    public void clickClear(View v)
    {
         EditText keyword = (EditText) findViewById(R.id.key_input);
         EditText priceFrom = (EditText) findViewById(R.id.from_input);
         EditText priceTo = (EditText) findViewById(R.id.to_input);
         Spinner sort = (Spinner) findViewById(R.id.spinner);
         TextView text = (TextView) findViewById(R.id.textResult);


        keyword.setText("");
        priceFrom.setText("");
        priceTo.setText("");
        sort.setSelection(0);
        text.setText("");
    }



    private class RunBackground extends AsyncTask<String, Void, String> {
        String response = "";
        @Override
        protected String doInBackground(String... urls) {
            for (String url : urls) {
                DefaultHttpClient client = new DefaultHttpClient();
                HttpGet httpGet = new HttpGet(url);
                try {
                    HttpResponse execute = client.execute(httpGet);
                    InputStream content = execute.getEntity().getContent();

                    BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
                    String s = "";
                    while ((s = buffer.readLine()) != null) {
                        response += s;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return response;
        }

        @Override
        protected void onPostExecute(String result) {
            EditText keyword = (EditText) findViewById(R.id.key_input);
            TextView text = (TextView) findViewById(R.id.textResult);

            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(response);
                String ack = jsonObject.getString("ack");
                if(ack.equals("Success")){
                    Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                    intent.putExtra("response",response);
                    intent.putExtra("keyword",keyword.getText().toString());
                    startActivity(intent);
                }
                else
                   text.setText("No Results Found");
                        //text.setText(ack);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
