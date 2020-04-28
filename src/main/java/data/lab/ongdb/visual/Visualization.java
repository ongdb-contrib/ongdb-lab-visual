package data.lab.ongdb.visual;
/*
 *
 * Data Lab - graph database organization.
 *
 */

import com.alibaba.fastjson.JSONObject;
import data.lab.ongdb.visual.server.HttpService;
import data.lab.ongdb.visual.util.FileUtil;
import data.lab.ongdb.visual.util.JSONTool;

import java.io.IOException;

/**
 * @author Yc-Ma
 * @PACKAGE_NAME: data.lab.ongdb.visual.Visualization
 * @Description: TODO(Visualization Plugin Run)
 * @date 2020/4/28 17:07
 */
public class Visualization {

    private final static String VISUAL_DATA_PATH = "neo-import-csv/check-graph-traversal.json";

    /**
     * @param queryResult:检索工具的查询结果
     * @return
     * @Description: TODO(Run graph data visualization)
     */
    public void run(JSONObject queryResult) throws IOException {
        JSONObject result = JSONTool.transferToOtherD3(queryResult);
        FileUtil.writeFileByNewFile(VISUAL_DATA_PATH, result.toJSONString());
        new HttpService().run();
    }

    /**
     * @param queryResult:检索工具的查询结果
     * @param port:指定HTTP服务的端口启动    - 需要对应在neo4j-engine-inter\src\main\resources\static\js\graph.js中修改HTTP请求的端口
     * @return
     * @Description: TODO(Run graph data visualization)
     */
    public void run(JSONObject queryResult, int port) throws IOException {
        JSONObject result = JSONTool.transferToOtherD3(queryResult);
        FileUtil.writeFileByNewFile(VISUAL_DATA_PATH, result.toJSONString());
        new HttpService().run(port);
    }

}

