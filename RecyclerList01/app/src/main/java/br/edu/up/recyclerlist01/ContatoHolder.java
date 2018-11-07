package br.edu.up.recyclerlist01;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ContatoHolder extends RecyclerView.ViewHolder {

    public TextView txtNomeCel;
    public TextView txtFoneCel;

    public ContatoHolder(@NonNull View itemView) {
        super(itemView);
        txtNomeCel = itemView.findViewById(R.id.txtNomeCel);
        txtFoneCel = itemView.findViewById(R.id.txtFoneCel);
    }

}
