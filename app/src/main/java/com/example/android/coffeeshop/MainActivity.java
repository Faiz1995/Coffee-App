package com.example.android.coffeeshop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity = 0;
    String name = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {



        Toast.makeText(this,"Thank You for ordering !!!",Toast.LENGTH_SHORT).show();
        displayName();

        CheckBox topping1 = (CheckBox) findViewById(R.id.toppingchecker);
        boolean topcheck1 = topping1.isChecked();

        CheckBox topping2 = (CheckBox) findViewById(R.id.chocolate_topping_checker);
        boolean topcheck2 = topping2.isChecked();

               /*  INTENT WORKING */
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee Order for " + name );
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


        if((topcheck1==true)&&(topcheck2==true)){

            int finalprice = quantity * 10;
            String message =  "Name : " +  name +  " \n" + "Quantity : " + quantity  + "\n" + "Whipped Topping : " + topcheck1 + "\n" + "Chocolate Topping : " + topcheck2 + "\n" +   "Total amount : " + finalprice + "\n" +  "Thank You !!! ";
            displayMessage(message);

            displayPrice(quantity * 10);



        }


        else if (topcheck1 == true)
        {
            int finalprice = quantity * 5 + quantity;
            String message =  "Name : " + name +  " \n" + "Quantity : " + quantity  + "\n" + "Whipped Topping : " + topcheck1 + "\n" + "Chocolate Topping : " + topcheck2 + "\n" +   "Total amount : " + finalprice + "\n" +  "Thank You !!! ";
            displayMessage(message);

            displayPrice(quantity * 5 + quantity);


        }
        else if (topcheck2 == true)
        {
            int finalprice = quantity * 5 + quantity * 2;
            String message =  "Name : " +  name +  " \n" + "Quantity : " + quantity  + "\n" + "Whipped Topping : " + topcheck1 + "\n" + "Chocolate Topping : " + topcheck2 + "\n" +   "Total amount : " + finalprice + "\n" +  "Thank You !!! ";
            displayMessage(message);

            displayPrice(quantity * 5 + quantity * 2);


        }

        else
        { displayPrice(quantity * 5);
            int finalprice = quantity * 5 ;
            String message =  "Name : " + name  + " \n" + "Quantity :  " + quantity + "\n" + "Whipped Topping : " + topcheck1 + "\n" + "Chocolate Topping : " + topcheck2 + "\n" +   "Total amount : " + finalprice + "\n" +  "Thank You !!! ";
            displayMessage(message);

        }

    }
    /**
     * This method is called when the increment button is clicked.
     */


    public void increment(View view){

        quantity = quantity + 1 ;
        display(quantity);
    }
    /**
     * This method is called when the decrement button is clicked.
     */

    public void decrement(View view){
        if(quantity > 0) {
            quantity = quantity - 1;
            display(quantity);
        }
        else { quantity = quantity;}
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);

    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    public void displayMessage (String message){

        TextView messagegetter = (TextView) findViewById(R.id.messagegetter);
        messagegetter.setText(message);
    }

    public void displayName(){

        EditText namefield = (EditText) findViewById(R.id.name_field);
        name = namefield.getText().toString();

    }

}
