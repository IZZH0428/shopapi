package com.fh.shopapi.controller;

import com.fh.shopapi.entity.po.Brand;
import com.fh.shopapi.entity.vo.PageParam1;
import com.fh.shopapi.entity.vo.PageResult;
import com.fh.shopapi.entity.vo.ReponseData;
import com.fh.shopapi.service.BrandService;
import com.fh.shopapi.utils.UploadDown;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/brand/")
@CrossOrigin
public class BrandController {
    @Resource
    private BrandService brandService;
    /*   1    查询所有的分类数据
    路径   http://localhost:8080/api/brand/getData
    get请求
   参数:limit(每页条数) page（当前页）
    返回值
         "code": 0,
        "msg": "处理成功",
        "count": ,
        "data": []
        */
    @GetMapping("getData")
    public  PageResult<Brand> getData(PageParam1 param){
        PageResult<Brand> rs = brandService.getData(param);
        return rs;
    }
    /*      新增
    路径   http://localhost:8080/api/brand/add
    post请求
   参数:name,bandE,imgpath,bandDesc,ord,author
    返回值"
    status": 200,
    "info": "处理成功",
    "data": null

        */
    @PostMapping("add")
    public ReponseData add(Brand brand){
        Integer  id=    brandService.add(brand);
        return ReponseData.success(id);
    }
      /*       回显
    路径   http://localhost:8080/api/brand/queryByid
    post请求
   参数:id
    返回值"
    status": 200,
    "info": "处理成功",
    "data":  "id": 1,
        "name": "aa",
        "bandE": "a",
        "imgpath": "aa.jsp",
        "bandDesc": "aaaaaaaaaaaaaaaa",
        "ord": 10,
        "isdel": 0,
        "createDate": "2021-01-13T11:05:02.000+00:00",
        "updateDate": null,
        "author": "aaaa"
        */
      @PostMapping("queryByid")
      public ReponseData queryByid(Integer id){
          Brand brand =brandService.queryByid(id);
          return ReponseData.success(brand);
      }
      /*       修改
            路径   http://localhost:8080/api/brand/update
            post请求
           参数:name,bandE,imgpath,bandDesc,ord,author,id
            返回值"
            status": 200,
            "info": "处理成功",
            "data": null
        */
      @PostMapping("update")
        public ReponseData update(Brand brand){
          brandService.update(brand);
          return ReponseData.success(null);
      }
    /*       删除
        路径   http://localhost:8080/api/brand/del
        post请求
        参数:id
        返回值"
        status": 200,
        "info": "处理成功",
        "data": null
    */
      @PostMapping("del")
    public  ReponseData del(Brand brand){
          brandService.del(brand);
          return ReponseData.success(null);
      }
    /*   1    文件上传
        路径   http://localhost:8080/api/brand/upload
        post请求
        参数:文件
        返回值"
        status": 200,
        "info": "处理成功",
        "data": url
        */
    @PostMapping("upload")
    public ReponseData upload(MultipartFile img, HttpServletRequest request){

        Map<String, String> map = UploadDown.upload(img, request, "imgFiles");
        String path=map.get("filePath");
        String Qpath="http://192.168.1.32:8080/"+path;
        return ReponseData.success(Qpath);
    }

}
