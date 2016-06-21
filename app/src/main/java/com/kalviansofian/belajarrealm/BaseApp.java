package com.kalviansofian.belajarrealm;

import android.app.Application;

import java.util.Date;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

/**
 * Created by root on 18/06/16.
 */
public class BaseApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //konfigurasi Realm
        RealmConfiguration config=new RealmConfiguration.Builder(this)
                //versi database
        .schemaVersion(0)
        .migration(new DataMigration())
        .build();


        Realm.setDefaultConfiguration(config);
    }

    private class DataMigration implements RealmMigration{

        @Override
        public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
            //mengambil schme
            RealmSchema schema=realm.getSchema();

            //membuat schema baru jika versi 0

            if(oldVersion==0){
                schema.create("Article")
                        .addField("id",int.class)
                        .addField("title",String.class)
                        .addField("description",String.class);

                oldVersion++;
            }
        }
    }
}
