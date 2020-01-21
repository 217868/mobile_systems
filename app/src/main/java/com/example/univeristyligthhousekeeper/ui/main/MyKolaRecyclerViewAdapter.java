package com.example.univeristyligthhousekeeper.ui.main;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.univeristyligthhousekeeper.DatabaseModel.JednostkaNadrzednaKN;
import com.example.univeristyligthhousekeeper.R;
import com.example.univeristyligthhousekeeper.ui.main.KolaFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyKolaRecyclerViewAdapter extends RecyclerView.Adapter<MyKolaRecyclerViewAdapter.ViewHolder> {

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private final List<JednostkaNadrzednaKN> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyKolaRecyclerViewAdapter(List<JednostkaNadrzednaKN> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_kola2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(Integer.toString(mValues.get(position).getId()));
        holder.mContentView.setText(mValues.get(position).getJednostkaNadrzedna());

        @SuppressLint("WrongConstant")
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                holder.recyclerViewSub.getContext(),
                LinearLayout.VERTICAL,
                false);

        layoutManager.setInitialPrefetchItemCount(mValues.get(position).getKolaNaukowe().size());

        MySubKolaRecyclerViewAdapter subRecycler = new MySubKolaRecyclerViewAdapter(mValues.get(position).getKolaNaukowe(), mListener);
        holder.recyclerViewSub.setLayoutManager(layoutManager);
        holder.recyclerViewSub.setAdapter(subRecycler);
        holder.recyclerViewSub.setRecycledViewPool(viewPool);

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
        public final TextView mIdView;
        public final TextView mContentView;
        public JednostkaNadrzednaKN mItem;
        public RecyclerView recyclerViewSub;
        public LinearLayout linearLayout;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
            recyclerViewSub = view.findViewById(R.id.sub_kolo);
            linearLayout = view.findViewById(R.id.linearKolo);
            recyclerViewSub.setVisibility(View.GONE);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewSub.getVisibility() == View.VISIBLE)
                        recyclerViewSub.setVisibility(View.GONE);
                    else recyclerViewSub.setVisibility(View.VISIBLE);
                }

            });
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
