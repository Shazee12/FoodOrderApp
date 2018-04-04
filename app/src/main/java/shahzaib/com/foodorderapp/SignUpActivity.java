package shahzaib.com.foodorderapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import shahzaib.com.foodorderapp.Model.User;

public class SignUpActivity extends AppCompatActivity {
    MaterialEditText phoneNumeber,password,name;
    Button signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


       name = findViewById(R.id.name);
       phoneNumeber = findViewById(R.id.phoneNumeber);
       password = findViewById(R.id.password);

       signUp = findViewById(R.id.btnsignUp);

       final FirebaseDatabase database = FirebaseDatabase.getInstance();
       final DatabaseReference reference = database.getReference("User");

       signUp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               final ProgressDialog dialog = new ProgressDialog(SignUpActivity.this);
               dialog.setMessage("Please waiting....");
               dialog.show();


               reference.addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(DataSnapshot dataSnapshot) {
                       //check if already exits
                       if(dataSnapshot.child(phoneNumeber.getText().toString()).exists()) {
                        dialog.dismiss();
                           Toast.makeText(SignUpActivity.this,"Already registered",Toast.LENGTH_SHORT).show();
                       }
                       else {
                           dialog.dismiss();
                           User user = new User(name.getText().toString(),password.getText().toString());
                           reference.child(phoneNumeber.getText().toString()).setValue(user);
                           Toast.makeText(SignUpActivity.this,"registered",Toast.LENGTH_SHORT).show();
                            finish();
                       }
                   }

                   @Override
                   public void onCancelled(DatabaseError databaseError) {

                   }
               });

           }
       });




    }


}
