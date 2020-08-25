package com.crystal.SpringBootPractise.config;

import io.shardingsphere.api.config.rule.ShardingRuleConfiguration;
import io.shardingsphere.api.config.rule.TableRuleConfiguration;
import io.shardingsphere.api.config.strategy.InlineShardingStrategyConfiguration;
import io.shardingsphere.api.config.strategy.StandardShardingStrategyConfiguration;
import io.shardingsphere.core.keygen.DefaultKeyGenerator;
import io.shardingsphere.core.keygen.KeyGenerator;
import io.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 数据库配置
 * 分库分表
 */
//@Configuration
public class DataSourceConfig {
@Bean
    DataSource getShardingDataSource() throws SQLException {
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(getOrderTableRuleConfiguration());

        return ShardingDataSourceFactory.createDataSource(createDataSourceMap(), shardingRuleConfig,  Collections.emptyMap(),new Properties());
    }


    TableRuleConfiguration getOrderTableRuleConfiguration() {
        // 配置Order表规则

        TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration();
        //逻辑表
        orderTableRuleConfig.setLogicTable("t_order");
        //实际节点
        orderTableRuleConfig.setActualDataNodes("ds${0..1}.t_order_${0..1}");
        //自动id生成对应的conlumn
        orderTableRuleConfig.setKeyGeneratorColumnName("order_id");
        //自动id生成策略
        orderTableRuleConfig.setKeyGenerator(new DefaultKeyGenerator());

        // 配置分库 策略
        orderTableRuleConfig.setDatabaseShardingStrategyConfig(
                new InlineShardingStrategyConfiguration("order_id", "ds${order_id % 2}"));
        // 配置分表策略
        orderTableRuleConfig.setTableShardingStrategyConfig(
                new InlineShardingStrategyConfiguration("order_id", "t_order_${order_id % 2}"));
        return orderTableRuleConfig;

    }

    /**
     * 配置数据源
     * @return
     */
    Map<String, DataSource> createDataSourceMap() {
        Map<String, DataSource> result = new HashMap<>();
        result.put("ds0", DataSourceUtil.createDataSource1("ds0"));
        result.put("ds1", DataSourceUtil.createDataSource2("ds1"));
        return result;
    }


    
}
