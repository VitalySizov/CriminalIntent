package com.sizov.vitaly.criminalintent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CrimeActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);

        // Получение объекта FragmentManager
        FragmentManager fm = getSupportFragmentManager();

        // Фрагмент для управления
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);

        if (fragment == null) {
            fragment = new CrimeFragment();
            fm.beginTransaction() // создание и закрепление транзакции
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }
    }
}
