package app.app.gamemyquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.CollapsibleActionView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class Level1 extends AppCompatActivity {
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

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
        dialog.show();//показать диалоговое окно
    }
}
