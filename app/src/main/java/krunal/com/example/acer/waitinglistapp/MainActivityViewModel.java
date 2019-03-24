package krunal.com.example.acer.waitinglistapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import krunal.com.example.acer.waitinglistapp.Database.Repository;
import krunal.com.example.acer.waitinglistapp.Database.WaitingListEntity;

/**
 * Created by Anusha
 * .
 */

public class MainActivityViewModel extends AndroidViewModel {

    private LiveData<List<WaitingListEntity>> mWaitingList;

    private Repository mrepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.mrepository = new Repository(application);
        this.mWaitingList = mrepository.getAllwaitinglist();
    }
    /**
     * Created by Anusha
     * Waitinglist adding to the repository.
     */
     LiveData<List<WaitingListEntity>> getList(){
        return mWaitingList;
    }

     void insert(WaitingListEntity waitingListEntity){
        mrepository.insert(waitingListEntity);
    }

     void delete(WaitingListEntity waitingListEntity){
        mrepository.delete(waitingListEntity);
    }

}
