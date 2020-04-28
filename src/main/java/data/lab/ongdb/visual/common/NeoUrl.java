package data.lab.ongdb.visual.common;
/*
 *
 * Data Lab - graph database organization.
 *
 */

/**
 * @author Yc-Ma
 * @PACKAGE_NAME: data.lab.ongdb.visual.common.NeoUrl
 * @Description: TODO
 * @date 2020/4/28 17:21
 */
public enum NeoUrl {

    // LOCALHOST HTTP SERVICE API
    NEO_CSV("neo-import-csv");

    private String symbol;

    NeoUrl(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbolValue() {
        return this.symbol;
    }
}

