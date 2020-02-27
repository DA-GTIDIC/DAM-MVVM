package cat.udl.tidic.amd.mvvm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    @NonNull
    private MainViewModel mViewModel = new MainViewModel();

    private DatePicker birthdayDatePicker;
    private TextView zodiacTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configView();
    }


    private  void configView(){

        birthdayDatePicker = findViewById(R.id.datePicker_birthday);
        zodiacTextView = findViewById(R.id.textView_bio);


        final Observer<String> observer = s -> zodiacTextView.setText(s);

        mViewModel.getZodiac().observe(this, observer);

    }


    public void updateButtonOnClick(View v){
        Calendar c = Calendar.getInstance();
        c.set(birthdayDatePicker.getYear(), birthdayDatePicker.getMonth(),
                birthdayDatePicker.getDayOfMonth());
        Date date = new Date(c.getTimeInMillis());
        mViewModel.zodiac(date);
        Log.d("Main", "Actualitzo la data al ViewModel");

    }

    public void resetButtonOnClick(View v){
        Calendar c = Calendar.getInstance();
        birthdayDatePicker.updateDate(c.get(Calendar.YEAR),c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH));
    }






}


