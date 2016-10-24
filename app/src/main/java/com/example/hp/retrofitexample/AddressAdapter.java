package com.example.hp.retrofitexample;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.retrofitexample.model.Result;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by hp on 10/23/16.
 */
public class AddressAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<Result> mResultList;
    private Context mContext;

    public AddressAdapter(List<Result> resultList, Context context) {
        this.mResultList = resultList;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view =  LayoutInflater.from(mContext).inflate(R.layout.item_location_view,parent,false);
        LocationHolder holder = new LocationHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        LocationHolder viewHolder = (LocationHolder) holder;
        viewHolder.locationNameTV.setText(mResultList.get(position).getName());
        viewHolder.locationAddressTV.setText(mResultList.get(position).getFormattedAddress());
        viewHolder.ratingTV.setText(String.valueOf(mResultList.get(position).getRating()));

        if (mResultList.get(position).getPhotos().size() > 0) {
            String imageUrl = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=" + mResultList.get(position).getPhotos().get(0).getPhotoReference()
                    + "&key=" + MainActivity.API_KEY + "&sensor=false";
            Uri uri = Uri.parse(imageUrl);
            viewHolder.imageView.setImageURI(uri);
        }
    }

    @Override
    public int getItemCount() {
        return mResultList.size();
    }

    private class LocationHolder extends RecyclerView.ViewHolder{

        private SimpleDraweeView imageView;
        private TextView locationAddressTV, locationNameTV, ratingTV;

        public LocationHolder(View itemView) {
            super(itemView);
            imageView = (SimpleDraweeView) itemView.findViewById(R.id.imageView);
            locationAddressTV = (TextView) itemView.findViewById(R.id.locationAddresTextView);
            locationNameTV = (TextView) itemView.findViewById(R.id.locationNameTextView);
            ratingTV = (TextView) itemView.findViewById(R.id.ratingTextView);
        }
    }
}
