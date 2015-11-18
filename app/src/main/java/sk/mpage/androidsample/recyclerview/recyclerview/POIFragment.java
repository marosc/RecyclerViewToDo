package sk.mpage.androidsample.recyclerview.recyclerview;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import sk.mpage.androidsample.recyclerview.R;
import sk.mpage.androidsample.recyclerview.helper.SampleResp;
import sk.mpage.androidsample.recyclerview.helper.WebRequestSingleton;
import sk.mpage.androidsample.recyclerview.poi.POI;
import sk.mpage.androidsample.recyclerview.poi.POIParser;
import sk.mpage.androidsample.recyclerview.poi.iSelectedPOI;

public class POIFragment extends Fragment implements iSelectedPOI, SharedPreferences.OnSharedPreferenceChangeListener {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ProgressBar mProgress;
    private POIParser poiParser;
    private POIAdapter POIAdapter;
    private static final String requestTag = "POIFragment";


    public int max_distance_poi = 100;

    public POIFragment() {
        // Required empty public constructor
        mLayoutManager = new LinearLayoutManager(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        poiParser = new POIParser();

        //todo: 5. pridat layout pre fragment poi_fragment.xml
        return null;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //todo: 5. nastavit progressbar do premennej
        mProgress = null;

        //todo: 5. nastavit recyclerview do premennej
        mRecyclerView = null;

        //todo: 5. nastavit mu pevnu velkost FixedSize
        //todo: 5. nastavit mu layout manager

        POIAdapter = new POIAdapter(this);
        //todo: 8. nastavit adapter pre recylcer view


        //todo: 9. ziskat argumenty "lat" a "lon" ak existuju

        //todo: 9. ak existuju tak pouzit metodu updatePOI(lat,lon) na ich zobrazenie
        //todo: 9. ak neexistuju tak informovat uzivatela ze sa caka na polohu

    }

    public void addItems(List<POI> items) {
        updateProgress(95);
        long id = getSelectedItem();
        if (items.isEmpty()) {
            deleteSelectedItem();
        } else {
            //todo: 23. zisit novu vzdialenost od oznaceneho poi a ak je vacsia ako zadana tak vymazat ho zo sharedpreferences a oznacit prvy

        }

        //todo: 24. pridat prvky do adaptera setItems() a upozornit adapter na zmenu udajov
    }

    @Override
    public long getSelectedItem() {
        //todo: 17. ziskat zo shared preferences id oznaceneho poi
        return -1;
    }

    @Override
    public void saveSelectedItem(POI poi) {
        //todo: 18. ulozit do shared preferences "id", "typ", "name", "lat", "lon"
        //todo: 19. nastavit v adapteri novu hodnotu poi_id
    }

    @Override
    public void deleteSelectedItem() {
        //todo: 20. vymazat poi zo shared preferences
        //todo: 21. nastavit v adapteri poi_id na hodnotu -1
    }

    //len pre ucely testovania kym vam nefunguje nacitanie z internetu
    public String dummyRequest(){
        return SampleResp.resp;
    }

    public void updatePOI(final double lat, final double lon) {
        updateProgress(70);
        //todo: 13a. ziskat pomocou Volley GET requestu na POIParser.getLink(lat, lon, max_distance_poi) json
        //todo: 14. parsovat json poiParser.parseResp(lat, lon, response);
        //todo: 15. pridat poi addItems(poiParser.pois);
        //todo: 16. v pripade chyby upozornit uzivatela

    }

    public void updateProgress(int progressStatus) {
        if (mProgress != null) {
            mProgress.setProgress(progressStatus);
        }
    }

    @Override
    public void onStop() {
        //todo: 22. pri skonceni fragmentu zrusit vsetky http requesty, ktore vytovril

        super.onStop();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.compareTo("max_distance_poi") == 0) {
            max_distance_poi = Integer.parseInt(sharedPreferences.getString("max_distance_poi", "100"));
        }
    }
}
