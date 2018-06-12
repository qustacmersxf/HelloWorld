package com.example.elephantfly.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TableLayout tableLayout;
    private EditText edit_num, edit_name, edit_college;
    private Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_main);

        tableLayout = (TableLayout)findViewById(R.id.tableLayout);
        edit_num = (EditText)findViewById(R.id.edit_num);
        edit_name = (EditText)findViewById(R.id.edit_name);
        edit_college = (EditText)findViewById(R.id.edit_college);
        btn_add = (Button)findViewById(R.id.btn_add);

        btn_add.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (edit_num.getText().toString().isEmpty() ||
                    edit_name.getText().toString().isEmpty() ||
                    edit_college.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(), "请输入添加信息",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            TableRow tableRow = new TableRow(tableLayout.getContext());

            TextView textView = new TextView(tableLayout.getContext());
            textView.setText(edit_num.getText());
            textView.setTextColor(getResources().getColor(R.color.white));
            tableRow.addView(textView);
            edit_num.setText("");

            textView = new TextView(tableLayout.getContext());
            textView.setText(edit_name.getText());
            textView.setTextColor(getResources().getColor(R.color.white));
            tableRow.addView(textView);
            edit_name.setText("");

            textView = new TextView(tableLayout.getContext());
            textView.setText(edit_college.getText());
            textView.setTextColor(getResources().getColor(R.color.white));
            tableRow.addView(textView);
            edit_college.setText("");

            tableLayout.addView(tableRow);
        }
    };
}
