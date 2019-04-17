/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int number_of_coffees = 0;

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int total;
        boolean whippedCream, nutella, chocolate;
        String customer, salutation;
        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whippedcream_checkbox);
        CheckBox nutellaCheckbox = (CheckBox) findViewById(R.id.nutella_checkbox);
        CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        whippedCream = whippedCreamCheckbox.isChecked();
        nutella = nutellaCheckbox.isChecked();
        chocolate = chocolateCheckbox.isChecked();
        customer = "Coffee Customer";
        salutation = "Thank you!";
        total = (number_of_coffees*15);
        createOrderSummary(total,customer,salutation,whippedCream,nutella,chocolate);
    }

    public void increament(View view) {
        number_of_coffees = number_of_coffees + 1;
        display(number_of_coffees);
    }

    public void decreament(View view) {
        number_of_coffees = number_of_coffees - 1;
        if (number_of_coffees < 0){
            number_of_coffees=0;
        }
        display(number_of_coffees);
    }

    public void createOrderSummary(int price, String name, String greet, boolean whippedCream, boolean nutella, boolean chocolate){
        String priceMessage = "";
        priceMessage = priceMessage + "Name: " + name;
        priceMessage = priceMessage +  "\nQuantity: " + number_of_coffees;
        if (whippedCream == false && nutella == false && chocolate == false)
            priceMessage = priceMessage + "\nWithout Toppings\n";
        if ((whippedCream || nutella || chocolate) == true)
            priceMessage = priceMessage + "\nWith added Toppings:\n";
        if(whippedCream==true) {
            priceMessage = priceMessage + "\tWhipped Cream\n";
            price = price + (10*number_of_coffees);
        }
        if(nutella==true) {
            priceMessage = priceMessage + "\tNutella\n";
            price = price + (8*number_of_coffees);
        }
        if(chocolate==true) {
            priceMessage = priceMessage + "\tChocolate\n";
            price = price + (7*number_of_coffees);
        }
        priceMessage = priceMessage + "Total: ₹" + price + "\n" + greet;
        displayMessage(priceMessage);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.orderSummary_text_view);
        orderSummaryTextView.setText(message);
    }
}
