package sk.mpage.androidsample.recyclerview.poi;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
public class POIParser {
    public List<POI> pois;

    public static final String getLink(double lat, double lng, double radius_in_m) {
        //// TODO: 10. implementovat vypocet obdlznika na zakladae radiusu

        return getLink(0,0,0,0);
    }

    public static final String getLink(double s, double w, double n, double e) {
        return "http://overpass.osm.rambler.ru/cgi/interpreter?data=[out:json];" +
                "node[\"name\"](" + s + "," + w + "," + n + "," + e + ");out;";
    }

    public POIParser() {
        this.pois = new ArrayList<>();

    }

    public void parseResp(double lat, double lon, JSONObject jsonObject) throws JSONException {
        this.pois = new ArrayList<>();
        //todo: 11. implementovat parser

        if (false) { //ma tag elements ?
            JSONArray elements = null;
            for (int i = 0; i < elements.length(); i++) {
                JSONObject element = null;

                //ak ma element atributy "id", "type", "lat", "lon"
                if (false) {
                    //ak "name" nie je prazdny string
                    if (false) {
                        POI poi = new POI(
                                0, //id
                                null, // type
                                null, //name
                                0, //lat
                                0 //lon
                        );
                        poi.calculateDistance(lat, lon);//vypocet vzdialnost od aktualnej pozicie
                        this.pois.add(poi); //pridanie bodu
                    }
                }
            }
            Collections.sort(pois); //usporiadanie podla vzdialenosti
        }
    }
}
