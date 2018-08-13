package com.masashi.tf09_tebyoushi;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

/**
 * Created by Masashi Hamaguchi on 2018/08/05.
 */

public class Clap {

    // 音楽プレイヤー
    private SoundPool soundPool;
    // 読み込んだ音源のID
    private int soundID;

    // Clapインスタンスを作り、初期化する
    public Clap(Context context) {
        // 新しいSoundPoolインスタンスを生成
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

        // 音声ファイルを読み込む
        soundID = soundPool.load(context, R.raw.clap, 1);

    }

    // 音声を再生するメソッド
    public void play() {
        soundPool.play(soundID, 1.0f, 1.0f, 0, 0, 1.0f);

    }

    // 手拍子を再生するメソッド
    public void repeatPlay(int repeat) {
        // 繰り返した回数をカウントする変数
        int count = 0;

        while (count < repeat) {
            // playメソッドで音声を再生
            play();
            // 繰り返しカウントを1増やす
            count++;

            try {
                // 500ミリ秒まつ
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
