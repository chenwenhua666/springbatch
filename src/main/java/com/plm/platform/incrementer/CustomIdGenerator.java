package com.plm.platform.incrementer;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.plm.platform.batch.service.impl.SnowflakeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author crystal
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CustomIdGenerator implements IdentifierGenerator {

    private final SnowflakeService snowflakeService;

    @Override
    public Number nextId(Object entity) {
        //可以将当前传入的class全类名来作为bizKey,或者提取参数来生成bizKey进行分布式Id调用生成.
        String bizKey = entity.getClass().getName();
        log.info("bizKey:{}", bizKey);
        /*
        MetaObject metaObject = SystemMetaObject.forObject(entity);
        String name = (String) metaObject.getValue("name");
        log.info("为{}生成主键值->:{}", name);
        */
        long id = snowflakeService.getId("leaf-snowflake").getId();
        log.info("主键={}",id);
        return id;
    }
}
