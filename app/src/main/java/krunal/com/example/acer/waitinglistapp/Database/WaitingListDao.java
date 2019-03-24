package krunal.com.example.acer.waitinglistapp.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by acer on 13-02-2018.
 */
@Dao
public interface WaitingListDao {

    @Query("select * from Waiting_table")
    LiveData<List<WaitingListEntity>> getAlllist();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(WaitingListEntity waitingListEntity);

    @Delete
    void delete(WaitingListEntity waitingListEntity);

}
