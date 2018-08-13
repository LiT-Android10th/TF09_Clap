package com.masashi.tf09_tebyoushi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    // 画面に配置した部品
    ImageButton button;
    Spinner spinner;

    // 音声プレイヤー
    Clap clapInstance;

    // 繰り返し回数
    int repeat = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 部品を関連付け
        button = findViewById(R.id.ImgBtn);
        spinner = findViewById(R.id.spinner);

        button.setOnClickListener(this);

        // 表示する文字列を配列に準備
        String[] strArray = new String[5];
        strArray[0] = "パンッ！";
        strArray[1] = "パンパンッ！";
        strArray[2] = "パンパンパンッ！";
        strArray[3] = "4回";
        strArray[4] = "5回";

        // 配列をspinnerに入れる方に変換
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, strArray
        );
        arrayAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_item
        );

        // spinnerに変化した配列をセット
        spinner.setAdapter(arrayAdapter);

        // spinnerが使われたときの処理をこのクラスで指定
        spinner.setOnItemSelectedListener(this);

        // 音声プレイヤーを作る
        clapInstance = new Clap(this.getApplicationContext());

    }

    // ボタンが押されたときの呼ばれるメソッド
    @Override
    public void onClick(View v) {
//        clapInstance.play();
        clapInstance.repeatPlay(repeat);

    }

    // スピナーの項目が選択されたとき
    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int pos, long id) {
        // 選択された項目の（0から数えた）番号+1を繰り返した回数に設定
        repeat = pos + 1;
    }

    // スピナーでなにも選択されたなかったとき
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

}
