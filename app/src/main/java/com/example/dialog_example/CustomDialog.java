package com.example.dialog_example;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class CustomDialog extends DialogFragment {

    interface OnButtonClickListener {
        void onCancelButtonClicked();
        void onOkButtonClicked();

    }

    private int mLayoutId;
    private String mTitle;
    private String mContent;
    private OnButtonClickListener mOnButtonClickListener;

    public CustomDialog(int layoutId, String title, String content, OnButtonClickListener onButtonClickListener) {
        mLayoutId = layoutId;
        mTitle = title;
        mContent = content;
        mOnButtonClickListener = onButtonClickListener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(mLayoutId, container, false);

        TextView titleTextView = view.findViewById(R.id.dialog_title);
        TextView contentTextView = view.findViewById(R.id.dialog_content);
        Button cancelButton = view.findViewById(R.id.dialog_button_cancel);
        Button okButton = view.findViewById(R.id.dialog_button_ok);

        titleTextView.setText(mTitle);
        contentTextView.setText(mContent);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnButtonClickListener.onCancelButtonClicked();
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnButtonClickListener.onOkButtonClicked();
            }
        });

        return view;
    }
}