package data.lab.ongdb.visual;
/*
 *
 * Data Lab - graph database organization.
 *
 */

/**
 * @author Yc-Ma
 * @PACKAGE_NAME: data.lab.ongdb.visual.VisualizationTest_01
 * @Description: TODO
 * @date 2020/4/28 17:47
 */
public class VisualizationTest_01 {

//     private final static String ipPorts = "192.168.12.19:7687";
//
//    private NeoSearcher neoSearcher = new NeoSearcher(ipPorts, "neo4j", "123456",
//            Config.builder().withMaxTransactionRetryTime(600, TimeUnit.SECONDS).build());
//
//    private void run() throws IOException {
//
//        // 加载结果
//        // 39516
//        JSONObject result=eventOrgZdrExpand(39516L);
//        System.out.println(result);
//
//        /**
//         * 使用可视化插件校验图分析数据-可视化插件的使用方式（一）：
//         * 1、将查询结果进行格式转换
//         * 2、转换后的数据写入到neo-import-csv/check-graph-traversal.json文件
//         * 3、启动HTTP-SERVICE:neo4j-engine-inter\src\main\java\casia\isi\neo4j\http\server\HttpService.java
//         * 4、双击neo4j-engine-inter\src\main\resources\static\index.html文件使用浏览器显示
//         * **/
//
//        /**
//         * 使用可视化插件校验图分析数据-可视化插件的使用方式（二）：
//         * 1、直接调用可视化插件类Visualization
//         * 2、然后双击static/index.html页面即可
//         * **/
//        System.out.println(result);
//        new Visualization().run(result);
//    }
//
//    public static void main(String[] args) throws IOException {
//        Configurator.setAllLevels("", Level.INFO);
//        GraphTraversal.setDEBUG(true);
//        new casia.isi.neo4j.visual.VisualizationTest_01().run();
//    }
//
//    /**
//     * @param
//     * @return
//     * @Description: TODO(事件右键【事件分析】--扩展出事件参与度较高的前N个人和事件相关的组织)
//     */
//    public JSONObject eventOrgZdrExpand(long nodeId) {
//        String cql="MATCH p=(n:专题事件)<-[:参与事件]-()-[:参与组织]->(:组织) WHERE id(n)="+nodeId+" RETURN p";
//        JSONObject initialResult = neoSearcher.execute(cql,CRUD.RETRIEVE);
//
//        String topNCql="MATCH p=(n:专题事件)<-[r:参与事件]-() WHERE id(n)="+nodeId+" RETURN p ORDER BY r.statisticsPostNum DESC LIMIT 50";
//        JSONObject topnResult= neoSearcher.execute(topNCql,CRUD.RETRIEVE);
//
//        return JSONTool.mergeResult(initialResult, topnResult);
//    }
}


