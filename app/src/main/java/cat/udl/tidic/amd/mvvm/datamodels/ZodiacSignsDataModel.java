package cat.udl.tidic.amd.mvvm.datamodels;


import androidx.annotation.NonNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import cat.udl.tidic.amd.mvvm.models.ZodiacSign;

public class ZodiacSignsDataModel implements IZodiacSignsDataModel {

    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM", Locale.ENGLISH);

    public ZodiacSignsDataModel() {

    }

    @NonNull
    @Override
    public List<ZodiacSign> getListZodiacSigns() throws ParseException {
        return Arrays
                .asList(

                        new ZodiacSign("Aquarius","" , formatter.parse("20-01"),
                                formatter.parse("18-02") ),

                        new ZodiacSign("Pisces","" , formatter.parse("19-02"),
                                formatter.parse("20-03") ),

                        new ZodiacSign("Aries","" , formatter.parse("21-03"),
                                formatter.parse("19-04") ),

                        new ZodiacSign("Taurus","" , formatter.parse("20-04"),
                                formatter.parse("20-05") ),

                        new ZodiacSign("Gemini","" , formatter.parse("21-05"),
                                formatter.parse("20-06") ),

                        new ZodiacSign("Cancer","" , formatter.parse("21-06"),
                                formatter.parse("22-07") ),

                        new ZodiacSign("Leo","" , formatter.parse("23-07"),
                                formatter.parse("22-08") ),

                        new ZodiacSign("Virgo","" , formatter.parse("23-08"),
                                formatter.parse("22-09") ),

                        new ZodiacSign("Libra","" , formatter.parse("23-09"),
                                formatter.parse("22-10") ),

                        new ZodiacSign("Scorpio","" , formatter.parse("23-10"),
                                formatter.parse("21-11") ),

                        new ZodiacSign("Sagitarius","" , formatter.parse("22-11"),
                                formatter.parse("21-12") ),

                        new ZodiacSign("Capricorn","" , formatter.parse("22-12"),
                                formatter.parse("19-01") )


                        );
    }

    @NonNull
    public String getZodiacByDate(@NonNull Date birthday) {

        try {
            for (ZodiacSign sign : this.getListZodiacSigns()) {
                if (isIn(birthday,sign.getFrom(),sign.getTo())){
                    return sign.getName();
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }

    private Boolean isIn(Date date, Date from, Date to){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        try {
            date = formatter.parse(calendar.get(Calendar.DAY_OF_MONTH) + "-" +
                    calendar.get(Calendar.MONTH));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date != null) {
            return from.compareTo(date) * date.compareTo(to) >= 0;
        }

        return Boolean.FALSE;
    }
}


