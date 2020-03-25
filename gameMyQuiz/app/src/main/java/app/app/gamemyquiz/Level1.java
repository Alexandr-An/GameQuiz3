package app.app.gamemyquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.CollapsibleActionView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.logging.Level;


public class Level1 extends AppCompatActivity {
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        // создать переменнуб text_levels
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level1);// установить текст


        final ImageView img_left= (ImageView)findViewById(R.id.img_left);
        //код который скругляет углы
        img_left.setClipToOutline(true);
        final ImageView img_right= (ImageView)findViewById(R.id.img_right);
        //код который скругляет углы
        img_right.setClipToOutline(true);

        //развернуть инру на весь экран начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //развернуть инру на весь экран конец

        //вызов диалогового окна в начале инры
        dialog = new Dialog(this);//пример диалогового окна
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть заголовок
        dialog.setContentView(R.layout.previewdialog);// путь к макету диалогового окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));// прозрачность диалогового окна
        dialog.setCancelable(false);// окно нельзя закрыть кнопкой назад
        //кнопка которая закрывает диалоговое окно начало
        TextView buttonclose = (TextView)dialog.findViewById(R.id.button_close);
        buttonclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //обработка нажатич кнопки насало
                try {
                    //вернутся назад к выбору уровня начало
                    Intent intent = new Intent(Level1.this, GameLevels.class);// намарение для переъода
                    startActivity(intent); //старт намерения
                    finish();//закрыть класс
                    //вернутся назад к выбору уровня конец
                }catch (Exception e){
                    //пусто
                }
                dialog.dismiss();//закрыть диалоговое окно
                //обработка нажатич кнопки конец
            }
        });
        //кнопка которая закрывает диалоговое окно конец
        //кнопка продолжить начало
        Button buttoncontinue = (Button)dialog.findViewById(R.id.buttonContinue);
        buttoncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();//закрываем диалоговое окно
            }
        });
        //кнопка продолжить конец

        dialog.show();//показать диалоговое окно

        //кнопка назад начало
        Button btn_back = (Button)findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //обработка кнопки назад начало
                try {
                    //вернуться назад к выбору уровня начало
                    Intent intent  = new Intent(Level1.this, GameLevels.class);//намерение
                    startActivity(intent);// старт намерения
                    finish();// закрыть класс
                    //вернуться назад к выбору уровня конец
                }catch (Exception e){
                    //пусто
                }
                //обработка кнопки назад конец
            }
        });
        //кнопка назад конец
    }
    //сстемная кнопка назд начало
@Override
    public void onBackPressed(){
    //обработка кнопки назад начало
    try {
        //вернуться назад к выбору уровня начало
        Intent intent  = new Intent(Level1.this, GameLevels.class);//намерение
        startActivity(intent);// старт намерения
        finish();// закрыть класс
        //вернуться назад к выбору уровня конец
    }catch (Exception e){
        //пусто
    }
    //обработка кнопки назад конец
}
    //сстемная кнопка назд конец
}
