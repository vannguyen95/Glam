package com.example.annie.glam.json;

import com.example.annie.glam.Model.DesProduct;
import com.example.annie.glam.Model.Product;
import com.example.annie.glam.Model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by DH Yuka on 6/9/2016.
 */
public class ParseDataJSON {
    List<Product> listProduct;

    public ParseDataJSON() {
    }

    public List<Product> getListProduct(String data) {

        listProduct = new ArrayList<>();

        try {
            JSONArray jsonarray = new JSONArray(data);

            for (int i = 0; i < jsonarray.length(); i++) {

                JSONObject jsonobj = jsonarray.getJSONObject(i);

                String _maSP = jsonobj.getString("MaSP");
                String _name = jsonobj.getString("Name");
                String _image = jsonobj.getString("Image");
                String _priceOld = jsonobj.getString("GiaBD") + ".000";
                String _priceNew = jsonobj.getString("GiaHT") + ".000";

                if (_maSP != "") {
                    listProduct.add(new Product(1, _maSP, _name, _image, "", true, _priceOld, _priceNew, new Date(), ""));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listProduct;
    }

    public DesProduct getDesProduct(String data) {
        DesProduct desProduct = null;

        try {
            JSONObject jsonobj = new JSONObject(data);

            String _maSP = jsonobj.getString("MaSP");
            String _image = jsonobj.getString("DsHinhAnh");
            String  _description = jsonobj.getString("ThongTinChiTiet");
            String _size = jsonobj.getString("FullSize");

            desProduct = new DesProduct(_maSP, _image, _description, _size);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return desProduct;
    }

    public User Logine(String data){
        User  user = null;

        try {
            JSONObject jsonobj = new JSONObject(data);

            String Email = jsonobj.getString("Email");
            String  PassWord = jsonobj.getString("PassWord");

            user = new User(Email, PassWord);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return user;
    }
}
