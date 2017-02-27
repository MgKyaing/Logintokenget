package com.example.zarni.logintokenget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.squareup.otto.Subscribe;


public class RegisterActivity extends AppCompatActivity {
    private Spinner spinner1;
    Button button;
    private String radio1,radio2;
    private RadioButton radioButton,radiobb;
    private RadioGroup radioGroup;
    private EditText Password,Login_Name,Email,Telephone_no;
private String User_type,user_type,login_name,password,category_id,email,telephone_no;
ConnectionHub communicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
            communicator=new ConnectionHub();

        category_id="2";
        radioButton=(RadioButton)findViewById(R.id.radio1);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        radiobb=(RadioButton)findViewById(R.id.radio2);
        radioGroup=(RadioGroup)findViewById(R.id.radiogroup);
        Email=(EditText)findViewById(R.id.email);
        Login_Name=(EditText)findViewById(R.id.login_name);
        Password=(EditText)findViewById(R.id.password);
        Telephone_no=(EditText)findViewById(R.id.telephone_no);

        button=(Button)findViewById(R.id.register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  int checkedRadioButtonId=radioGroup.getCheckedRadioButtonId();
                    if (checkedRadioButtonId == radioButton.getId())
                    {
                        user_type="1";
                    }
                    else
                    {
                        user_type="2";
                    }
             //  Toast.makeText(getApplicationContext(),user_type,Toast.LENGTH_LONG).show();
                    //user_type=User_type.toString();
                 email=Email.getText().toString();
                       login_name=Login_Name.getText().toString();
                        password=Password.getText().toString();
                //user_type=User_type.getBytes().toString();
                telephone_no=Telephone_no.getText().toString();
                    useregister(login_name,email,telephone_no,password,user_type,category_id);

            }*/
            }});}

      //  addListenerOnButton();
      //addListenerOnSpinnerItemSelection();


    public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        String firstItem = String.valueOf(spinner1.getSelectedItem());

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            if (firstItem.equals(String.valueOf(spinner1.getSelectedItem()))) {
                // ToDo when first item is selected
            } else {
                Toast.makeText(parent.getContext(),
                        "You have selected : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {


        }

        private void useregister(String login_name,String email,String telephone_no, String password,String user_type,String category_id) {
        communicator.registerpost(login_name,email,telephone_no,password,user_type,category_id);
    }




    @Subscribe
    public void onServerEvent(ServerEvent serverEvent) {


        if (!serverEvent.getServerResponse().equals(null)) {
            Toast.makeText(getApplicationContext(),"blabla"+serverEvent.getServerResponse().getToken(),Toast.LENGTH_LONG).show();




            // Toast.makeText(getApplicationContext(), "Success ServerEvent Respond" + serverEvent.getServerResponse().getlogin(), Toast.LENGTH_LONG).show();

            //
            // extraInformation.setText("" + serverEvent.getServerResponse());
            //token = serverEvent.getServerResponse().getToken();
            // Intent intent = new Intent(MainLoginActivity.this, JFirstMenuPage.class);
            //    startActivity(intent)
        }


        //       if (serverEvent.getServerResponse().getToken() != null) {
        //     information.setText("Username: " + serverEvent.getServerResponse().getToken() + " || Password: " + serverEvent.getServerResponse().getPassword());
        //       }
    }


    public void selecttype(){


    }
  //  @Override
   // public void onResume() {
     //   super.onResume();
       // BusProvider.getInstance().register(this);
//    }

  //  @Override
    //public void onPause() {
      //  super.onPause();
        //BusProvider.getInstance().unregister(this);
//    }

    //public void addListenerOnSpinnerItemSelection()  {
      //  spinner1=(Spinner)findViewById(R.id.spinner1);
        //spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
   // }

   /*
    private void addListenerOnButton() {
        radioGroup=(RadioGroup)findViewById(R.id.radiogroup);
     final TextView textView=(TextView)findViewById(R.id.textview);
        button=(Button)findViewById(R.id.register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


             int checkedRadioButtonId=radioGroup.getCheckedRadioButtonId();
                if (checkedRadioButtonId== -1)
                {
                    //Toast.makeText(getApplicationContext(),0,Toast.LENGTH_LONG).show();
                }
                else if (checkedRadioButtonId == R.id.radio1) {
                    user_type=1;

                }
                else if (checkedRadioButtonId ==R.id.radio2)
                {
                    user_type=2;
                }
                textView.setText("this is"+user_type); */



}}
