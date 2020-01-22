package com.example.univeristyligthhousekeeper.ui.main;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.univeristyligthhousekeeper.DatabaseModel.JednostkaNadrzednaKN;
import com.example.univeristyligthhousekeeper.DatabaseModel.Kierunek;
import com.example.univeristyligthhousekeeper.DatabaseModel.KoloNaukowe;
import com.example.univeristyligthhousekeeper.R;
import com.example.univeristyligthhousekeeper.ui.main.KolaFragment.OnListFragmentInteractionListener;

import java.util.ArrayList;
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
    int mExpandedPosition = -1;
    int previousExpandedPosition = -1;
    private String searchString = "";
    private final Context context;

    public MyKolaRecyclerViewAdapter(List<JednostkaNadrzednaKN> items, OnListFragmentInteractionListener listener, Context context) {
        mValues = items;
        mListener = listener;
        this.context = context;
    }

    public MyKolaRecyclerViewAdapter(List<JednostkaNadrzednaKN> items, OnListFragmentInteractionListener listener, String searchString, Context context) {
        mValues = items;
        mListener = listener;
        this.searchString = searchString;
        this.context = context;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.kola_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).getJednostkaNadrzedna());

        @SuppressLint("WrongConstant")
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                holder.recyclerViewSub.getContext(),
                LinearLayout.VERTICAL,
                false);

        layoutManager.setInitialPrefetchItemCount(mValues.get(position).getKolaNaukowe().size());
        List<KoloNaukowe> searched = new ArrayList<>();
        for (KoloNaukowe k: mValues.get(position).getKolaNaukowe()) {
            if (k.getKoloNaukowe().contains(searchString))searched.add(k);
        }
        MySubKolaRecyclerViewAdapter subRecycler = new MySubKolaRecyclerViewAdapter(searched, mListener, context);
        holder.recyclerViewSub.setLayoutManager(layoutManager);
        holder.recyclerViewSub.setAdapter(subRecycler);
        holder.recyclerViewSub.setRecycledViewPool(viewPool);

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
        public JednostkaNadrzednaKN mItem;
        public RecyclerView recyclerViewSub;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = (TextView) view.findViewById(R.id.content_kola);
            recyclerViewSub = view.findViewById(R.id.sub_item_kola);
            recyclerViewSub.setVisibility(View.GONE);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
