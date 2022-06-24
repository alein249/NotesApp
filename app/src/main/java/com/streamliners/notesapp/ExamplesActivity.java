package com.streamliners.notesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExamplesActivity extends AppCompatActivity {

    private static final String TAG = "ExamplesActivity";
    
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examples);
    }

    public void createDocument(View view) {
        
//        Map<String, Object> map = new HashMap<>();
//        map.put("test", "i wanna watch harry potter again and again");
//        map.put("isCompleted", false);
//        map.put("created", new Timestamp(new Date()));
//
//        firestore.collection("notes")
//                .add(map)
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Log.d(TAG, "onSuccess: task was successful");
//                        Log.d(TAG, "onSuccess: " + documentReference.get());
//
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.d(TAG, "onFailure: task was NOT successful");
//
//                    }
//                });

        Map<String, Object> map = new HashMap<>();
        map.put("name", "iPhone 11");
        map.put("price", 699);
        map.put("isAvailable", true);

        FirebaseFirestore.getInstance().collection("products")
                .add(map)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "onSuccess: Product is added successfully");
                        Log.d(TAG, "onSuccess: " + documentReference.getId());

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(TAG, "onFailure: ", e);

                    }
                });

    }

    public void readDocument(View view) {

//        FirebaseFirestore.getInstance().collection("notes")
//                .get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        Log.d(TAG, "onSuccess: We are getting the data");
//                        List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
//                        for(DocumentSnapshot snapshot : snapshotList){
//                            Log.d(TAG, "onSuccess: " + snapshot.getData().toString());
//                        }
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.e(TAG, "onFailure: " + e);
//                    }
//                });

        FirebaseFirestore.getInstance().collection("notes")
                .document("9O4RsuKS6B1rMkwbLIBl")
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        Log.d(TAG, "onSuccess: " + documentSnapshot.getId());
                        Log.d(TAG, "onSuccess: " + documentSnapshot.getData());
                        Log.d(TAG, "onSuccess: " + documentSnapshot.getString("test"));
                        Log.d(TAG, "onSuccess: " + documentSnapshot.getBoolean("isCompleted"));

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e(TAG, "onFailure: " + e);
                    }
                });
    }

    public void updateDocument(View view) {
    }

    public void deleteDocument(View view) {
    }

    public void getAllDocuments(View view) {
    }

    public void getAllDocumentsWithRealtimeUpdates(View view) {
    }
}