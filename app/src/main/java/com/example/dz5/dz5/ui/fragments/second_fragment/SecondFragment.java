package com.example.dz5.dz5.ui.fragments.second_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dz5.R;
import com.example.dz5.databinding.FragmentSecondBinding;
import com.example.dz5.dz5.model.ModelData;
import com.example.dz5.dz5.ui.fragments.first_fragment.FirstFragment;


public class SecondFragment extends Fragment {
    ModelData modelData;
    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listeners();
        getData();

    }



    private void listeners() {
       binding.btnToSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirstFragment firstFragment= new FirstFragment();
                FragmentTransaction fragmentTransaction=getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment1,firstFragment).commit();
                save();

            }
       });
    }

    private void save() {
        String data= binding.etData.getText().toString();
        if (data.isEmpty()){
            binding.etData.setError("Input text");
        }
        else {
            modelData = new ModelData(data);
            Bundle bundle=new Bundle();
            bundle.putSerializable("key",modelData);
            FirstFragment firstFragment=new FirstFragment();
            firstFragment.setArguments(bundle);
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.container_fragment,firstFragment).commit();
        }
    }

    private void getData() {
        if (getArguments() !=null){
            modelData = (ModelData) getArguments().getSerializable("key1");
            binding.etData.setText(modelData.getData());
        }

    }



}