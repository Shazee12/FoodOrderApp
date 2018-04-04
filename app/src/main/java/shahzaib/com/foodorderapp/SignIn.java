package shahzaib.com.foodorderapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import shahzaib.com.foodorderapp.Model.User;


public class SignIn extends AppCompatActivity {
    MaterialEditText phoneNumeber,password;
    Button signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        phoneNumeber = findViewById(R.id.phoneNumeber);
        password = findViewById(R.id.password);

        signIn = findViewById(R.id.btnsignin);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog dialog = new ProgressDialog(SignIn.this);
                dialog.setMessage("Please waiting....");
                dialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if(dataSnapshot.child(phoneNumeber.getText().toString()).exists()) {
                        dialog.dismiss();

                            //get User Information
                            User user = dataSnapshot.child(phoneNumeber.getText().toString()).getValue(User.class);
                            if (user.getPassword().equals(password.getText().toString())) {
                                Toast.makeText(SignIn.this, "sign in succesfully", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(SignIn.this, "sign in failed", Toast.LENGTH_SHORT).show();

                            }
                        }
                         else {
                            Toast.makeText(SignIn.this, "User not exists", Toast.LENGTH_SHORT).show();

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
