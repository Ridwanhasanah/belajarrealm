package com.kalviansofian.belajarrealm.Helper;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.kalviansofian.belajarrealm.Model.ArticelModel;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by root on 18/06/16.
 */
public class RealmHelper {
    private static  final String TAG="RealmHelper";


    private Realm realm;
    private RealmResults<Articel> realmResults;
    public Context context;

    //constructor untuk inisial realm

    public RealmHelper(Context context){

        realm=Realm.getInstance(context);
        this.context=context;

    }

    //menambah data
    public void addArtikel(String title,String description){

        Articel articel=new Articel();
        articel.setId((int)(System.currentTimeMillis()/1000));
        articel.setTitle(title);
        articel.setDescription(description);


        //transaksi simpan
        realm.beginTransaction();
        realm.copyToRealm(articel);
        realm.commitTransaction();


        showLog("Add : " + title);
        showToast(title + "Berhasil disimpan.");


    }

    //mencari semua artikel
    public ArrayList<ArticelModel> findAllArticel(){
        ArrayList<ArticelModel> data=new ArrayList<ArticelModel>();

        realmResults=realm.where(Articel.class).findAll();
        realmResults.sort("id", Sort.DESCENDING);


        if(realmResults.size()>0){
            showLog("Size : " + realmResults.size());

            for(int i=0;i<realmResults.size();i++){

                String title,description;
                int id=realmResults.get(i).getId();
                title=realmResults.get(i).getTitle();
                description=realmResults.get(i).getDescription();
                data.add(new ArticelModel(id,title,description));



            }
        }else{
            showLog("Size : 0");
            showToast("Database Kosong");

        }
        return data;
    }

    //method update articel
    public void updateArticel(int id,String title,String description){
        realm.beginTransaction();
        Articel articel=realm.where(Articel.class).equalTo("id",id).findFirst();
        articel.setTitle(title);
        articel.setDescription(description);
        realm.commitTransaction();
        showLog("Updated : "+title);

        showToast(title + " berhasil diupdate");
    }

    //method delete
    public void deleteData(int id){
        RealmResults<Articel> dataDesults=realm.where(Articel.class).equalTo("id",id).findAll();
        realm.beginTransaction();
        dataDesults.remove(0);
        dataDesults.removeLast();
        dataDesults.clear();
        realm.commitTransaction();

        showLog("Hapus data berhasil");
    }
    //membuat log
    private void showLog(String s){
        Log.d(TAG,s);
    }

    private void showToast(String s){
        Toast.makeText(context,s,Toast.LENGTH_LONG).show();
    }

}
