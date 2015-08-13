package com.thickman.brewbro;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class RecipeFragment extends Fragment implements View.OnClickListener {

    // Holds all malt rows
    private LinearLayout llFermentables;

    // Initial malt row
    private LinearLayout llMalt1;
    private Spinner spMalt1;
    private EditText etMalt1;
    private TextView txtLbs;

    // Holds all hop rows
    private LinearLayout llHops;

    // Initial hop row
    private LinearLayout llHop1;
    private Spinner spHop1;
    private EditText etHopWeight1;
    private EditText etHopTime1;
    private TextView txtOz;
    private TextView txtMin;

    // Add/remove buttons
    private Button btnMoreGrain;
    private Button btnLessGrain;
    private Button btnMoreHops;
    private Button btnLessHops;

    // Yeast
    private Spinner spYeast;

    // Just dummy ingredients for now, I'll use web services later to get all the latest ingredients!
    private String[] dummyMalt = { "Pale (2-Row)", "Munich", "German Pilsner", "Vienna", "Maris Otter", "Chocolate", "Black Barley", "Crystal 10", "Crystal 40", "Crystal 60", "Carapils" };
    private String[] dummyHops = { "Amarillo", "Cascade", "Citra", "Centennial", "Mosaic", "El Dorado", "Hallertau", "Nugget", "Fuggle", "Northern Brewer", "Saaz", "Magnum"  };
    private String[] dummyYeast = { "American", "California", "English", "Irish", "Kölsch", "European", "London", "Burton", "German Hefe" };

    public RecipeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_edit_recipe, container, false);

        // Malt
        llFermentables = (LinearLayout) rootView.findViewById(R.id.llFermentables);
        btnMoreGrain = (Button) rootView.findViewById(R.id.btnMoreGrain);
        btnMoreGrain.setOnClickListener(this);
        btnLessGrain = (Button) rootView.findViewById(R.id.btnLessGrain);
        btnLessGrain.setOnClickListener(this);
        llMalt1 = (LinearLayout) rootView.findViewById(R.id.llMalt1);
        spMalt1 = (Spinner) rootView.findViewById(R.id.spMalt1);
        etMalt1 = (EditText) rootView.findViewById(R.id.etMalt1);
        txtLbs = (TextView) rootView.findViewById(R.id.txtLbs);

        // Hops
        llHops = (LinearLayout) rootView.findViewById(R.id.llHops);
        btnMoreHops = (Button) rootView.findViewById(R.id.btnMoreHops);
        btnMoreHops.setOnClickListener(this);
        btnLessHops = (Button) rootView.findViewById(R.id.btnLessHops);
        btnLessHops.setOnClickListener(this);
        llHop1 = (LinearLayout) rootView.findViewById(R.id.llHop1);
        spHop1 = (Spinner) rootView.findViewById(R.id.spHop1);
        etHopTime1 = (EditText) rootView.findViewById(R.id.etHopTime1);
        etHopWeight1 = (EditText) rootView.findViewById(R.id.etHopWeight1);
        txtOz = (TextView) rootView.findViewById(R.id.txtOz);
        txtMin = (TextView) rootView.findViewById(R.id.txtMin);

        // Yeast
        spYeast = (Spinner) rootView.findViewById(R.id.spYeast);

        setIngredientSpinner(spMalt1, dummyMalt);
        setIngredientSpinner(spHop1, dummyHops);
        setIngredientSpinner(spYeast, dummyYeast);

        return rootView;
    }

    // Universal method for my spinners to set dropdown items, whether they're hops or grains
    private void setIngredientSpinner(Spinner spinner, String[] list) {
        ArrayAdapter<String> spAdapterMalt = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, list);
        spinner.setAdapter(spAdapterMalt);
    }

    // Dynamically create a row to add a new type of hop to your recipe, and insert it into the layout.
    private void addGrainRow() {

        // Get context and create all the new views to be inserted
        Context ctx = getActivity();
        LinearLayout llRow = new LinearLayout(ctx);
        Spinner spGrain = new Spinner(ctx);
        EditText etWeight = new EditText(ctx);
        TextView txtLbl = new TextView(ctx);

        // Right now, I'm just using a dummy list of fermentables. In the future, I'll use a web service call to get all the latest ingredients.
        setIngredientSpinner(spGrain, dummyMalt);

        // Here I'm getting the layout params from the one existing row in the layout, since all other rows of hops will look the same.
        llRow.setLayoutParams(llMalt1.getLayoutParams());
        spGrain.setLayoutParams(spMalt1.getLayoutParams());
        etWeight.setLayoutParams(etMalt1.getLayoutParams());
        txtLbl.setLayoutParams(txtLbs.getLayoutParams());

        txtLbl.setText(txtLbs.getText());

        etWeight.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);

        // Add them in the order you want them
        llRow.addView(spGrain);
        llRow.addView(etWeight);
        llRow.addView(txtLbl);

        // Add the view
        llFermentables.addView(llRow);
    }

    // Dynamically create a row to add a new type of hop to your recipe, and insert it into the layout.
    private void addHopRow() {

        // Get context and create all the new views to be inserted
        Context ctx = getActivity();
        LinearLayout llRow = new LinearLayout(ctx);
        Spinner spHop = new Spinner(ctx);
        EditText etWeight = new EditText(ctx);
        EditText etTime = new EditText(ctx);
        TextView txtLblOz = new TextView(ctx);
        TextView txtLblMin = new TextView(ctx);

        // Right now, I'm just using a dummy list of hops. In the future, I'll use a web service call to get all the latest ingredients.
        setIngredientSpinner(spHop, dummyHops);

        // Here I'm getting the layout params from the one existing row in the layout, since all other rows of hops will look the same.
        llRow.setLayoutParams(llHop1.getLayoutParams());
        spHop.setLayoutParams(spHop1.getLayoutParams());
        etWeight.setLayoutParams(etHopWeight1.getLayoutParams());
        etTime.setLayoutParams(etHopTime1.getLayoutParams());
        txtLblOz.setLayoutParams(txtOz.getLayoutParams());
        txtLblMin.setLayoutParams(txtMin.getLayoutParams());

        txtLblOz.setText(txtOz.getText());
        txtLblMin.setText(txtMin.getText());

        etWeight.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
        etTime.setInputType(InputType.TYPE_NUMBER_VARIATION_NORMAL);

        // Add them in the order you want them
        llRow.addView(spHop);
        llRow.addView(etWeight);
        llRow.addView(txtLblOz);
        llRow.addView(etTime);
        llRow.addView(txtLblMin);

        // Add the view
        llHops.addView(llRow);
    }

    // Removes the last row of ingredients (hops or grains) from the desired layout
    private void removeIngredientRow(LinearLayout layout) {
        if (layout.getChildCount() > 1)
            layout.removeViewAt(layout.getChildCount() - 1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // Button to add another row for grain to the layout
            case R.id.btnMoreGrain:
                addGrainRow();
                break;
            // Button to remove the last row of grain from the layout
            case R.id.btnLessGrain:
                removeIngredientRow(llFermentables);
                break;
            // Button to add another row for hops to the layout
            case R.id.btnMoreHops:
                addHopRow();
                break;
            // Button to remove the last row of hops from the layout
            case R.id.btnLessHops:
                removeIngredientRow(llHops);
                break;
        }
    }
}
