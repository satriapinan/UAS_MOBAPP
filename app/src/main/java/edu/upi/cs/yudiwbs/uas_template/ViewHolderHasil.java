package edu.upi.cs.yudiwbs.uas_template;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderHasil extends RecyclerView.ViewHolder {
    public TextView tvHasil;
    public TextView tvHasilStatus;
    public TextView tvHasilAdvice;

    public ViewHolderHasil(@NonNull View itemView) {
        super(itemView);
        tvHasil = itemView.findViewById(R.id.tvRow);
        tvHasilStatus = itemView.findViewById(R.id.tvStatus);
        tvHasilAdvice = itemView.findViewById(R.id.tvAdvice);
    }
}
