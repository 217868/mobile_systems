package com.example.univeristyligthhousekeeper.ui.main;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.univeristyligthhousekeeper.DatabaseModel.Kierunek;
import com.example.univeristyligthhousekeeper.DatabaseModel.Wydzial;
import com.example.univeristyligthhousekeeper.R;
import com.example.univeristyligthhousekeeper.ui.main.KierunkiFragment.OnListFragmentInteractionListener;

import java.util.ArrayList;
import java.util.List;

public class MyKierunkiRecyclerViewAdapter extends RecyclerView.Adapter<MyKierunkiRecyclerViewAdapter.ViewHolder> {

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private final List<Wydzial> mValues;
    private final OnListFragmentInteractionListener mListener;
    int mExpandedPosition = -1;
    int previousExpandedPosition = -1;
    private String searchString = "";
    private final Context context;

    public MyKierunkiRecyclerViewAdapter(List<Wydzial> items, OnListFragmentInteractionListener listener, Context context) {
        mValues = items;
        mListener = listener;
        this.context = context;
    }

    public MyKierunkiRecyclerViewAdapter(List<Wydzial> items, OnListFragmentInteractionListener listener, String searchString, Context context) {
        mValues = items;
        mListener = listener;
        this.searchString = searchString;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.kierunek_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).getWydzial());

        @SuppressLint("WrongConstant")
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                holder.recyclerViewSub.getContext(),
                LinearLayout.VERTICAL,
                false);

        layoutManager.setInitialPrefetchItemCount(mValues.get(position).getKierunki().size());
        List<Kierunek> searched = new ArrayList<>();
        for (Kierunek k: mValues.get(position).getKierunki()) {
            if (k.getKierunek().contains(searchString))searched.add(k);
        }
        MySubKierunekRecyclerView subRecycler = new MySubKierunekRecyclerView(searched, mListener, context);
        holder.recyclerViewSub.setLayoutManager(layoutManager);
        holder.recyclerViewSub.setAdapter(subRecycler);
        holder.recyclerViewSub.setRecycledViewPool(viewPool);

//        holder.mView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(holder.recyclerViewSub.getVisibility() == View.VISIBLE)
//                    holder.recyclerViewSub.setVisibility(View.GONE);
//                else holder.recyclerViewSub.setVisibility(View.VISIBLE);
//                if (null != mListener) {
//                    // Notify the active callbacks interface (the activity, if the
//                    // fragment is attached to one) that an item has been selected.
//                    mListener.onListFragmentInteraction(holder.mItem);
//                }
//            }
//        });

        final boolean isExpanded = position==mExpandedPosition;
        holder.recyclerViewSub.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.itemView.setActivated(isExpanded);
        final int finPosition = position;

        if (isExpanded)
            previousExpandedPosition = position;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1:finPosition;
                notifyItemChanged(previousExpandedPosition);
                notifyItemChanged(finPosition);
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
        public Wydzial mItem;
        public RecyclerView recyclerViewSub;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = (TextView) view.findViewById(R.id.content);
            recyclerViewSub = view.findViewById(R.id.sub_item);
            recyclerViewSub.setVisibility(View.GONE);
        }


        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
