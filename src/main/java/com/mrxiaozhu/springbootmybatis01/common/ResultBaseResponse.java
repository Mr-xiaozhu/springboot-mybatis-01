package com.mrxiaozhu.springbootmybatis01.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * @author yangmingyang
 * 此类用来返回给APP使用
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResultBaseResponse implements java.io.Serializable{
	private static final long serialVersionUID = 4541324354676887L;
	
	private Integer result;
    
	private String resultMessage;
    
    
    /**
     * 直接返回成功的对象
     * @param resultMessage
     * @return
     */
    public static final ResultBaseResponse success(String resultMessage) {
    	ResultBaseResponse resultBaseResponse = new ResultBaseResponse();
    	resultBaseResponse.setResult(0);
    	resultBaseResponse.setResultMessage(resultMessage);

        return resultBaseResponse;
    }
    /**
     * 直接返回失败的对象
     * @param resultMessage
     * @return
     */
    public static final ResultBaseResponse fail(String resultMessage) {
    	ResultBaseResponse resultBaseResponse = new ResultBaseResponse();
    	resultBaseResponse.setResult(-1);
    	resultBaseResponse.setResultMessage(resultMessage);
    	
        return resultBaseResponse;
    }
    /**
     * 指定result，resultMessage，content返回的对象
     * @param result
     * @param resultMessage
     * @return
     */
    public static ResultBaseResponse generate(Integer result,String resultMessage) {
        ResultBaseResponse resultBaseResponse = new ResultBaseResponse();
    	resultBaseResponse.setResult(result);
    	resultBaseResponse.setResultMessage(resultMessage);
    	
        return resultBaseResponse;
    }
}