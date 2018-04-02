package com.aobri.omaccollection.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aobri.omaccollection.R;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * This app displays an order form to order coffee.
 */
public class AppJustJavaActivity extends AppCompatActivity {

    int quantity = 1;
    int basePrice = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_just_java);
        setTitle(R.string.app_just_java_name);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        String name = ((EditText) findViewById(R.id.name_edit_text)).getText().toString().trim();
        boolean hasWhippedCream = ((CheckBox) findViewById(R.id.topping_1_text_view)).isChecked();
        boolean hasChocolate = ((CheckBox) findViewById(R.id.topping_2_text_view)).isChecked();
        int price = calculatePrice(quantity, basePrice, hasWhippedCream, hasChocolate);
        String summary = createOrderSummary(name, price, hasWhippedCream, hasChocolate);
        displayMessage(summary);
    }

    public void sendEmail(View view) {

        String name = ((EditText) findViewById(R.id.name_edit_text)).getText().toString().trim();
        boolean hasWhippedCream = ((CheckBox) findViewById(R.id.topping_1_text_view)).isChecked();
        boolean hasChocolate = ((CheckBox) findViewById(R.id.topping_2_text_view)).isChecked();
        int price = calculatePrice(quantity, 5, hasWhippedCream, hasChocolate);
        String summary = createOrderSummary(name, price, hasWhippedCream, hasChocolate);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        //intent.putExtra(Intent.EXTRA_EMAIL, null);
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject));
        intent.putExtra(Intent.EXTRA_TEXT, summary);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * Calculates the price of the order.
     *
     * @param quantity  is the number of cups of coffee ordered
     * @param basePrice is the price of one cup of coffee
     */
    private int calculatePrice(int quantity, int basePrice, boolean addWhippedCream, boolean addChocolate) {
        basePrice += addWhippedCream ? 1 : 0;
        basePrice += addChocolate ? 2 : 0;
        return quantity * basePrice;
    }

    /**
     * @param price of the ordered items
     * @return the order summary
     */
    private String createOrderSummary(String name, int price, boolean hasWhippedCream, boolean hasChocolate) {
        return getString(R.string.summary_name, name) +
                "\n" + getString(R.string.summary_whipped_cream, hasWhippedCream) +
                "\n" + getString(R.string.summary_chocolate, hasChocolate) +
                "\n" + getString(R.string.summary_quantity, quantity) +
                "\n" + getString(R.string.summary_total, NumberFormat.getCurrencyInstance().format(price)) +
                "\n" + getString(R.string.summary_thank_you);
    }

    /**
     * increases quantity of cups
     *
     * @param view for + button click
     */
    public void increment(View view) {
        if (quantity < 100) {
            quantity++;
            displayQuantity(quantity);
        } else {
            Toast.makeText(this, R.string.max_cups_limit, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * decreases quantity of cups
     *
     * @param view for - button click
     */
    public void decrement(View view) {
        if (quantity > 1) {
            quantity--;
            displayQuantity(quantity);
        } else {
            Toast.makeText(this, R.string.min_cups_limit, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.format(Locale.getDefault(), "%d", number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}