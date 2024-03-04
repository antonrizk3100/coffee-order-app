package com.example.justjava;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int count=0;

  public void increment(View view){
      if(count<10){
          count=count+1;
      }
        display_quantity(count);
  }
    public void decrement(View view) {
      if(count>0){
          count=count-1;
      }

        display_quantity(count);
    }

    public void summary(View view){
      int price = count*5;
        CheckBox whipped_cream_check_box = (CheckBox) findViewById(R.id.checkbox_whipped_cream);
        CheckBox chocolate_check_box = (CheckBox) findViewById(R.id.checkbox_chocolate);
        boolean whipped_cream_check = false;
        boolean chocolate_check = false;
        if(whipped_cream_check_box.isChecked()){
            whipped_cream_check=true;
            price =count*5 + count*1;
        }
        else {
            whipped_cream_check = false;
        }


        if(chocolate_check_box.isChecked()){
            chocolate_check=true;
            price = count*5 + count*2;

        }
        else {
            chocolate_check = false;
        }

        if(whipped_cream_check_box.isChecked()&&chocolate_check_box.isChecked()){

            price = count * 5 + count * 2 + count * 1;

        }

      EditText n = (EditText) findViewById(R.id.name_edit_text);
        String name = String.valueOf(n.getText());


        String message ="name :"+name;
        message+="\nquantity :"+count;
        message+="\n add whipped cream ?"+" "+whipped_cream_check;
        message+="\n add chocolate ?"+" "+chocolate_check;
        message+="\ntotal :"+price;
        message+="\n "+getString(R.string.thank_you);




        display_supmit_order(message);
    }



    private void display_quantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void display_supmit_order(String message) {
        TextView order_summary = (TextView) findViewById(R.id.order_summary_text);
        order_summary.setText(message);
    }

}