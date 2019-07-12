package io.github.ds.ds;

/**
 * 数据源上下文环境
 *
 * @author mq
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<DataSourceType> CONTEXT_HOLDER = new InheritableThreadLocal<>();

    /**
     * 设置数据源
     *
     * @param dataSource
     */
    public static void setDataSource(DataSourceType dataSource) {
        CONTEXT_HOLDER.set(dataSource);
    }

    /**
     * 取得当前数据源
     *
     * @return
     */
    public static DataSourceType getDataSource() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 清除上下文数据
     */
    public static void clear() {
        CONTEXT_HOLDER.remove();
    }
}
