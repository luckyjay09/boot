package com.jay.boot.controller;

import com.jay.boot.pojo.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * @RestController = @Controller + @ResponseBody
 *
 * 2.请求映射
 * @GetMapping @PostMapping @PutMapping @DeleteMapping()
 *
 * 3. 获取请求参数
 * @PathVariable 获取路径上的参数mvc/{msg}
 *
 * 4.RequestEntity  ResponseEntity
 *
 * 5.返回格式变化 json  xml
 *  {@link WebMvcConfigurationSupport}
 *  <dependency>
 *     <groupId>com.fasterxml.jackson.dataformat</groupId>
 *     <artifactId>jackson-dataformat-xml</artifactId>
 *
 *  </dependency>
 *
 *
 */

@RestController
@RequestMapping("/mvc")
public class WebMvcController {

    @RequestMapping("/msg") //@RequestParam 自动类型转换
    public String mvcRequestParam(@RequestParam(value = "msg", required = false, defaultValue = "1") String message) {
        return message;
    }

    @GetMapping("/msg/{msg}")
    public String mvcPathVariable(@PathVariable String msg) {
        return msg;
    }

    @RequestMapping(value = "/old", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public String mvcOld(HttpServletRequest request, HttpServletResponse response) {

        String msg = request.getParameter("msg");
        return msg;
    }

    @RequestMapping("/header")
    public String mvcHeader(@RequestHeader("Accept") String accept) {
        return accept;
    }

    @RequestMapping("/response/entity")
    public ResponseEntity<String> mvcResponseEntity() {

//        return ResponseEntity.ok("html");
        HttpHeaders headers = new HttpHeaders();
        headers.put("myHeader", Arrays.asList("myHeaderView"));
        ResponseEntity responseEntity = new ResponseEntity("body", headers, HttpStatus.OK);
        return responseEntity;
    }


    //    WebMvcConfigurationSupport "com.fasterxml.jackson.dataformat.xml.XmlMapper"
    @RequestMapping(value = "/xml",
//            consumes = MediaType.APPLICATION_XML_VALUE,
//            consumes = {MediaType.TEXT_HTML_VALUE, "application/xhtml+xml"},
//            produces = MediaType.APPLICATION_JSON_VALUE
            produces = MediaType.APPLICATION_XML_VALUE)
    public User mvcXml() {
        User user = new User(5, "zhefef", 30);
        return user;
    }
}
