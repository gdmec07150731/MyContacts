package cn.edu.gdmec.s07150731.mycontacts;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nameedittext;
    private EditText mobileedittext;
    private EditText qqedittext;
    private EditText danweiedittext;
    private EditText addressedittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("添加联系人");
        nameedittext= (EditText) findViewById(R.id.name);
        mobileedittext= (EditText) findViewById(R.id.mobile);
        danweiedittext= (EditText) findViewById(R.id.danwei);
        qqedittext= (EditText) findViewById(R.id.qq);
        addressedittext= (EditText) findViewById(R.id.address);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,1,Menu.NONE,"保存");
        menu.add(Menu.NONE,2,Menu.NONE,"返回");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                if (!nameedittext.getText().toString().equals("")){
                    User user=new User();
                    user.setName(nameedittext.getText().toString());
                    user.setMobile(mobileedittext.getText().toString());
                    user.setDanwei(danweiedittext.getText().toString());
                    user.setQq(qqedittext.getText().toString());
                    user.setAddress(addressedittext.getText().toString());

                    ContactsTable ct=new ContactsTable(MainActivity.this);
                    if (ct.addData(user)){
                        Toast.makeText(MainActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        Toast.makeText(MainActivity.this,"添加失败",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this,"请先输入数据",Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
