package com.thickman.brewbro;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

    private Toolbar tbToolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private ListView leftDrawerList;
    private ArrayAdapter<String> navigationDrawerAdapter;
    private String[] leftSliderData = {"Recipes", "Brix Calculator"};
    private FrameLayout flContentView;
    private FloatingActionButton fabButton;

    public static final int FRAGMENT_RECIPES = 0;
    public static final int FRAGMENT_BRIX_CALCULATOR = 1;
    public static final int FRAGMENT_EDIT_RECIPE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        if (tbToolbar != null) {
            tbToolbar.setTitle(getResources().getString(R.string.app_name));
            setSupportActionBar(tbToolbar);
        }

        initDrawer();

        fabButton = new FloatingActionButton.Builder(this)
                .withDrawable(
                        getResources().getDrawable(R.drawable.ic_plus_white_24dp))
                .withButtonColor(getResources().getColor(R.color.amber_dark))
                .withGravity(Gravity.BOTTOM | Gravity.RIGHT)
                .withMargins(0, 0, 12, 12)
                .create();
        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectFragment(MainActivity.FRAGMENT_EDIT_RECIPE);
            }
        });

        selectFragment(FRAGMENT_RECIPES);
    }

    private void initView() {
        tbToolbar = (Toolbar) findViewById(R.id.tbToolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationDrawerAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, leftSliderData);

        leftDrawerList = (ListView) findViewById(R.id.left_drawer);
        leftDrawerList.setAdapter(navigationDrawerAdapter);
        leftDrawerList.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectFragment(position);
            }
        });
    }

    private void initDrawer() {
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, tbToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                fabButton.setVisibility(View.VISIBLE);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                fabButton.setVisibility(View.GONE);
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
    }

    public void selectFragment(int fragment) {
        selectFragment(fragment, null);
    }

    public void selectFragment(int fragment, Bundle extras) {

        Fragment newFragment = null;

        switch (fragment) {
            case FRAGMENT_RECIPES:
                newFragment = new MainFragment();
                break;
            case FRAGMENT_BRIX_CALCULATOR:
                newFragment = new BrixCalculatorFragment();
                break;
            case FRAGMENT_EDIT_RECIPE:
                newFragment = new RecipeFragment();
                break;
            default:
                newFragment = new MainFragment();
                break;
        }

        if (extras != null)
            newFragment.setArguments(extras);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.flContentView, newFragment)
                .addToBackStack("FRAGMENT_" + String.valueOf(fragment))
                .commit();

        fabButton.setVisibility(fragment == FRAGMENT_RECIPES ? View.VISIBLE : View.GONE);

        drawerLayout.closeDrawers();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (drawerToggle != null)
            drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (drawerToggle != null)
            drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
