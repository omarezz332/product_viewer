package com.example.omaradel.productviewer;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static final String PRODUCT_ID = "PRODUCT_ID ";//a public ID to control productid from detailActivity.
    public CoordinatorLayout coordinatorLayout;
    private static String webUrl = "https://www.facebook.com/H-Sport-1388674971422183/";//facebook of h+ sport
    private static String email = "info@hplussport.com"; //the email adress of h+ sport to send to
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;
    private String TAG = MainActivity.class.getSimpleName();
    // URL to get contacts JSON
    private static String url = "http://www.nweave.com/wp-content/uploads/2012/09/featured.txt";


   private ArrayList<product> list1_allproduct = new ArrayList<>();
    private ArrayList<product> list2_mostcheap = new ArrayList<>();
    private ArrayList<product> list3_mostexpensive = new ArrayList<>();
  //  RecyclerView recyclerView=findViewById(R.id.recycl_list) ;
    Fragment_allproduct fragment_allproduct=new Fragment_allproduct() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drowerlayout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_viw);
        navigationView.setNavigationItemSelectedListener(this);
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_continer,
//                new Fragment_allproduct()).commit()

        navigationView.setCheckedItem(R.id.all_products);
      // new load_Data().execute();
//        load_Data load_data = new load_Data(this,recyclerView);
//        list2_mostcheap = load_data.sort_contactList2();
//        list3_mostexpensive = load_data.sort_contactList3();
        new load_Data(this).execute();



    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.all_products:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_continer,
                        Fragment_allproduct.getInstance(list1_allproduct)).commit();
                // Fragment_allproduct.getInstance(list) == fragment frag = new Fragment(list);
                break;
            case R.id.Most_Cheapest_products:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_continer,
                        Fragment_mostcheap.getInstance(list2_mostcheap)).commit();
                break;
            case R.id.Most_Expensive_products:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_continer,
                        Fragment_mostexpensive.getInstance(list3_mostexpensive)).commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    public void fill_Recy1(final ArrayList<product> contactList1)
    {
        list1_allproduct=contactList1;
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_continer,
                Fragment_allproduct.getInstance(contactList1)).commit();
    }

    public void fill_Recy2(ArrayList<product> contactList2) {
        list2_mostcheap=contactList2;
    }
    public void fill_Recy3(ArrayList<product> contactList3) {
        list3_mostexpensive=contactList3;
    }
}
