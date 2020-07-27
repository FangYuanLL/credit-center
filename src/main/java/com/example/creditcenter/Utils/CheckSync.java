package com.example.creditcenter.Utils;

import com.example.creditcenter.Model.Audit;

import java.util.*;

public class CheckSync {

    private static Map<String,Audit> synMap = Collections.synchronizedMap(new HashMap<>());

    public static boolean  CheckDuplicate(Audit audit){
        boolean flag = true;//默认为true不会插入数据
        if (!synMap.containsKey("CheckDuplicate")){
            synMap.put("CheckDuplicate",audit);
            flag = false;
        }else{
            Audit key = synMap.get("CheckDuplicate");
            if (key.getSerialnumber().equals(audit.getSerialnumber()) == true && key.getPlatform()==audit.getPlatform()){
                flag = true;
            }else {
                flag = false;
            }
        }
        return flag;
    }
}
