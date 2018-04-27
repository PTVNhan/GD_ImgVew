package vn.edu.ou.giaibaithi;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    ImageView img1, img2;
    LinearLayout i;
    RadioGroup rdGroup;
    RadioButton rd1, rd2, rd3;

    String cache = "White";
    String PREFNAME = "baithi";

    // Được rồi đó :D da

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = (ImageView) findViewById(R.id.imageView);
        img2 = (ImageView) findViewById(R.id.imageView2);

        rdGroup = (RadioGroup) findViewById(R.id.radGroup);
        rd1 = (RadioButton) findViewById(R.id.rad1);
        rd2 = (RadioButton) findViewById(R.id.rad2);
        rd3 = (RadioButton)findViewById(R.id.rad3);
        i = (LinearLayout) findViewById(R.id.Layout);

        //biết xài arrow function luôn ghê
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.setBackgroundResource(R.drawable.a);
                rdGroup.clearCheck();
                cache = "Imag1";

            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.setBackgroundResource(R.drawable.b);
                rdGroup.clearCheck();
                cache = "Imag2";
            }
        });
        rd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.setBackgroundColor(Color.parseColor("BLUE"));
                cache = "Blue";
            }
        });
        rd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.setBackgroundColor(Color.parseColor("#FF9FFF3F"));

                cache = "Green";
            }
        });
        rd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.setBackgroundColor(Color.parseColor("#FFD618F7"));
                cache = "Purple";
            }
        }); // buồn ngủ quá


//        int k = rdGroup.getCheckedRadioButtonId();
//        if(R.id.radGroup == 1) {
//            switch (k) {
//                case R.id.rad1:
//                    rd1.setChecked(true);
//                    break;
//                case R.id.rad2:
//                    rd2.setChecked(true);
//                    break;
//                case R.id.rad3:
//                    rd3.setChecked(true);
//                    break;
//            }
//        }else{ rd1.setChecked(false); rd2.setChecked(false); rd3.setChecked(false);}
//        rd1.setChecked(false); rd2.setChecked(false); rd3.setChecked(false);

    }

    public void setBackgroundCache(String cache) {
        if (!cache.equals(null)) {
            switch (cache) {
                case "White": {
                    i.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    break;
                }
                case "Blue": {
                    i.setBackgroundColor(Color.parseColor("#ffff55"));
                    break;
                }
                case "Green": {
                    i.setBackgroundColor(Color.parseColor("#ff55ff"));
                    break;
                }
                case "Purple": {
                    i.setBackgroundColor(Color.parseColor("#f55fff"));
                    break;
                }
                case "Img1": {
                    i.setBackgroundResource(R.drawable.a);
                    rdGroup.clearCheck();
                    break;
                }
                case "Img2": {
                    i.setBackgroundResource(R.drawable.b);
                    rdGroup.clearCheck();
                    break;
                }
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Viết ik
        SharedPreferences preferences = getSharedPreferences(PREFNAME, Activity.MODE_PRIVATE);
        // lát lên trên khai báo :v lỡ ở dưới này rồi
        if (preferences != null && preferences.contains("baithi")){
            cache = preferences.getString("baithi", "White");
        }
        setBackgroundCache(cache);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences preferences = getSharedPreferences(PREFNAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("LongDepTrai", cache);
        editor.clear();
        editor.commit();
    }
}
