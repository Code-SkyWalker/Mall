package com.skywalker.file.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author Code SkyWalker
 * @Date 17:31 2022/12/9
 * @Classname FastDFSFile
 * @Description TODO
 */
@Getter
@Setter
@ToString
public class FastDFSFile {

    private String name;
    private byte[] content;
    private String ext;
    private String md5;
    private String author;

    public FastDFSFile() {
    }

    public FastDFSFile(String name, byte[] content, String ext) {
        this.name = name;
        this.content = content;
        this.ext = ext;
    }

    public FastDFSFile(String name, byte[] content, String ext, String md5, String author) {
        this.name = name;
        this.content = content;
        this.ext = ext;
        this.md5 = md5;
        this.author = author;
    }
}
