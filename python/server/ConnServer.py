# coding=utf-8
from concurrent import futures

import time
import grpc
from sklearn.datasets import load_iris

from ML.FormatData import toArr
from ML.TrainData import train
from source import connection_pb2, connection_pb2_grpc

_ONE_DAY_IN_SECONDS = 60 * 60 * 24


class ProcessData(connection_pb2_grpc.ConnectionServicer):

    def Conn(self, request_iterator, context):
        # request中是工客户端接收到的请求信息和数据
        # switch request case x: X()
        response = []
        request_type = request_iterator.next().request
        if request_type == "0":
            try:
                while True:
                    print request_iterator.next()
            except StopIteration:
                pass
            response.append(connection_pb2.ConnResponse(response="python response 0"))
        elif request_type == "1":
            arr = []
            try:
                while True:
                    arr.append(toArr(str(request_iterator.next().request)))
            except StopIteration:
                pass
            iris = load_iris()
            model = train(arr, iris.target)
            response.append(connection_pb2.ConnResponse(response=model))
        else:
            response.append(connection_pb2.ConnResponse(response="python response others"))

        # 返回应答给客户端
        resp_iterator = response.__iter__()
        return resp_iterator


def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    connection_pb2_grpc.add_ConnectionServicer_to_server(ProcessData(), server)
    server.add_insecure_port('[::]:12345')
    server.start()
    try:
        while True:
            time.sleep(_ONE_DAY_IN_SECONDS)
    except KeyboardInterrupt:
        server.stop(0)


if __name__ == '__main__':
    serve()
