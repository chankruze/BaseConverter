package in.geekofia.baseconverter;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;

public class GeekofiaKeyboard extends LinearLayout implements View.OnClickListener {

    private MaterialButton button1, button2, button3, button4, button5,
            button6, button7, button8, button9, button0,
            buttonA, buttonB, buttonC, buttonD, buttonE, buttonF,
            buttonDelete, buttonReset, buttonConvert;

    private SparseArray<String> keyValues = new SparseArray<>();
    private InputConnection inputConnection;

    public GeekofiaKeyboard(Context context) {
        this(context, null, 0);
    }

    public GeekofiaKeyboard(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GeekofiaKeyboard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.keyboard, this, true);
        button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(this);
        button4 = findViewById(R.id.button_4);
        button4.setOnClickListener(this);
        button5 = findViewById(R.id.button_5);
        button5.setOnClickListener(this);
        button6 = findViewById(R.id.button_6);
        button6.setOnClickListener(this);
        button7 = findViewById(R.id.button_7);
        button7.setOnClickListener(this);
        button8 = findViewById(R.id.button_8);
        button8.setOnClickListener(this);
        button9 = findViewById(R.id.button_9);
        button9.setOnClickListener(this);
        button0 = findViewById(R.id.button_0);
        button0.setOnClickListener(this);
        buttonA = findViewById(R.id.button_a);
        buttonA.setOnClickListener(this);
        buttonB = findViewById(R.id.button_b);
        buttonB.setOnClickListener(this);
        buttonC = findViewById(R.id.button_c);
        buttonC.setOnClickListener(this);
        buttonD = findViewById(R.id.button_d);
        buttonD.setOnClickListener(this);
        buttonE = findViewById(R.id.button_e);
        buttonE.setOnClickListener(this);
        buttonF = findViewById(R.id.button_f);
        buttonF.setOnClickListener(this);
        buttonDelete = findViewById(R.id.button_delete);
        buttonDelete.setOnClickListener(this);

        keyValues.put(R.id.button_1, "1");
        keyValues.put(R.id.button_2, "2");
        keyValues.put(R.id.button_3, "3");
        keyValues.put(R.id.button_4, "4");
        keyValues.put(R.id.button_5, "5");
        keyValues.put(R.id.button_6, "6");
        keyValues.put(R.id.button_7, "7");
        keyValues.put(R.id.button_8, "8");
        keyValues.put(R.id.button_9, "9");
        keyValues.put(R.id.button_0, "0");
        keyValues.put(R.id.button_a, "A");
        keyValues.put(R.id.button_b, "B");
        keyValues.put(R.id.button_c, "C");
        keyValues.put(R.id.button_d, "D");
        keyValues.put(R.id.button_e, "E");
        keyValues.put(R.id.button_f, "F");
    }

    @Override
    public void onClick(View view) {
        if (inputConnection == null)
            return;

        if (view.getId() == R.id.button_delete) {
            CharSequence selectedText = inputConnection.getSelectedText(0);

            if (TextUtils.isEmpty(selectedText)) {
                inputConnection.deleteSurroundingText(1, 0);
            } else {
                inputConnection.commitText("", 1);
            }
        } else {
            String value = keyValues.get(view.getId());
            inputConnection.commitText(value, 1);
        }
    }

    public void setInputConnection(InputConnection ic) {
        inputConnection = ic;
    }
}