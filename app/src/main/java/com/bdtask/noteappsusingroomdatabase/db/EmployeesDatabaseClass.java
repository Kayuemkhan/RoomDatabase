package com.bdtask.noteappsusingroomdatabase.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.bdtask.noteappsusingroomdatabase.daos.EmployeeDao;
import com.bdtask.noteappsusingroomdatabase.entities.Employee;

@Database(entities = {Employee.class}, version = 1 )
public abstract class EmployeesDatabaseClass extends RoomDatabase {
    private static EmployeesDatabaseClass db;

    public abstract EmployeeDao getAllEmployeeDao();

    public static EmployeesDatabaseClass getInstance(Context context) {
        if ( db != null ) {
            return db;
        }
        db = Room.databaseBuilder(context,
                EmployeesDatabaseClass.class, "emp_db")
                 .allowMainThreadQueries()
                .build();

        return db;

    }
}



