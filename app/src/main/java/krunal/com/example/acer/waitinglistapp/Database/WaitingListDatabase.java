package krunal.com.example.acer.waitinglistapp.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by acer on 13-02-2018.
 */
@Database(entities = {WaitingListEntity.class},version = 1)
public abstract class WaitingListDatabase extends RoomDatabase {

    private static WaitingListDatabase INSTANCE;

    public abstract WaitingListDao getDao();

    static WaitingListDatabase getinstance(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context,WaitingListDatabase.class,"record").build();
        }
        return INSTANCE;
    }
}
