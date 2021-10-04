package com.example.hotels;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class BookingAdapter extends FirebaseRecyclerAdapter<BookingModel,BookingAdapter.myViewHolder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public BookingAdapter(@NonNull @NotNull FirebaseRecyclerOptions<BookingModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull myViewHolder holder, int position, @NonNull @NotNull BookingModel model) {
        holder.name.setText(model.getName());
        holder.ratings.setText(model.getRatings());
        holder.tags.setText(model.getTags());
        holder.visits.setText(model.getVisits());



        Glide.with(holder.img.getContext())
                .load(model.getHurl())
                .placeholder(R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);

       holder.book.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                final  DialogPlus dialogPlus = DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.booking_popup))
                       .setExpanded(true,1400)
                       .create();

                //Add to cart button connect
                View view = dialogPlus.getHolderView();
                Button btnAddcart = view.findViewById(R.id.btnAddcart);

              dialogPlus.show();




            }
        });



   }

    @NonNull
    @NotNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_item,parent,false);
        return new BookingAdapter.myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        CircleImageView img;
        TextView name,ratings,tags,visits;


        Button book;
        Button cart;

        public myViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);


            img = (CircleImageView)itemView.findViewById(R.id.img1);
            name = (TextView)itemView.findViewById(R.id.nametext);
            ratings =(TextView)itemView.findViewById(R.id.ratingstext);
            tags =(TextView)itemView.findViewById(R.id.tagstext);
            visits =(TextView)itemView.findViewById(R.id.visitstext);

            book = (Button)itemView.findViewById(R.id.book);
            cart = (Button)itemView.findViewById(R.id.cart);


        }
    }
}
