package com.example.suitcaseapp;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AddDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dialog);
    }
    // 1. Instantiate an AlertDialog.Builder with its constructor.
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

// 2. Chain together various setter methods to set the dialog characteristics.
       builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);

    // 3. Get the AlertDialog.
    AlertDialog dialog = builder.create();

    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
// Add the buttons.
builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            // User taps OK button.
        }
    });
builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            // User cancels the dialog.
        }
    });
// Set other dialog properties.
...

    // Create the AlertDialog.
    AlertDialog dialog = builder.create();

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.pick_color)
                .setItems(R.array.colors_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position of the selected item.
                    }
                });
        return builder.create();
    }
}