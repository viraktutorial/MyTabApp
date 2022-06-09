package com.virak.mytabapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TabLayoutMediator.TabConfigurationStrategy{
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    ArrayList<String> titles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tabLayout=findViewById(R.id.tabLayout);
        viewPager2=findViewById(R.id.viewPager2);
        titles=new ArrayList<String>();
        titles.add("Tasks");
        titles.add("Events");
        titles.add("News");

        ViewPager2Adapter viewPager2Adapter = new ViewPager2Adapter(this);
        ArrayList<Fragment> fragmentList=new ArrayList<Fragment>();
        fragmentList.add(new TaskFragment());
        fragmentList.add(new EventFragment());
        fragmentList.add(new NewsFragment());
        viewPager2Adapter.setData(fragmentList);
        viewPager2.setAdapter(viewPager2Adapter);

        new TabLayoutMediator(tabLayout, viewPager2, this).attach();



    }

    @Override
    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
        tab.setText(titles.get(position));
    }

    public void addTaskClickListener(View view){
        TaskDialogFragment taskDialog=new TaskDialogFragment();
        taskDialog.show(getSupportFragmentManager(), "taskDialogTag");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuitem_search:
                Toast.makeText(this, getString(R.string.ui_menu_search),
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuitem_send:
                Toast.makeText(this, getString(R.string.ui_menu_send),
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuitem_add:
                Toast.makeText(this, getString(R.string.ui_menu_add),
                        Toast.LENGTH_SHORT).show();

                return true;
            case R.id.menuitem_share:
                Toast.makeText(this, getString(R.string.ui_menu_share),
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuitem_feedback:
                Toast.makeText(this, getString(R.string.ui_menu_feedback),
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuitem_about:
                Toast.makeText(this, getString(R.string.ui_menu_about),
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuitem_quit:
                Toast.makeText(this, getString(R.string.ui_menu_quit), Toast.LENGTH_SHORT).show();
                finish(); // close the activity
                return true;
        }
        return false;
    }
}