package spstudio.com.tzolkin;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import spstudio.com.tzolkin.core.Tzolkin;
import spstudio.com.tzolkin.core.TzolkinDay;

public class MainActivity extends AppCompatActivity {

    int dayOffset = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        loadSealAndTone();
    }

    private void loadSealAndTone(){

        SimpleDateFormat sdf = new SimpleDateFormat("G EEE MMM,dd yyyy zzz");

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, dayOffset);

        ((TextView) findViewById(R.id.txtCurrentDate)).setText(sdf.format(c.getTime()));

        TzolkinDay td = new Tzolkin().cal(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DAY_OF_MONTH));
        ((ImageView)findViewById(R.id.imgSeal)).setImageResource(getResourceByReflect("s" + td.getSeal()));
        ((ImageView)findViewById(R.id.imgTone)).setImageResource(getResourceByReflect("t" + td.getTone()));

        String mayaName = td.getSealName().substring(td.getSealName().indexOf("(") + 1, td.getSealName().length() - 1);
        ((TextView)findViewById(R.id.txtMayaName)).setText(mayaName);
        ((TextView)findViewById(R.id.txtSealName)).setText(td.getSealName().replace("(" + mayaName + ")", ""));
        ((TextView)findViewById(R.id.txtToneName)).setText(td.getToneName());
        ((TextView)findViewById(R.id.txtKin)).setText("KIN:" + td.getKin());

        LinearLayout ll = (LinearLayout)findViewById(R.id.codes);
        ll.removeAllViews();
        for (String s: td.getCodeArrays()){
            TextView text1=new TextView(this);
            text1.setGravity(Gravity.CENTER_HORIZONTAL);
            text1.setTextSize(14);
            text1.setText(s);
            ll.addView(text1);
        }

    }

    public int getResourceByReflect(String imageName){
        Class drawable  =  R.drawable.class;
        Field field = null;
        int r_id = 0;
        try {
            field = drawable.getField(imageName);
            r_id = field.getInt(field.getName());
        } catch (Exception e) {
            //
        }
        return r_id;
    }

    public void onBtnClick(View view){
        switch (view.getId()){
            case R.id.btnPreview:
                dayOffset --;
                loadSealAndTone();
                break;
            case R.id.btnNext:
                dayOffset ++;
                loadSealAndTone();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case R.id.action_settings:
                dayOffset = 0;
                loadSealAndTone();
                break;
            case R.id.action_settings2:
                final EditText et = new EditText(this);
                new AlertDialog.Builder(this).setTitle("请输入日期(YYYYMMDD)").setIcon(
                        android.R.drawable.ic_dialog_info).setView(et)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String input = et.getEditableText().toString();
                                try {
                                    LocalDate targetDate = new LocalDate(Integer.valueOf(input.substring(0,4)), Integer.valueOf(input.substring(4,6)), Integer.valueOf(input.substring(6,8)));
                                    Calendar c = Calendar.getInstance();
                                    LocalDate today = new LocalDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DAY_OF_MONTH));
                                    dayOffset = Days.daysBetween(today, targetDate).getDays();
                                    loadSealAndTone();
                                } catch (Exception e) {
//                                    e.printStackTrace();
                                }
                            }
                        }).setNegativeButton("取消", null).show();
                break;
            case R.id.action_settings3:
                new AlertDialog.Builder(this).setTitle("开发者的邮箱").setIcon(
                        android.R.drawable.ic_dialog_info).setMessage("streetpoet@163.com, 软件版本 v1.02")
                        .setPositiveButton("确定", null).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
