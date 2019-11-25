package com.example.thietkegiaodienapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thietkegiaodienapplication.R;
import com.example.thietkegiaodienapplication.activity.Login2Activity;
import com.example.thietkegiaodienapplication.dao.UserDAO;
import com.example.thietkegiaodienapplication.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHowder> {
    List<User> users;
    Context context;
    UserDAO userDAO = new UserDAO(context);


    public UserAdapter(List<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewHowder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.giaodien1, null);


        return new UserViewHowder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHowder holder, final int position) {
        final User user = users.get(position);
        holder.tvname.setText(user.name);
        holder.imgxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userDAO = new UserDAO(context);
                userDAO.delete(user.getName());
                users.remove(user);
                notifyDataSetChanged();
                Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Login2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("NAME", user.getName());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class UserViewHowder extends RecyclerView.ViewHolder {
        public TextView tvname;
        ImageView imgxoa;

        public UserViewHowder(@NonNull View itemView) {
            super(itemView);
            tvname = itemView.findViewById(R.id.tvname);
            imgxoa = itemView.findViewById(R.id.imgxoa);

        }
    }
}
