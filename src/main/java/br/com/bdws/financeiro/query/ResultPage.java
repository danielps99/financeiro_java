package br.com.bdws.financeiro.query;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

@Data
public class ResultPage implements Result {

    private final int page;
    private final long size;
    private final long total;
    private final long pages;
    private final long elapsedTime;
    private final List<Map<String, Object>> data;

    public ResultPage(int page, long size, long total, long elapsedTime, List<Map<String, Object>> data) {
        this.page = page;
        this.size = size;
        this.total = total;
        this.elapsedTime = elapsedTime;
        this.data = data;
        if (size == 0) {
            this.pages = 0;
        } else {
            this.pages = new BigDecimal(((float) total) / (float) size).setScale(0, RoundingMode.UP).intValue();
        }
    }
}