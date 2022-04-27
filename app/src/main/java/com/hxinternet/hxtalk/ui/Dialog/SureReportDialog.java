package com.hxinternet.hxtalk.ui.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.hxinternet.hxtalk.R;

import butterknife.ButterKnife;

/**
 * create time: 2021/3/3
 * author: wd
 * description:È·ÈÏÀ­ºÚ
 */
public class SureReportDialog extends Dialog {


    private Context mContext;
    public SureReportDialog(Context context) {
        super(context, R.style.center_dialog);
        mContext=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_surereport);
        ButterKnife.bind(this);
        initWindow();
    }

    private void initWindow() {
        Window window = getWindow();
        window.setGravity(Gravity.CENTER);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
    }



}
