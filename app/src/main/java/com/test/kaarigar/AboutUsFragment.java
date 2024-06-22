// AboutUsFragment.java

package com.test.kaarigar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AboutUsFragment extends Fragment {

    private TextView textAboutUs, textCompanyDescription,
            textMember1Name, textMember2Name, textMember3Name, textMember4Name;
    private ImageView imageMember1, imageMember2, imageMember3, imageMember4;
    private Button buttonGitHub;

    public AboutUsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_us, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize views
        textAboutUs = view.findViewById(R.id.text_about_us);
        textCompanyDescription = view.findViewById(R.id.text_company_description);
        textMember1Name = view.findViewById(R.id.text_member1_name);
        textMember2Name = view.findViewById(R.id.text_member2_name);
        textMember3Name = view.findViewById(R.id.text_member3_name);
        textMember4Name = view.findViewById(R.id.text_member4_name);
        imageMember1 = view.findViewById(R.id.image_member1);
        imageMember2 = view.findViewById(R.id.image_member2);
        imageMember3 = view.findViewById(R.id.image_member3);
        imageMember4 = view.findViewById(R.id.image_member4);
        buttonGitHub = view.findViewById(R.id.button_github);

        // Set company description
        String companyDescription = getString(R.string.company_description_long);
        textCompanyDescription.setText(companyDescription);

        // Set team member details
        textMember1Name.setText("Hafiz M. Mutashim Mohsin");
        textMember2Name.setText("Izhar ul Haq");
        textMember3Name.setText("Rayyan Wamiq");
        textMember4Name.setText("Jazib Noor");

        // Set team member images
        imageMember1.setImageResource(R.drawable.ic_member1);
        imageMember2.setImageResource(R.drawable.ic_member2);
        imageMember3.setImageResource(R.drawable.ic_member3);
        imageMember4.setImageResource(R.drawable.ic_member4);

        // Set GitHub button click listener
        buttonGitHub.setOnClickListener(v -> {
            // Open GitHub link
            String githubUrl = "https://github.com/Muhtashim99";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl));
            startActivity(intent);
        });
    }
}
