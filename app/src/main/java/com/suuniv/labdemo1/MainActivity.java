package com.suuniv.labdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private String buttonText="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void AddNewInLandscape(View view){
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.mipmap.su_logo_background);
        LinearLayout ll=findViewById(R.id.mainContainer);
        ll.addView(imageView);
    }

    public void AddNew(View view){
        EditText et = findViewById(R.id.edittxtview);
        System.out.println("text "+et.getText());
        buttonText = et.getText().toString();
        System.out.println("buttonText "+buttonText);
        linearLayoutHelper();
    }
    public void linearLayoutHelper(){
        LinearLayout ll=new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setPadding(0,5,0,0);
        ll.setWeightSum(3);

        EditText editText=new EditText(this);
        LinearLayout.LayoutParams params=new
                LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,2f);
        editText.setLayoutParams(params);
        Button b=new Button(this);
        b.setText(buttonText);
        LinearLayout.LayoutParams params2=new
                LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1f);
        b.setLayoutParams(params2);

        // editText.getText();

        ll.addView(editText);
        ll.addView(b);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Implement the click handler here
                System.out.println("Button clicked");

                System.out.println("text2 "+editText.getText());
                buttonText= editText.getText().toString();
                if("H".equalsIgnoreCase(buttonText)){
                    horizontalHelper();
                }else{
                    linearLayoutHelper();
                }

            }
        });

        LinearLayout main_container=findViewById(R.id.mainContainer);
        main_container.addView(ll);
    }

    public void horizontalHelper(){

        HorizontalScrollView horizontalScrollView= new HorizontalScrollView(this);
        LinearLayout.LayoutParams scrollViewParams =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
        horizontalScrollView.setLayoutParams(scrollViewParams);

        final LinearLayout ll=new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setPadding(0,5,0,0);

        Button b=new Button(this);
        Integer count=ll.getChildCount()+1;
        b.setText(count.toString());
        ll.addView(b);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Implement the click handler here
                System.out.println("H Button clicked");

                Button an = new Button(getApplicationContext());
//                LinearLayout lls= (LinearLayout) findViewById(R.id.mainContainer);


                 Integer c = ll.getChildCount()+1;
              an.setText(c.toString());

               ll.addView(an);


            }
        });


        LinearLayout main_container= (LinearLayout) findViewById(R.id.mainContainer);
        horizontalScrollView.addView(ll);
        main_container.addView(horizontalScrollView);

    }


}