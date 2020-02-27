package cat.udl.tidic.amd.mvvm;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Date;

import cat.udl.tidic.amd.mvvm.datamodels.ZodiacSignsDataModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<String> zodiacSign;
    private ZodiacSignsDataModel mDataModel;

    public MainViewModel(){
        zodiacSign = new MutableLiveData<>();
        mDataModel = new ZodiacSignsDataModel();
    }

    public LiveData<String> getZodiac(){
        return zodiacSign;
    }

    public void zodiac(Date date ){
        zodiacSign.setValue(mDataModel.getZodiacByDate(date));
    }

}
