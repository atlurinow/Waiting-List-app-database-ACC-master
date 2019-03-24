package krunal.com.example.acer.waitinglistapp.Database;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by acer on 13-02-2018.
 */

public class Repository {

    private LiveData<List<WaitingListEntity>> mwaitinglist;
    private WaitingListDatabase mwaitinglistdatabase;

    public Repository(Context context){
        this.mwaitinglistdatabase = WaitingListDatabase.getinstance(context);
        this.mwaitinglist = mwaitinglistdatabase.getDao().getAlllist();
    }

    public LiveData<List<WaitingListEntity>> getAllwaitinglist(){
        return mwaitinglist;
    }

    public void insert(WaitingListEntity waitingListEntity){
        new insertAsyTask(mwaitinglistdatabase).execute(waitingListEntity);
    }

    public void delete(WaitingListEntity waitingListEntity){
        new deleteAsyTask(mwaitinglistdatabase).execute(waitingListEntity);
    }

    private static class deleteAsyTask extends AsyncTask<WaitingListEntity,Void,Void>{

        private WaitingListDatabase db;

        deleteAsyTask(WaitingListDatabase db){
            this.db = db;
        }

        @Override
        protected Void doInBackground(WaitingListEntity... waitingListEntities) {
            db.getDao().delete(waitingListEntities[0]);
            return null;
        }
    }

    private static class insertAsyTask extends AsyncTask<WaitingListEntity,Void,Void>{

        private WaitingListDatabase db;

        insertAsyTask(WaitingListDatabase db){
            this.db = db;
        }

        @Override
        protected Void doInBackground(WaitingListEntity... waitingListEntities) {
            db.getDao().insert(waitingListEntities[0]);
            return null;
        }
    }


}
