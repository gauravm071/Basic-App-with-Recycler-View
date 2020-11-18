
package com.example.first;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    ArrayList<Integer> table= new ArrayList<>();
    int index=1;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent= getIntent();
        Bundle extras= intent.getExtras();
        recyclerView= findViewById(R.id.rvId);
        int number= Integer.parseInt(extras.getString("number"));
        for(int i=1;i<=20;i++){
            table.add(number*i);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new TableAdapter(table,number));

    }

    public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ViewHolder>{
        private TextView textView;
        ArrayList<Integer> listOfData= new ArrayList<>();
        int num;
        public class ViewHolder extends RecyclerView.ViewHolder{
            TextView textView;
            public ViewHolder(@NonNull View itemView) {

                super(itemView);
                textView= itemView.findViewById(R.id.tvTable);
            }
        }

        public TableAdapter(ArrayList<Integer> listOfData,int num){
            this.listOfData= listOfData;
            this.num=num;
        }

        @NonNull
        @Override
        public TableAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View myview= LayoutInflater.from(parent.getContext()).inflate(R.layout.table,parent,false);
            return new ViewHolder(myview);
        }

        @Override
        public void onBindViewHolder(@NonNull TableAdapter.ViewHolder holder, int position) {
            int data= listOfData.get(position);
            holder.textView.setText(num+" * "+ index+" = "+data);
            index++;
        }

        @Override
        public int getItemCount() {
            return listOfData.size();
        }
    }


}