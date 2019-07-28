package igc.rsquareapps.team.bottom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BottomSheetBehavior behavior;
    LinearLayout layout;
    CoordinatorLayout mainLayout;
    public RecyclerView recyclerView;
    public list_adepter adepter;
    public List<list_data> list;
    TextView j_title, j_salary, j_timing;

    TextView status,tvIcon;

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout=findViewById(R.id.bottom);
        mainLayout=findViewById(R.id.mainLayout);
        status=findViewById(R.id.status);
        tvIcon=findViewById(R.id.tvIcon);
        j_title = findViewById(R.id.jobTitle);



        mainLayout.setOnDragListener(new View.OnDragListener() {
    @Override
    public boolean onDrag(View v, DragEvent event) {
        ClipData clipData = event.getClipData();

        //Log.d(TAG, "onDrag: "+event.getResult());
        switch (event.getAction()) {

            case DragEvent.ACTION_DROP:
                Log.d("Droped", "droped Data: "+clipData);
                String cData = clipData.toString();
                j_title.setText(cData);
                return true;
        }
        Log.d("Action"," "+event.getAction());
        return true;
    }
});


        behavior=BottomSheetBehavior.from(layout);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState){
                    case BottomSheetBehavior.STATE_COLLAPSED:{
                        status.setText("Collapsed");
                        break;
                    }
                    case BottomSheetBehavior.STATE_EXPANDED: {
                        status.setText("Expended");
                    }
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                Log.d(TAG, "onSlide: ");
            }


        });


        recyclerView=findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        list = new ArrayList<>();
        list.add(new list_data("Web Developer","20000-25000","Full Time","1-2 Years Experience","Hire Me","2019-06-31","Chandigrah",R.drawable.ic_computer_black_24dp));
        list.add(new list_data("Android developer","25000-30000","Full Time","2-3 Years Experience","Rathore Apps","2019-07-05","Mohali",R.drawable.ic_computer_black_24dp));
        list.add(new list_data("Technical Support","15000-20000","Part Time","1-2 Years Experience","Media Guru","2019-07-15","Ludhiana",R.drawable.ic_computer_black_24dp));
        list.add(new list_data("Customer Care","20000-25000","Full Time","0-1 Years Experience","Soft Tech","2019-07-20","Chandigrah",R.drawable.ic_computer_black_24dp));

        adepter = new list_adepter(list);

        recyclerView.setAdapter(adepter);

    }


}
