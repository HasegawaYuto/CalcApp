package jp.techacademy.yuuto.hasegawa.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.text.InputType;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText textVal1;
    EditText textVal2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(this);

        Button buttonSub = (Button) findViewById(R.id.buttonSub);
        buttonSub.setOnClickListener(this);

        Button buttonMul = (Button) findViewById(R.id.buttonMul);
        buttonMul.setOnClickListener(this);

        Button buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonDiv.setOnClickListener(this);

        textVal1 = (EditText)findViewById(R.id.editText1);
        textVal2 = (EditText)findViewById(R.id.editText2);

        textVal1.setInputType(InputType.TYPE_CLASS_NUMBER);
        textVal2.setInputType(InputType.TYPE_CLASS_NUMBER);
    }

    @Override
    public void onClick(View view) {
        String val1Flag = textVal1.getText().toString();
        String val2Flag = textVal2.getText().toString();
        if (val1Flag.length() != 0 && val2Flag.length() != 0) {
            Double val1 = Double.parseDouble(textVal1.getText().toString());
            Double val2 = Double.parseDouble(textVal2.getText().toString());
            Intent intent = new Intent(this, ResultActivity.class);
            if (view.getId() == R.id.buttonAdd) {
                intent.putExtra("RESULT", String.valueOf(val1 + val2));
            } else if (view.getId() == R.id.buttonSub) {
                intent.putExtra("RESULT", String.valueOf(val1 - val2));
            } else if (view.getId() == R.id.buttonMul) {
                intent.putExtra("RESULT", String.valueOf(val1 * val2));
            } else if (view.getId() == R.id.buttonDiv) {
                if (val2 != 0) {
                    intent.putExtra("RESULT", String.valueOf(val1 / val2));
                } else {
                    intent.putExtra("RESULT", "0では割れません");
                }
            }
            startActivity(intent);
        }
    }
}
