package com.mrxiaozhu.springbootmybatis01.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ResultContentResponse<T> extends ResultBaseResponse {
    private static final long serialVersionUID = 413578129899766L;

    private T content;
    
    public ResultContentResponse(Integer result, String resultMessage) {
        super(result, resultMessage);
    }

    /**
     * 返回成功的对象
     * @param resultMessage
     * @param content
     * @return
     */
    public static ResultContentResponse<Object> success(String resultMessage, Object content) {
        ResultContentResponse<Object> resultContentResponse = new ResultContentResponse<Object>();
        resultContentResponse.setResult(0);
        resultContentResponse.setResultMessage(resultMessage);
        resultContentResponse.setContent(content);
        return resultContentResponse;
    }

    public static<T> ResultContentResponse<T> successGeneric(String resultMessage, T content) {
        ResultContentResponse<T> resultContentResponse = new ResultContentResponse<T>();
        resultContentResponse.setResult(0);
        resultContentResponse.setResultMessage(resultMessage);
        resultContentResponse.setContent(content);
        return resultContentResponse;
    }

    /**
     * 返回失败的对象
     * @param resultMessage
     * @param content
     * @return
     */
    public static ResultContentResponse<Object> fail(String resultMessage, Object content) {
        ResultContentResponse<Object> resultContentResponse = new ResultContentResponse<Object>();
        resultContentResponse.setResult(-1);
        resultContentResponse.setResultMessage(resultMessage);
        resultContentResponse.setContent(content);
        return resultContentResponse;
    }
    /**
     * 指定result，resultMessage，content返回的对象
     * @param result
     * @param resultMessage
     * @param content
     * @return
     */
    public static ResultContentResponse<Object> generate(Integer result,String resultMessage, Object content) {
        ResultContentResponse<Object> resultContentResponse = new ResultContentResponse<Object>();
        resultContentResponse.setResult(result);
        resultContentResponse.setResultMessage(resultMessage);
        resultContentResponse.setContent(content);
        return resultContentResponse;
    }

    public static<T> ResultContentResponse<T> generateGeneric(Integer result,String resultMessage, T content) {
        ResultContentResponse<T> resultContentResponse = new ResultContentResponse<T>();
        resultContentResponse.setResult(result);
        resultContentResponse.setResultMessage(resultMessage);
        resultContentResponse.setContent(content);
        return resultContentResponse;
    }
    
    /**
     * 直接返回失败的对象
     * @param resultMessage
     * @return
     */
    public static <T> ResultContentResponse<T> failGeneric(String resultMessage,T content) {
        ResultContentResponse<T> resultContentResponse = new ResultContentResponse<>();
        resultContentResponse.setResult(-1);
        resultContentResponse.setResultMessage(resultMessage);
        resultContentResponse.setContent(content);

        return resultContentResponse;
    }
    
    /**
     * 直接返回失败的对象
     * @param resultMessage
     * @return
     */
    public static <T> ResultContentResponse<T> succGeneric(String resultMessage,T content) {
    	ResultContentResponse<T> resultContentResponse = new ResultContentResponse<>();
    	resultContentResponse.setResult(-1);
    	resultContentResponse.setResultMessage(resultMessage);
    	resultContentResponse.setContent(content);
    	
    	return resultContentResponse;
    }
    
}