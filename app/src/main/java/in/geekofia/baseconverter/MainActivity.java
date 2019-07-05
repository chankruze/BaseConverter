package in.geekofia.baseconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner mFromBaseSpinner, mToBaseSpinner;
    private TextInputLayout mInputNumber, mConvertedNumber;
    private TextInputEditText mInputNumberEditText, mConvertedNumberEditText;
    private MaterialButton mButtonReset, mButtonConvert;
    private int mSelectedBaseFrom, mSelectedBaseTo;
    private GeekofiaKeyboard keyboard;
    private TextView mButtonSwap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        mFromBaseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String baseSplitFrom[] = mFromBaseSpinner.getSelectedItem().toString().split(" ");
                mSelectedBaseFrom = Integer.parseInt(baseSplitFrom[0]);

                if (mSelectedBaseFrom == 16) {
                    mInputNumberEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                    mInputNumberEditText.setTextIsSelectable(true);

                    mInputNumberEditText.setShowSoftInputOnFocus(false);
                    InputConnection ic = mInputNumberEditText.onCreateInputConnection(new EditorInfo());
                    keyboard.setInputConnection(ic);
                } else {
                    mInputNumberEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
                    mInputNumberEditText.setTextIsSelectable(true);
                    mInputNumberEditText.setShowSoftInputOnFocus(false);

                    InputConnection ic = mInputNumberEditText.onCreateInputConnection(new EditorInfo());
                    keyboard.setInputConnection(ic);
                }

                String mHintFromBase = baseSplitFrom[1];
                mHintFromBase = mHintFromBase.replace("(", "");
                mHintFromBase = mHintFromBase.replace(")", "");
                mInputNumber.setHint(mHintFromBase);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        mToBaseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String baseSplitTo[] = mToBaseSpinner.getSelectedItem().toString().split(" ");
                mSelectedBaseTo = Integer.parseInt(baseSplitTo[0]);

                String mHintToBase = baseSplitTo[1];
                mHintToBase = mHintToBase.replace("(", "");
                mHintToBase = mHintToBase.replace(")", "");
                mConvertedNumber.setHint(mHintToBase);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mInputNumberEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                int FOCUS_INT = keyboard.getVisibility();
                if (FOCUS_INT == 8) {
                    keyboard.setVisibility(View.VISIBLE);
                } else {
                    keyboard.setVisibility(View.GONE);
                }
            }
        });

        mButtonSwap.setOnClickListener(this);
        mButtonReset.setOnClickListener(this);
        mButtonConvert.setOnClickListener(this);
    }

    private void initViews() {
        // From Base Spinner
        mFromBaseSpinner = findViewById(R.id.spinner_from);
        ArrayAdapter<CharSequence> mFromAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_select_base, android.R.layout.simple_spinner_item);
        mFromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mFromBaseSpinner.setAdapter(mFromAdapter);

        mButtonSwap = findViewById(R.id.button_swap);

        // To Base Spinner
        mToBaseSpinner = findViewById(R.id.spinner_to);
        ArrayAdapter<CharSequence> mToAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_select_base, android.R.layout.simple_spinner_item);
        mToAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mToBaseSpinner.setAdapter(mToAdapter);

        mInputNumber = findViewById(R.id.input_number);
        mConvertedNumber = findViewById(R.id.converted_number);

        mButtonReset = findViewById(R.id.button_reset);
        mButtonConvert = findViewById(R.id.button_convert);

        mInputNumberEditText = findViewById(R.id.input_number_edit_text);
        mInputNumberEditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});

        mConvertedNumberEditText = findViewById(R.id.converted_number_edit_text);

        keyboard = findViewById(R.id.keyboard);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_swap:
                int mFromSelecton = mFromBaseSpinner.getSelectedItemPosition();
                mFromBaseSpinner.setSelection(mToBaseSpinner.getSelectedItemPosition());
                mToBaseSpinner.setSelection(mFromSelecton);
                break;

            case R.id.button_reset:
                mInputNumberEditText.setText("");
                mConvertedNumberEditText.setText("");
                break;

            case R.id.button_convert:
                String test = mInputNumberEditText.getText().toString();
                mConvertedNumberEditText.setText(test);
                break;
        }
    }


}
