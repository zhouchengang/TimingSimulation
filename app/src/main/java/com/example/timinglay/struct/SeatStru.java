package com.example.timinglay.struct;

import android.graphics.Bitmap;

/**
 * 描述:
 * TimingLay-
 *
 * @Author J_jiasheng@qq.com
 * @create 2020-12-17 11:55
 */
public class SeatStru {
    public Bitmap head1;
    public Bitmap head2;
    public Bitmap head3;
    public Bitmap head4;
    public boolean ismale1;
    public boolean ismale2;
    public boolean ismale3;
    public boolean ismale4;
    public SeatStru(Bitmap head1, Bitmap head2, Bitmap head3, Bitmap head4,
                    boolean ismale1, boolean ismale2, boolean ismale3, boolean ismale4){
        this.head1=head1;
        this.head2=head2;
        this.head3=head3;
        this.head4=head4;
        this.ismale1=ismale1;
        this.ismale2=ismale2;
        this.ismale3=ismale3;
        this.ismale4=ismale4;
    }
}