package com.example.StudentApp.FragmentStd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.StudentApp.MainActivity;
import com.example.StudentApp.Model.Student;
import com.example.StudentApp.R;

public class AddStdFragment extends Fragment {
   private EditText name, age, address;
   private RadioGroup rdoGender;
   private Button btnSave;
   private RadioButton btnGender;
   private int image;

    public  AddStdFragment(){

    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
                             @NonNull Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.add_std_details, container, false);
        name = view.findViewById(R.id.EnterFullName);
        age = view.findViewById(R.id.EnterAge);
        rdoGender = view.findViewById(R.id.RadioGender);
        address = view.findViewById(R.id.EnterAddress);
        btnSave = view.findViewById(R.id.BottonSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(name.equals("")){
                    name.setError("Enter the username did not match");
                    return;
                }
                if (age.equals("")){
                    age.setError("Enter the age");
                    return;
                }
                if (address.equals("")){
                    address.setError("Enter the address");
                    return;
                }
                int selectGender = rdoGender.getCheckedRadioButtonId();
                btnGender = view.findViewById(selectGender);

                switch (btnGender.getText().toString()){
                    case "Male":
                        image = R.drawable.malephoto;
                        break;
                    case "Female":
                        image = R.drawable.femalephotos;
                        break;
                    case "Others":
                        image = R.drawable.heros;
                        break;
                }
                MainActivity.students.add(new Student(name.getText().toString(),Integer.parseInt(age.getText().toString()),btnGender.getText().toString(),address.getText().toString(),image));

                Toast toast = Toast.makeText(getContext(), "Student Details Saved", Toast.LENGTH_LONG);
                toast.show();
            }
        });
        return view;
    }



    }



