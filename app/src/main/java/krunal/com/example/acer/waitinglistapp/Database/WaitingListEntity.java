package krunal.com.example.acer.waitinglistapp.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by acer on 13-02-2018.
 */
@Entity(tableName = "Waiting_table")
public class WaitingListEntity {

    @NonNull
    @ColumnInfo(name = "ID")
    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name = "Name")
    private String name;

    @ColumnInfo(name = "Number")
    private int number;

    public WaitingListEntity(){

    }

    public WaitingListEntity(String name,int num){
        this.name = name;
        this.number = num;
    }

    @NonNull
    int getID() {
        return ID;
    }

    public void setID(@NonNull int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
