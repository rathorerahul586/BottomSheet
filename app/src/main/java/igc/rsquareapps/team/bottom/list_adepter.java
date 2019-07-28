package igc.rsquareapps.team.bottom;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Build;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class list_adepter extends RecyclerView.Adapter<list_adepter.ViewHolder> {


    private List<list_data> myList;
    private static final String TAG = "list_adepter";
    public list_adepter(List<list_data> myList) {
        this.myList = myList;
    }

    public ClipData clipData;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {

        viewHolder.icon.setImageResource(myList.get(i).getIcon());
        viewHolder.textView1.setText(myList.get(i).getTv1());
        viewHolder.textView2.setText(myList.get(i).getTv2());
        viewHolder.textView3.setText(myList.get(i).getTv3());
        viewHolder.textView4.setText(myList.get(i).getTv4());
        viewHolder.companyName.setText(myList.get(i).getCompanyName());
        viewHolder.date.setText(myList.get(i).getDate());
        viewHolder.location.setText(myList.get(i).getLocation());

        viewHolder.myCard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item job_title = new ClipData.Item(viewHolder.textView1.getText());
                    /*ClipData.Item salary = new ClipData.Item(textView2.getText());
                    ClipData.Item timing = new ClipData.Item(textView3.getText());
                    ClipData.Item experience = new ClipData.Item(textView4.getText());
                    ClipData.Item location = new ClipData.Item(textView1.getText());
                    ClipData.Item company_name = new ClipData.Item(companyName.getText());
                    ClipData.Item L_date = new ClipData.Item(date.getText());
*/
                    String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
                    clipData = new ClipData("abc",mimeTypes,job_title);
                    //clipData.addItem(job_title);

                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(viewHolder.myCard);
                Log.d("long Pressed", "onLongClick: "+job_title);
                viewHolder.myCard.startDrag(clipData,myShadow,null,0);

                return true;
            } });
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView icon;
        private TextView textView1,textView2,textView3,textView4,companyName,date,location;
        private CardView myCard;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            myCard=itemView.findViewById(R.id.mainCard);
            icon = itemView.findViewById(R.id.icon);
            textView1 = itemView.findViewById(R.id.tv1);
            textView2 = itemView.findViewById(R.id.tv2);
            textView3 = itemView.findViewById(R.id.tv3);
            textView4 = itemView.findViewById(R.id.tv4);
            date = itemView.findViewById(R.id.date);
            location = itemView.findViewById(R.id.location);
            companyName = itemView.findViewById(R.id.companyName);
        }

    }

}
