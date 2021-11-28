package com.example.jsonexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.MyViewHolder> {

    LayoutInflater inflater;
    List<User> users;

   // JSONArray users;
    Context context;
    public recyclerViewAdapter(Context context,List<User> users){
        this.inflater= LayoutInflater.from(context);
        this.users=users;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.user_layout, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.etID.setText(users.get(position).getId());
        holder.etUserName.setText(users.get(position).getUsername());
        holder.etName.setText(users.get(position).getName());
        holder.etEmail.setText(users.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private EditText etID, etUserName, etName, etEmail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            etID= itemView.findViewById(R.id.etID_);
            etUserName= itemView.findViewById(R.id.etUserName_);
            etName=itemView.findViewById(R.id.etName_);
            etEmail=itemView.findViewById(R.id.etEmail_);

        }
    }
}
