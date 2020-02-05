package life.majiang.community.utils;

import lombok.Data;

@Data
public class AjaxResponse {

    private boolean isok;   //请求是否处理成功
    private int code;          //请求响应状态码（200、400、500）
    private String message;  //请求结果描述信息
    private Object data;  //请求结果数据

    private AjaxResponse() {

    }

    public static AjaxResponse success() {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        return resultBean;
    }

    public static AjaxResponse success(Object data) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        resultBean.setData(data);
        return resultBean;
    } public static AjaxResponse fail() {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(500);
        resultBean.setMessage("fail");
        return resultBean;
    }

    public static AjaxResponse fail(Object data) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(500);
        resultBean.setMessage("fail");
        resultBean.setData(data);
        return resultBean;
    }

    // getter / setter 略
}