package com.example.jobbox.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jobbox.R;
import com.example.jobbox.models.Postlist;

import java.util.ArrayList;

import javax.xml.xpath.XPathFunctionResolver;

public class PostCustomAdapter extends BaseAdapter {

    ArrayList<Postlist> Postlist;
//    private Integer[] mImage = {R.drawable.im1, R.drawable.im2, R.drawable.im3, R.drawable.im4};
    public PostCustomAdapter(ArrayList<Postlist> Postlist ) {
        this.Postlist = Postlist;
    }

    @Override
    public int getCount() {
        return Postlist.size();
    }

    @Override
    public Postlist getItem(int position) {
        return Postlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listpost, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Postlist user = getItem(position);
        viewHolder.headline.setText(user.getheadline());
        viewHolder.location.setText(user.getLocation());
        viewHolder.salary.setText(user.getSalary());
        viewHolder.language.setText(user.getLanguage());
        viewHolder.experience.setText(user.getExperience());


        return view;
    }

    class ViewHolder{
        TextView headline;
        TextView location;
        TextView salary;
        TextView language;
        TextView experience;


        public ViewHolder(View view){
            headline = view.findViewById(R.id.headline);
            location = view.findViewById(R.id.location);
            salary = view.findViewById(R.id.salary);
            language = view.findViewById(R.id.language);
            experience = view.findViewById(R.id.experience);
        }
    }
}
