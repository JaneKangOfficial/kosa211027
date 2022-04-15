package com.example.controller;

import com.example.dto.SampleUserDto;
import com.example.service.SampleTransactionService;
import kr.msp.constant.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: mium2
 * Date: 14. 3. 18
 * Time: 오후 6:31
 * 서버 클라이언트 연동 트랜잭션 사용 방법 샘플
 */
@Controller
public class SampleTransactionCtrl {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired(required=true)
    private SampleTransactionService sampleTransactionService;

    @Autowired(required=true)
    private MessageSource messageSource;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // !!!주의 확인: RequestMapping  uri 는 반드시 /api로 시작 해야만 한다.
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(method= RequestMethod.POST, value="/api/msp/sampleTran/{id}",produces = "application/json; charset=utf8")
    public ModelAndView sampleList(HttpServletRequest request, HttpServletResponse response){
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 클라이언트에서 넘어온 request 값  map으로 리턴해줌 (반드시 포함)
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //rest로 넘어온 URI Path VARIABLES ATTRIBUTE 맵정보
        Map<String,Object> uriPathVal = (Map<String,Object>)request.getAttribute(Const.REST_URI_PATH_VAL);
        //클라이언트에서 넘어온 request(HEAD+BODY) 모든정보
        Map<String,Object> reqMap =  (Map<String,Object>)request.getAttribute(Const.HTTP_BODY);
        //클라이언트에서 넘어온 공통 헤더 맵정보
        Map<String,Object> reqHeadMap =  (Map<String,Object>)request.getAttribute(Const.HEAD);
        //클라이언트에서 넘긴 파라미터 맵정보
        Map<String,Object> reqBodyMap =  (Map<String,Object>)request.getAttribute(Const.BODY);
        //클라이언트에서 넘길 Response 맵 세팅
        Map<String,Object> responseMap = new HashMap<String, Object>();
        Map<String, Object> responseBodyMap= new HashMap<String, Object>();
        if(reqHeadMap==null){
            reqHeadMap = new HashMap<String, Object>();
        }
        reqHeadMap.put(Const.RESULT_CODE, Const.OK);
        reqHeadMap.put(Const.RESULT_MESSAGE, Const.SUCCESS);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        try{
            /**************************************************************************************************
             * 이 부분에 비즈니스 로직을 코딩한다.
             * 만약, 클라이언트에 에러처리를 하고 싶다면  responseMap.setResultCode(Const.EXCEPTION_ERROR); 사용
             **************************************************************************************************/
            List<SampleUserDto> users = new ArrayList<SampleUserDto>();
            SampleUserDto userDto = new SampleUserDto();
            userDto.setSEQNO(2);
            userDto.setUSERID(uriPathVal.get("id").toString());
            userDto.setUSERNM("테스트1");
            userDto.setUSERSN("001");
            users.add(userDto);
            userDto = new SampleUserDto();
            userDto.setSEQNO(3);
            userDto.setUSERID("Test2");
            userDto.setUSERNM("테스트2");
            userDto.setUSERSN("002");
            users.add(userDto);

            sampleTransactionService.transactionInsert(users);

            /**************************************************************************************************
             * 이 부분에 비즈니스 로직 마침.
             *************************************************************************************************/
        } catch (Exception e) {
            reqHeadMap.put(Const.RESULT_CODE,Const.EXCEPTION_ERROR);
            if(e.getMessage() != null){
                reqHeadMap.put(Const.RESULT_MESSAGE,e.getMessage());
            } else {
                reqHeadMap.put(Const.RESULT_MESSAGE,messageSource.getMessage("500.error", null , Locale.getDefault().ENGLISH ));
            }
        }
        responseMap.put(Const.HEAD,reqHeadMap);
        responseMap.put(Const.BODY,responseBodyMap);

        ModelAndView mv = new ModelAndView("defaultJsonView");
        mv.addAllObjects(responseMap);
        return mv;
    }
}
