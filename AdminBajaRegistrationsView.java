package com.application.qatarmotorsports;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.util.BackgroundQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AdminBajaRegistrationsView extends AppCompatActivity {



    private CollectionReference Forumref = FirebaseFirestore.getInstance().collection("BajaRegistrations");
    private DocumentReference Forumdoc = FirebaseFirestore.getInstance().document("Bajaregistration/NewReg");

    public static AllDataFromObjects alldata;


     private NoteAdapter adapter;


    private List<AllDataFromObjects> allDataFromObjectslist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_baja_registrations_view);




        if(Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));
        }


        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        Query query = Forumref.orderBy("firstName",Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<AllDataFromObjects> options = new FirestoreRecyclerOptions.Builder<AllDataFromObjects>()
                .setQuery(query,AllDataFromObjects.class)
                .build();

        adapter = new NoteAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {


                    AlertDialog.Builder builder = new AlertDialog.Builder(AdminBajaRegistrationsView.this);
                    builder.setMessage("Are you sure to delete?");
                    builder.setPositiveButton("REMOVE", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            adapter.DeleteItem(viewHolder.getAdapterPosition());
                            return;
                        }
                    }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {  //not removing items if cancel is done
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            adapter.notifyItemRemoved(viewHolder.getAdapterPosition() + 1);
                            adapter.notifyItemRangeChanged(viewHolder.getAdapterPosition(), adapter.getItemCount());

                            return;
                        }
                    }).show();  //show alert dialog

            }
        }).attachToRecyclerView(recyclerView);

        adapter.setOnItemClickListener(new NoteAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DocumentSnapshot documentSnapshot, int position) {
                alldata = documentSnapshot.toObject(AllDataFromObjects.class);
                String id = documentSnapshot.getId();
                Toast.makeText(AdminBajaRegistrationsView.this,"Position"+ position + "ID:" + id,Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(AdminBajaRegistrationsView.this, ViewRegistrant.class);
                AdminBajaRegistrationsView.this.startActivity(intent3);
            }
        });

    }



    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
