package com.example.bysj.patientanddoctor;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Qian on 2018/5/31.
 * 获取和设置SharedPreferences中数据内容的工具
 */
public class SPUtil {

    public static SharedPreferences getSP(Context context){
        return context.getSharedPreferences(Constant.SP_KEY,0);
    }

    public static SharedPreferences.Editor getSPEditor(Context context){
        return context.getSharedPreferences(Constant.SP_KEY,0).edit();
    }


    public static String getName(Context context){
        return getSP(context).getString(Constant.SP_NAME,null);
    }

    public static void setName(Context context,String name){
        getSPEditor(context).putString(Constant.SP_NAME,name).commit();
    }
    public static int getRole(Context context){
        return getSP(context).getInt(Constant.SP_ROLE,0);
    }

    public static void setRole(Context context,int role){
        getSPEditor(context).putInt(Constant.SP_ROLE,role).commit();
    }

    public static int getId(Context context){
        return getSP(context).getInt(Constant.SP_ID,0);
    }


    public static void setId(Context context,int userid){
        getSPEditor(context).putInt(Constant.SP_ID,userid).commit();
    }

}
