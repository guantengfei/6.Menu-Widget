package com.example.a6menu_widget;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView mMyListView;
    Button mMyPopupMenu;
    PopupMenu popupMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mMyListView = (ListView) findViewById(R.id.mylistview);
        //创建数据源
        String[] list = new String[]{"选项1", "选项2", "选项3"};
        //创建适配器，管理数据源list
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, list);
        //View加载适配器，适配器关联View和数据源使用View显示数据源list数据
        mMyListView.setAdapter(arrayAdapter);
        registerForContextMenu(mMyListView);
        mMyPopupMenu = (Button) findViewById(R.id.mypopupmenu);
        popupMenu = new PopupMenu(this, mMyPopupMenu);
        //PopupMenu.inflate内部封装了getMenuInflater().inflate(menuRes, mMenu);
        //加载解析menu.xml文件
        popupMenu.inflate(R.menu.mymenu);
        mMyPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //显示PopupMenu菜单
                popupMenu.show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //每次长按View时都会调用onCreatContextMenu()方法
        Log.v("ContextMenu", "创建成功");
        //获取菜单解析器MenuInflater实例
        MenuInflater menuInflater = getMenuInflater();
        //解析器加载解析menu.xml文件
        menuInflater.inflate(R.menu.mymenu, menu);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action1) {
            return true;
        }
        if (id == R.id.action2) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
