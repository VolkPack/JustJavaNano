package com.example.nick.justjava;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends ActionBarActivity {

    public int amount = 0;
    public float total = 0;


    /**
     * onCreate sets TextView @id/number_of_drink to Display 0
     * onCreate sets TextView @id/total_due to Display 0
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDrinks();
        setTotal();
    }

    /**
     * Displays the amount of Drinks ordered in TextView @id/number_of_drinks
     */
    public void setDrinks()
    {
        TextView drinks_view = (TextView) findViewById(R.id.number_of_drinks);
        drinks_view.setText(Integer.toString(amount));
    }

    /**
     * Displays the Total in the TextView @id/total_due
     */
    public void setTotal()
    {
        TextView total_view = (TextView) findViewById(R.id.total_due);
        total_view.setText(Float.toString(total));
        total = 0;
    }

    /**
     * Sets TextView @id/thanks to empty String
     */
    public void resetThank()
    {
        TextView thanks = (TextView) findViewById(R.id.thanks);
        thanks.setText("");
    }

    /**
     * if amount of drinks is > 0
     * onClick @id/less_button subtracts 1 from amount of Drinks
     * if amount of drunks < 0
     * Displays toast to notify user that no drinks are ordered
     * Resets TextView @id/thanks to empty String
     * Resets TextView @id/total_due to 0
     * @param view
     */
    public void subtractDrink(View view)
    {
        //Check if amount of drunks is zero
        //Pops Up toast Saying cannot be less then 0
        resetThank();
        resetTotal();
        if (amount == 0)
        {
            noDrinks();
        }
        else
        {
            amount = amount - 1;
            setDrinks();

        }
    }

    /**
     * onClick @id/more_button adds 1 to the ammount of drinks
     * Resets TextView @id/thanks to empty String
     * Resets TextView @id/total_due to 0
     * @param view
     */
    public void addDrink(View view)
    {
        resetThank();
        resetTotal();
        amount = amount + 1;
        setDrinks();

    }

    /**
     * Displayes toast notification that no drinks are ordered
     */
    public void noDrinks()
    {
        Context context = getApplicationContext();
        String toasts = getString(R.string.toast);
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, toasts, duration);
        toast.show();
    }

    /**
     * Calculates total and displayes amount in TextView @id/total_due
     * if no drinks are ordered displays a toast notification
     * sets TextView @id/thanks to dispay "Thank you"
     * @param view
     */
    public void calculateTotal(View view)
    {
        float price = Float.parseFloat(getString(R.string.price_of_latte));
        if(amount != 0)
        {
            total = (total + (amount * price));
            setTotal();
            TextView thanks = (TextView) findViewById(R.id.thanks);
            thanks.setText(getString(R.string.thanks));
        }
        else
        {
            noDrinks();
        }
    }

    /**
     * Rests String in TextView @id/total_due to 0
     */
    public void resetTotal()
    {
        total = 0;
        TextView total_view = (TextView) findViewById(R.id.total_due);
        total_view.setText(Float.toString(total));
    }




}
