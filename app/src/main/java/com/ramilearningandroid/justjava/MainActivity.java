package com.ramilearningandroid.justjava;

/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava; 
 */

import android.annotation.TargetApi;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private int quantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantity = toInt(((TextView) findViewById(R.id.quantity_text_view)).getText().toString());
    }

    private int toInt(String str){
        int result = 0;
        try{
            result = Integer.parseInt(str);
        }catch (Exception e){
            result = 0;
        }
        return result;
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = 5;
        display(quantity);
        displayPrice(quantity *price);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given quantity value on the screen
     * @param number - the number of the cups of coffee
     */
    @TargetApi(Build.VERSION_CODES.N)
    private void displayPrice(int number){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void increment(View view) {
        quantity++;
        display(quantity);
    }

    public void decrement(View view) {
        if (quantity > 0){
            quantity--;
        }
        display(quantity);
    }
}