package com.bdtask.noteappsusingroomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bdtask.noteappsusingroomdatabase.db.EmployeesDatabaseClass;
import com.bdtask.noteappsusingroomdatabase.entities.Employee;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    EditText nameET;
    EditText ageET;
    EditText salaryET;
    @BindView(R.id.submit_button)
    Button submit_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passdataTodb();
            }
        });
    }
    
    private void init() {
         nameET = findViewById(R.id.name);
         ageET = findViewById(R.id.age);
         salaryET = findViewById(R.id.salary);
    }

    public void passdataTodb(){
        String name = nameET.getText().toString();
        String age = ageET.getText().toString();
        String salary = salaryET.getText().toString();
        int agei = Integer.parseInt(age);
        double salaeryi = Double.parseDouble(salary);
        Employee employee = new Employee( name, agei, salaeryi);
        long rowId =  EmployeesDatabaseClass.getInstance(this)
                .getAllEmployeeDao()
                .insertNewEmployee(employee);
        if(rowId > 0){
            Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
        }

    }

}