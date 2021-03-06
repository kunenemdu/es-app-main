package com.example.fypmetroapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    ImageButton register, login, forgot;
    final Fragment loginFragment = new LoginFragment();
    final Fragment signupFragment = new SignupFragment();
    final Fragment forgotFragment = new ForgotPasswordFragment();
    Fragment placeholder;
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active;
    LinearLayout emailLL, passLL, resetLL, roleLL, logDetailsLL, logButtonLL;
    EditText email, password;
    public View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();

        fm.beginTransaction().add(R.id.content_account, forgotFragment, "1").hide(forgotFragment).commit();
        fm.beginTransaction().add(R.id.content_account, loginFragment, "2").hide(loginFragment).commit();
        fm.beginTransaction().add(R.id.content_account, signupFragment, "3").hide(signupFragment).commit();
        placeholder = new Fragment();

        active = placeholder;
    }

    @Override
    protected void onStart() {
        super.onStart();
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
        forgot = findViewById(R.id.resetBtn);

        logDetailsLL = findViewById(R.id.logDetailsLL);
        passLL = findViewById(R.id.passwordLL);
        resetLL = findViewById(R.id.resetLL);
        roleLL = findViewById(R.id.roleLL);
        logButtonLL = findViewById(R.id.logButtonLL);
        emailLL = findViewById(R.id.emailLL);
        email = findViewById(R.id.txtEmail);
        password = findViewById(R.id.txtPassword);

        login.setOnClickListener(ButtonClicked);
        register.setOnClickListener(ButtonClicked);
        forgot.setOnClickListener(ButtonClicked);
        // Check if user is signed in (non-null) and update UI accordingly.
    }

    private View.OnClickListener ButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.login:
                    if (active != loginFragment){
                        fm.beginTransaction()
                                .hide(active)
                                .show(loginFragment)
                                .setCustomAnimations(
                                        R.anim.fragment_open_enter,
                                        R.anim.fragment_fade_exit
                                )
                                .commit();
                        if (logDetailsLL.getVisibility() == View.GONE || logButtonLL.getVisibility() == View.GONE || resetLL.getVisibility() == View.GONE) {
                            logDetailsLL.setVisibility(View.VISIBLE);
                            logButtonLL.setVisibility(View.VISIBLE);
                            resetLL.setVisibility(View.VISIBLE);
                        }
                        active = loginFragment;
                    } else {
                        fm.beginTransaction()
                                .hide(active)
                                .setCustomAnimations(
                                        R.anim.fragment_open_enter,
                                        R.anim.fragment_fade_exit
                                )
                                .commit();
                        active = placeholder;
                    }
                    break;
                case R.id.register:
                    if (active != signupFragment) {
                        fm.beginTransaction()
                                .hide(active)
                                .show(signupFragment)
                                .setCustomAnimations(
                                        R.anim.fragment_open_enter,
                                        R.anim.fragment_fade_exit
                                )
                                .commit();
                        active = signupFragment;
                    } else {
                        fm.beginTransaction()
                                .hide(active)
                                .setCustomAnimations(
                                        R.anim.fragment_open_enter,
                                        R.anim.fragment_fade_exit
                                )
                                .commit();
                        active = placeholder;
                    }
                    break;

                case R.id.resetBtn:
                    fm.beginTransaction()
                            .hide(active)
                            .show(forgotFragment)
                            .setCustomAnimations(
                                    R.anim.fragment_open_enter,
                                    R.anim.fragment_fade_exit
                            )
                            .commit();
                    active = forgotFragment;
                    break;
            }
        }
    };

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
        super.onBackPressed();
    }
}