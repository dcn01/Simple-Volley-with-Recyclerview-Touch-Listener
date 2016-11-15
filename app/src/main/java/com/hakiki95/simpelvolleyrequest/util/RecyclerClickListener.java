package com.hakiki95.simpelvolleyrequest.util;

import android.view.View;

/**
 * Created by hakiki95 on 14/11/2016.
 */

public interface RecyclerClickListener {

    void onClick(View view, int position);

    void onLongClick( View view, int position);
}
