package com.example.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

public class myCustomBaseAdapter2 extends BaseAdapter {

    //  step 4.1: receive context & data source
    private Context context;
    private String[] countries;    // Data Source

    //  step 4.2: create constructor to fetch or receive data of context & data source
    public myCustomBaseAdapter2(Context context, String[] countries){
        this.context = context;
        this.countries = countries;
    }


    //  step 4.3: create all methods (for extended class i.e, base class here --> has 4 methods)
    @Override
    public int getCount() {
        return countries.length;
    }

    @Override
    public Object getItem(int position) {
        return countries[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        //  step 4.5:  Initialize the ViewHolder
        //             Declare a variable to hold the instance of the ViewHolder class which will be used to store the references to the views.
        ViewHolder holder;

        //  step 4.6: check is the view new or used one
        //            (here view/s means the  actual every single main filled structure/component of lists in which the no. of things(means the type & quantity of views) are placed & data is not placed/attached/binded respectively )

        if (view == null){
            // view: is a recycled View (the component i.e, filled) (means this view is got scrolled up (** denotes that its can not be null ** ) & so now its not on the screen)
            //       that you can reuse(by changing/putting  the data only & by avoiding/decreasing the  unnecessary load for creation from starting) to improve the performance of your list.

            // If the view is null then its new one --> so attach all new objets & new data to it --> whose procedure is below

            //  step 4.6.1A: Inflate the View
            //               Create a new view by inflating the layout file for the list item using the LayoutInflater.
            view = LayoutInflater.from(context).inflate(R.layout.my_custom_textview_for_list_data_for_custom_base_adapter, viewGroup,false);

            //  step 4.6.2A: Create a New ViewHolder
            //               Instantiate the ViewHolder to hold references to the views within the newly inflated layout.
            holder = new ViewHolder();

            //  step 4.6.3A: Find and Store the TextView
            //               Locate the TextView within the inflated view and store its reference in the ViewHolder.
            holder.textview = view.findViewById(R.id.myTextviewForCustomBaseAdapter);

            //  step 4.6.4A: Associate the ViewHolder with the View
            //               Attach the ViewHolder to the view by storing it in the view's tag, which allows for efficient retrieval later.
            view.setTag(holder);
        }
        else{
            // If the view is not null then --> its used one(i.e, got scrolled up & now not on screen) --> so attach all new objets & new data to it --> whose procedure is below
            // Reusing the View (that's recycled)

            //  step 4.6.1B: Retrieve the ViewHolder
            //               Get the ViewHolder associated with the view from the view's tag, ensuring you have access to the references stored in the ViewHolder.
            holder = (ViewHolder) view.getTag();
        }

        //  step 4.7: Set the data to the view
        //            Populate/fill the TextView in the ViewHolder with the data at the given position from the countries array.
        holder.textview.setText(countries[position]);

        //  step 4.8: Return the View
        //            Return the view with the data bound to it, making it ready for display in the list.
        //            Binding data to views within the view (told in course)
        //            Displays the data at a position in the data set  (told in course)
        return view;
    }

    //  step 4.4: create subclass of base class --> for to return "type & quantity of views" only
    //            (here views means the no. of things  for every single main empty structure/component/view  of lists)
    static class ViewHolder{
        // Holds references to the views within an countries layout
        TextView textview;
    }

}
