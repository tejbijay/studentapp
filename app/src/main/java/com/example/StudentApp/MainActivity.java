package com.example.StudentApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.StudentApp.FragmentStd.AboutUsFragment;
import com.example.StudentApp.FragmentStd.AddStdFragment;
import com.example.StudentApp.FragmentStd.HomeFragment;
import com.example.StudentApp.Model.Student;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    FrameLayout main_layout;
    public static List<Student> students = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottom_navigation);
        main_layout = findViewById(R.id.MainLayout);
        students.add(new Student("Tej Singh Chaudhary", 24, "male", "kalanki", R.drawable.tejsinghchaudhary));
        students.add(new Student("Bijay Chaudhary", 25, "Male", "Butwal", R.drawable.malephoto));
        students.add(new Student("Girl", 23, "Female", "Chitwan", R.drawable.femalephotos));

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.Nav_Home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.Nav_AboutUs:
                        fragment = new AboutUsFragment();
                        break;
                    case R.id.Nav_AddStudent:
                        fragment = new AddStdFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.MainLayout,
                        fragment).commit();
                return true;

            }
        });
    }
     }



