package sk.mpage.androidsample.recyclerview.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sk.mpage.androidsample.recyclerview.R;
import sk.mpage.androidsample.recyclerview.poi.POI;
import sk.mpage.androidsample.recyclerview.poi.iSelectedPOI;

/*
 * Copyright (C) 2015 Maros Cavojsky, (mpage.sk)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class POIAdapter extends RecyclerView.Adapter<POIAdapter.ItemViewHolder> {

    private final List<POI> mItems = new ArrayList<>();
    protected int selectedPosition;
    private long poi_id;
    private iSelectedPOI iSelectedPOI;

    public POIAdapter(iSelectedPOI iSelectedPOI) {
        this.iSelectedPOI = iSelectedPOI;
        this.poi_id = this.iSelectedPOI.getSelectedItem();
        this.selectedPosition = -1;
    }

    public void setPOI_id(long id) {
        this.poi_id = id;
    }

    public void setItems(List<POI> items) {
        mItems.clear();
        selectedPosition = -1;
        mItems.addAll(items);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //todo: 26. nastavit itemViewHolder pre riadok ... layout item_view.xml
        return null;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        //// TODO: 27. zobrazit udaje o prvku na pozicii position
        //// TODO: 28.  nastavit mu pozadia podla toho ci je vybraty alebo nie item_row_bg/item_row_bg_selected
    }


    @Override
    public int getItemCount() {
        //todo 29. vratit pocet prvkov v adaptery
        return 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        public final TextView item_left = null;
        public final TextView item_right = null;

        public ItemViewHolder(View itemView) {
            super(itemView);
            //todo 30. nastavit itemView klikatelnym a tiez listener na kliknutie
            //todo 25. nastavit views prvky riadku
        }

        @Override
        public void onClick(View view) {
            //todo: 31. nastavit poziciu prvku na ktorom bol klik
            selectedPosition = 0;

            //todo: 31. nastavit jeho id do premennej poi_id
            poi_id = 0;

            Log.d("POIAdapter", "Kliknute na " + selectedPosition);
            //todo: 31. nastavit mu pozadie item_row_bg_selected

            //todo: 31. ulozit ho do shared prefences
            POIAdapter.this.iSelectedPOI.saveSelectedItem(null);

            //todo: 31. oznamit adapteru aby zrusil zvyraznenie predchadzajuceho prvku
        }
    }
}
