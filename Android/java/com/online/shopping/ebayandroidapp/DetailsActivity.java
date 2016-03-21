package com.online.shopping.ebayandroidapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class DetailsActivity extends ActionBarActivity {

    String detailsImage,detailsImageURL,detailsSuperImageURL,detailsTitle,detailsLocation,detailsPrice,detailsBadge;
    String detailsCategory,detailsCondition,detailsBuyFormat;
    String detailsUserName,detailsFeedback,detailsPositive,detailsFeedbackRating,detailsTopRated,detailsStore,detailsStoreURL;
    String detailsShippingType,detailsHandlingTime,detailsShippingLocations,detailsExpedited,detailsOneDay,detailsRetAcc;

    CallbackManager callbackManager;
    ShareDialog shareDialog;
    private LoginButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details2);

        FacebookSdk.sdkInitialize(getApplicationContext());
        LoginManager.getInstance().logOut();
        callbackManager = CallbackManager.Factory.create();

        shareDialog = new ShareDialog(this);

        //Login Callback registration
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
            }
            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "Login Cancelled", Toast.LENGTH_LONG).show();
            }
            @Override
            public void onError(FacebookException exception) {
                Toast.makeText(getApplicationContext(), "Error occurred in Login", Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        WebView galleryImage = (WebView) findViewById(R.id.imageView);
        ImageView badgeView = (ImageView) findViewById(R.id.badgeView);
        ImageButton fbButton = (ImageButton) findViewById(R.id.fbButton);
        TextView titleView = (TextView) findViewById(R.id.titleView);
        TextView priceView = (TextView) findViewById(R.id.priceView);
        TextView locationView = (TextView) findViewById(R.id.locationView);

        TextView categoryView = (TextView) findViewById(R.id.categoryNameValue);
        TextView conditionView = (TextView) findViewById(R.id.conditionValue);
        TextView buyFormatView = (TextView) findViewById(R.id.buyValue);

        TextView userNameView = (TextView) findViewById(R.id.userNameValue);
        TextView feedbackView = (TextView) findViewById(R.id.feedbackValue);
        TextView positiveView = (TextView) findViewById(R.id.positiveValue);
        TextView ratingView = (TextView) findViewById(R.id.ratingValue);
        ImageView topRatedView = (ImageView) findViewById(R.id.topRatedValue);
        TextView storeView = (TextView) findViewById(R.id.storeValue);

        TextView shippingTypeView = (TextView) findViewById(R.id.shippingTypeValue);
        TextView handlingTimeView = (TextView) findViewById(R.id.handlingTimeValue);
        TextView shippingLocationsView = (TextView) findViewById(R.id.shippingLocationsValue);
        ImageView expeditedView = (ImageView) findViewById(R.id.expeditedValue);
        ImageView oneDayView = (ImageView) findViewById(R.id.oneDayValue);
        ImageView retAccView = (ImageView) findViewById(R.id.retAccValue);
        Button buyButton = (Button) findViewById(R.id.buyButton);

        String percent = " %";
        String days = " day(s)";

        detailsImage = intent.getExtras().getString("image");
        detailsImageURL = intent.getExtras().getString("imageURL");
        detailsSuperImageURL = intent.getExtras().getString("superImageURL");
        detailsTitle = intent.getExtras().getString("title");
        detailsPrice = intent.getExtras().getString("price");
        detailsLocation = intent.getExtras().getString("location");

        detailsCategory = intent.getExtras().getString("category");
        detailsCondition = intent.getExtras().getString("condition");
        detailsBuyFormat = intent.getExtras().getString("buyFormat");

        detailsUserName = intent.getExtras().getString("username");
        detailsFeedback = intent.getExtras().getString("feedback");
        detailsPositive = intent.getExtras().getString("positive");
        detailsFeedbackRating = intent.getExtras().getString("feedbackRating");
        detailsTopRated = intent.getExtras().getString("topRated");
        detailsStore = intent.getExtras().getString("store");
        detailsStoreURL = intent.getExtras().getString("storeURL");

        detailsShippingType = intent.getExtras().getString("shippingType");
        detailsHandlingTime = intent.getExtras().getString("handlingTime");
        detailsShippingLocations = intent.getExtras().getString("shippingLocations");
        detailsExpedited = intent.getExtras().getString("expedited");
        detailsOneDay = intent.getExtras().getString("oneDay");
        detailsRetAcc = intent.getExtras().getString("retAcc");

        /*StringBuffer result = new StringBuffer();
        for (int i = 0; i < detailsLocation.length; i++) {
            result.append( detailsLocation[i] );
            //result.append( optional separator );
        }
        String mynewstring = result.toString();*/
        if (detailsLocation.getClass().isArray()) {
            detailsLocation = detailsLocation.toString();
        }

        detailsBadge = intent.getExtras().getString("badge");
        String HTML_FORMAT = "<html><body style=\"text-align: center; vertical-align: center;\"><img src = \"%s\" /></body></html>";
        String html = String.format(HTML_FORMAT, detailsSuperImageURL);

      //  if(detailsSuperImageURL.isEmpty())
        galleryImage.loadUrl(detailsImage);
       /* else{
            galleryImage.getSettings().setLoadWithOverviewMode(true);
            galleryImage.getSettings().setUseWideViewPort(true);
            galleryImage.loadUrl(detailsSuperImageURL);
            //galleryImage.loadDataWithBaseURL("", html, "text/html", "UTF-8", "");
         }*/
        if (detailsBadge.equals("true"))
            badgeView.setImageResource(R.drawable.badge);
        fbButton.setImageResource(R.drawable.fb);
        titleView.setText(detailsTitle);
        priceView.setText(detailsPrice);
        locationView.setText(detailsLocation);

        if (detailsCategory.isEmpty())
            categoryView.setText("N/A");
        else
            categoryView.setText(detailsCategory);

        if (detailsCondition.isEmpty())
            conditionView.setText("N/A");
        else
            conditionView.setText(detailsCondition);

        if (detailsBuyFormat.isEmpty())
            buyFormatView.setText("N/A");
        else
            buyFormatView.setText(detailsBuyFormat);

        if (detailsUserName.isEmpty())
            userNameView.setText("N/A");
        else
            userNameView.setText(detailsUserName);

        if (detailsFeedback.isEmpty())
            feedbackView.setText("N/A");
        else
            feedbackView.setText(detailsFeedback);

        if (detailsPositive.isEmpty())
            positiveView.setText("N/A");
        else
            positiveView.setText(detailsPositive + percent);

        if (detailsFeedbackRating.isEmpty())
            ratingView.setText("N/A");
        else
            ratingView.setText(detailsFeedbackRating);

        if (detailsTopRated.equals("true"))
            topRatedView.setImageResource(R.drawable.tick);
        else
            topRatedView.setImageResource(R.drawable.cross);

        if (detailsStore.isEmpty())
            storeView.setText("N/A");
        else {
            storeView.setText(detailsStore);
            storeView.setTextColor(Color.parseColor("#ff90deff"));
        }

        if (detailsShippingType.isEmpty())
            shippingTypeView.setText("N/A");
        else if (detailsShippingType.equals("FlatDomesticCalculatedInternational"))
            shippingTypeView.setText("Flat,Domestic,Calculated,International");
        else
            shippingTypeView.setText(detailsShippingType);

        if (detailsHandlingTime.isEmpty())
            handlingTimeView.setText("N/A");
        else
            handlingTimeView.setText(detailsHandlingTime + days);

        if (detailsShippingLocations.isEmpty())
            shippingLocationsView.setText("N/A");
        else if (detailsShippingLocations.getClass().isArray())
            shippingLocationsView.setText(detailsShippingLocations.toString());
        else
            shippingLocationsView.setText(detailsShippingLocations);

        if (detailsExpedited.equals("true"))
            expeditedView.setImageResource(R.drawable.tick);
        else
            expeditedView.setImageResource(R.drawable.cross);
        if (detailsOneDay.equals("true"))
            oneDayView.setImageResource(R.drawable.tick);
        else
            oneDayView.setImageResource(R.drawable.cross);
        if (detailsRetAcc.equals("true"))
            retAccView.setImageResource(R.drawable.tick);
        else
            retAccView.setImageResource(R.drawable.cross);

        galleryImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(detailsImageURL));
                startActivity(intent);
            }
        });

        storeView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(detailsStoreURL));
                startActivity(intent);
            }
        });

        buyButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(detailsImageURL));
                startActivity(intent);
            }
        });
    }

        public void onFbClick(final View v)
        {
            shareDialog.registerCallback(callbackManager, new FacebookCallback<Sharer.Result>() {
                @Override
                public void onSuccess(Sharer.Result result) {
                    String postId = result.getPostId();
                    if (postId == null) {
                        Toast.makeText(getApplicationContext(), "Post Cancelled", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Posted Story ID:" + postId, Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onCancel() {
                    Toast.makeText(getApplicationContext(), "Post Cancelled", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onError(FacebookException error) {
                    Toast.makeText(getApplicationContext(), "Error occurred during post", Toast.LENGTH_LONG).show();
                }
            });
            String description=detailsPrice+",Location:"+detailsLocation;
            ShareLinkContent content = new ShareLinkContent.Builder().setContentUrl(Uri.parse(detailsImageURL)).setContentTitle(detailsTitle).setImageUrl(Uri.parse(detailsImage)).setContentDescription(description).build();
            ShareDialog.show(this, content);
        }

        @Override
        protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }



    public void clickBasic(View v){

        Button basicButton = (Button)findViewById(R.id.basicButton);
        Button sellerButton = (Button)findViewById(R.id.sellerButton);
        Button shippingButton = (Button)findViewById(R.id.shippingButton);
        RelativeLayout basicRelative = (RelativeLayout)findViewById(R.id.basicRelative);
        RelativeLayout sellerRelative = (RelativeLayout)findViewById(R.id.sellerRelative);
        RelativeLayout shippingRelative = (RelativeLayout)findViewById(R.id.shippingRelative);

        basicButton.setBackgroundColor(Color.parseColor("#ff90deff"));  // set it to blue
        sellerButton.setBackgroundColor(Color.parseColor("#ffe2deff")); // set it to gray
        shippingButton.setBackgroundColor(Color.parseColor("#ffe2deff")); // set it to gray

        basicRelative.setVisibility(View.VISIBLE);
        sellerRelative.setVisibility(View.INVISIBLE);
        shippingRelative.setVisibility(View.INVISIBLE);
    }

    public void clickSeller(View v){

        Button basicButton = (Button)findViewById(R.id.basicButton);
        Button sellerButton = (Button)findViewById(R.id.sellerButton);
        Button shippingButton = (Button)findViewById(R.id.shippingButton);
        RelativeLayout basicRelative = (RelativeLayout)findViewById(R.id.basicRelative);
        RelativeLayout sellerRelative = (RelativeLayout)findViewById(R.id.sellerRelative);
        RelativeLayout shippingRelative = (RelativeLayout)findViewById(R.id.shippingRelative);

        sellerButton.setBackgroundColor(Color.parseColor("#ff90deff"));  // set it to blue
        basicButton.setBackgroundColor(Color.parseColor("#ffe2deff")); // set it to gray
        shippingButton.setBackgroundColor(Color.parseColor("#ffe2deff")); // set it to gray

        sellerRelative.setVisibility(View.VISIBLE);
        basicRelative.setVisibility(View.INVISIBLE);
        shippingRelative.setVisibility(View.INVISIBLE);
    }

    public void clickShipping(View v){

        Button basicButton = (Button)findViewById(R.id.basicButton);
        Button sellerButton = (Button)findViewById(R.id.sellerButton);
        Button shippingButton = (Button)findViewById(R.id.shippingButton);
        RelativeLayout basicRelative = (RelativeLayout)findViewById(R.id.basicRelative);
        RelativeLayout sellerRelative = (RelativeLayout)findViewById(R.id.sellerRelative);
        RelativeLayout shippingRelative = (RelativeLayout)findViewById(R.id.shippingRelative);

        shippingButton.setBackgroundColor(Color.parseColor("#ff90deff"));  // set it to blue
        sellerButton.setBackgroundColor(Color.parseColor("#ffe2deff")); // set it to gray
        basicButton.setBackgroundColor(Color.parseColor("#ffe2deff")); // set it to gray

        shippingRelative.setVisibility(View.VISIBLE);
        sellerRelative.setVisibility(View.INVISIBLE);
        basicRelative.setVisibility(View.INVISIBLE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
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
