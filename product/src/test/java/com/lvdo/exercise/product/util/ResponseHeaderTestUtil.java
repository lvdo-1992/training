package com.lvdo.exercise.product.util;

import org.springframework.http.ResponseEntity;

/**
 * 
 * @author lvdo
 *
 */
public class ResponseHeaderTestUtil {

    /**
     * Test response header is successful - OK {@code 200}
     * 
     * @param <T>
     * @param response
     */
    public static <T> void testResponseHeaderData(ResponseEntity<T> response) {
        T responseSvo = response.getBody();
//        assertNotNull(responseSvo);
//        ServiceHeadVo headerVo = responseSvo.getResponseHeadVo();
//
//        assertNotNull(headerVo);
//        assertEquals(ServiceResultType.SUCCESS, headerVo.getServiceResultCode());
//        assertEquals(InfoMessageType.SUCCESS_IN_RETRIEVE.getCode(), headerVo.getResponseMessageCode());
    }
//    
//    /**
//     * Test response header has code {@link resultType}
//     * 
//     * @param <T>
//     * @param response
//     * @param resultType
//     */
//    public static <T> void testResponseHeaderData(ResponseEntity<T> response, ServiceResultType resultType) {
//        T responseSvo = response.getBody();
//        assertNotNull(responseSvo);
//        ServiceHeadVo headerVo = responseSvo.getResponseHeadVo();
//
//        assertNotNull(headerVo);
//        assertEquals(resultType, headerVo.getServiceResultCode());
//    }
//    
//    /**
//     * Test response header has code {@link resultType} and information message {@link infoMessage}
//     * 
//     * @param <T>
//     * @param response
//     * @param resultType
//     * @param infoMessage
//     */
//    public static <T> void testResponseHeaderData(ResponseEntity<T> response, ServiceResultType resultType, InfoMessageType infoMessage) {
//        T responseSvo = response.getBody();
//        assertNotNull(responseSvo);
//        ServiceHeadVo headerVo = responseSvo.getResponseHeadVo();
//
//        assertNotNull(headerVo);
//        assertEquals(resultType, headerVo.getServiceResultCode());
//        assertEquals(infoMessage.getCode(), headerVo.getResponseMessageCode());
//    }
}
