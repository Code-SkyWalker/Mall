package com.skywalker.file.controller;

import com.skywalker.entity.Result;
import com.skywalker.file.entity.FastDFSFile;
import com.skywalker.file.util.FastDFSClient;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author Code SkyWalker
 * @Date 15:24 2022/12/12
 * @Classname FileController
 * @Description TODO
 */
@RestController
@RequestMapping("/file")
public class FileController {

    /**
     * 文件上传
     * @param file file
     * @return 文件访问路径
     */
    @PostMapping("/upload")
    public Result fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        // 封装一个FastDFSFile对象
        FastDFSFile DFSFile = new FastDFSFile(
                file.getOriginalFilename(),
                file.getBytes(),
                StringUtils.getFilenameExtension(file.getOriginalFilename())
        );

        String[] upload = FastDFSClient.upload(DFSFile);

        return Result.ok("上传成功", FastDFSClient.getTrackerURL() + "/" + upload[0] + "/" + upload[1]);
    }


    /**
     * 文件删除
     * @param url 文件访问路径
     * @return string
     */
    @DeleteMapping("/delete")
    public Result fileDelete(@RequestParam("url") String url) throws MalformedURLException {
        /* https://124.221.97.152:8080/group1/M00/00/00/CgAEEWLE_3KACBALAAPMG24iwMU437.png */
        String[] splitPath = new URL(url).getPath().replaceFirst("/", "").split("/", 2);
        FastDFSClient.deleteFile(splitPath[0], splitPath[1]);
        return Result.ok("文件删除成功");
    }
}
