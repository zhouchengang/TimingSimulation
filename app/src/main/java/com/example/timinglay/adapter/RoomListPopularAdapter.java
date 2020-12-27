package com.example.timinglay.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.timinglay.R;
import com.example.timinglay.struct.SeatStru;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 描述:
 * TimingLay-
 *
 * @Author J_jiasheng@qq.com
 * @create 2020-12-17 11:57
 */
public class RoomListPopularAdapter  extends BaseQuickAdapter<SeatStru, BaseViewHolder> {

    /**
     * 构造方法，此示例中，在实例化Adapter时就传入了一个List。
     * 如果后期设置数据，不需要传入初始List，直接调用 super(layoutResId); 即可
     */
    public RoomListPopularAdapter(List<SeatStru> list) {
        super(R.layout.seatgrid, list);
    }


    /**
     * 在此方法中设置item数据
     */
    @Override
    protected void convert(@NotNull BaseViewHolder helper, @NotNull SeatStru item) {
        helper.setImageBitmap(R.id.p1, item.head1 );
        helper.setImageBitmap(R.id.p2, item.head2 );
        helper.setImageBitmap(R.id.p3, item.head3 );
        helper.setImageBitmap(R.id.p4, item.head4 );
        if(!item.ismale1){
            helper.setImageResource(R.id.gender1, R.mipmap.iv_female_icon );
        }
        if(!item.ismale2){
            helper.setImageResource(R.id.gender2, R.mipmap.iv_female_icon );
        }
        if(!item.ismale3){
            helper.setImageResource(R.id.gender3, R.mipmap.iv_female_icon );
        }
        if(!item.ismale4){
            helper.setImageResource(R.id.gender4, R.mipmap.iv_female_icon );
        }






        ImageView bp= helper.getView(R.id.greenpoint);
                ObjectAnimator a0=ObjectAnimator.ofFloat(bp,"rotation",0,360).setDuration(1000);
                ObjectAnimator alphaani=ObjectAnimator.ofFloat(bp,"alpha",1,0).setDuration(500);
                ObjectAnimator alphaani2=ObjectAnimator.ofFloat(bp,"alpha",0,1).setDuration(400);
                AnimatorSet as=new AnimatorSet();
                as.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        Log.e("ANI","onAnimationStart");
                    }
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Log.e("ANI","onAnimationEnd");
                        as.start();
                    }
                    @Override
                    public void onAnimationCancel(Animator animation) {
                        Log.e("ANI","onAnimationCancel");
                    }
                    @Override
                    public void onAnimationRepeat(Animator animation) {
                        Log.e("ANI","onAnimationRepeat");
                    }
                });
                as.play(alphaani);
                as.play(alphaani2).after(alphaani);
                as.start();


                TextView tv=helper.getView(R.id.djs);
                Handler handler = new Handler( );
                handler.postDelayed(new Runnable( ) {
                    @Override
                    public void run ( ) {
                        tv.setText(new SimpleDateFormat("hh:mm:ss").format(new java.util.Date()));
                        handler.postDelayed(this,1000);
                    }
                },0);

    }
}
