package com.example.bottomsheet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomsheet.databinding.DateItemBinding;

import java.util.ArrayList;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> {

    private CalendarInterface calendarInterface;
    private ArrayList<CalendarDate> list;
    private int pos = -1;

    public CalendarAdapter(CalendarInterface calendarInterface, ArrayList<CalendarDate> list) {
        this.calendarInterface = calendarInterface;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        DateItemBinding binding = DateItemBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(list.get(position), position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private DateItemBinding binding;

        public ViewHolder(DateItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(CalendarDate calendarDataModel, int position) {
            TextView calendarDay = binding.tvCalendarDay;
            TextView calendarDate = binding.tvCalendarDate;
            View cardView = binding.getRoot();

            if (pos == position) {
                calendarDataModel.setSelected(true);
            }

            if (calendarDataModel.isSelected()) {
                pos = -1;
                calendarDay.setTextColor(ContextCompat.getColor(itemView.getContext(), R.color.white));
                calendarDate.setTextColor(ContextCompat.getColor(itemView.getContext(), R.color.white));
                cardView.setBackgroundColor(ContextCompat.getColor(itemView.getContext(), R.color.white));
            } else {
                calendarDate.setTextColor(ContextCompat.getColor(itemView.getContext(), R.color.teal));
                calendarDay.setTextColor(ContextCompat.getColor(itemView.getContext(), R.color.teal));
                cardView.setBackgroundColor(ContextCompat.getColor(itemView.getContext(), R.color.white));
            }

            calendarDay.setText(calendarDataModel.getCalendarDay());
            calendarDate.setText(calendarDataModel.getCalendarDate());

            cardView.setOnClickListener(view -> calendarInterface.onSelect(calendarDataModel, getAdapterPosition(), calendarDate));
        }
    }

    public interface CalendarInterface {
        void onSelect(CalendarDate calendarDate, int position, TextView day);
    }

    public void setPosition(int pos) {
        this.pos = pos;
    }

    public void updateList(ArrayList<CalendarDate> calendarList) {
        list.clear();
        list.addAll(calendarList);
        notifyDataSetChanged();
    }
}
