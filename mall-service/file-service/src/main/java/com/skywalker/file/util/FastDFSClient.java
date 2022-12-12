package com.skywalker.file.util;

import com.skywalker.file.entity.FastDFSFile;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

/**
 * @Author Code SkyWalker
 * @Date 17:25 2022/12/9
 * @Classname FastDFSClient
 * @Description TODO
 */
public class FastDFSClient {

    /* 初始化tracker信息 */
    static {
        try {
            // 获取tracker的配置文件位置
            String filePath = new ClassPathResource("fdfs_client.conf").getPath();

            // 加载tracker信息
            ClientGlobal.init(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件上传
     *
     * @param file 要上传的文件信息封装
     * @return String[] 1. 文件上传所存储的组名 2. 文件存储路径
     */
    public static String[] upload(FastDFSFile file) {
        // 获取文件作者
        NameValuePair[] meta_list = new NameValuePair[1];
        meta_list[0] = new NameValuePair(file.getAuthor());

        // 文件上传后返回值:
        // [0]: 文件上传所存储的组名
        // [1]: 文件存储路径: M00/00/00/wKjThF0DBzaAP23MAAXz2mMp9oM26.jpeg
        String[] uploadResults = null;

        try {
            StorageClient storageClient = getStorageClient();

            uploadResults = storageClient.upload_file(file.getContent(), file.getExt(), meta_list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uploadResults;
    }


    /* 获取StorageClient */
    private static StorageClient getStorageClient() throws Exception {
        // 获取TrackerServer
        TrackerServer trackerServer = getTrackerServer();

        // 通过TrackerServer的链接信息可以获取Storage的链接信息, 创建StorageClient对象存储Storage的链接信息
        return new StorageClient(trackerServer, null);
    }

    /* 获取TrackerServer */
    private static TrackerServer getTrackerServer() throws Exception {
        return new TrackerClient().getConnection();
    }

    /**
     * 文件删除
     * @param groupName 组名
     * @param remoteFileName 文件存储完整名称
     */
    public static void deleteFile(String groupName, String remoteFileName) {
        try {
            // 通过storageClient 删除文件
            getStorageClient().delete_file(groupName, remoteFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过组名获取storage组信息
     * @param groupName 组名
     * @return  StorageServer对象
     */
    public static StorageServer getStorages(String groupName) {
        try {
            // 创建TrackerClient对象
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();

            // 通过组名获取storage信息
            return trackerClient.getStoreStorage(trackerServer, groupName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 根据 组名 和 文件存储路径 获取 storage服务的ip和端口信息
     * @param groupName 组名
     * @param remoteFileName 存储路径
     * @return StorageServer的ip:port;
     */
    public static ServerInfo[] getServerInfo(String groupName, String remoteFileName) {
        try {
            // 创建TrackerClient对象
            TrackerClient trackerClient = new TrackerClient();

            // 通过Tracker获取TrackerServer对象
            TrackerServer trackerServer = trackerClient.getConnection();

            return trackerClient.getFetchStorages(trackerServer, groupName, remoteFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取Tracker服务器的地址
     * @return tracker 服务器地址
     */
    public static String getTrackerURL() {
        try {
            TrackerServer trackerServer = getTrackerServer();

            return "http://" + trackerServer.getInetSocketAddress().getHostName()
                    + ":" + ClientGlobal.getG_tracker_http_port();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取文件信息
     * @param group 组名
     * @param remoteFileName 文件名
     */
    public static FileInfo getFile(String group, String remoteFileName) {

        try {
            StorageClient storageClient = getStorageClient();

            return storageClient.get_file_info(group, remoteFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 文件下载
     * @param group /
     * @param remoteFileName /
     * @return  /
     */
    public static InputStream downloadFile(String group, String remoteFileName) {
        try {
            StorageClient storageClient = getStorageClient();
            byte[] fileByte = storageClient.download_file(group, remoteFileName);
            return new ByteArrayInputStream(fileByte);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String url = "https://124.221.97.152:8080/group1/M00/00/00/CgAEEWOW3jqAecX_AFCAgS4Ncvs680.jpg";
        String[] splitPath;
        try {
            splitPath = new URL(url).getPath().replaceFirst("/", "").split("/", 2);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Arrays.toString(splitPath));
    }

}
