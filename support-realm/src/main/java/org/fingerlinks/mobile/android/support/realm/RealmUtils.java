package org.fingerlinks.mobile.android.support.realm;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by raphaelbussa on 20/04/16.
 */
public class RealmUtils {

    public static GsonBuilder getGsonBuilder() {
        Type tokenInt = new TypeToken<RealmList<RealmInt>>() {
        }.getType();
        Type tokenString = new TypeToken<RealmList<RealmString>>() {
        }.getType();
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.setExclusionStrategies(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return f.getDeclaringClass().equals(RealmObject.class);
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        });
        builder.registerTypeAdapter(tokenString, new TypeAdapter<RealmList<RealmString>>() {

            @Override
            public void write(JsonWriter out, RealmList<RealmString> value) throws IOException {
                // Ignore
            }

            @Override
            public RealmList<RealmString> read(JsonReader in) throws IOException {
                RealmList<RealmString> list = new RealmList<>();
                in.beginArray();
                while (in.hasNext()) {
                    list.add(new RealmString(in.nextString()));
                }
                in.endArray();
                return list;
            }
        });
        builder.registerTypeAdapter(tokenInt, new TypeAdapter<RealmList<RealmInt>>() {

            @Override
            public void write(JsonWriter out, RealmList<RealmInt> value) throws IOException {
                // Ignore
            }

            @Override
            public RealmList<RealmInt> read(JsonReader in) throws IOException {
                RealmList<RealmInt> list = new RealmList<>();
                in.beginArray();
                while (in.hasNext()) {
                    list.add(new RealmInt(in.nextInt()));
                }
                in.endArray();
                return list;
            }
        });
        return builder;
    }


}
