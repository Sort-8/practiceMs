package com.ruoyi.web.controller.common;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;

import java.io.File;


public class ConnectTencentCloud {

    protected static COSClient cosClient;
    protected String secretId = "AKIDc4GEvMWQ43tTosfBRQ9cplPmshGYaNt8";
    protected String secretKey = "zh8JDqDI6dttc5IEtIQHxLTMyJNBj00j";
    protected String bucketName = "shenwo-1302502474";
    protected String apCity = "ap-nanjing";
    public ConnectTencentCloud(){
        COSCredentials cred = new BasicCOSCredentials(secretId,secretKey);

        Region region = new Region(apCity);

        ClientConfig clientConfig = new ClientConfig(region);

        clientConfig.setHttpProtocol(HttpProtocol.https);

        cosClient = new COSClient(cred,clientConfig);
    }

    public PutObjectResult uploadObject(File localFile, String fileKey) {
        try {
            // 指定要上传的文件,本地的路径
            // fileKey 指定要上传到 COS 上对象键
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileKey, localFile);
            PutObjectResult  putObjectResult = cosClient.putObject(putObjectRequest);
            return putObjectResult;
        } catch (CosServiceException serverException) {
            throw  new RuntimeException("上传文件平台Server异常"+serverException.getErrorMessage());
        } catch (CosClientException clientException) {
            throw  new RuntimeException("上传文件平台Client异常"+clientException.getMessage());
        }

    }




}
