package com.online.shopping.ebayandroidapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;


public class ResultActivity extends ActionBarActivity {

    String responseText,keyValue;
    String detailsImage0,detailsImageURL0,detailsSuperImageURL0,detailsTitle0,detailsLocation0,detailsPrice0,detailsBadge0,detailsCategory0,detailsCondition0,detailsBuyFormat0,detailsUserName0,detailsFeedback0,detailsPositive0,detailsFeedbackRating0,detailsTopRated0,detailsStore0,detailsStoreURL0,detailsShippingType0,detailsHandlingTime0,detailsShippingLocations0,detailsExpedited0,detailsOneDay0,detailsRetAcc0;
    String detailsImage1,detailsImageURL1,detailsSuperImageURL1,detailsTitle1,detailsLocation1,detailsPrice1,detailsBadge1,detailsCategory1,detailsCondition1,detailsBuyFormat1,detailsUserName1,detailsFeedback1,detailsPositive1,detailsFeedbackRating1,detailsTopRated1,detailsStore1,detailsStoreURL1,detailsShippingType1,detailsHandlingTime1,detailsShippingLocations1,detailsExpedited1,detailsOneDay1,detailsRetAcc1;
    String detailsImage2,detailsImageURL2,detailsSuperImageURL2,detailsTitle2,detailsLocation2,detailsPrice2,detailsBadge2,detailsCategory2,detailsCondition2,detailsBuyFormat2,detailsUserName2,detailsFeedback2,detailsPositive2,detailsFeedbackRating2,detailsTopRated2,detailsStore2,detailsStoreURL2,detailsShippingType2,detailsHandlingTime2,detailsShippingLocations2,detailsExpedited2,detailsOneDay2,detailsRetAcc2;
    String detailsImage3,detailsImageURL3,detailsSuperImageURL3,detailsTitle3,detailsLocation3,detailsPrice3,detailsBadge3,detailsCategory3,detailsCondition3,detailsBuyFormat3,detailsUserName3,detailsFeedback3,detailsPositive3,detailsFeedbackRating3,detailsTopRated3,detailsStore3,detailsStoreURL3,detailsShippingType3,detailsHandlingTime3,detailsShippingLocations3,detailsExpedited3,detailsOneDay3,detailsRetAcc3;
    String detailsImage4,detailsImageURL4,detailsSuperImageURL4,detailsTitle4,detailsLocation4,detailsPrice4,detailsBadge4,detailsCategory4,detailsCondition4,detailsBuyFormat4,detailsUserName4,detailsFeedback4,detailsPositive4,detailsFeedbackRating4,detailsTopRated4,detailsStore4,detailsStoreURL4,detailsShippingType4,detailsHandlingTime4,detailsShippingLocations4,detailsExpedited4,detailsOneDay4,detailsRetAcc4;
 //  String detailsImage,detailsTitle,detailsLocation,detailsPrice,detailsBadge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
       // TextView textView = (TextView)findViewById(R.id.textView);
        Intent intent = getIntent();
        responseText = intent.getExtras().getString("response");
        keyValue = intent.getExtras().getString("keyword");
        //textView.setText(responseText);

        try {
            parseData();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

  //  public void onBackPressed()
   // {
    //}

    public void parseData() throws JSONException {
        JSONObject jsonObject = new JSONObject(responseText);
        int i;
        TextView textView0 = (TextView) findViewById(R.id.textView1);
        TextView textView1 = (TextView) findViewById(R.id.textView2);
        TextView textView2 = (TextView) findViewById(R.id.textView3);
        TextView textView3 = (TextView) findViewById(R.id.textView4);
        TextView textView4 = (TextView) findViewById(R.id.textView5);
        WebView webView0 = (WebView) findViewById(R.id.webView1);
        WebView webView1 = (WebView) findViewById(R.id.webView2);
        WebView webView2 = (WebView) findViewById(R.id.webView3);
        WebView webView3 = (WebView) findViewById(R.id.webView4);
        WebView webView4 = (WebView) findViewById(R.id.webView5);



        TextView result = (TextView) findViewById(R.id.resultTitle);
        String str = "Results for '"+keyValue+"'";
        result.setText(str);


        for(i=0;i<5;i++) {
            String title = jsonObject.getJSONObject("item"+Integer.toString(i)).getJSONObject("basicInfo").getString("title");
            String shippingCost = jsonObject.getJSONObject("item"+Integer.toString(i)).getJSONObject("basicInfo").getString("shippingServiceCost");
            String price = jsonObject.getJSONObject("item"+Integer.toString(i)).getJSONObject("basicInfo").getString("convertedCurrentPrice");
            String imageURL = jsonObject.getJSONObject("item"+Integer.toString(i)).getJSONObject("basicInfo").getString("viewItemURL");
            String image = jsonObject.getJSONObject("item"+Integer.toString(i)).getJSONObject("basicInfo").getString("galleryURL");
            String pictureSuperSize = jsonObject.getJSONObject("item"+Integer.toString(i)).getJSONObject("basicInfo").getString("pictureURLSuperSize");
            String location = jsonObject.getJSONObject("item"+Integer.toString(i)).getJSONObject("basicInfo").getString("location");
            String rating = jsonObject.getJSONObject("item"+Integer.toString(i)).getJSONObject("basicInfo").getString("topRatedListing");
            String categoryName = jsonObject.getJSONObject("item"+Integer.toString(i)).getJSONObject("basicInfo").getString("categoryName");
            String conditionName = jsonObject.getJSONObject("item"+Integer.toString(i)).getJSONObject("basicInfo").getString("conditionDisplayName");
            String buyFormat = jsonObject.getJSONObject("item"+Integer.toString(i)).getJSONObject("basicInfo").getString("listingType");
            String userName = jsonObject.getJSONObject("item"+Integer.toString(i)).getJSONObject("sellerInfo").getString("sellerUserName");
            String feedback = jsonObject.getJSONObject("item"+Integer.toString(i)).getJSONObject("sellerInfo").getString("feedbackScore");
            String positive = jsonObject.getJSONObject("item"+Integer.toString(i)).getJSONObject("sellerInfo").getString("positiveFeedbackPercent");
            String feedbackRating = jsonObject.getJSONObject("item"+Integer.toString(i)).getJSONObject("sellerInfo").getString("feedbackRatingStar");
            String topRatedBool = jsonObject.getJSONObject("item"+Integer.toString(i)).getJSONObject("sellerInfo").getString("topRatedSeller");
            String storeURL = jsonObject.getJSONObject("item"+Integer.toString(i)).getJSONObject("sellerInfo").getString("sellerStoreURL");
            String store = jsonObject.getJSONObject("item"+Integer.toString(i)).getJSONObject("sellerInfo").getString("sellerStoreName");
            String shippingType = jsonObject.getJSONObject("item"+Integer.toString(i)).getJSONObject("shippingInfo").getString("shippingType");
            String handlingTime = jsonObject.getJSONObject("item"+Integer.toString(i)).getJSONObject("shippingInfo").getString("handlingTime");
            String shippingLocations = jsonObject.getJSONObject("item"+Integer.toString(i)).getJSONObject("shippingInfo").getString("shipToLocations");
            String expeditedBool = jsonObject.getJSONObject("item"+Integer.toString(i)).getJSONObject("shippingInfo").getString("expeditedShipping");
            String oneDayBool = jsonObject.getJSONObject("item"+Integer.toString(i)).getJSONObject("shippingInfo").getString("oneDayShippingAvailable");
            String retAccBool = jsonObject.getJSONObject("item"+Integer.toString(i)).getJSONObject("shippingInfo").getString("returnsAccepted");


            String shipping = "";
            if (!shippingCost.isEmpty()) {
                if (Float.valueOf(shippingCost) == 0.0) {
                    shipping = " (FREE Shipping)";
                } else {
                    shipping = " (+ $" + Float.valueOf(shippingCost) + " Shipping)";
                }
            }

            String priceStr = "\n\n\nPrice:$" + Float.valueOf(price) + shipping;

            if(i==0){
                webView0.loadUrl(image);
                textView0.setText(title+priceStr);
                detailsImage0 = image;
                detailsImageURL0 = imageURL;
                detailsSuperImageURL0 = pictureSuperSize;
                detailsTitle0 = title;
                detailsPrice0 = priceStr;
                detailsLocation0 = location;
                detailsBadge0 = rating;

                detailsCategory0 = categoryName;
                detailsCondition0 = conditionName;
                detailsBuyFormat0 = buyFormat;

                detailsUserName0 = userName;
                detailsFeedback0 = feedback;
                detailsPositive0 = positive;
                detailsFeedbackRating0 = feedbackRating;
                detailsTopRated0 = topRatedBool;
                detailsStore0 = store;
                detailsStoreURL0 = storeURL;

                detailsShippingType0 = shippingType;
                detailsHandlingTime0 = handlingTime;
                detailsShippingLocations0 = shippingLocations;
                detailsExpedited0 = expeditedBool;
                detailsOneDay0 = oneDayBool;
                detailsRetAcc0 = retAccBool;

              /*  detailsImage = image;
                detailsTitle = title;
                detailsPrice = priceStr;
                detailsLocation = location;
                detailsBadge = rating; */

            }
            if(i==1){
                webView1.loadUrl(image);
                textView1.setText(title+priceStr);
                detailsImage1 = image;
                detailsImageURL1 = imageURL;
                detailsSuperImageURL1 = pictureSuperSize;
                detailsTitle1 = title;
                detailsPrice1 = priceStr;
                detailsLocation1 = location;
                detailsBadge1 = rating;

                detailsCategory1 = categoryName;
                detailsCondition1 = conditionName;
                detailsBuyFormat1 = buyFormat;

                detailsUserName1 = userName;
                detailsFeedback1 = feedback;
                detailsPositive1 = positive;
                detailsFeedbackRating1 = feedbackRating;
                detailsTopRated1 = topRatedBool;
                detailsStore1 = store;
                detailsStoreURL1 = storeURL;

                detailsShippingType1 = shippingType;
                detailsHandlingTime1 = handlingTime;
                detailsShippingLocations1 = shippingLocations;
                detailsExpedited1 = expeditedBool;
                detailsOneDay1 = oneDayBool;
                detailsRetAcc1 = retAccBool;

                /*detailsImage = image;
                detailsTitle = title;
                detailsPrice = priceStr;
                detailsLocation = location;
                detailsBadge = rating; */


            }
            if(i==2){
                webView2.loadUrl(image);
                textView2.setText(title+priceStr);
                detailsImage2 = image;
                detailsImageURL2 = imageURL;
                detailsSuperImageURL2 = pictureSuperSize;
                detailsTitle2 = title;
                detailsPrice2 = priceStr;
                detailsLocation2 = location;
                detailsBadge2 = rating;

                detailsCategory2 = categoryName;
                detailsCondition2 = conditionName;
                detailsBuyFormat2 = buyFormat;

                detailsUserName2 = userName;
                detailsFeedback2 = feedback;
                detailsPositive2 = positive;
                detailsFeedbackRating2 = feedbackRating;
                detailsTopRated2 = topRatedBool;
                detailsStore2 = store;
                detailsStoreURL2 = storeURL;

                detailsShippingType2 = shippingType;
                detailsHandlingTime2 = handlingTime;
                detailsShippingLocations2 = shippingLocations;
                detailsExpedited2 = expeditedBool;
                detailsOneDay2 = oneDayBool;
                detailsRetAcc2 = retAccBool;

               /* detailsImage = image;
                detailsTitle = title;
                detailsPrice = priceStr;
                detailsLocation = location;
                detailsBadge = rating; */

            }
            if(i==3){
                webView3.loadUrl(image);
                textView3.setText(title+priceStr);
                detailsImage3 = image;
                detailsImageURL3 = imageURL;
                detailsSuperImageURL3 = pictureSuperSize;
                detailsTitle3 = title;
                detailsPrice3 = priceStr;
                detailsLocation3 = location;
                detailsBadge3 = rating;

                detailsCategory3 = categoryName;
                detailsCondition3 = conditionName;
                detailsBuyFormat3 = buyFormat;

                detailsUserName3 = userName;
                detailsFeedback3 = feedback;
                detailsPositive3 = positive;
                detailsFeedbackRating3 = feedbackRating;
                detailsTopRated3 = topRatedBool;
                detailsStore3 = store;
                detailsStoreURL3 = storeURL;

                detailsShippingType3 = shippingType;
                detailsHandlingTime3 = handlingTime;
                detailsShippingLocations3= shippingLocations;
                detailsExpedited3 = expeditedBool;
                detailsOneDay3 = oneDayBool;
                detailsRetAcc3 = retAccBool;

             /*   detailsImage = image;
                detailsTitle = title;
                detailsPrice = priceStr;
                detailsLocation = location;
                detailsBadge = rating; */

            }
            if(i==4){
                webView4.loadUrl(image);
                textView4.setText(title+priceStr);
                detailsImage4 = image;
                detailsImageURL4 = imageURL;
                detailsSuperImageURL4 = pictureSuperSize;
                detailsTitle4 = title;
                detailsPrice4 = priceStr;
                detailsLocation4 = location;
                detailsBadge4 = rating;

                detailsCategory4 = categoryName;
                detailsCondition4 = conditionName;
                detailsBuyFormat4 = buyFormat;

                detailsUserName4 = userName;
                detailsFeedback4 = feedback;
                detailsPositive4 = positive;
                detailsFeedbackRating4 = feedbackRating;
                detailsTopRated4 = topRatedBool;
                detailsStore4 = store;
                detailsStoreURL4 = storeURL;

                detailsShippingType4 = shippingType;
                detailsHandlingTime4 = handlingTime;
                detailsShippingLocations4 = shippingLocations;
                detailsExpedited4 = expeditedBool;
                detailsOneDay4 = oneDayBool;
                detailsRetAcc4 = retAccBool;

                /*detailsImage = image;
                detailsTitle = title;
                detailsPrice = priceStr;
                detailsLocation = location;
                detailsBadge = rating; */

            }

            textView0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ResultActivity.this,DetailsActivity.class);
                    intent.putExtra("image",detailsImage0);
                    intent.putExtra("imageURL",detailsImageURL0);
                    intent.putExtra("superImageURL",detailsSuperImageURL0);
                    intent.putExtra("title",detailsTitle0);
                    intent.putExtra("price",detailsPrice0);
                    intent.putExtra("location",detailsLocation0);
                    intent.putExtra("badge",detailsBadge0);

                    intent.putExtra("category",detailsCategory0);
                    intent.putExtra("condition",detailsCondition0);
                    intent.putExtra("buyFormat",detailsBuyFormat0);

                    intent.putExtra("username",detailsUserName0);
                    intent.putExtra("feedback",detailsFeedback0);
                    intent.putExtra("positive",detailsPositive0);
                    intent.putExtra("feedbackRating",detailsFeedbackRating0);
                    intent.putExtra("topRated",detailsTopRated0);
                    intent.putExtra("store",detailsStore0);
                    intent.putExtra("storeURL",detailsStoreURL0);

                    intent.putExtra("shippingType",detailsShippingType0);
                    intent.putExtra("handlingTime",detailsHandlingTime0);
                    intent.putExtra("shippingLocations",detailsShippingLocations0);
                    intent.putExtra("expedited",detailsExpedited0);
                    intent.putExtra("oneDay",detailsOneDay0);
                    intent.putExtra("retAcc",detailsRetAcc0);

                    startActivity(intent);
                }
            });

            textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ResultActivity.this,DetailsActivity.class);
                    intent.putExtra("image",detailsImage1);
                    intent.putExtra("imageURL",detailsImageURL1);
                    intent.putExtra("superImageURL",detailsSuperImageURL1);
                    intent.putExtra("title",detailsTitle1);
                    intent.putExtra("price",detailsPrice1);
                    intent.putExtra("location",detailsLocation1);
                    intent.putExtra("badge",detailsBadge1);

                    intent.putExtra("category",detailsCategory1);
                    intent.putExtra("condition",detailsCondition1);
                    intent.putExtra("buyFormat",detailsBuyFormat1);

                    intent.putExtra("username",detailsUserName1);
                    intent.putExtra("feedback",detailsFeedback1);
                    intent.putExtra("positive",detailsPositive1);
                    intent.putExtra("feedbackRating",detailsFeedbackRating1);
                    intent.putExtra("topRated",detailsTopRated1);
                    intent.putExtra("store",detailsStore1);
                    intent.putExtra("storeURL",detailsStoreURL1);


                    intent.putExtra("shippingType",detailsShippingType1);
                    intent.putExtra("handlingTime",detailsHandlingTime1);
                    intent.putExtra("shippingLocations",detailsShippingLocations1);
                    intent.putExtra("expedited",detailsExpedited1);
                    intent.putExtra("oneDay",detailsOneDay1);
                    intent.putExtra("retAcc",detailsRetAcc1);

                    startActivity(intent);
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ResultActivity.this,DetailsActivity.class);
                    intent.putExtra("image",detailsImage2);
                    intent.putExtra("imageURL",detailsImageURL2);
                    intent.putExtra("superImageURL",detailsSuperImageURL2);
                    intent.putExtra("title",detailsTitle2);
                    intent.putExtra("price",detailsPrice2);
                    intent.putExtra("location",detailsLocation2);
                    intent.putExtra("badge",detailsBadge2);

                    intent.putExtra("category",detailsCategory2);
                    intent.putExtra("condition",detailsCondition2);
                    intent.putExtra("buyFormat",detailsBuyFormat2);

                    intent.putExtra("username",detailsUserName2);
                    intent.putExtra("feedback",detailsFeedback2);
                    intent.putExtra("positive",detailsPositive2);
                    intent.putExtra("feedbackRating",detailsFeedbackRating2);
                    intent.putExtra("topRated",detailsTopRated2);
                    intent.putExtra("store",detailsStore2);
                    intent.putExtra("storeURL",detailsStoreURL2);

                    intent.putExtra("shippingType",detailsShippingType2);
                    intent.putExtra("handlingTime",detailsHandlingTime2);
                    intent.putExtra("shippingLocations",detailsShippingLocations2);
                    intent.putExtra("expedited",detailsExpedited2);
                    intent.putExtra("oneDay",detailsOneDay2);
                    intent.putExtra("retAcc",detailsRetAcc2);

                    startActivity(intent);
                }
            });
            textView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ResultActivity.this,DetailsActivity.class);
                    intent.putExtra("image",detailsImage3);
                    intent.putExtra("imageURL",detailsImageURL3);
                    intent.putExtra("superImageURL",detailsSuperImageURL3);
                    intent.putExtra("title",detailsTitle3);
                    intent.putExtra("price",detailsPrice3);
                    intent.putExtra("location",detailsLocation3);
                    intent.putExtra("badge",detailsBadge3);

                    intent.putExtra("category",detailsCategory3);
                    intent.putExtra("condition",detailsCondition3);
                    intent.putExtra("buyFormat",detailsBuyFormat3);

                    intent.putExtra("username",detailsUserName3);
                    intent.putExtra("feedback",detailsFeedback3);
                    intent.putExtra("positive",detailsPositive3);
                    intent.putExtra("feedbackRating",detailsFeedbackRating3);
                    intent.putExtra("topRated",detailsTopRated3);
                    intent.putExtra("store",detailsStore3);
                    intent.putExtra("storeURL",detailsStoreURL3);

                    intent.putExtra("shippingType",detailsShippingType3);
                    intent.putExtra("handlingTime",detailsHandlingTime3);
                    intent.putExtra("shippingLocations",detailsShippingLocations3);
                    intent.putExtra("expedited",detailsExpedited3);
                    intent.putExtra("oneDay",detailsOneDay3);
                    intent.putExtra("retAcc",detailsRetAcc3);

                    startActivity(intent);
                }
            });
            textView4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ResultActivity.this,DetailsActivity.class);
                    intent.putExtra("image",detailsImage4);
                    intent.putExtra("imageURL",detailsImageURL4);
                    intent.putExtra("superImageURL",detailsSuperImageURL4);
                    intent.putExtra("title",detailsTitle4);
                    intent.putExtra("price",detailsPrice4);
                    intent.putExtra("location",detailsLocation4);
                    intent.putExtra("badge",detailsBadge4);

                    intent.putExtra("category",detailsCategory4);
                    intent.putExtra("condition",detailsCondition4);
                    intent.putExtra("buyFormat",detailsBuyFormat4);

                    intent.putExtra("username",detailsUserName4);
                    intent.putExtra("feedback",detailsFeedback4);
                    intent.putExtra("positive",detailsPositive4);
                    intent.putExtra("feedbackRating",detailsFeedbackRating4);
                    intent.putExtra("topRated",detailsTopRated4);
                    intent.putExtra("store",detailsStore4);
                    intent.putExtra("storeURL",detailsStoreURL4);

                    intent.putExtra("shippingType",detailsShippingType4);
                    intent.putExtra("handlingTime",detailsHandlingTime4);
                    intent.putExtra("shippingLocations",detailsShippingLocations4);
                    intent.putExtra("expedited",detailsExpedited4);
                    intent.putExtra("oneDay",detailsOneDay4);
                    intent.putExtra("retAcc",detailsRetAcc4);

                    startActivity(intent);
                }
            });

            webView0.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    String url = detailsImageURL0;
                    if (!url.startsWith("http://") && !url.startsWith("https://"))
                        url = "http://" + url;
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(browserIntent);
                    return true;
                }
            });

            webView1.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    String url = detailsImageURL1;
                    if (!url.startsWith("http://") && !url.startsWith("https://"))
                        url = "http://" + url;
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(browserIntent);
                    return true;
                }
            });

            webView2.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    String url = detailsImageURL2;
                    if (!url.startsWith("http://") && !url.startsWith("https://"))
                        url = "http://" + url;
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(browserIntent);
                    return true;
                }
            });

            webView3.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    String url = detailsImageURL3;
                    if (!url.startsWith("http://") && !url.startsWith("https://"))
                        url = "http://" + url;
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(browserIntent);
                    return true;
                }
            });

            webView4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    String url = detailsImageURL4;
                    if (!url.startsWith("http://") && !url.startsWith("https://"))
                        url = "http://" + url;
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(browserIntent);
                    return true;
                }
            });
        }

    }

    /*public void sendData(String sendimage,String sendtitle,String sendprice,String sendlocation, boolean sendbadge){
        Intent intent = new Intent(ResultActivity.this,DetailsActivity.class);
        intent.putExtra("image",sendimage);
        intent.putExtra("title",sendtitle);
        intent.putExtra("price",sendprice);
        intent.putExtra("location",sendlocation);
        intent.putExtra("badge",sendbadge);
        startActivity(intent);
    }*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
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
