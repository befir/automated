package user.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

public class ChannelManage extends RestfulAutomatedTest {

    //查询渠道
    private String queryChannelServiceUrl = baseUrl+"/ouser-web/channel/queryChannelPage.do";
    //新增渠道
    private String addChannelServiceUrl = baseUrl+"/ouser-web/channel/addChannel.do";
    //修改渠道信息
    private String updateChannelServiceUrl = baseUrl+"/ouser-web/channel/updateChannelById.do";
    @Test
    public void queryChannel() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver,queryChannelServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
}
