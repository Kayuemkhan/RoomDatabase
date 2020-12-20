package com.bdtask.noteappsusingroomdatabase.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.bdtask.noteappsusingroomdatabase.entities.Employee;

import java.util.List;

@Dao
public interface EmployeeDao {
    @Insert
    long insertNewEmployee(Employee employee);

    @Query("select * from tbl_employee")
    List<Employee> getAllemployes();

    @Update
    int UpdateEmployee(Employee employee);

    @Delete
    int deleteEmployee(Employee employee);

}
