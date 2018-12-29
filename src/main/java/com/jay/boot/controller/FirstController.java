package com.jay.boot.controller;

import org.springframework.stereotype.Controller;

/**
 * @see <a href="https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/reference/htmlsingle/#production-ready">actuator文档</a>
 *
 *  #actuator端口
 * management.server.port=9001
 * #修改访问路径  2.0之前默认是/   2.0默认是 /actuator  可以通过这个属性值修改
 * management.endpoints.web.base-path=/monitor
 * #开放所有页面节点  默认只开启了health、info两个节点
 * management.endpoints.web.exposure.include=*
 * #显示健康具体信息  默认不会显示详细信息
 * management.endpoint.health.show-details=always
 *
 *
 */
@Controller
public class FirstController {

}
