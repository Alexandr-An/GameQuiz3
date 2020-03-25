package app.app.gamemyquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.CollapsibleActionView;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.logging.Level;


public class Level1 extends AppCompatActivity {
    Dialog dialog;

    public int numLeft;// левое изображение + текст
    public int numRight;// правое изображение + текст
    Array array = new Array();
    Random random = new Random();

    public int count = 0;// счётчик правильных ответов

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

        // путь к левой textView
        final TextView text_left = findViewById(R.id.text_left);
        // путь к правой textView
        final TextView text_right = findViewById(R.id.text_right);

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

        //подключить анимацию начало
final Animation a = AnimationUtils.loadAnimation(Level1.this,R.anim.alpha);
        //подключить анимацию конец

        numLeft = random.nextInt(10);//генерация случаёногог числа
        img_left.setImageResource(array.images1[numLeft]);// достать из массива картинку
        text_left.setText(array.texts1[numLeft]);// достать из массива текст

        numRight = random.nextInt(10);//генерация случаёногог числа
        // цикл с предусловием проверяющий равенство чисел начало
        while (numLeft == numRight){
            numRight = random.nextInt(5);
        }
        // цикл с предусловием проверяющий равенство чисел конец
        img_right.setImageResource(array.images1[numRight]);// достать из массива картинку
        text_right.setText(array.texts1[numRight]);// достать из массива текст

        //обраю=ботка нажатия на левую картинку начало
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // условие касания картинки начло
                if(event.getAction() == MotionEvent.ACTION_DOWN){

                // если коснулся картинки начало
                  img_right.setEnabled(false);// блокировка правой картинки
                    if (numLeft > numRight){
                        img_left.setImageResource(R.drawable.img_true);
                    }else {img_left.setImageResource(R.drawable.img_false);}
                }else if(event.getAction() == MotionEvent.ACTION_UP){

                // если отпустил палец начало

                }
                // условие касания картинки конец
                return true;
            }
        });
        //обраю=ботка нажатия на левую картинку конец
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
