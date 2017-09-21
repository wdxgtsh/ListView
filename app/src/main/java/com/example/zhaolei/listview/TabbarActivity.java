package com.example.zhaolei.listview;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * Created by zhaolei on 2017/9/18.
 */

public class TabbarActivity extends Activity implements OnClickListener
{

    private HomeFragment mTab01;
    private ConsultFragment mTab02;
    private CaseFragment mTab03;
    private MineFragment mTab04;


    /**
     * 底部四个按钮
     */
    private LinearLayout mTabHomePage;
    private LinearLayout mTabConsult;
    private LinearLayout mTabCase;
    private LinearLayout mTabMine;
    /**
     * 用于对Fragment进行管理
     */
    private FragmentManager fragmentManager;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        initViews();
        fragmentManager = getFragmentManager();
        setTabSelection(0);
    }



    private void initViews()
    {

        mTabHomePage = (LinearLayout) findViewById(R.id.id_tab_bottom_weixin);
        mTabConsult = (LinearLayout) findViewById(R.id.id_tab_bottom_friend);
        mTabCase = (LinearLayout) findViewById(R.id.id_tab_bottom_contact);
        mTabMine = (LinearLayout) findViewById(R.id.id_tab_bottom_setting);

        mTabHomePage.setOnClickListener(this);
        mTabConsult.setOnClickListener(this);
        mTabCase.setOnClickListener(this);
        mTabMine.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.id_tab_bottom_weixin:
                setTabSelection(0);
                break;
            case R.id.id_tab_bottom_friend:
                setTabSelection(1);
                break;
            case R.id.id_tab_bottom_contact:
                setTabSelection(2);
                break;
            case R.id.id_tab_bottom_setting:
                setTabSelection(3);
                break;

            default:
                break;
        }
    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     */
    @SuppressLint("NewApi")
    private void setTabSelection(int index)
    {
        // 重置按钮
        resetBtn();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index)
        {
            case 0:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                ((ImageButton) mTabHomePage.findViewById(R.id.btn_tab_bottom_weixin))
                        .setImageResource(R.drawable.ic_tabar_home_selected);
                if (mTab01 == null)
                {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    mTab01 = new HomeFragment();
                    transaction.add(R.id.id_content, mTab01);
                } else
                {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(mTab01);
                }
                break;
            case 1:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                ((ImageButton) mTabConsult.findViewById(R.id.btn_tab_bottom_friend))
                        .setImageResource(R.drawable.ic_tabar_consult_selected);
                if (mTab02 == null)
                {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    mTab02 = new ConsultFragment();
                    transaction.add(R.id.id_content, mTab02);
                } else
                {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(mTab02);
                }
                break;
            case 2:
                // 当点击了动态tab时，改变控件的图片和文字颜色
                ((ImageButton) mTabCase.findViewById(R.id.btn_tab_bottom_contact))
                        .setImageResource(R.drawable.ic_tabar_case_selected);
                if (mTab03 == null)
                {
                    // 如果NewsFragment为空，则创建一个并添加到界面上
                    mTab03 = new CaseFragment();
                    transaction.add(R.id.id_content, mTab03);
                } else
                {
                    // 如果NewsFragment不为空，则直接将它显示出来
                    transaction.show(mTab03);
                }
                break;
            case 3:
                // 当点击了设置tab时，改变控件的图片和文字颜色
                ((ImageButton) mTabMine.findViewById(R.id.btn_tab_bottom_setting))
                        .setImageResource(R.drawable.ic_tabar_personal_selected);
                if (mTab04 == null)
                {
                    // 如果SettingFragment为空，则创建一个并添加到界面上
                    mTab04 = new MineFragment();
                    transaction.add(R.id.id_content, mTab04);
                } else
                {
                    // 如果SettingFragment不为空，则直接将它显示出来
                    transaction.show(mTab04);
                }
                break;
        }
        transaction.commit();
    }

    /**
     * 清除掉所有的选中状态。
     */
    private void resetBtn()
    {
        ((ImageButton) mTabHomePage.findViewById(R.id.btn_tab_bottom_weixin))
                .setImageResource(R.drawable.ic_tabar_home);
        ((ImageButton) mTabConsult.findViewById(R.id.btn_tab_bottom_friend))
                .setImageResource(R.drawable.ic_tabar_consult);
        ((ImageButton) mTabCase.findViewById(R.id.btn_tab_bottom_contact))
                .setImageResource(R.drawable.ic_tabar_case);
        ((ImageButton) mTabMine.findViewById(R.id.btn_tab_bottom_setting))
                .setImageResource(R.drawable.ic_tabar_personal);
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction
     *            用于对Fragment执行操作的事务
     */
    @SuppressLint("NewApi")
    private void hideFragments(FragmentTransaction transaction)
    {
        if (mTab01 != null)
        {
            transaction.hide(mTab01);
        }
        if (mTab02 != null)
        {
            transaction.hide(mTab02);
        }
        if (mTab03 != null)
        {
            transaction.hide(mTab03);
        }
        if (mTab04 != null)
        {
            transaction.hide(mTab04);
        }

    }

}

