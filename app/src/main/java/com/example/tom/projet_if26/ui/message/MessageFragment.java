package com.example.tom.projet_if26.ui.message;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tom.projet_if26.R;

public class MessageFragment extends Fragment {

    private MessageViewModel mViewModel;

    public MessageFragment() {
        // Required empty public constructor
    }

    public static MessageFragment newInstance() {
        return new MessageFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.message_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MessageViewModel.class);
        // TODO: Use the ViewModel
    }

}
