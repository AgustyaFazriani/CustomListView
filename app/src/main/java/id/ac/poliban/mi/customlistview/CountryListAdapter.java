package id.ac.poliban.mi.customlistview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class CountryListAdapter extends BaseAdapter {
    private List<Country> countries;

    public CountryListAdapter(List<Country> countries) {

    }

    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public Object getItem(int i) {
        return countries.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_country_list, viewGroup, false);

        //mengenali view ke object
        ImageView imgCountryListFlag = view.findViewById(R.id.img_country_flag_list);
        TextView tvCountryName = view.findViewById(R.id.tv_country_name);
        TextView tvCountryDetail = view.findViewById(R.id.tv_country_detail);

        //isi data
        Glide.with(viewGroup.getContext())
                .load(countries.get(i).getFlag())
                .apply(new RequestOptions().override(90, 55))
                .into(imgCountryListFlag);
        tvCountryName.setText(countries.get(i).getCountryName());
        tvCountryDetail.setText(countries.get(i).getCountryDetail());

        return view;
    }
}
