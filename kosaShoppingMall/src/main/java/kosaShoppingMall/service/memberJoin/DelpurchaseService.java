package kosaShoppingMall.service.memberJoin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.DelGoodsPurchaseDTO;
import kosaShoppingMall.mapper.MemberMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class DelpurchaseService {
	@Autowired
	MemberMapper memberMapper;
	
	public Integer execute(String purchaseNum) {
		
		String str = purchaseNum;
		JSONArray arr = JSONArray.fromObject(str); // [["2202252312","sdafff"],["2202252312","sdafff"]]
		
		 List<String[]> resendList = new ArrayList<String[]>();
		 for(int i=0; i<arr.size(); i++){
			 JSONArray arr1 = JSONArray.fromObject(arr.get(i));
			 String[] stringArray = null; 
		     if (arr1 != null) {
		            int length = arr1.size();
		            stringArray = new String[length];
		            for (int ii = 0; ii < length; ii++) {
		                stringArray[ii] = arr1.optString(ii);
		                System.out.println("arr.optString(ii) : " + arr1.optString(ii));
		            }
		        }
			resendList.add(stringArray);
		 }
		return memberMapper.delPurchase(resendList);
/*
        JSONArray arr = JSONArray.fromObject(str);
		
		 List<Map<String, Object>> resendList = new ArrayList<Map<String, Object>>();
		 for(int i=0; i<arr.size(); i++){   
		        JSONObject obj = (JSONObject)arr.get(i);
		        Map<String, Object> resendMap = new HashMap<String, Object>();
		        resendMap.put("Nation", obj.get("Nation"));
		        resendMap.put("Brand", obj.get("Brand"));
		        resendList.add(resendMap);
		  }
		  return memberMapper.delPurchase(resendList);
		  
		  
		  DELETE FROM GLB_TB WHERE
			<foreach collection="resendList" item="item" separator="OR">
				V_NATION = #{item.Nation} AND V_BRAND = #{item.Brand}
			</foreach>

 */
		
	}
}
