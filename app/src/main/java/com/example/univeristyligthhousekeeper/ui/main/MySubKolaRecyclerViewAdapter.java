package com.example.univeristyligthhousekeeper.ui.main;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.univeristyligthhousekeeper.DatabaseModel.KoloNaukowe;
import com.example.univeristyligthhousekeeper.R;

import java.util.List;

public class MySubKolaRecyclerViewAdapter extends RecyclerView.Adapter<MySubKolaRecyclerViewAdapter.ViewHolder> {

    private final List<KoloNaukowe> mValues;
    private final KolaFragment.OnListFragmentInteractionListener mListener;


    public MySubKolaRecyclerViewAdapter(List<KoloNaukowe> mValues, KolaFragment.OnListFragmentInteractionListener mListener) {
        this.mValues = mValues;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public MySubKolaRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.subkolo, parent, false);
        return new MySubKolaRecyclerViewAdapter.ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull final MySubKolaRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        Log.d("Kolo Naukowe: ", mValues.get(position).getKoloNaukowe());
        holder.mContentView.setText(mValues.get(position).getKoloNaukowe());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;
        public KoloNaukowe mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = (TextView) view.findViewById(R.id.kolo);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
