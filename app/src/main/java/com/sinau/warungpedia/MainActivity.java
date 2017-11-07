package com.sinau.warungpedia;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.ExpandableBadgeDrawerItem;
import com.mikepenz.materialdrawer.model.ExpandableDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;


import java.util.List;


public class MainActivity extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        new DrawerBuilder().withActivity(this).build();

        PrimaryDrawerItem beranda = new PrimaryDrawerItem().withIdentifier(1).withName("Beranda");
        PrimaryDrawerItem kategori = new PrimaryDrawerItem().withIdentifier(1).withName("Kategori");
        PrimaryDrawerItem masuk = new PrimaryDrawerItem().withIdentifier(1).withName("Masuk");
        PrimaryDrawerItem daftar = new PrimaryDrawerItem().withIdentifier(1).withName("Daftar");
        PrimaryDrawerItem kosong = new PrimaryDrawerItem().withIdentifier(1).withName("");
        PrimaryDrawerItem kosong1 = new PrimaryDrawerItem().withIdentifier(1).withName("");

//if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("home");
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName("   atur");
//create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        new SecondaryDrawerItem()
//                                .withTypeface (yourTypeface)//jika menggunakan font
                        ,
                        item2,
                        new SecondaryDrawerItem().withName("setting")
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        return false;
                    }
                })
                .build(); //ini membuild default tanpa nav header

// Create the AccountHeader
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.warung)
                .withHeaderBackgroundScaleType(ImageView.ScaleType.CENTER_CROP)
                .addProfiles(
                        new ProfileDrawerItem().withName("Android").withEmail("android@gmail.com").withIcon(getResources().getDrawable(R.mipmap.ic_launcher))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

        //Now create your drawer and pass the AccountHeader.Result
        new DrawerBuilder()
        .withActivity(this)

                .withToolbar (toolbar)
                .withActionBarDrawerToggleAnimated (true)
//                .withDisplayBelowStatusBar(true)
//                .withTranslucentStatusBar(true)
                .withActionBarDrawerToggle(true)
                .withAccountHeader(headerResult)


                .addDrawerItems(
                        beranda,kategori,masuk,daftar,kosong,kosong1,





                        item1,
                new DividerDrawerItem(),//menggunakan garis
                item2,
                        new SecondaryDrawerItem().withName("setting"),
        new ExpandableBadgeDrawerItem().withSubItems(item1),
                        new ExpandableDrawerItem().withName("list").withSubItems(item2)
                )

        //additional Drawer setup as shown above

    .build();



    }}
