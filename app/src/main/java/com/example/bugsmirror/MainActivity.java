package com.example.bugsmirror;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    String[] stringlist ;
    ListView applists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void getPermission(View view){
        editText=findViewById(R.id.search);

        String temp=editText.getText().toString();
        stringlist=new String[1];
        stringlist[0]=temp;
        List<PackageInfo> Listapplication = getPackageManager().getPackagesHoldingPermissions(stringlist, PackageManager.GET_META_DATA);
        applists=findViewById(R.id.permissionsList);
        String[] temp_stringlist = new String[Listapplication.size()];
        int i = 0;
        for (PackageInfo app : Listapplication) {
            temp_stringlist[i] = app.packageName;
            i++;
        }

        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,temp_stringlist);
        applists.setAdapter(arr);

    }


}