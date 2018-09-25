package cn.itcast.ssm.po;

import java.util.List;

/**
 * Created by gofocus on 2018/1/23 18:02.
 */
public class EUDataGridResult<T> {
    private long total;
    private List<T> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
