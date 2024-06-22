package com.test.kaarigar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.IOException;

public class MessagesFragment extends Fragment {

    private static final int PICK_IMAGE = 1;

    private ImageView profilePic;
    private TextView username, email, location;
    private TextView password;
    private Button resetPassword, changeProfilePic;

    public MessagesFragment() {
        // Required empty public constructor
    }

    public static MessagesFragment newInstance(String param1, String param2) {
        MessagesFragment fragment = new MessagesFragment();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Retrieve the parameters passed to the fragment
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_messages, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        profilePic = view.findViewById(R.id.profile_pic);
        username = view.findViewById(R.id.username);
        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.password);
        location = view.findViewById(R.id.location);
        changeProfilePic = view.findViewById(R.id.change_profile_pic);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        username.setText(sharedPreferences.getString("username", "N/A"));
        email.setText(sharedPreferences.getString("email", "N/A"));
        password.setText(sharedPreferences.getString("password", ""));
        location.setText(sharedPreferences.getString("location", "N/A"));

        // Load saved profile picture if available
        String profilePicUri = sharedPreferences.getString("profile_pic", null);
        if (profilePicUri != null) {
            profilePic.setImageURI(Uri.parse(profilePicUri));
        }

        changeProfilePic.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, PICK_IMAGE);
        });

        resetPassword.setOnClickListener(v -> {
            // Logic to reset password
            Toast.makeText(getActivity(), "Reset Password clicked", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == getActivity().RESULT_OK && data != null) {
            Uri imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), imageUri);
                profilePic.setImageBitmap(bitmap);

                // Save the profile picture Uri in SharedPreferences
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("profile_pic", imageUri.toString());
                editor.apply();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
