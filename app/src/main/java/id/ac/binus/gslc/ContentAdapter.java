package id.ac.binus.gslc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContentAdapter extends BaseAdapter {
    List<DataModel> listData;
    Context context;
    LayoutInflater inflater;

    public ContentAdapter(List<DataModel> listData, Context context) {
        this.listData = listData;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.product_list,null);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageData);
        TextView nameView = (TextView) convertView.findViewById(R.id.txtName);
        TextView priceView = (TextView) convertView.findViewById(R.id.txtPrice);

        imageView.setImageResource(listData.get(position).getImage());
        nameView.setText(listData.get(position).getNama());
        priceView.setText(listData.get(position).getHarga());
        return convertView;
    }
}
