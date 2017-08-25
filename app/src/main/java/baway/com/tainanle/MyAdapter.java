package baway.com.tainanle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by 贾秀坤 on 2017/8/24.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    Context context;
    private Bean bean;
    private MyHolder holder;
  //  private String imageUrl="https://image.yunifang.com/yunifang/images/goods/121/goods_img/17062610568378169043195978.jpg";
    private  ImageView images;
    public MyAdapter(Context context, Bean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        holder = new MyHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.texts.setText(bean.getData().get(position).getEfficacy());
        Glide.with(context).load(bean.getData().get(position).getGoods_img()).into(images);
    }

    @Override
    public int getItemCount() {
        return  bean.getData().size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private final TextView texts;


        public MyHolder(View itemView) {
            super(itemView);

            texts = (TextView) itemView.findViewById(R.id.texts);
            images = (ImageView) itemView.findViewById(R.id.images);
        }
    }
}
