package com.example.imran.doctorscorner;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.telecom.Call;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.imran.doctorscorner.FirstAid.FirstAid;

import com.example.imran.doctorscorner.ambulance.Ambulance;
import com.example.imran.doctorscorner.bloodbank.BloodBank;
import com.example.imran.doctorscorner.bloodbank.BloofBankDetails;
import com.example.imran.doctorscorner.healthtips.HealthTips;
import com.example.imran.doctorscorner.medicinecabinet.MedicineCabinet;
import com.example.imran.doctorscorner.topdoc.TopDoc;
import com.example.imran.doctorscorner.tophos.TopHos;

import java.util.ArrayList;


public class Hospitals extends AppCompatActivity implements Chittagong.onitemclick, Dhaka.onitemclickdhaka, Sylet.onitemclicksylet
        , Comilla.onitemclickcomilla, Kulna.onitemclickkulna, Rajshahi.onitemclickrajshahi,
        TopDoc.onitemclicktopdoc, TopHos.onitemclicktophos, BloodBank.OnItemSelectedListener, Ambulance.onitemclickambulance {
    public DrawerLayout mdrawerlayput;
    public ActionBarDrawerToggle mtoogle;
    //git remote add origin git@github.com:imrankashem/DoctorsCorener.git
//git push -u origin master
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Email = new Intent(Intent.ACTION_SEND);
                Email.setType("text/email");
                Email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"imransr6@gmail.com"});  //developer 's email
                Email.putExtra(Intent.EXTRA_SUBJECT,
                        "Add your Subject"); // Email 's Subject
                Email.putExtra(Intent.EXTRA_TEXT, "Dear Developer Name," + "");  //Email 's Greeting text
                startActivity(Intent.createChooser(Email, "Send Feedback:"));


            }
        });
        ImageButton ref = (ImageButton) findViewById(R.id.refresh);

        ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomClick(v);


            }
        });

        toolbar = (Toolbar) findViewById(R.id.nev_action);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.nev1);


        if (savedInstanceState != null) {
            return;
        }

//first activity
        Dhaka dha = new Dhaka();
        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.fragmentcontainer, dha);
        fragmentTransaction1.commit();

        //for the drawer layout
        mdrawerlayput = (DrawerLayout) findViewById(R.id.DrawerLayout);

        mtoogle = new ActionBarDrawerToggle(this, mdrawerlayput, R.string.open, R.string.close);

        mdrawerlayput.addDrawerListener(mtoogle);

        mtoogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView mNavigationView = (NavigationView) findViewById(R.id.nev);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override //menu item click
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    //ids from nevigation menu
                    case R.id.CHittagong:
                        Chittagong chi = new Chittagong();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slide_to_right);
                        fragmentTransaction.replace(R.id.fragmentcontainer, chi);
                        fragmentTransaction.commit();
                        mdrawerlayput.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.Dhhaka:
                        Dhaka dha = new Dhaka();
                        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction1.setCustomAnimations(R.anim.slide_from_left, R.anim.slide_to_right);
                        fragmentTransaction1.replace(R.id.fragmentcontainer, dha);
                        fragmentTransaction1.commit();

                        mdrawerlayput.closeDrawer(GravityCompat.START);
                        return true;
                    case R.id.Rajshahi:
                        Rajshahi raj = new Rajshahi();
                        FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction2.setCustomAnimations(R.anim.slide_from_left, R.anim.slide_to_right);
                        fragmentTransaction2.replace(R.id.fragmentcontainer, raj);
                        fragmentTransaction2.commit();
                        mdrawerlayput.closeDrawer(GravityCompat.START);
                        return true;
                    case R.id.Sylett:
                        Sylet sy = new Sylet();
                        FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction3.setCustomAnimations(R.anim.slide_from_left, R.anim.slide_to_right);
                        fragmentTransaction3.replace(R.id.fragmentcontainer, sy);
                        fragmentTransaction3.commit();
                        mdrawerlayput.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.Comilla:
                        Comilla com = new Comilla();
                        FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction4.setCustomAnimations(R.anim.slide_from_left, R.anim.slide_to_right);
                        fragmentTransaction4.replace(R.id.fragmentcontainer, com);
                        fragmentTransaction4.commit();
                        mdrawerlayput.closeDrawer(GravityCompat.START);
                        return true;
                    case R.id.Kulna:
                        Kulna kul = new Kulna();
                        FragmentTransaction fragmentTransaction5 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction5.setCustomAnimations(R.anim.slide_from_left, R.anim.slide_to_right);
                        fragmentTransaction5.replace(R.id.fragmentcontainer, kul);
                        fragmentTransaction5.commit();
                        mdrawerlayput.closeDrawer(GravityCompat.START);
                        return true;
                    case R.id.TRdoctors:
                        TopDoc topdoc = new TopDoc();
                        FragmentTransaction fragmentTransaction6 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction6.setCustomAnimations(R.anim.slide_from_left, R.anim.slide_to_right);
                        fragmentTransaction6.replace(R.id.fragmentcontainer, topdoc);
                        fragmentTransaction6.commit();
                        //to close drawer layput
                        mdrawerlayput.closeDrawer(GravityCompat.START);
                        return true;
                    case R.id.TRhospitals:
                        TopHos topHos = new TopHos();
                        FragmentTransaction fragmentTransaction7 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction7.setCustomAnimations(R.anim.slide_from_left, R.anim.slide_to_right);
                        fragmentTransaction7.replace(R.id.fragmentcontainer, topHos);
                        fragmentTransaction7.commit();
                        mdrawerlayput.closeDrawer(GravityCompat.START);
                        return true;
                    case R.id.firstaid:
                        FirstAid firstAid = new FirstAid();
                        FragmentTransaction fragmentTransaction8 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction8.setCustomAnimations(R.anim.slide_from_left, R.anim.slide_to_right);
                        fragmentTransaction8.replace(R.id.fragmentcontainer, firstAid);
                        fragmentTransaction8.commit();
                        mdrawerlayput.closeDrawer(GravityCompat.START);
                        return true;
                    case R.id.htips:
                        HealthTips healthTips = new HealthTips();
                        FragmentTransaction fragmentTransaction9 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction9.setCustomAnimations(R.anim.slide_from_left, R.anim.slide_to_right);
                        fragmentTransaction9.replace(R.id.fragmentcontainer, healthTips);
                        fragmentTransaction9.commit();
                        mdrawerlayput.closeDrawer(GravityCompat.START);
                        return true;


                    case R.id.blood:
                        BloodBank bloodBank = new BloodBank();
                        FragmentTransaction fragmentTransaction11 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction11.setCustomAnimations(R.anim.slide_from_left, R.anim.slide_to_right);
                        fragmentTransaction11.replace(R.id.fragmentcontainer, bloodBank);
                        fragmentTransaction11.commit();
                        mdrawerlayput.closeDrawer(GravityCompat.START);
                        return true;
                    case R.id.ambulance:
                        Ambulance ambulance = new Ambulance();
                        FragmentTransaction fragmentTransaction12 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction12.setCustomAnimations(R.anim.slide_from_left, R.anim.slide_to_right);
                        fragmentTransaction12.replace(R.id.fragmentcontainer, ambulance);
                        fragmentTransaction12.commit();
                        mdrawerlayput.closeDrawer(GravityCompat.START);
                        return true;

                }


                return true;


            }

        });


    }

    public void CustomClick(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.activity_toastlayout,
                (ViewGroup) findViewById(R.id.customtoast_layout));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("DONE ");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }


    //make the menu icon clickable
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (mtoogle.onOptionsItemSelected(item)) {
            return true;


        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

    //chittagong
    @Override
    public void onclick(Intent c) {
        startActivity(c);
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    //for dhaka
    @Override
    public void onclickdhaka(Intent d) {
        startActivity(d);
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    //for sylet
    @Override
    public void onclicksylet(Intent s) {
        startActivity(s);
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

    }

    @Override
    public void onclickcomilla(Intent co) {
        startActivity(co);
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    @Override
    public void onclickkulna(Intent k) {
        startActivity(k);
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    @Override
    public void onclickrajshahi(Intent r) {
        startActivity(r);
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    @Override
    public void onclicktopdoc(Intent td) {
        startActivity(td);
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    @Override
    public void onclicktophos(Intent th) {
        startActivity(th);
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    //blood bank
    @Override
    public void Ons(Intent position) {
        startActivity(position);
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

    }

    //for ambulance
    @Override
    public void onClick(Intent ambu) {
        startActivity(ambu);
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }
}












