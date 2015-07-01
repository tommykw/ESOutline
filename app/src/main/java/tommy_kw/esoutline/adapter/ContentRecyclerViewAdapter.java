package tommy_kw.esoutline.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import tommy_kw.esoutline.R;

/**
 * Created by tomita on 15/07/01.
 */
public class ContentRecyclerViewHolder extends RecyclerView.ViewHolder {

    private String mUrl;
    private CardView cardView;
    private TextView titleView;
    private TextView  descriptionView;
    private TextView  dateView;
//    protected RecyclerViewListener mListener;

    public ContentRecyclerViewHolder(View view) {
        super(view);
//        mListener = null;
//        findView(view);
//        setEvent();
    }

//    public ContentRecyclerViewHolder(View view, RecyclerViewListener listener) {
//        super(view, listener);
//        mListener = listener;
//        findView(view);
//        setEvent();
//    }
//
//    @Override
//    protected void findView(View v){
//        cardView = (CardView) v.findViewById(R.id.card_view);
//        imgThumbnail = (CustomImageView) v.findViewById(R.id.img_thumbnail);
//        titleView = (TextView) v.findViewById(R.id.text_title);
//        descriptionView = (TextView) v.findViewById(R.id.text_description);
//        dateView   =(TextView)v.findViewById(R.id.text_date);
//        mUrl = null;
//    }
//
//    @Override
//    protected void setEvent() {
//        cardView.setOnClickListener( new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                if( mListener != null ){
//                    if( Utilities.isEmpty(mUrl))return;
//                    mListener.onClickedView(mUrl);
//                }
//            }
//        });
//    }
//
//    @Override
//    public void bind(ListData listData){
//
//        if( listData instanceof ContentData) {
//
//            ContentData data = (ContentData) listData;
//            mUrl = data.getUrl();
//            titleView.setText(data.getTitle());
//            descriptionView.setText(data.getDescription());
//            dateView.setText(data.getDate());
//
//            if (Utilities.isEmpty(data.getImageUrl())) {
//                imgThumbnail.setVisibility(View.GONE);
//                imgThumbnail.setImageResource(R.drawable.no_image);
//            } else {
//                imgThumbnail.setVisibility(View.VISIBLE);
//                RequestCreator pc = Picasso.with(imgThumbnail.getContext()).load(data.getImageUrl());
//                pc.placeholder(R.drawable.image_loading);
//                pc.error(R.drawable.no_image)
//                        .into(imgThumbnail);
//            }
//        }else{
//            titleView.setText("");
//            descriptionView.setText("");
//            dateView.setText("");
//            imgThumbnail.setVisibility(View.GONE);
//            imgThumbnail.setImageResource(R.drawable.no_image);
//
//        }
//    }
//
//    public interface RecyclerViewListener{
//        public void onClickedView(String mUrl);
//    }
}
