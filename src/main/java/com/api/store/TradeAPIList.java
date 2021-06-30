package com.api.store;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.base.BaseTest;
import com.api.utils.HttpClientUtil;
import java.util.List;
import java.util.Map;

public class TradeAPIList extends BaseTest{

    /***
     * 处理请求结果的返回值
     * @param resultBean
     * @return 返回response结果中data下的list集合
     */
    public List<JSONObject> getPageList(HttpClientUtil.ResultBean resultBean) {
        return ((JSONObject) resultBean.getData()).getJSONArray("list").toJavaList(JSONObject.class);
    }

    /***
     * 新增手工单并返回查询结果的第一条数据
     * @param httpClient httpclient也需要传递过来， 不然会报空指针
     * @param path url-path 参数
     * @param params trade 订单的具体字段 K-V
     * @return 返回response的JSONArray中的[data]下的[list]下的[0]条数据
     */
    public JSONObject saveTrade(HttpClientUtil httpClient, String path, Map<String, Object> params) {//json
        String str = JSONObject.toJSONString(params);

        HttpClientUtil.ResultBean resultBean = httpClient.postJson(path,str);

        return getPageList(resultBean).get(0);
    }

    /***
     * 审核订单，审核成功返回sid,反之则返回“审核失败”
     * @param httpClient
     * @param path
     * @param params
     * @return data/successResult
     */
    public Object auditTrade(HttpClientUtil httpClient, String path, Map<String, String> params) {//form-data
        HttpClientUtil.ResultBean resultBean = httpClient.post(path,params);
        JSONObject data = (JSONObject) resultBean.getData();
        return ((JSONObject)resultBean.getData()).getJSONArray("successResult").getJSONObject(0);
    }

    /**
     * content-type为form形式且返回为data-list集合的所有请求
     * @param httpClient
     * @param path
     * @param params
     * @return 返回response的JSONArray中的[data]下的[list]下的[0]条数据
     */
    public Object form(HttpClientUtil httpClient, String path, Map<String, String> params){ //form-data

        HttpClientUtil.ResultBean resultBean = httpClient.post(path,params);
        return getPageList(resultBean).get(0);
    }

    /***
     * 保存云打印快递模板
     * @param httpClient
     * @param path
     * @param params
     * @return data/trades
     */
    public Object saveCloudTemplate(HttpClientUtil httpClient, String path, Map<String, String> params){//form-data
        HttpClientUtil.ResultBean resultBean = httpClient.post(path,params);

        //return ((JSONObject)resultBean.getData()).getJSONArray("list").getJSONObject(0);
        return ((JSONObject)resultBean.getData()).getJSONArray("trades").getJSONObject(0);

    }




}
