package com.sizov.vitaly.criminalintent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class PhotoDialogFragment extends DialogFragment {

    private static final String ARG_PHOTO = "photo";

    public static PhotoDialogFragment newInstance(File photoFile) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_PHOTO, photoFile);

        PhotoDialogFragment fragment = new PhotoDialogFragment();
        fragment.setArguments(args);

        return fragment;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        File photoFile = (File) getArguments().getSerializable(ARG_PHOTO);
        Bitmap image = PictureUtils.getScaledBitmap(photoFile.getPath(), getActivity());
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_photo, null);

        ImageView imageView = (ImageView) v.findViewById(R.id.dialog_photo_picker);
        imageView.setImageBitmap(image);

        return new AlertDialog.Builder(getActivity()).setView(imageView).create();
    }
}
