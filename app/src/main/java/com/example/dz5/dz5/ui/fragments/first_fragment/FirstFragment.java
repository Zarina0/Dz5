package com.example.dz5.dz5.ui.fragments.first_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dz5.R;

import com.example.dz5.databinding.FragmentFirstBinding;
import com.example.dz5.dz5.listeners.OnClickListener;
import com.example.dz5.dz5.model.ModelData;
import com.example.dz5.dz5.ui.fragments.first_fragment.adapter.AdapterData;
import com.example.dz5.dz5.ui.fragments.second_fragment.SecondFragment;

import java.util.List;


public class FirstFragment extends Fragment {
    private FragmentFirstBinding binding;
    AdapterData adapterData;
    ModelData modelData;
    List<ModelData> list;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentFirstBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapterData= new AdapterData();
        binding.recycleviewFirsFragment.setAdapter(adapterData);
        listener();
        getData();

    }



    private void listener() {
        binding.btnTransition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondFragment secondFragment= new SecondFragment();
                FragmentTransaction fragmentTransaction=getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment,secondFragment).commit();
            }

        });

        adapterData.setOnItemClickListener(new OnClickListener() {
            @Override
            public void onItemClickListener(int position, ModelData modelData) {
                SecondFragment secondFragment= new SecondFragment();
                FragmentTransaction fragmentTransaction=getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment,secondFragment).commit();
                ModelData modelData1 = new ModelData(adapterData.list.get(position).getData());
                Bundle bundle=new Bundle();
                bundle.putSerializable("key1",modelData1);
                secondFragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container_fragment,secondFragment).commit();


            }
        });
    }


    private void getData() {
        if (getArguments() !=null){
            modelData = (ModelData) getArguments().getSerializable("key");
            adapterData.addData(modelData);
        }


    }


}