package cat.udl.tidic.amd.mvvm.datamodels;

import androidx.annotation.NonNull;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import cat.udl.tidic.amd.mvvm.models.ZodiacSign;

public interface IZodiacSignsDataModel {


    @NonNull
    List<ZodiacSign> getListZodiacSigns() throws ParseException;

    @NonNull
    String getZodiacByDate(@NonNull final Date birthday);

}
