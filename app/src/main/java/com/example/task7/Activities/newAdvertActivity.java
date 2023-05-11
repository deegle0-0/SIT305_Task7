package com.example.task7.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.task7.MainActivity;
import com.example.task7.R;
import com.example.task7.adapter.AdvertViewModel;
import com.example.task7.data.Advert;

public class newAdvertActivity extends AppCompatActivity {

    RadioGroup radioGroup;

    Button save;
    EditText name,phone,desc,date,location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_advert);

        save = findViewById(R.id.button);
        name= findViewById(R.id.itemName);
        phone= findViewById(R.id.phoneNo);
        desc= findViewById(R.id.itemDesc);
        date= findViewById(R.id.date);
        location= findViewById(R.id.itemLocation);
        radioGroup = findViewById(R.id.radioGroup);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.lostItem)
                {
                    boolean found = false;
                    save.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent();
                            if(TextUtils.isEmpty(name.getText())){
                                setResult(RESULT_CANCELED, intent);
                            }
                            else{
                                String nameValue = name.getText().toString();
                                String descValue = desc.getText().toString();
                                String phoneVal = phone.getText().toString();
                                String dateVal = date.getText().toString();
                                String locationVal = location.getText().toString();

                                intent.putExtra("add_value1", nameValue);
                                intent.putExtra("add_value2", descValue);
                                intent.putExtra("add_value3", phoneVal);
                                intent.putExtra("add_value4", dateVal);
                                intent.putExtra("add_value5", locationVal);
                                intent.putExtra("add_value6", found);

                                setResult(RESULT_OK, intent);
                            }
                            finish();
                        }

                    });
                }
                else if(checkedId== R.id.foundButton)
                {
                    boolean found = true;
                    save.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent();
                            if(TextUtils.isEmpty(name.getText())){
                                setResult(RESULT_CANCELED, intent);
                            }
                            else{

                                String nameValue = name.getText().toString();
                                String descValue = desc.getText().toString();
                                String phoneVal = phone.getText().toString();
                                String dateVal = date.getText().toString();
                                String locationVal = location.getText().toString();

                                intent.putExtra("add_value1", nameValue);
                                intent.putExtra("add_value2", descValue);
                                intent.putExtra("add_value3", phoneVal);
                                intent.putExtra("add_value4", dateVal);
                                intent.putExtra("add_value5", locationVal);
                                intent.putExtra("add_value6", found);
                                setResult(RESULT_OK, intent);

                            }
                            finish();
                        }
                    });
                }
            }
        });

    }
}