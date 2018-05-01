package com.xzit.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huang on 2018/4/1.
 */
public class EntityToColum {

    public static String GetUserMap(String key){
        Map userMap;
        userMap=new HashMap();
        userMap.put("userLoginCount","user_login_count");
        userMap.put("userNickname","userid");
        userMap.put("userNickname","user_nickname");
        userMap.put("userTruename","user_truename");
        userMap.put("userEmail","user_email");
        userMap.put("userPassword","user_password");
        userMap.put("userBalance","user_balance");
        userMap.put("userResignDate","user_resign_date");
        userMap.put("userPaypassword","user_paypassword");
        userMap.put("userLoginDate","user_login_date");
        userMap.put("userState","user_state");
        userMap.put("userAuthority","user_authority");
        userMap.put("userDrive","user_drive");
        userMap.put("deletestate","deletestate");

return (String) userMap.get(key);
    }

   public static String GetVenuesMap(String key){
       Map venuesMap=new HashMap();
       venuesMap.put("venuesid","venuesid");
       venuesMap.put("venuesUserCharge","venues_user_charge");
       venuesMap.put("venuesProvice","venues_provice");
       venuesMap.put("venuesCity","venues_city");
       venuesMap.put("venuesAreas","venues_areas");
       venuesMap.put("venuesAddress","venues_address");
       venuesMap.put("venuesLongitude","venues_longitude");
       venuesMap.put("venuesLatitude","venues_latitude");
       venuesMap.put("openTime","open_time");
       venuesMap.put("closeTime","close_time");
       venuesMap.put("venuesName","venues_name");
       venuesMap.put("deletestate","deletestate");
       return (String) venuesMap.get(key);
   }
   public static String GetOrderMap(String key){
       Map orderMap=new HashMap();
       orderMap.put("orderId","order_id");
       orderMap.put("userid","userid");
       orderMap.put("incomeState","income_state");
       orderMap.put("money","money");
       orderMap.put("cause","cause");
       orderMap.put("incomeUserId","income_user_id");
       orderMap.put("medium","medium");
       orderMap.put("time","time");
       orderMap.put("deletestate","deletestate");
   return (String) orderMap.get(key);
   }


    public static String GetUserCustomer(String key){
        Map orderMap=new HashMap();
        orderMap.put("venuesid","venuesid");
        orderMap.put("userid","userid");
        orderMap.put("venuesAllocationId","venues_allocation_id");
        orderMap.put("activitiesSettingTime","activities_setting_time");
        orderMap.put("activitiesStartTime","activities_start_time");
        orderMap.put("enlistStopTime","activities_stop_time");
        orderMap.put("enlistStartTime","enlist_start_time");
        orderMap.put("activitiesStopTime","activities_stop_time");
        orderMap.put("deletestate","deletestate");
        orderMap.put("total","total");
        orderMap.put("enlistnum","enlistnum");
        orderMap.put("paymentmoney","paymentmoney");
        orderMap.put("auditing","auditing");
        orderMap.put("payState","pay_state");
        orderMap.put("userpay","userpay");
        orderMap.put("createtime","createtime");
        return (String) orderMap.get(key);
    }
}
