/**
 * =============================================================
 * Copyright 2018 Lianjia Group All Rights Reserved
 * CompanyName: 上海链家有限公司
 * SystemName: 贝壳
 * ClassName: StudentServiceImpl
 * version: 1.0.0
 * date: 2018/9/13
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.grpc;

import com.tjq.netty.proto.MRequest;
import com.tjq.netty.proto.MResponse;
import com.tjq.netty.proto.StudentServiceOGrpc;
import io.grpc.stub.StreamObserver;

/**
 * @author Tyson
 * @version V1.0
 * @Description: TODO
 * @date 2018/9/13下午3:57
 */
public class StudentServiceImpl extends StudentServiceOGrpc.StudentServiceImplBase {

    @Override
    public void getRealnameByUserName(MRequest request, StreamObserver<MResponse> responseObserver) {
        System.out.println("接收到客户端信息" + request.getUsername());
        responseObserver.onNext(MResponse.newBuilder().setRealname("张三").build());
        responseObserver.onCompleted();
    }
}
