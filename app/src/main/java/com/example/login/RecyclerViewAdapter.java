package com.example.login;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.Model.Personaje;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<Personaje> array_personajes;

    public RecyclerViewAdapter(ArrayList arrN){
        array_personajes = arrN;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.etiquetaNom.setText(array_personajes.get(position).getNom());
        //holder.powerTV.setText(array_personajes.get(position).getPoder());
        //holder.bossTV.setText(array_personajes.get(position).getCapita());
        //holder.moneyTV.setText(array_personajes.get(position).getRecompensa());
    }

    @Override
    public int getItemCount() {
        return array_personajes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView etiquetaNom;
        //TextView powerTV;
        //TextView bossTV;
        //TextView moneyTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            etiquetaNom = itemView.findViewById(R.id.userName);
            //powerTV = itemView.findViewById(R.id.powerTV);
            //bossTV = itemView.findViewById(R.id.boss_TV);
            //moneyTV = itemView.findViewById(R.id.moneyTV);
        }
    }
}
