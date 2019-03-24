package krunal.com.example.acer.waitinglistapp;


import android.arch.lifecycle.ViewModelProviders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import krunal.com.example.acer.waitinglistapp.Database.WaitingListEntity;

public class MainActivity extends AppCompatActivity {

    private EditText mnameedittext, mnumberedittext;
    private Button maddbutton;
    private RecyclerView mrecycleview;
    private RecycleViewAdapter mrecycleviewadapter;
    private MainActivityViewModel mmainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mnameedittext = findViewById(R.id.nameEdittext);
        mnumberedittext = findViewById(R.id.numberEditText);
        maddbutton = findViewById(R.id.Add);
        mmainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mrecycleview = findViewById(R.id.recyclerView);
        mrecycleview.setLayoutManager(new LinearLayoutManager(this));
        mrecycleviewadapter = new RecycleViewAdapter(this);
        mrecycleview.setAdapter(mrecycleviewadapter);

        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                mmainActivityViewModel.delete(mrecycleviewadapter.get(viewHolder.getAdapterPosition()));
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(mrecycleview);

        mmainActivityViewModel.getList().observe(this, list -> {
            mrecycleviewadapter.add(list);
        });

        maddbutton.setOnClickListener((View n) -> {
            String name = mnameedittext.getText().toString().trim();
            String number = mnumberedittext.getText().toString().trim();
            mnumberedittext.setFilters(new InputFilter[]{new InputFilterMinMax("1", "80")});
            hidekeyboard();
            if (TextUtils.isEmpty(name) || number.equals("")) {
                Toast.makeText(this, "Empty Field Not Allowed", Toast.LENGTH_LONG).show();
            } else {
                int finalnumber = Integer.parseInt(number);
                mmainActivityViewModel.insert(new WaitingListEntity(name, finalnumber));
                Toast.makeText(this, "Added", Toast.LENGTH_LONG).show();
                mnameedittext.setText("");
                mnumberedittext.setText("");
            }
/**
 * Created by Anusha
 * This method helps not allowing empty fileld.
 */
        });
    }

    void hidekeyboard() {
        try {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            assert imm != null;
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/**
 * Created by Anusha
 * Hiding the kryboard function.
 */

}
