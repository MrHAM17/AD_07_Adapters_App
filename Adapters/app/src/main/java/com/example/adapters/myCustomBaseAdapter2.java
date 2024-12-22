package com.example.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

public class myCustomBaseAdapter2 extends BaseAdapter {

    // Step 4.1: The adapter needs the context (the current state of the application) and the data source to work.
    //           These are passed to the adapter when it is created.

    private Context context;
    private String[] countries;    // Data Source

    // Step 4.2: The constructor initializes the adapter with the context and the data source, 
    //           ensuring the adapter knows where to fetch the data from and where to display it.

    public myCustomBaseAdapter2(Context context, String[] countries){
        this.context = context;
        this.countries = countries;
    }


    // Step 4.3: Override methods from the BaseAdapter class to define:
    //           - `getCount()`: Returns the total number of items in the data source.
    //           - `getItem(int position)`: Returns the data at the specified position.
    //           - `getItemId(int position)`: Returns a unique ID for each item (typically its position).
    //           - `getView(int position, View view, ViewGroup parent)`: Prepares and returns the view for each item.

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
       
        // Step 4.5: Declare a variable of type ViewHolder 
        //           --> to store references to the views.
        //           (to hold the instance of the ViewHolder class)
        //           ( --> which will be used to store the references to the views.)
        //           This is used to efficiently manage and reuse views in the ListView.

        
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
            //               Instantiate the ViewHolder to hold/store references to the views within the newly inflated layout.
            holder = new ViewHolder();

            //  step 4.6.3A: Find and Store the TextView
            //               Locate the required views (e.g., TextView) within the inflated view and store its reference in the ViewHolder.
            holder.textview = view.findViewById(R.id.myTextviewForCustomBaseAdapter);

            //  step 4.6.4A: Associate the ViewHolder with the View
            //               Attach the ViewHolder to the view by storing/using it in the view's tag, which allows for efficient retrieval later.
            view.setTag(holder);
        }
        else{
            // If the view is not null then --> its used one(i.e, got scrolled up & now not on screen) --> so attach all new objets & new data to it --> whose procedure is below
            // Reusing the View (that's recycled)

            //  step 4.6.1B: Retrieve the ViewHolder
            //               Get the ViewHolder associated with the view from the view's tag, ensuring you have access to the references stored in the ViewHolder.
            //               (If the view is being reused (recycled), retrieve the ViewHolder instance from the view's tag.)
                        
            holder = (ViewHolder) view.getTag();
        }

        //  step 4.7: Set the data to the view
        //            Populate/fill the TextView in the ViewHolder with the data at the given position from the countries array.
        //            (Bind data from the data source to the views in the ViewHolder for the current position.)
        //            (Here, set the text of the TextView to the corresponding value in the `countries` array.)

        
        holder.textview.setText(countries[position]);

        //  step 4.8: Return the View
        //            Return the view with the data bound to it, making it ready for display in the list.
        //            Binding data to views within the view (told in course)
        //            Displays the data at a position in the data set  (told in course)
        //            (Return the fully prepared view (with the data bound) for display in the ListView.)

        return view;
    }

   
    // Step 4.4: Create a static ViewHolder class (subclass of base class) 
    //           --> to hold references to the views in the layout for a single list item.
    //           (for to return "type & quantity of views" only, hope so...)
    //           (here views means the no. of things  for every single main empty structure/component/view  of lists)
    //           This improves performance by avoiding repeated calls to `findViewById`.

    static class ViewHolder{
        // Holds references to the views within an countries layout
        TextView textview;
    }

}
