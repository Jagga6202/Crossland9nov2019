package com.vjes.crossland.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import com.vjes.crossland.Adapter.CustomAdapter;
import com.vjes.crossland.Fragments.AboutUsFragment;
import com.vjes.crossland.Fragments.AlertFragment;
import com.vjes.crossland.Fragments.AustraliaFragment;
import com.vjes.crossland.Fragments.AustraliaSmFragment;
import com.vjes.crossland.Fragments.CaelFragment;
import com.vjes.crossland.Fragments.CanadaFragment;
import com.vjes.crossland.Fragments.CanadaSmFragment;
import com.vjes.crossland.Fragments.CelpiFragment;
import com.vjes.crossland.Fragments.EuropeFragment;
import com.vjes.crossland.Fragments.FranchiseFragment;
import com.vjes.crossland.Fragments.GermanyFragment;
import com.vjes.crossland.Fragments.IeltsFragment;
import com.vjes.crossland.Fragments.NewZealandFragment;
import com.vjes.crossland.Fragments.OetFragment;
import com.vjes.crossland.Fragments.PteFragment;
import com.vjes.crossland.Fragments.SingaporeFragment;
import com.vjes.crossland.Fragments.SpokenEnglishFragment;
import com.vjes.crossland.Fragments.ContactUsFragment;
import com.vjes.crossland.Fragments.UkFragment;
import com.vjes.crossland.Fragments.UsaFragment;
import com.vjes.crossland.Fragments.WorkWithUsFragment;
import com.vjes.crossland.Model.ChildInfo;
import com.vjes.crossland.Fragments.HomeFragment;
import com.vjes.crossland.Model.GroupInfo;
import com.vjes.crossland.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity
        /*implements NavigationView.OnNavigationItemSelectedListener*/ {
    private LinkedHashMap<String, GroupInfo> subjects = new LinkedHashMap<String, GroupInfo>();
    private ArrayList<GroupInfo> deptList = new ArrayList<GroupInfo>();

    private CustomAdapter listAdapter;
    private ExpandableListView simpleExpandableListView;
    private ImageView alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        loadData();
        alert=(ImageView)toolbar.findViewById(R.id.alert);
        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(new AlertFragment());
            }
        });

        //get reference of the ExpandableListView
        simpleExpandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        // create the adapter by passing your ArrayList data
        listAdapter = new CustomAdapter(MainActivity.this, deptList);
        // attach the adapter to the expandable list view
        simpleExpandableListView.setAdapter(listAdapter);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame, new HomeFragment());
        ft.commit();
        /*NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/
        simpleExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //get the group header
                GroupInfo headerInfo = deptList.get(groupPosition);
                //get the child info
                ChildInfo detailInfo =  headerInfo.getProductList().get(childPosition);
                //display it or do something with it
               // Toast.makeText(MainActivity.this, ""+detailInfo.getName(), Toast.LENGTH_SHORT).show();
                if(detailInfo.getName().equalsIgnoreCase("IELTS")){
                    addFragment(new IeltsFragment());
                }
                else if(detailInfo.getName().equalsIgnoreCase("PTE")){
                    addFragment(new PteFragment());
                }
                else if(detailInfo.getName().equalsIgnoreCase("OET")){
                    addFragment(new OetFragment());
                }
                else if(detailInfo.getName().equalsIgnoreCase("CAEL")){
                    addFragment(new CaelFragment());
                }
                else if(detailInfo.getName().equalsIgnoreCase("CELPIP")){
                    addFragment(new CelpiFragment());
                }
                else if(detailInfo.getName().equalsIgnoreCase("Spoken English")){
                    addFragment(new SpokenEnglishFragment());
                }
                else if(detailInfo.getName().equalsIgnoreCase("Australia")){
                    addFragment(new AustraliaFragment());
                }
                else if(detailInfo.getName().equalsIgnoreCase("Canada")){
                    addFragment(new CanadaFragment() );
                }
                else if(detailInfo.getName().equalsIgnoreCase("Germany")){
                    addFragment(new GermanyFragment());
                }
                else if(detailInfo.getName().equalsIgnoreCase("Europe")){
                    addFragment(new EuropeFragment());
                }
                else if(detailInfo.getName().equalsIgnoreCase("New Zealand")){
                   addFragment(new NewZealandFragment());
                }
                else if(detailInfo.getName().equalsIgnoreCase("Singapore")){
                    addFragment(new SingaporeFragment());
                }
                else if(detailInfo.getName().equalsIgnoreCase("UK")){
                    addFragment(new UkFragment());
                }
                else if(detailInfo.getName().equalsIgnoreCase("USA")){
                    addFragment(new UsaFragment());
                }
                //Skill Migtarion Australia(SM)
                else if(detailInfo.getName().equalsIgnoreCase("Australia(SM)")){
                    addFragment(new AustraliaSmFragment());
                }
                //Skill Migtarion Canada(SM)
                else if(detailInfo.getName().equalsIgnoreCase("Canada(SM)")){
                    addFragment(new CanadaSmFragment());
                }
                else if(detailInfo.getName().equalsIgnoreCase("Work With Us")){
                    addFragment(new WorkWithUsFragment());
                }
                //Skill Migtarion Canada(SM)
                else if(detailInfo.getName().equalsIgnoreCase("Franchise Enquiry")){
                    addFragment(new FranchiseFragment());
                }
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);

                return false;
            }
        });
        // setOnGroupClickListener listener for group heading click
        simpleExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                //get the group header
                GroupInfo headerInfo = deptList.get(groupPosition);
                //display it or do something with it

                if(headerInfo.getName().equalsIgnoreCase("Home")){
                    addFragment(new HomeFragment());
                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                    drawer.closeDrawer(GravityCompat.START);
                }
                else if(headerInfo.getName().equalsIgnoreCase("AboutUs")){

                    addFragment(new AboutUsFragment());
                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                    drawer.closeDrawer(GravityCompat.START);
                }
                else if(headerInfo.getName().equalsIgnoreCase("ContactUs")){
                    addFragment(new ContactUsFragment());
                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                    drawer.closeDrawer(GravityCompat.START);
                }


                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }


 /*   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    /*@SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/
    //load some initial data into out list
    private void loadData(){

        addProduct("Home","");
        addProduct("AboutUs","");
        addProduct("English Training","IELTS");
        addProduct("English Training","PTE");
        addProduct("English Training","OET");
        addProduct("English Training","CAEL");
        addProduct("English Training","CELPIP");
        addProduct("English Training","Spoken English");
        addProduct("Study Abroad","Australia");
        addProduct("Study Abroad","Canada");
        addProduct("Study Abroad","Germany");
        addProduct("Study Abroad","Europe");
        addProduct("Study Abroad","New Zealand");
        addProduct("Study Abroad","Singapore");
        addProduct("Study Abroad","UK");
        addProduct("Study Abroad","USA");
        addProduct("Skill Migration","Australia(SM)");
        addProduct("Skill Migration","Canada(SM)");
        addProduct("Join Us","Work With Us");
        addProduct("Join Us","Franchise Enquiry");
        addProduct("ContactUs","");

    }

    //here we maintain our products in various departments
    private int addProduct(String department, String product){

        int groupPosition = 0;

        //check the hash map if the group already exists
        GroupInfo headerInfo = subjects.get(department);
        //add the group if doesn't exists
        if(headerInfo == null){
            headerInfo = new GroupInfo();
            headerInfo.setName(department);
            subjects.put(department, headerInfo);
            deptList.add(headerInfo);
        }

        //get the children for the group
        ArrayList<ChildInfo> productList = headerInfo.getProductList();
        //size of the children list
        int listSize = productList.size();
        //add to the counter
        listSize++;
if(product.equals("")){

}
else{
    //create a new child and add that to the group
    ChildInfo detailInfo = new ChildInfo();
   // detailInfo.setSequence(String.valueOf(listSize));
    detailInfo.setName(product);
    productList.add(detailInfo);
    headerInfo.setProductList(productList);
}

        //find the group position inside the list
        groupPosition = deptList.indexOf(headerInfo);
        return groupPosition;
    }


    public void addFragment(Fragment fragment){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frame,fragment);
        ft.commit();
        ft.addToBackStack(null);

    }




}
