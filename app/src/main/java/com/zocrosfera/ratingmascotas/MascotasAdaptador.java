package com.zocrosfera.ratingmascotas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by rafaelocrin on 16/11/16.
 */

public class MascotasAdaptador extends RecyclerView.Adapter<MascotasAdaptador.MascotasViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotasAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotasAdaptador.MascotasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        return new MascotasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotasAdaptador.MascotasViewHolder mascotasViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotasViewHolder.imgfoto.setImageResource(mascota.getFoto());
        mascotasViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotasViewHolder.tvRatingCV.setText(mascota.getRating());

//        mascotasViewHolder.btnDoRating.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {


                //Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();

//                Intent intent = new Intent(activity, DetalleContacto.class);
//                intent.putExtra("nombre", contacto.getNombre());
//                intent.putExtra("telefono", contacto.getTelefono());
//                intent.putExtra("email", contacto.getEmail());
//                activity.startActivity(intent);
//            }
//        });

//        mascotasViewHolder.btnLike.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(activity, "Diste like a " + contacto.getNombre(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgfoto;
        private TextView tvNombreCV;
        private TextView tvRatingCV;
//        private ImageButton btnDoRating;
//        private ImageView imgRating;


        public MascotasViewHolder(View itemView) {
            super(itemView);
            imgfoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombre);
            tvRatingCV = (TextView) itemView.findViewById(R.id.tvRating);
//            btnDoRating = (ImageButton) itemView.findViewById(R.id.btnDoRating);
//            imgRating = (ImageView) itemView.findViewById(R.id.imgRating);
        }
    }

}


