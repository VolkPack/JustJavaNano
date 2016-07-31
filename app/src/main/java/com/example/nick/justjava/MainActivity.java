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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDrinks();
        setTotal();
    }

    public void setDrinks()
    {
        TextView drinks_view = (TextView) findViewById(R.id.number_of_drinks);
        drinks_view.setText(Integer.toString(amount));
    }

    public void setTotal()
    {
        TextView total_view = (TextView) findViewById(R.id.total_due);
        total_view.setText(Float.toString(total));
        total = 0;
    }

    public void subtractDrink(View view)
    {
        //Check if amount of drunks is zero
        //Pops Up toast Saying cannot be less then 0
        if (amount == 0)
        {
            Context context = getApplicationContext();
            String toasts = getString(R.string.toast);
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, toasts, duration);
            toast.show();
        }
        else
        {
            amount = amount - 1;
            setDrinks();

        }
    }

    public void addDrink(View view)
    {

        amount = amount + 1;
        setDrinks();

    }

    public void calculateTotal(View view)
    {
        float price = Float.parseFloat(getString(R.string.price_of_latte));
        total = (total + (amount*price));
        setTotal();
    }




}
