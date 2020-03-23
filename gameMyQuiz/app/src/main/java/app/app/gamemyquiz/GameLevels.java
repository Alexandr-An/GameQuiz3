package app.app.gamemyquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.gamelevels);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);// убрать строку состояния

        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // команда кнопки

                //начало конструкции

                try {
                 Intent intent = new Intent(GameLevels.this, MainActivity.class);
                 startActivity(intent);finish();
                }catch (Exception e){

                }
                //конец конструкции
            }
        });
        // кнопка для перехода на первый уровень начало
        TextView textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                     Intent intent = new Intent(GameLevels.this, Level1.class);
                     startActivity(intent);finish();
                }catch (Exception e){
                    //пусто
                }
            }
        });

        // кнопка для перехода на первый уровень конец

    }

    //системная кнопка назад начало
    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
    }
    // системная кнопка назад конец
}
