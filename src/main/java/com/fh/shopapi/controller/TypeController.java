package com.fh.shopapi.controller;

import com.fh.shopapi.entity.po.Type;
import com.fh.shopapi.entity.vo.ReponseData;
import com.fh.shopapi.service.TypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/type/")
@CrossOrigin
public class TypeController {
    @Resource
    private TypeService typeService;
 /*   1    查询所有的分类数据
    路径   http://localhost:8080/api/type/getData

    get请求

            参数

    返回值   {"code":200,"message":"提示",data:[{*}]}*/

    @GetMapping("getData")
    public ReponseData getData(){
        List<Type> rs = typeService.getData();
        return ReponseData.success(rs);
    }

/*2    查询指定pid的数据

    路径   http://localhost:8080/api/type/getDataByPid

    get请求

    参数    Pid

    返回值   {"code":200,"message":"提示",data:[{*}]}*/

    @GetMapping("getDataByPid")
    public ReponseData getDataByPid(Integer pid){
        List<Type> rs = typeService.getDataByPid(pid);
        return ReponseData.success(rs);
    }
/*3  新增分类

    路径   http://localhost:8080/api/type/add

    post请求

    参数    pid    name

    返回值    {code:"",message:"",data:新增的id}*/

@PostMapping("add")
    public ReponseData add(Type type){
    Integer rs = typeService.add(type);
    return ReponseData.success(rs);
}

/*  修改

    路径   http://localhost:8080/api/type/update

    post请求

    参数   id （必传）     pid   name  isDel

    返回值     {code:"",message:""}*/
@PostMapping("update")
public ReponseData update(Type type){
    typeService.update(type);
    return ReponseData.success(null);
}
}
